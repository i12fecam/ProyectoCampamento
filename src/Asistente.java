import java.time.LocalDate;
/**
 * Assistant  class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Asistente extends Persona{

    private LocalDate fechaNacimiento;
    private boolean atencionEspecial;

    /**
     *  Constructor vacio para un objeto Asistente
     */
    public Asistente(){

    };

    /**
     *  Constructor para un objeto Asistente
     * @param identificador El identificador del asistente
     * @param nombre El nombre del asistente
     * @param apellido1 El primero apellido del asistente
     * @param apellido2 El segundo apellido del asistente
     * @param atencionEspecial Indica si el asistente requiere atencion especial
     * @param fechaNacimiento La fecha de nacimiento del asistente
     */
    public Asistente(int identificador, String nombre, String apellido1, String apellido2, boolean atencionEspecial, LocalDate fechaNacimiento) {
        super(identificador, nombre, apellido1, apellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.atencionEspecial=atencionEspecial;
    }

    /**
     *  Obtiene la fecha de nacimiento del Asistente
     * @return Fecha de nacimiento del asistente
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
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
     * Establece la fecha de nacimiento del Asistente
     * @param fechaNacimiento Fecha de nacimiento del Asistente
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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


