import java.time.LocalDate;
import java.util.ArrayList;

public class GestorCampamentos {
    private ArrayList<Campamento> campamentos;

    private ArrayList<Monitor> monitores;
    private ArrayList<Actividad> actividades;
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
    public boolean asociarMonitorActividad(int idMonitor,int idActividad)
    {
        Actividad actividad = actividades.get(idActividad);
        Monitor monitor = monitores.get(idMonitor);


    }
    public boolean asociarActividadCampamento(){
        return false;
    }

    public boolean asociarMonitorCampamento(){
        return false;
    }
    public boolean asociarMonitorEspecialCampamento(){
        return false;
    }

    public Campamento buscarCampamento(int idCampamento) {
        for (Campamento campamento : campamentos) {
            if (campamento.getIdCampamento() == idCampamento) {
                return campamento;
            }
        }
        return null;
    }
}
