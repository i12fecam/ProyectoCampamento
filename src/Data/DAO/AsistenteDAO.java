package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.Asistente;
import java.util.ArrayList;

import java.sql.Connection;

import java.sql.*;


public class AsistenteDAO {


    private ProyectProperties prop;

    private ConexionBD bd;

    private Connection con;

    public AsistenteDAO() {
        prop = new ProyectProperties();
        bd = new ConexionBD();

        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }

    public void crear(Asistente asistente) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_record_Asistentes"));

            ps.setString(1, asistente.getNombre());
            ps.setDate(2, Date.valueOf(asistente.getFechaNacimiento()));
            ps.setInt(3, asistente.isAtencionEspecial() ? 1 : 0);
            ps.setString(4, asistente.getApellido1() + " " + asistente.getApellido2());

            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Asistente agregado con éxito");
            } else {
                System.out.println("Fallo al agregar el asistente");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void modificar(Asistente asistente) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Asistente"));

            ps.setString(1, asistente.getNombre());
            ps.setDate(2, Date.valueOf(asistente.getFechaNacimiento()));
            ps.setInt(3, asistente.isAtencionEspecial() ? 1 : 0);
            ps.setString(4, asistente.getApellido1() + " " + asistente.getApellido2());

            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Asistente agregado con éxito");
            } else {
                System.out.println("Fallo al agregar el asistente");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public ArrayList<Asistente> listar() {
        ArrayList<Asistente> listaAsistentes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_all_Asistentes"));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Asistente asistente = new Asistente();
                asistente.setIdentificador(rs.getInt("id_asistente"));
                asistente.setNombre(rs.getString("nombre"));
                asistente.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                asistente.setAtencionEspecial(rs.getInt("especial") == 1);
                //REVISAR//
                asistente.setApellido1(rs.getString("apellidos"));
                //
                listaAsistentes.add(asistente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAsistentes;
    }
}