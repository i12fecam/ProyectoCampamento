import java.time.LocalDate;
public class Asistente extends Persona{
    @Override
    private LocalDate fecha_nacimiento;
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
                ", Fecha de Nacimiento:'" + getFecha_nacimiento() + '\'' +
                ", especial=" + isEspecial() +
                '}';
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
