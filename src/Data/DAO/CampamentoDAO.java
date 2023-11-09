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
            ps.setString(3, campamento.getNivelEducativo().toString().toUpperCase());
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
            ps.setString(2, actividad.getNivelEducativo().toString().toUpperCase());
            ps.setString(3, actividad.getHorario().toString().toUpperCase());
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
            ps.setString(2, monitor.getApellidos());
            ps.setDate(3, Date.valueOf(monitor.getFechaNacimiento()));
            ps.setInt(4, monitor.isEducadorEspecial() ? 1 : 0);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void asociar_Monitor_Actividad(int idMonitor, int idActividad) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_monitor_actividad"));
            ps.setInt(1, idMonitor);
            ps.setInt(2, idActividad);
            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Monitor asociado a la actividad con exito");
            } else {
                System.out.println("Fallo al asociar el monitor a la actividad");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void asociar_actividad(int id_actividad, int id_campamento) {
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_actividad_campamento"));
            ps.setInt(1, id_campamento);
            ps.setInt(2, id_actividad);
             ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void monitorResponsable(int idMonitor,int idCampamento){
        try{
            PreparedStatement ps = con. prepareStatement(prop.getSentente("update_monitorResponsable"));
            ps.setInt(1,idMonitor);
            int status = ps.executeUpdate();
            if (status > 0){
                System.out.println("Monitor responsable al campamento asociado con exito");
            }else{
                System.out.println("Fallo al asociar el monitor responsable del campamento");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void monitorEspecial (int idMonitor, int idCampamento){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("update_monitorEspecial"));
            ps.setInt(1,idMonitor);
            int status = ps.executeUpdate();
            if ( status > 0){
                System.out.println("Monitor especial del campamento asociado con exito");
            }else{
                System.out.println("Fallo al asociar el monitor especial del campamento");
            }
        }catch (SQLException e){
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
            act.setMaxParticipantes(rs.getInt("max_participantes"));
            act.setIdentificador(rs.getInt("id_actividad"));
            return act;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Campamento devolverCampamento(int idCampamento){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_campamento_id"));
            ps.setInt(1,idCampamento);
            ResultSet rs = ps.executeQuery();
            Campamento camp=new Campamento();
            String n = rs.getString("nivel_educativo");
            if( n.equals("infantil")){
                camp.setNivelEducativo(NivelEducativo.INFANTIL);
            }
            else{
                if(n.equals("juvenil")){
                    camp.setNivelEducativo(NivelEducativo.JUVENIL);
                }
                else if(n.equals("adolescente")){
                    camp.setNivelEducativo(NivelEducativo.ADOLESCENTE);
                }
            }
            camp.setMaxAsistentes(rs.getInt("max_asistentes"));
            camp.setIdCampamento(rs.getInt("id_campamento"));
            camp.setFechaFinal(rs.getDate("fecha_final").toLocalDate());
            camp.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
            return camp;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Monitor devolverMonitor(int idMonitor){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_campamento_id"));
            ps.setInt(1,idMonitor);
            ResultSet rs = ps.executeQuery();
            Monitor mon=new Monitor();
            mon.setNombre(rs.getString("nombre"));
            mon.setIdentificador(rs.getInt("id_monitor"));
            mon.setEducadorEspecial(rs.getBoolean("especial"));
            mon.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
            mon.setApellidos(rs.getString("apellidos"));//Cambiar

            return mon;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Campamento> listarCampamentos() {
        ArrayList<Campamento> listaCampamentos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_all_Campamentos"));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Campamento campamento = new Campamento();
                campamento.setIdCampamento(rs.getInt("id_campamento"));
                campamento.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                campamento.setFechaFinal(rs.getDate("fecha_final").toLocalDate());
                String n = rs.getString("nivel_educativo");
                if( n.equals("Infantil")){
                    campamento.setNivelEducativo(NivelEducativo.INFANTIL);
                }
                else{
                    if(n.equals("Juvenil")){
                        campamento.setNivelEducativo(NivelEducativo.JUVENIL);
                    }
                    else if(n.equals("Adolescente")){
                        campamento.setNivelEducativo(NivelEducativo.ADOLESCENTE);
                    }
                }
                campamento.setMaxAsistentes(rs.getInt("max_asistentes"));
                //falta monitor responsable y monitor especial
                listaCampamentos.add(campamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCampamentos;
    }
    public ArrayList<Actividad> listarActividad(){
        ArrayList<Actividad> listaActividades = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_all_Actividades"));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Actividad actividad =  new Actividad();
                actividad.setNombre(rs.getString("nombre"));
                String n = rs.getString("nivel_educativo");
                if( n.equals("Infantil")){
                    actividad.setNivelEducativo(NivelEducativo.INFANTIL);
                }
                else{
                    if(n.equals("Juvenil")){
                        actividad.setNivelEducativo(NivelEducativo.JUVENIL);
                    }
                    else if(n.equals("Adolescente")){
                        actividad.setNivelEducativo(NivelEducativo.ADOLESCENTE);
                    }
                }
                String h = rs.getString("horario");
                if( h.equals("parcial")){
                    actividad.setHorario(Horario.PARCIAL);
                }
                else{
                    actividad.setHorario(Horario.COMPLETA);
                }
                actividad.setMaxParticipantes(rs.getInt("max_participantes"));
                actividad.setMonitoresNecesarios(rs.getInt("monitores_necesarios"));
                actividad.setIdentificador(rs.getInt("id_actividad"));
                listaActividades.add(actividad);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaActividades;
    }
    public ArrayList<Monitor> listarMonitores(){
        ArrayList<Monitor> listaMonitores = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("select_all_Monitores"));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Monitor monitor =  new Monitor();
                monitor.setNombre(rs.getString("nombre"));
                monitor.setApellidos(rs.getString("apellidos"));
                monitor.setIdentificador(rs.getInt("id_monitor"));
                monitor.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                monitor.setEducadorEspecial(rs.getBoolean("especial"));
                listaMonitores.add(monitor);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaMonitores;
    }
}


