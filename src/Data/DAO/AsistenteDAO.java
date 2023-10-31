package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.Asistente;

import java.sql.Connection;

import java.sql.*;


public class AsistenteDAO {


    private ProyectProperties prop;

    private ConexionBD bd;

    private Connection con;

    public AsistenteDAO(){
        prop = new ProyectProperties();
        bd = new ConexionBD();

        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }
    public void crear(Asistente asistente){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_record_Asistentes"));

            ps.setInt(1, asistente.getIdentificador());
            ps.setString(2, asistente.getNombre());
            ps.setDate(3, Date.valueOf(asistente.getFechaNacimiento()));
            ps.setInt(4, asistente.isAtencionEspecial() ? 1 : 0);
            ps.setString(5, asistente.getApellido1() + " " + asistente.getApellido2());

            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Asistente agregado con éxito");
            } else {
                System.out.println("Fallo al agregar el asistente");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
