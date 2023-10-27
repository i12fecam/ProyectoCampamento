package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.Campamento;
import Data.DTO.Inscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

public class InscripcionDAO {

    ProyectProperties prop;

    ConexionBD bd;

    Connection con;

    InscripcionDAO(){
        prop = new ProyectProperties();
        bd = new ConexionBD();

        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }
    void nuevaInscripcion(Inscripcion inscripcion)
    {
        PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_inscripcion"));

    }

    void cancelarInscripcion(){

    }

    Vector<Campamento> InscripcionesDisponibles(){

    }
}
