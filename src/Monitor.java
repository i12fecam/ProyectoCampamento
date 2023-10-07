/**
 * Monitor class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Monitor extends Persona{
    @Override
    private boolean educadorEspecial;
    /**Constructor vacío**/
    public Monitor{

    }
    /**Constructor con todos sus parametros obligatorios
     * @param identificador El identificador del monitor.
     * @param nombre El nombre del monitor.
     * @param apellido1 El primer apellido del monitor.
     * @param apellido2 El segundo apellido del monitor.
     * @param educadorEspecial Indica si el monitor es educador especial.
     * @param fechaNacimiento La fecha de nacimiento del monitor.
    */
    public Monitor(int identificador, String nombre, String apellido1, String apellido2, boolean educadorEspecial, LocalDate fechaNacimiento) {
        super(identificador, nombre, apellido1, apellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.educadorEspecial=educadorEspecial;
    }
    /**Setter atributo educadorEspecial**/
    public void setEducadorEspecial(boolean educadorEspecial) {
        this.educadorEspecial = educadorEspecial;
    }

    /**Devuelve si el Monitor es educador especial**/
    public boolean isEducadorEspecial() {
        return educadorEspecial;
    }

    /**Imprime toda la informacion del Monitor**/
    public String toString() {
        return "Monitor{" +
                "identificador=" + getIdentificador() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", especial=" + isEducadorEspecial() +
                '}';
    }
}
