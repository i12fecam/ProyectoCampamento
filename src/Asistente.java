import java.time.LocalDate;
public class Asistente extends Persona{

    private LocalDate fechaNacimiento;
    private boolean atencionEspecial;
    public Asistente(){

    };
    public Asistente(int identificador, String nombre, String apellido1, String apellido2, boolean atencionEspecial, LocalDate fechaNacimiento) {
        super(identificador, nombre, apellido1, apellido2);
        this.fechaNacimiento = fechaNacimiento;
        this.atencionEspecial=atencionEspecial;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(boolean atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
    public String toString() {
        return "Asistente{" +
                "identificador=" + getIdentificador() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", Fecha de Nacimiento:'" + getFechaNacimiento() + '\'' +
                ", especial=" + isEspecial() +
                '}';
    }
