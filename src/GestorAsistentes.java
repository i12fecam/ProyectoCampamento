
import java.util.ArrayList;

public class GestorAsistentes {
    private ArrayList<Asistente> asistentes;
    private String NombreArchivo;

    private void cargarFichero(){

    }
    public GestorAsistentes() {
    }

    public GestorAsistentes(String NombreArchivo){
        this.NombreArchivo=NombreArchivo;
    }

    public String getNombreArchivo() {return NombreArchivo;}

    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }

    public void setAsistentes(ArrayList<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public ArrayList<Asistente> getAsistentes() {return asistentes;}

    public boolean darAlta(Asistente asistente) {
        if (asistentes.contains(asistente)) {
            throw new IllegalArgumentException("El asistente ya esta dado de alta");

        }
        asistentes.add(asistente);
        return true;
    }
    //modificarAsistentes , hacemos una funcion por cada atributo a modificar?
    public void listar() {
        String valor;
        for (Asistente asistente : asistentes) {
            if(asistente.isAtencionEspecial()){
                valor="true";
            }else{
                valor="false";
            }
            System.out.println ("Asistente{" +
                    "identificador=" + asistente.getIdentificador() +
                    ", nombre='" + asistente.getNombre() + '\'' +
                    ", apellido1='" + asistente.getApellido1() + '\'' +
                    ", apellido2='" + asistente.getApellido2() + '\'' +
                    ", Fecha de Nacimiento:'" + asistente.getFechaNacimiento() + '\'' +
                    ",especial=" + valor +
                    '}');
        }
    }


}