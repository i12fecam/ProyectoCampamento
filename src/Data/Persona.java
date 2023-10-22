package Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Person class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public class Persona implements Serializable {
    /*Attributes*/
    protected int identificador;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;

    protected LocalDate fechaNacimiento;

    /* Constructors */

    /**
     * Empty (default) constructor
     * */
    public Persona() {
    }

    /**
     * Parameterized constructor
     * @param identificador
     * @param nombre
     * @param apellido1
     * @param apellido2
     */
    public Persona(int identificador, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }
    /* Getters and setters*/
    /**
     * @return fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return nombre + apellido1 + apellido2
     */
    public String getNombreCompleto() {
        return nombre + apellido1 + apellido2;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Persona.
     *
     * @return Una cadena que contiene los atributos de la instancia en formato legible.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    /**
     * Compara esta instancia de Persona con otra para verificar si tienen el mismo identificador.
     *
     * @param persona La instancia de Persona con la que se va a comparar.
     * @return true si ambas instancias tienen el mismo identificador, false en caso contrario.
     */
    public boolean equals (Persona persona) {
        return persona.identificador == this.identificador;

    }
}