import java.time.LocalDate;
import java.util.ArrayList;
/**
 * GestorCampamentos class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class GestorCampamentos {
    private ArrayList<Campamento> campamentos;
    private String NombreArchivo;
    private ArrayList<Monitor> monitores;
    private ArrayList<Actividad> actividades;
    /**
    * empty(default) constructor
     **/
    public GestorCampamentos(){}

    /**
     * parametrized constructor
     * @param NombreArhivo
     */
    public GestorCampamentos(String NombreArhivo){
        this.NombreArchivo=NombreArhivo;
        this.campamentos = new ArrayList<>();
    }
    //private void cargarFichero(){

    /**
     * @param fechaInicio
     * @param fechaFinal
     * @param nivelEducativo
     * @param maxAsistentes
     * @param numAsistentes
     */
    //}
    public void crearCampamento( LocalDate fechaInicio, LocalDate fechaFinal, NivelEducativo nivelEducativo, int maxAsistentes,int numAsistentes){
        int idCampamento = campamentos.size();
        Campamento campamento = new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes,0);

        campamentos.add(campamento);
    }

    /**
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
     * @param idActividad
     * @param idCampamento
     */
    public void asociarActividadCampamento(int idActividad,int idCampamento){
        Actividad actividad = actividades.get(idActividad);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarActividad(actividad);

    }

    /**
     * @param idMonitor
     * @param idCampamento
     */
    public void asociarMonitorCampamento(int idMonitor, int idCampamento){
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitor(monitor);

    }

    /**
     * @param idMonitor
     * @param idCampamento
     */
    public void asociarMonitorEspecialCampamento(int idMonitor, int idCampamento){
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitorEspecial(monitor);
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

    /**
     * @return NombreArchivo
     */
    /*Getters and setters*/
    public String getNombreArchivo() {return NombreArchivo;}

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

    /**
     * @param nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }
}
