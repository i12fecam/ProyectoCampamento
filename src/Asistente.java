import java.time.LocalDate;
public class Asistente extends Persona{

    private LocalDate fechaNacimiento;
    public Asistente(){

    }
    public Asistente(int identificador, String nombre, String apellido1, String apellido2, boolean especial, LocalDate fechaNacimiento) {
        super(identificador, nombre, apellido1, apellido2, especial);
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
