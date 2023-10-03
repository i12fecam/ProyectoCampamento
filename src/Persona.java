
public class Persona {
    private int identificador;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private boolean especial;


    public Persona() {
    }

    public Persona(int identificador, String nombre, String apellido1, String apellido2, boolean especial) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.especial = especial;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    public String getNombreCompleto() {
        return nombre + apellido1 + apellido2;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", especial=" + especial +
                '}';
    }
}
