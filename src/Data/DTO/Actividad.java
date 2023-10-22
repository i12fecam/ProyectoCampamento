package Data.DTO;

import Data.Horario;
import Data.NivelEducativo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Activity class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Actividad implements Serializable {
    /*Attributes*/
    private String nombre;

    private int identificador;
    private NivelEducativo nivelEducativo;

    private Horario horario;
    private int maxParticipantes;
    private int monitoresNecesarios;

    ArrayList<Monitor> monitores = new ArrayList<Monitor>();

    /* Constructors */
    /**
     * Empty (default) constructor
     */
    public Actividad() {
    }

    /**
     *  Parameterized constructor
     * @param nombre Nombre de la actividad
     * @param identificador identificador de la actividad
     * @param nivelEducativo Nivel educativo que tiene la actividad
     * @param horario Horario de la actividad
     * @param maxParticipantes Numero maximo de participantes que tiene la actividad
     * @param monitoresNecesarios Numero de monitores necesarios
     */
    public Actividad(String nombre, int identificador, NivelEducativo nivelEducativo, Horario horario, int maxParticipantes, int monitoresNecesarios) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.nivelEducativo = nivelEducativo;
        this.horario = horario;
        this.maxParticipantes = maxParticipantes;
        this.monitoresNecesarios = monitoresNecesarios;
    }
    /*getters and setters*/
    /**
     * @return Nombre de la actividad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la actividad
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Identificador de la Actividad
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @return Nivel educativo de la actividad
     */
    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    /**
     * Establece el nivel educativo de la actividad
     * @param nivelEducativo
     */
    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    /**
     * @return Horario de la actividad
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Establece el horario de la actividad
     * @param horario
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * @return Numero maximo de participantes de la actividad
     */
    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    /**
     * Establece el numero maximo de partcipentes de la actividad
     * @param maxParticipantes
     */
    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    /**
     * @return Numero de monitores necesarios
     */
    public int getMonitoresNecesarios() {
        return monitoresNecesarios;
    }

    /**
     * Establece el número de monitores necesarios
     * @param monitoresNecesarios
     */
    public void setMonitoresNecesarios(int monitoresNecesarios) {
        this.monitoresNecesarios = monitoresNecesarios;
    }

    /**
     * @return Lista con los monitores asociados a la actividad
     */
    public ArrayList<Monitor> getMonitores() {return monitores;}

    /**
     * Establece la lista con los monitores asociados a la actividad
     * @param monitores
     */
    public void setMonitores(ArrayList<Monitor> monitores) {this.monitores = monitores;}

    /**
     * Imprime la información de la actividad
     * @return Cadena con toda la información necesaria de una actividad
     */
    @Override
    public String toString() {
        return "Actividad{" +
                "Id=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", nivelEducativo=" + nivelEducativo +
                ", horario=" + horario +
                ", maxParticipantes=" + maxParticipantes +
                ", monitoresNecesarios=" + monitoresNecesarios +
                ", monitores=" + monitores +
                '}';
    }


    /**
     * Método para asociar un monitor a una actividad. Solo se asocian si no s ha sobrepasado el limite de monitores
     * necesarios y si además dicho monitor no se encuentra previamente añadido en la lista de los monitores de la
     * actividad
     * @param monitor Monitor que se desea asociar
     */
    public void asociarMonitor(Monitor monitor) {
        if (!monitores.contains(monitor) ) {
            if(monitores.size()<getMonitoresNecesarios()) {
                monitores.add(monitor);
            }else{
                throw new RuntimeException("Nº monitores necesarios alcanzado");
            }
        } else {
            throw new RuntimeException("Este monitor ya esta añadido");
        }
    }
    public boolean equals (Actividad actividad) {
        return actividad.identificador == this.identificador;

    }


}