public class Monitor extends Persona{
    @Override
    private boolean educadorEspecial;
    public Monitor{

    }
    public Monitor(int identificador, String nombre, String apellido1, String apellido2, boolean educadorEspecial, LocalDate fechaNacimiento) {
        super(identificador, nombre, apellido1, apellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.educadorEspecial=educadorEspecial;
    }
    public void setEducadorEspecial(boolean educadorEspecial) {
        this.educadorEspecial = educadorEspecial;
    }
    public boolean isEducadorEspecial() {
        return educadorEspecial;
    }
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
