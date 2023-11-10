package Business;

import Data.DAO.AsistenteDAO;
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
     * @param id_asistente
     * @param id_campamento
     * @param fechaInscripcion
     * @param horario
     */
    public void crearInscripcion(int id_asistente,int id_campamento, LocalDate fechaInscripcion, Horario horario){

        InscripcionDAO ins = new InscripcionDAO();
        CampamentoDAO camp = new CampamentoDAO();
        AsistenteDAO asis = new AsistenteDAO();
        Asistente asistente = asis.getAsistente(id_asistente);
        Campamento campamento = camp.devolverCampamento(id_campamento);
        float precio;

        //comprobar si el campamento sigue teniendo espacio
       if(ins.GetInscritos(id_campamento) > campamento.getMaxAsistentes())
       {
           throw new RuntimeException("El campamento ya se encuentra lleno");
       }


        //mirar si es tardia
        TipoInscripcion tipoInscripcion;
        if(fechaInscripcion.isBefore(campamento.getFechaInicio().minusDays(15))){
            tipoInscripcion = TipoInscripcion.TEMPRANA;
        }
        else if(fechaInscripcion.isAfter(campamento.getFechaInicio().minus(15, ChronoUnit.DAYS)) && fechaInscripcion.isBefore(campamento.getFechaInicio().minus(2,ChronoUnit.DAYS))){

            tipoInscripcion = TipoInscripcion.TARDIA;
        }
        else{
            throw new RuntimeException("La fecha de inscripcion es demasiado tardia");
        }

        //comprobar si necesita monitor especial

        if (asistente.isAtencionEspecial() && !campamento.tieneMonitorEspecial()) {
            //añadir monitor especial al campamento
            System.out.println("!!!!ATENCION: Después de esta operación asegurese de añadir un monitor especial al campamento");
        }

        //calcular precio
        if(horario == Horario.PARCIAL){
            precio = 100;
            precio = precio + camp.getNumActividadesParciales(campamento.getIdCampamento())*20;
        }else{
            precio = 300;
        }
        //se crea la inscripción
        ins.nuevaInscripcion(new Inscripcion(asistente.getIdentificador(),campamento.getIdCampamento(),fechaInscripcion,precio,tipoInscripcion,horario));
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
    public void consultarCampamentosDisponibles() {

        CampamentoDAO camp = new CampamentoDAO();

        ArrayList<Campamento> listaCampamentos = camp.getCampamentosInscribibles();
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

}
