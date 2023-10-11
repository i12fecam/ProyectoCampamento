import java.time.LocalDate;
import java.util.ArrayList;

public class GestorCampamentos {
    private ArrayList<Campamento> campamentos;
    private String NombreArchivo;
    private ArrayList<Monitor> monitores;
    private ArrayList<Actividad> actividades;

    public GestorCampamentos(){}
    public GestorCampamentos(String NombreArhivo){
        this.NombreArchivo=NombreArhivo;
    }
    private void cargarFichero(){

    }
    public void crearCampamento( LocalDate fechaInicio, LocalDate fechaFinal, NivelEducativo nivelEducativo, int maxAsistentes){
        int idCampamento = campamentos.size();
        Campamento campamento = new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes);

        campamentos.add( new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes));
    }

    public void crearMonitor( String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, boolean educadorEspecial){
        int identificador = monitores.size();
        Monitor monitor = new Monitor(identificador,nombre,apellido1,apellido2,fechaNacimiento,educadorEspecial);

        monitores.add(monitor);
    }

    public void crearActividad(String nombre, NivelEducativo nivelEducativo, Horario horario, int maxParticipantes, int monitoresNecesarios){
        int identificador = actividades.size();
        Actividad actividad = new Actividad(nombre,identificador,nivelEducativo,horario,maxParticipantes,monitoresNecesarios);

        actividades.add(actividad);
    }
    public void asociarMonitorActividad(int idMonitor,int idActividad)
    {
        Actividad actividad = actividades.get(idActividad);
        Monitor monitor = monitores.get(idMonitor);
        actividad.asociarMonitor(monitor);

    }
    public void asociarActividadCampamento(int idActividad,int idCampamento){
        Actividad actividad = actividades.get(idActividad);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarActividad(actividad);

    }

    public void asociarMonitorCampamento(int idMonitor, int idCampamento){
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitor(monitor);

    }
    public void asociarMonitorEspecialCampamento(int idMonitor, int idCampamento){
        Monitor monitor = monitores.get(idMonitor);
        Campamento campamento = campamentos.get(idCampamento);
        campamento.asociarMonitorEspecial(monitor);
    }

    public Campamento buscarCampamento(int idCampamento) {
        for (Campamento campamento : campamentos) {
            if (campamento.getIdCampamento() == idCampamento) {
                return campamento;
            }
        }
        return null;
    }

    public String getNombreArchivo() {return NombreArchivo;}

    public ArrayList<Campamento> getCampamentos() {return campamentos;}

    public ArrayList<Monitor> getMonitores() {return monitores;}

    public ArrayList<Actividad> getActividades() {return actividades;}

    public void setCampamentos(ArrayList<Campamento> campamentos) {
        this.campamentos = campamentos;
    }

    public void setMonitores(ArrayList<Monitor> monitores) {
        this.monitores = monitores;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }
}
