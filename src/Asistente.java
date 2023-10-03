import java.time.LocalDate;
public class Asistente extends Persona{
    @Override
    private LocalDate fecha_nacimiento;
    public String toString() {
        return "Asistente{" +
                "identificador=" + getIdentificador() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", especial=" + isEspecial() +
                '}';
    }
}
