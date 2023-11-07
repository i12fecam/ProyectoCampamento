package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.*;
import Data.Horario;
import Data.NivelEducativo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CampamentoDAO {
    private ProyectProperties prop;
    private ConexionBD bd;
    private Connection con;


    public CampamentoDAO() {
        prop = new ProyectProperties();
        bd = new ConexionBD();
        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }

    public void crearCampamento(Campamento campamento) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Campamentos"));
            ps.setDate(1, Date.valueOf(campamento.getFechaInicio()));
            ps.setDate(2, Date.valueOf(campamento.getFechaFinal()));

            if (campamento.getNivelEducativo() == NivelEducativo.INFANTIL) {
                ps.setString(3, "infantil");
            } else if (campamento.getNivelEducativo() == NivelEducativo.JUVENIL) {
                ps.setString(3, "juvenil");
            } else {
                ps.setString(3, "adolescente");
            }

            ps.setInt(4, campamento.getMaxAsistentes());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void crearActividad(Actividad actividad) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Actividades"));
            ps.setString(1, actividad.getNombre());

            if (actividad.getNivelEducativo() == NivelEducativo.INFANTIL) {
                ps.setString(2, "infatil");
            } else if (actividad.getNivelEducativo() == NivelEducativo.JUVENIL) {
                ps.setString(2, "juvenil");
            } else {
                ps.setString(2, "adolescente");
            }

            if (actividad.getHorario() == Horario.PARCIAL) {
                ps.setString(3, "parcial");
            } else {
                ps.setString(3, "completa");
            }

            ps.setInt(4, actividad.getMaxParticipantes());
            ps.setInt(5, actividad.getMonitoresNecesarios());
            ps.setInt(6, actividad.getIdentificador());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearMonitor(Monitor monitor) {

        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Monitores"));
            ps.setString(1, monitor.getNombre());
            ps.setString(2, monitor.getApellido1() + " " + monitor.getApellido2());
            ps.setDate(3, Date.valueOf(monitor.getFechaNacimiento()));
            ps.setInt(4, monitor.isEducadorEspecial() ? 1 : 0);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void asociarMonitorResponsableActividad(int idMonitor, int idActividad) {
        try {
            int maxMonitores = ObtenerMonitoresMax(idActividad);
            int monitores = contarMonitores(idActividad);
            if (monitores < maxMonitores) {
                PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_monitor-actividad"));
                ps.setInt(1, idMonitor);
                ps.setInt(2, idActividad);
                int status = ps.executeUpdate();
                if (status > 0) {
                    System.out.println("Monitor asociado a la actividad con éxito");
                } else {
                    System.out.println("Fallo al asociar el monitor a la actividad");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int ObtenerMonitoresMax(int idActividad) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("max_monitores"));
            ps.setInt(1, idActividad);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getInt("max_monitores");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    private int contarMonitores(int idActividad) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("contar_monitores"));
            ps.setInt(1, idActividad);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void asociar_actividad(int id_actividad, int id_campamento) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_actividad_campamento"));
            ps.setInt(1, id_campamento);
            ps.setInt(2, id_actividad);
            int status = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param campamento campamento del cual se mira las actividades
     * @param horario    horario de las actividades que se cuentan
     * @return numero de actividades del campamento segun su horario
     */
    public int getNumActividades(Campamento campamento, Horario horario) {
        return 0;
    }

    /**
     * @return Todos los camapamentos en los que se puede inscribir en esa fecha
     */
    public ArrayList<Campamento> getCampamentosInscribibles() {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("get_campamentos_disponibles"));
            ResultSet rs = ps.executeQuery();
            ArrayList<Campamento> vector = new ArrayList<>();
            while (rs.next()) {
                Campamento camp = new Campamento();
                camp.setIdCampamento(rs.getInt("id"));//no se si poner id o id_campamento
                camp.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                rs.getString("nivel_educativo");
                camp.setMaxAsistentes(rs.getInt("max_asistentes"));
                //aqui se podria poner la foreign key de los montores especiales y responsables
                vector.add(camp);
            }
            return vector;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Actividad devolverActividad(int idActividad) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_actividad_id"));
            ps.setInt(1,idActividad);
            ResultSet rs = ps.executeQuery();
            Actividad act=new Actividad();
            String s = rs.getString("horario");
            if( s.equals("Parcial")){
                act.setHorario(Horario.PARCIAL);
            }
            else if(s.equals("Completa")){
                act.setHorario(Horario.COMPLETA);
            }
            String n = rs.getString("nivel_educativo");
            if( n.equals("infantil")){
                act.setNivelEducativo(NivelEducativo.INFANTIL);
            }
            else{
                if(n.equals("juvenil")){
                    act.setNivelEducativo(NivelEducativo.JUVENIL);
                }
                else if(n.equals("adolescente")){
                    act.setNivelEducativo(NivelEducativo.ADOLESCENTE);
                }
            }
            act.setNombre(rs.getString("nombre"));
            act.setMonitoresNecesarios(rs.getInt("monitores_necesarios"));
            return act;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
