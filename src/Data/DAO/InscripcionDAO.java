package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.Inscripcion;
import Data.Horario;
import Data.TipoInscripcion;

import java.sql.*;

public class InscripcionDAO {

    private ProyectProperties prop;

    private ConexionBD bd;

    private Connection con;

    public InscripcionDAO(){
        prop = new ProyectProperties();
        bd = new ConexionBD();

        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }

    @Override
    protected void finalize(){
        bd.closeConnection();
    }
    public void nuevaInscripcion(Inscripcion inscripcion) {

        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Inscripcion"));

            ps.setDate(1, Date.valueOf(inscripcion.getFechaInscripcion()));
            ps.setFloat(2, inscripcion.getPrecio());

            if (inscripcion.getHorario() == Horario.PARCIAL) {
                ps.setInt(3, 1);
            } else {
                ps.setInt(3, 2);
            }
            if (inscripcion.getTipoInscripcion() == TipoInscripcion.TARDIA) {
                ps.setInt(4,2);
            } else {
                ps.setInt(4,1);
            }
            ps.setInt(5,1);//completar
            ps.setInt(6,1);
            int status = ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    /**
     *
     * @param inscripcion
     */
    public void cancelarInscripcion(Inscripcion inscripcion){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("cancelar_incripcion"));
            ps.setInt(1,inscripcion.getIdParticipante());
            ps.setInt(2,inscripcion.getIdCampamento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     *
     * @param id_asistente
     * @param id_campamento
     * @return Inscripcion descrita por id asistente e id campamento
     */
    public Inscripcion getInscripcion(int id_asistente,int id_campamento){
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("get_inscripcion"));
            ps.setInt(1,id_asistente);
            ps.setInt(2,id_campamento);
            ResultSet res = ps.executeQuery();
            Inscripcion ins =new Inscripcion();
            res.next();
            ins.setFechaInscripcion(res.getDate("fecha_inscripcion").toLocalDate());
            ins.setPrecio(res.getFloat("precio"));
            String s = res.getString("horario");
            if( s.equals("parcial")){
                ins.setHorario(Horario.PARCIAL);
            }
            else if(s.equals("completa")){
                ins.setHorario(Horario.COMPLETA);
            }
            else throw new RuntimeException("Esto no deberia pasar");

            s = res.getString("tipo_inscripcion");
            if(s.equals("temprana")){
                ins.setTipoInscripcion(TipoInscripcion.TEMPRANA);
            }
            else if(s.equals("tardia")){
                ins.setTipoInscripcion(TipoInscripcion.TARDIA);
            }else throw new RuntimeException("Esto no deberia pasar 2");
            ins.setIdCampamento(id_campamento);
            ins.setIdParticipante(id_asistente);
            return ins;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int GetInscritos(int id_campamentos){
        int nInscritos = -1;
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_n_inscritos"));
            ps.setInt(1,id_campamentos);

            ResultSet rs = ps.executeQuery();
            rs.next();
            nInscritos = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nInscritos;

    }


}
