import java.time.LocalDate;
/**
 * Assistant  class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Asistente extends Persona{


    private boolean atencionEspecial;

    /**
     *  Constructor vacio para un objeto Asistente
     */
    public Asistente(){

    }

    /**
     *  Constructor para un objeto Asistente
     * @param identificador El identificador del asistente
     * @param nombre El nombre del asistente
     * @param apellido1 El primero apellido del asistente
     * @param apellido2 El segundo apellido del asistente
     * @param atencionEspecial Indica si el asistente requiere atencion especial
     * @param fechaNacimiento La fecha de nacimiento del asistente
     */
    public Asistente(int identificador, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, boolean atencionEspecial) {
        super(identificador, nombre, apellido1, apellido2, fechaNacimiento);
        this.atencionEspecial = atencionEspecial;
    }


    /**
     *  Verifica si el Asistente requiere atencion especial
     * @return True si el asistente requiere atencion especial, false en caso de no necesitarla
     */
    public boolean isAtencionEspecial() {
        return atencionEspecial;
    }

    /**
     * Establece si el Asistente requiere atencion especial
     * @param atencionEspecial true si el Asistente requiere atencion especial, false en caso de no necesitarla
     */
    public void setAtencionEspecial(boolean atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }



    /**
     * Es una representacion del objeto Asistente
     * @return Una cadena que contiene los detalles del Asistente
     */
    public String toString() {
        return "Asistente{" +
                "identificador=" + getIdentificador() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", Fecha de Nacimiento:'" + getFechaNacimiento() + '\'' +
                ", especial=" + isAtencionEspecial() +
                '}';
    }

}


