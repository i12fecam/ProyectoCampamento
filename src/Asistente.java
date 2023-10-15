import java.io.Serializable;
import java.time.LocalDate;
/**
 * Assistant  class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Asistente extends Persona implements Serializable {

    /*Attributes*/
    private boolean atencionEspecial;

    /**
     * empty(default) constructor
     */
    public Asistente(){

    }

    /**
     *  Parametrized constructor
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
     * Convierte los atributos de un objeto en una cadena de texto en formato CSV (Valores Separados por Comas).
     *
     * @return Una cadena de texto que contiene los valores de los atributos separados por espacios en blanco y seguidos por un salto de línea.
     */
    public String toCSV() {
        String atencionEspecialStr = atencionEspecial ? "true" : "false";
        return identificador + " " + nombre + " " + apellido1 + " " + apellido2 + " " + fechaNacimiento + " " + atencionEspecialStr + "\n";
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


