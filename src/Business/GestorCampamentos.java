package Business;

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


    /**
     * empty(default) constructor
     **/
    public GestorCampamentos() {

    }


    /**
     * Metodo que crea un campamento
     * @param fechaInicio d
     * @param fechaFinal c
     * @param nivelEducativo c
     * @param maxAsistentes c
     */

    public void crearCampamento(LocalDate fechaInicio, LocalDate fechaFinal, NivelEducativo nivelEducativo, int maxAsistentes){
        /*
        int idCampamento = campamentos.size();

        Campamento campamento = new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes);

        campamentos.add(campamento);

         */
    }

    /**
     * Metodo que crea un monitor
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param fechaNacimiento
     * @param educadorEspecial
     */
    public void crearMonitor( String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, boolean educadorEspecial){
        /*
        int identificador = monitores.size();

        Monitor monitor = new Monitor(identificador,nombre,apellido1,apellido2,fechaNacimiento,educadorEspecial);

        monitores.add(monitor);
        */
    }

    /**
     * Metodo que crea una actividad
     * @param nombre
     * @param nivelEducativo
     * @param horario
     * @param maxParticipantes
     * @param monitoresNecesarios
     */
    public void crearActividad(String nombre, NivelEducativo nivelEducativo, Horario horario, int maxParticipantes, int monitoresNecesarios){
        /*
        int identificador = actividades.size();
        Actividad actividad = new Actividad(nombre,identificador,nivelEducativo,horario,maxParticipantes,monitoresNecesarios);

        actividades.add(actividad);

         */
    }

    /**
     * Metodo que asocia un monitor a una actividad
     * @param idMonitor
     * @param idActividad
     */
    public void asociarMonitorActividad(int idMonitor,int idActividad)
    {
        /*
        Actividad actividad = actividades.get(idActividad);
        Monitor monitor = monitores.get(idMonitor);
        actividad.asociarMonitor(monitor);
        */
        CampamentoDAO camp = new CampamentoDAO();
        Actividad act = camp.devolverActividad(idActividad);
        Monitor mon = camp.devolverMonitor(idMonitor);
        if(mon.getIdentificador()<act.getMonitoresNecesarios()){
            camp.asociarMonitorResponsableActividad(idMonitor,idActividad);
        }
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
    public void toStringCampamentos(){
        /*
        for(Campamento it:campamentos){
            System.out.println(it.toString());;
        }

         */
    }
    /**
     * Imprime en la consola una representación en cadena de los objetos Monitor almacenados en la lista "monitores".
     * Este método itera a través de la lista de objetos Monitor almacenados en el atributo "monitores" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Monitor.
     */
    public void listarCampamentos(){
        CampamentoDAO camp = new CampamentoDAO();
       ArrayList<Campamento> listaCampamentos = camp.listar();
        for (Campamento campamento : listaCampamentos) {
            System.out.println("ID: " + campamento.getIdCampamento());
            System.out.println("Fecha-inicio: " + campamento.getFechaInicio());
            System.out.println("Fecha-final: " + campamento.getFechaFinal());
            System.out.println("Nivel educativo: " + campamento.getNivelEducativo());
            System.out.println("Maximo de asistentes " + campamento.getMaxAsistentes());
            System.out.println("--------------------------------------");
        }
    }
    /**
     * Imprime en la consola una representación en cadena de los objetos Actividad almacenados en la lista "actividades".
     * Este método itera a través de la lista de objetos Actividad almacenados en el atributo "actividades" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Actividad.
     */
    public void toStringActividades() {
        CampamentoDAO camp = new CampamentoDAO();
        ArrayList<Actividad> listaActividad = camp.listarActividad();
        for( Actividad actividad : listaActividad){
            System.out.println("ID: " + actividad.getIdentificador());
            System.out.println("Nombre: " + actividad.getNombre());
            System.out.println("Nivel Educativo: " + actividad.getNivelEducativo());
            System.out.println("Horario: " + actividad.getHorario());
            System.out.println("Maximo de asistentes " + actividad.getMaxParticipantes());
            System.out.println("Maximo de monitores: " + actividad.getMonitoresNecesarios());
            System.out.println("--------------------------------------");
        }
    }

    public Campamento getCampamento(int id){
        return null;
    }




}
