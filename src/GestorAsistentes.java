import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;
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
    private String NombreArchivo;




    /**
     * Parametrized constructor
     * @param NombreArchivo
     */
    public GestorAsistentes(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
        FileInputStream fileInputStream
                = null;
        if(new File(NombreArchivo).length() != 0){

            try {
                fileInputStream = new FileInputStream(NombreArchivo);

                ObjectInputStream objectInputStream
                        = new ObjectInputStream(fileInputStream);
                GestorAsistentes gestor = (GestorAsistentes) objectInputStream.readObject();
                objectInputStream.close();
                this.asistentes = gestor.asistentes;
            } catch (FileNotFoundException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            asistentes= new ArrayList<>();

        }
    }
    public void guardarFichero(){
        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(NombreArchivo);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*Getters and setters*/
    /**
     * @return nombreArchivo
     */
    public String getNombreArchivo() {return NombreArchivo;}

    /**
     * Establece NombreArchivo
     * @param nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
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
                guardarFichero();
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
