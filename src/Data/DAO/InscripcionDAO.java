package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.Campamento;
import Data.DTO.Inscripcion;
import Data.Horario;
import Data.TipoInscripcion;

import java.sql.*;
import java.util.Vector;

public class InscripcionDAO {

    private ProyectProperties prop;

    private ConexionBD bd;

    private Connection con;

    public InscripcionDAO(){
        prop = new ProyectProperties();
        bd = new ConexionBD();

        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }
    public void nuevaInscripcion(Inscripcion inscripcion) {

        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_inscripcion"));

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
        }catch (SQLException e)
            throw new RuntimeException(e);
        }


    }

    public boolean esFechaInscripcionInvalida(Inscripcion inscripcion){ //ahora creo que esta funcion no es tan necesario porque estoy comprobando por la primary key
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("fecha_inscripcion_valida"));
            ps.setInt(1,inscripcion.getIdParticipante());
            ps.setInt(2,inscripcion.getIdCampamento());
            ResultSet res = ps.executeQuery();
            int count = 0;
            while(res.next()){
                count++;
            }
            if(count > 0){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

    public Inscripcion getInscripcion(int id_asistente,int id_campamento){
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("get_incripcion"));
            ps.setInt(1,id_asistente);
            ps.setInt(2,id_campamento);
            ResultSet res = ps.executeQuery();
            Inscripcion ins =new Inscripcion();
            ins.setFechaInscripcion(res.getDate("fecha_inscripcion").toLocalDate());
            ins.setPrecio(res.getFloat("precio"));
            String s = res.getString("horario");
            if( s.equals("Parcial")){
                ins.setHorario(Horario.PARCIAL);
            }
            else if(s.equals("Completa")){
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

    Vector<Campamento> InscripcionesDisponibles(){
        return null;
    }
}
