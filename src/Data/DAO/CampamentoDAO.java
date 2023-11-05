package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.*;
import Data.Horario;
import Data.NivelEducativo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CampamentoDAO {
    private ProyectProperties prop;
    private ConexionBD bd;
    private Connection con;


    public CampamentoDAO(){
        prop = new ProyectProperties();
        bd = new ConexionBD();
        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }

    public void crearCampamento (Campamento campamento){
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Campamentos"));
            ps.setDate(1,Date.valueOf(campamento.getFechaInicio()));
            ps.setDate(2, Date.valueOf(campamento.getFechaFinal()));

            if(campamento.getNivelEducativo()== NivelEducativo.INFANTIL){
                ps.setString(3,"infantil");
            }
            else if(campamento.getNivelEducativo()==NivelEducativo.JUVENIL){
                ps.setString(3,"juvenil");
            }
            else{
                ps.setString(3,"adolescente");
            }

            ps.setInt(4,campamento.getMaxAsistentes());

            ps.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void crearActividad(Actividad actividad){
        try {
            PreparedStatement ps= con.prepareStatement(prop.getSentente("insert_Actividades"));
            ps.setString(1, actividad.getNombre());

            if(actividad.getNivelEducativo()==NivelEducativo.INFANTIL){
                ps.setString(2,"infatil");
            }
            else if(actividad.getNivelEducativo()==NivelEducativo.JUVENIL){
                ps.setString(2,"juvenil");
            }
            else{
                ps.setString(2,"adolescente");
            }

            if(actividad.getHorario()==Horario.PARCIAL){
                ps.setString(3,"parcial");
            }
            else{
                ps.setString(3,"completa");
            }

            ps.setInt(4,actividad.getMaxParticipantes());
            ps.setInt(5,actividad.getMonitoresNecesarios());
            ps.setInt(6,actividad.getIdentificador());
            ps.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearMonitor(Monitor monitor){

        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_Monitores"));
            ps.setString(1, monitor.getNombre());
            ps.setString(2, monitor.getApellido1() + " " + monitor.getApellido2());
            ps.setDate(3, Date.valueOf(monitor.getFechaNacimiento()));
            ps.setInt(4, monitor.isEducadorEspecial() ? 1 : 0);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void asociarMonitorResponsableActividad(int idMonitor, int idActividad) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_monitor_actividad"));
            ps.setInt(1, idMonitor);
            ps.setInt(2, idActividad);
            int status = ps.executeUpdate();

            if (status > 0) {
                System.out.println("Monitor asociado a la actividad con éxito");
            } else {
                System.out.println("Fallo al asociar el monitor a la actividad");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    /**
     *
     * @param campamento campamento del cual se mira las actividades
     * @param horario horario de las actividades que se cuentan
     * @return numero de actividades del campamento segun su horario
     */
    public int getNumActividades(Campamento campamento,Horario horario){
        return 0;
    }

    /**
     *
     * @return  Todos las camapamentos en los que se puede inscribir en esa fecha
     */
    public ArrayList<Campamento> getCampamentosInscribibles(){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("get_campamentos_disponibles"));
            ResultSet rs = ps.executeQuery();
            ArrayList<Campamento> vector = new ArrayList<>();
            while(rs.next()){
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
}
