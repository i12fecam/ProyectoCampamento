package Business;

import Data.DTO.Campamento;
import Data.Horario;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


/**
 * GestorInscripciones class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class GestorInscripciones implements Serializable{
    /*Attributes*/





    public GestorInscripciones(){


    }








    /**
     * @param gestorCampamentos
     * @param gestorAsistentes
     * @param idAsistente
     * @param idCampamento
     * @param fechaInscripcion
     * @param horario
     */
    public void crearInscripcion(GestorCampamentos gestorCampamentos, GestorAsistentes gestorAsistentes, int idAsistente, int idCampamento, LocalDate fechaInscripcion, Horario horario){
        /*Asistente asistente= null;
        Campamento campamento=null;
        if (idCampamento >= 0 && idCampamento < gestorCampamentos.getCampamentos().size()) {

             campamento = gestorCampamentos.getCampamentos().get(idCampamento);
        }
        if(idAsistente >= 0 && idAsistente < gestorAsistentes.getAsistentes().size()){

          asistente = gestorAsistentes.getAsistentes().get(idAsistente);
        }

        float precio;
        boolean tardia;
        //comprobar si el asistente ya esta inscrito en el campamento
        for(Inscripcion it:inscripciones){
            if(it.idCampamento == idCampamento && it.idParticipante == idAsistente){
                throw new RuntimeException("Ya esta el particpante en el campamento");
            }
        }
        //mirar si es tardia
        if(fechaInscripcion.isBefore(campamento.getFechaInicio().minusDays(15))){
            tardia =true;
        }
        else if(fechaInscripcion.isAfter(campamento.getFechaInicio().minus(15, ChronoUnit.DAYS)) && fechaInscripcion.isBefore(campamento.getFechaInicio().minus(2,ChronoUnit.DAYS))){
            tardia =false;
        }
        else{
            throw new RuntimeException("La fecha de inscripcion es demasiado tardia");
        }

        //comprobar si necesita monitor especial
        if(asistente !=null && campamento !=null) {
            if (asistente.isAtencionEspecial() && !campamento.tieneMonitorEspecial()) {
                //añadir monitor especial al campamento
                System.out.println("!!!!ATENCION: Después de esta operación asegurese de añadir un monitor especial al campamento");
            }
        }
        //calcular precio
        if(horario == Horario.PARCIAL){
            precio = 100;
            ArrayList<Actividad> actividades = campamento.getActividades();
            for (Actividad it:actividades){
                if (it.getHorario() == Horario.PARCIAL){
                    precio+=20;
                }
            }
        }else{
            precio = 300;
        }
        //se crea la inscripción
        if(tardia){
            InscriptionFactoryTardia factoria = new InscriptionFactoryTardia();
            if(horario == Horario.COMPLETA){
                inscripciones.add(factoria.crearInscripcionCompleta(idAsistente,idCampamento,fechaInscripcion,precio));
            }
            else{
                inscripciones.add(factoria.crearInscripcionParcial(idAsistente,idCampamento,fechaInscripcion,precio));
            }

        }
        else{
            InscriptionFactoryTemprana factoria = new InscriptionFactoryTemprana();
            if(horario == Horario.COMPLETA){
                inscripciones.add(factoria.crearInscripcionCompleta(idAsistente,idCampamento,fechaInscripcion,precio));
            }
            else{
                inscripciones.add(factoria.crearInscripcionParcial(idAsistente,idCampamento,fechaInscripcion,precio));
            }
        }

        System.out.println("El precio de la inscripcion es de: " + precio);

         */
    }


    public boolean cancelarInscripcion(int idParticipante, int idCampamento){
        /*
        }
        for(Inscripcion it:inscripciones){
            if(it.getIdCampamento()== idCampamento && it.getIdParticipante() == idParticipante && it.getTipoInscripcion() == TipoInscripcion.TEMPRANA){
                inscripciones.remove(it);
                return true;
            }
        }
        return false;

         */
        return false;
    }
    /**
     * Metodo que permite consultar los campamentos disponibles
     * @param gestor
     * @return lista de campamentos disponibles
     */
    public ArrayList<Campamento> consultarCampamentosDisponibles() {
        /*
        ArrayList<Campamento> campamentosDisponibles = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now(); // Obtén la fecha actual
        for (Campamento it : gestor.getCampamentos()) {
            if (fechaActual.isBefore(it.getFechaInicio()) && // Campamento no ha comenzado
                    it.getNumAsistentes() < it.getMaxAsistentes()) { // Plazas disponibles
                campamentosDisponibles.add(it);
            }
        }

        return campamentosDisponibles;

         */
        return null;
    }

}