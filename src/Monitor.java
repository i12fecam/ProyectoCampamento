public class Monitor extends Persona{
    @Override
    public String toString() {
        return "Monitor{" +
                "identificador=" + getIdentificador() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", especial=" + isEspecial() +
                '}';
    }
}
