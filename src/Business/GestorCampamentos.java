package Business;

import Data.DAO.AsistenteDAO;
import Data.DAO.CampamentoDAO;
import Data.DTO.Actividad;
import Data.DTO.Asistente;
import Data.DTO.Campamento;
import Data.DTO.Monitor;
import Data.Horario;
import Data.NivelEducativo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * GestorCampamentos class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class GestorCampamentos implements Serializable {


    private CampamentoDAO campamentoDAO;

    public GestorCampamentos() {
        this.campamentoDAO = new CampamentoDAO();

    }

    public boolean crearCampamento(Campamento campamento){
        if (campamento == null) {
            System.out.println("El campamento es nulo.");
            return false;
        }
        campamentoDAO.crearCampamento(campamento);
        return true;
    }



    public boolean crearMonitor(Monitor monitor){
        if (monitor == null) {
            System.out.println("La actividad es nula.");
            return false;
        }
        campamentoDAO.crearMonitor(monitor);
        return true;

    }


    public boolean crearActividad(Actividad actividad){
        if (actividad == null) {
            System.out.println("La actividad es nula.");
            return false;
        }
        campamentoDAO.crearActividad(actividad);
        return true;
    }

    /**
     * Metodo que asocia un monitor a una actividad
     * @param idMonitor
     * @param idActividad
     */
    public void asociarMonitorActividad(int idMonitor,int idActividad)
    {
        campamentoDAO.asociar_Monitor_Actividad(idMonitor,idActividad);
    }

    /**
     * Metodo que asocia una actividad a un campamento
     * @param idActividad
     * @param idCampamento
     */
    public void asociarActividadCampamento(int idActividad,int idCampamento){

        /*
        Actividad actividad = actividades.get(idActividad);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarActividad(actividad);
        */
        CampamentoDAO camp=new CampamentoDAO();
        Actividad act=camp.devolverActividad(idActividad);
        Campamento campament=camp.devolverCampamento(idCampamento);
        if(act.getNivelEducativo()==campament.getNivelEducativo()){
            camp.asociar_actividad(idActividad,idCampamento);
        }


    }

    /**
     * Metodo que asocia un monitor a un campamento
     * @param idMonitor
     * @param idCampamento
     */
    public void asociarMonitorResponsableCampamento(int idMonitor, int idCampamento){
        /*
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitor(monitor);
        */
        CampamentoDAO camp=new CampamentoDAO();
        Monitor mon=camp.devolverMonitor(idMonitor);
        Campamento campament=camp.devolverCampamento(idCampamento);
        campament.asociarMonitor(mon);
        camp.monitorResponsable(idMonitor, idCampamento);
    }

    /**
     * Metodo que asocia un monitor especial a un campamento
     * @param idMonitor
     * @param idCampamento
     */
    public void asociarMonitorEspecialCampamento(int idMonitor, int idCampamento){
        /*
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitorEspecial(monitor);
        */
        CampamentoDAO camp=new CampamentoDAO();
        Monitor mon=camp.devolverMonitor(idMonitor);
        Campamento campament=camp.devolverCampamento(idCampamento);
        campament.asociarMonitorEspecial(mon);
        camp.monitorEspecial(idMonitor,idCampamento);
    }

    /**
     * Imprime en la consola una representación en cadena de los objetos Campamento almacenados en la lista "campamentos".
     * Este método itera a través de la lista de objetos Campamento almacenados en el atributo "campamentos" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Campamento.
     */

    public void toStringCampamentos() {
        ArrayList<Campamento> listaCampamentos = campamentoDAO.listarCampamentos();
        for (Campamento campamento : listaCampamentos) {
            System.out.println("ID: " + campamento.getIdCampamento());
            System.out.println("Fecha Inicio: " + campamento.getFechaInicio());
            System.out.println("Fecha Fin: " + campamento.getFechaFinal());
            System.out.println("Nivel Educativo: " + (campamento.getNivelEducativo().toString()));
            System.out.println("Asistentes máximos: " + campamento.getMaxAsistentes());
            //FALTA MONITOR RESPONSABLE Y ESPECIAL//
            System.out.println("--------------------------------------");
        }
    }
    /**
     * Imprime en la consola una representación en cadena de los objetos Monitor almacenados en la lista "monitores".
     * Este método itera a través de la lista de objetos Monitor almacenados en el atributo "monitores" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Monitor.
     */
    public void toStringMonitores(){
        ArrayList<Monitor> listaMonitores=campamentoDAO.listarMonitores();
        for(Monitor monitor : listaMonitores){
          System.out.println("ID: " + monitor.getIdentificador());
          System.out.println("Nombre: " + monitor.getNombre());
          System.out.println("Apellidos: "+ monitor.getApellidos());
          System.out.println("Especial: " + monitor.isEducadorEspecial());
          System.out.println("Fecha nacimiento: " + monitor.getFechaNacimiento());
          System.out.println("--------------------------------------");

        }
    }
    /**
     * Imprime en la consola una representación en cadena de los objetos Actividad almacenados en la lista "actividades".
     * Este método itera a través de la lista de objetos Actividad almacenados en el atributo "actividades" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Actividad.
     */
    public void toStringActividades() {
        ArrayList<Actividad> listaActividad = campamentoDAO.listarActividad();
        for( Actividad actividad : listaActividad){
            System.out.println("ID: " + actividad.getIdentificador());
            System.out.println("Nombre: " + actividad.getNombre());
            System.out.println("Nivel Educativo: " + actividad.getNivelEducativo().toString());
            System.out.println("Horario: " + actividad.getHorario().toString());
            System.out.println("Maximo de asistentes " + actividad.getMaxParticipantes());
            System.out.println("Maximo de monitores: " + actividad.getMonitoresNecesarios());
            System.out.println("--------------------------------------");
        }
    }

    public Campamento getCampamento(int id){
        return null;
    }




}
