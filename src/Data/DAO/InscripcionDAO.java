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
        }catch (SQLException e) {
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

    void cancelarInscripcion(){

    }

    Vector<Campamento> InscripcionesDisponibles(){
        return null;
    }
}
