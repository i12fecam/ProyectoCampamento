
import java.util.ArrayList;

public class GestorAsistentes {
    private ArrayList<Asistente> asistentes;

    private void cargarFichero(){

    }
    public GestorAsistentes() {
    }

    public boolean darAlta(Asistente asistente){
        if(asistentes.contains(asistente)){
            return false;
        }
        asistentes.add(asistente);
        return true;
    }
    //modificarAsistentes , hacemos una funcion por cada atributo a modificar?
    public void listar(){

    }
}
