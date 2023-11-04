package Business;

import Data.DAO.CampamentoDAO;
import Data.DAO.InscripcionDAO;
import Data.DTO.Asistente;
import Data.DTO.Campamento;
import Data.DTO.Inscripcion;
import Data.Horario;
import Data.TipoInscripcion;

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
     * @param asistente
     * @param campamento
     * @param fechaInscripcion
     * @param horario
     */
    public void crearInscripcion(Asistente asistente, Campamento campamento, LocalDate fechaInscripcion, Horario horario){

        InscripcionDAO ins = new InscripcionDAO();
        CampamentoDAO camp = new CampamentoDAO();

        float precio;
        //comprobar si el asistente ya esta inscrito en el campamento
        /*
        if(ins.esFechaInscripcionInvalida()){

            throw new RuntimeException("Fecha Inscripcion invalida");
        }
        */

        //comprobar si el campamento sigue teniendo espacio
        //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        //mirar si es tardia
        TipoInscripcion tipoInscripcion;
        if(fechaInscripcion.isBefore(campamento.getFechaInicio().minusDays(15))){
            tipoInscripcion = TipoInscripcion.TARDIA;
        }
        else if(fechaInscripcion.isAfter(campamento.getFechaInicio().minus(15, ChronoUnit.DAYS)) && fechaInscripcion.isBefore(campamento.getFechaInicio().minus(2,ChronoUnit.DAYS))){

            tipoInscripcion = TipoInscripcion.TEMPRANA;
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
            precio = precio + camp.getNumActividades(campamento,Horario.PARCIAL)*20;
        }else{
            precio = 300;
        }
        //se crea la inscripción
        ins.nuevaInscripcion(new Inscripcion(asistente.getIdentificador(),campamento.getIdCampamento(),fechaInscripcion,precio,tipoInscripcion,horario));
        /*
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
        */
        System.out.println("El precio de la inscripcion es de: " + precio);


    }


    public boolean cancelarInscripcion(int id_asistente,int id_campamento){

        InscripcionDAO ins = new InscripcionDAO();
        Inscripcion inscripcion = ins.getInscripcion(id_asistente,id_campamento);
        if(inscripcion.getTipoInscripcion() == TipoInscripcion.TEMPRANA){
            ins.cancelarInscripcion(inscripcion);
            return true;
        }

        return false;
    }
    /**
     * Metodo que permite consultar los campamentos disponibles
     * @return lista de campamentos disponibles
     */
    public ArrayList<Campamento> consultarCampamentosDisponibles() {

        CampamentoDAO camp = new CampamentoDAO();
        return camp.getCampamentosInscribibles();
    }

}
