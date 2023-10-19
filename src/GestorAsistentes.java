import java.io.*;
import java.util.ArrayList;
/**
 * GestorAsistentes class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public class GestorAsistentes implements Serializable{
    /*Attributes*/
    private ArrayList<Asistente> asistentes;






    public GestorAsistentes() {

            asistentes= new ArrayList<>();


    }




    /**
     * Establece asistentes
     * @param asistentes
     */
    public void setAsistentes(ArrayList<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    /**
     * @return asistentes
     */
    public ArrayList<Asistente> getAsistentes() {return asistentes;}

    /**
     * Método que permite dar de alta a un asistente
     * @param asistente
     * @return true excepto si el asistente ya esta dado de alta o es nulo que retorna false
     */
    public boolean darAlta(Asistente asistente) {
        if (asistente == null) {
            System.out.println("El asistente es nulo.");
            return false;
        }

        if (asistentes.contains(asistente)) {
            System.out.println("El asistente ya está dado de alta.");
            return false;
        }

        asistentes.add(asistente);
        //guardarFichero();
        return true;
    }

    /**
     * Metodo que permite modificar un asistente
     * @param asistente
     */
    public void ModificarAsistente(Asistente asistente) {
        for (Asistente it : asistentes) {
            if (it.getIdentificador() == asistente.getIdentificador()) {

                // Modificar el asistente con los nuevos datos
                it.setNombre(asistente.getNombre());
                it.setApellido1(asistente.getApellido1());
                it.setApellido2(asistente.getApellido2());
                it.setFechaNacimiento(asistente.getFechaNacimiento());
                it.setAtencionEspecial(asistente.isAtencionEspecial());

                // Imprimir un mensaje de éxito
                System.out.println("Asistente modificado con éxito.");

                return; // Terminar el bucle una vez que se modifica el asistente
            }
        }
        System.out.println("No se encontró ningún asistente con ese id.");
    }



    /**
     * Método que nos permite listar a los asistentes
     */
    public void listar() {
        for (Asistente asistente : asistentes) {
            System.out.println(asistente.toString());
        }
    }
}
