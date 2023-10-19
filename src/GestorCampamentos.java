import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * GestorCampamentos class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class GestorCampamentos implements Serializable {
    private ArrayList<Campamento> campamentos;
    private String NombreArchivo;
    private ArrayList<Monitor> monitores;
    private ArrayList<Actividad> actividades;

    /**
     * empty(default) constructor
     **/
    public GestorCampamentos() {
        campamentos = new ArrayList<>();
        monitores = new ArrayList<>();
        actividades = new ArrayList<>();
    }

    /**
     * parametrized constructor
     *
     * @param NombreArchivo
     */
    public GestorCampamentos(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
        FileInputStream fileInputStream
                = null;
        if(new File(NombreArchivo).length() != 0){

            try {
                fileInputStream = new FileInputStream(NombreArchivo);

                ObjectInputStream objectInputStream
                        = new ObjectInputStream(fileInputStream);
                GestorCampamentos gestor = (GestorCampamentos) objectInputStream.readObject();
                objectInputStream.close();
                this.campamentos= gestor.campamentos;
                this.monitores = gestor.monitores;
                this.actividades = gestor.actividades;
            } catch (FileNotFoundException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            campamentos = new ArrayList<>();
            monitores = new ArrayList<>();
            actividades = new ArrayList<>();
        }


    }


    /**
     * Guarda el objeto actual en un archivo mediante la serialización.
     *
     * Este método guarda el objeto actual en un archivo utilizando la serialización de objetos
     * de Java. El objeto es guardado en el archivo especificado por el atributo "NombreArchivo".
     *
     * @throws RuntimeException si ocurre un error durante la operación de escritura en el archivo.
     */
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


    /**
     * Metodo que crea un campamento
     * @param fechaInicio
     * @param fechaFinal
     * @param nivelEducativo
     * @param maxAsistentes
     */

    public void crearCampamento( LocalDate fechaInicio, LocalDate fechaFinal, NivelEducativo nivelEducativo, int maxAsistentes){
        int idCampamento = campamentos.size();
        Campamento campamento = new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes);

        campamentos.add(campamento);
    }

    /**
     * Metodo que crea un monitor
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param fechaNacimiento
     * @param educadorEspecial
     */
    public void crearMonitor( String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, boolean educadorEspecial){
        int identificador = monitores.size();
        Monitor monitor = new Monitor(identificador,nombre,apellido1,apellido2,fechaNacimiento,educadorEspecial);

        monitores.add(monitor);
    }

    /**
     * Metodo que crea una actividad
     * @param nombre
     * @param nivelEducativo
     * @param horario
     * @param maxParticipantes
     * @param monitoresNecesarios
     */
    public void crearActividad(String nombre, NivelEducativo nivelEducativo, Horario horario, int maxParticipantes, int monitoresNecesarios){
        int identificador = actividades.size();
        Actividad actividad = new Actividad(nombre,identificador,nivelEducativo,horario,maxParticipantes,monitoresNecesarios);

        actividades.add(actividad);
    }

    /**
     * Metodo que asocia un monitor a una actividad
     * @param idMonitor
     * @param idActividad
     */
    public void asociarMonitorActividad(int idMonitor,int idActividad)
    {
        Actividad actividad = actividades.get(idActividad);
        Monitor monitor = monitores.get(idMonitor);
        actividad.asociarMonitor(monitor);

    }

    /**
     * Metodo que asocia una actividad a un campamento
     * @param idActividad
     * @param idCampamento
     */
    public void asociarActividadCampamento(int idActividad,int idCampamento){
        Actividad actividad = actividades.get(idActividad);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarActividad(actividad);

    }

    /**
     * Metodo que asocia un monitor a un campamento
     * @param idMonitor
     * @param idCampamento
     */
    public void asociarMonitorCampamento(int idMonitor, int idCampamento){
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitor(monitor);

    }

    /**
     * Metodo que asocia un monitor especial a un campamento
     * @param idMonitor
     * @param idCampamento
     */
    public void asociarMonitorEspecialCampamento(int idMonitor, int idCampamento){
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitorEspecial(monitor);
    }

    /**
     * Imprime en la consola una representación en cadena de los objetos Campamento almacenados en la lista "campamentos".
     *
     * Este método itera a través de la lista de objetos Campamento almacenados en el atributo "campamentos" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Campamento.
     */
    public void toStringCampamentos(){
        for(Campamento it:campamentos){
            System.out.println(it.toString());;
        }
    }
    /**
     * Imprime en la consola una representación en cadena de los objetos Monitor almacenados en la lista "monitores".
     *
     * Este método itera a través de la lista de objetos Monitor almacenados en el atributo "monitores" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Monitor.
     */
    public void toStringMonitores(){
        for(Monitor it:monitores){
            System.out.println(it.toString());;
        }
    }
    /**
     * Imprime en la consola una representación en cadena de los objetos Actividad almacenados en la lista "actividades".
     *
     * Este método itera a través de la lista de objetos Actividad almacenados en el atributo "actividades" e imprime
     * en la consola una representación en cadena de cada uno de ellos utilizando el método "toString" de la clase Actividad.
     */
    public void toStringActividades(){
        for(Actividad it:actividades){
            System.out.println(it.toString());;
        }
    }
    /**
     * Método para buscar un campamento
     * @param idCampamento
     * @return campamento si lo encuentra, y si no retorna null
     */
    public Campamento buscarCampamento(int idCampamento) {
        for (Campamento campamento : campamentos) {
            if (campamento.getIdCampamento() == idCampamento) {
                return campamento;
            }
        }
        return null;
    }
    /* Getters and setters*/
    /**
     * @return NombreArchivo
     */
    /*Getters and setters*/
    public String getNombreArchivo() {return NombreArchivo;}
    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }

    /**
     * @return campamentos
     */
    public ArrayList<Campamento> getCampamentos() {return campamentos;}

    /**
     * @return monitores
     */
    public ArrayList<Monitor> getMonitores() {return monitores;}

    /**
     * @return actividades
     */
    public ArrayList<Actividad> getActividades() {return actividades;}

    /**
     * @param campamentos
     */
    public void setCampamentos(ArrayList<Campamento> campamentos) {
        this.campamentos = campamentos;
    }

    /**
     * @param monitores
     */
    public void setMonitores(ArrayList<Monitor> monitores) {
        this.monitores = monitores;
    }

    /**
     * @param actividades
     */
    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }


}
