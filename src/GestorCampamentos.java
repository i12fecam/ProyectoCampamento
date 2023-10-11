import java.time.LocalDate;
import java.util.ArrayList;

public class GestorCampamentos {
    private ArrayList<Campamento> campamentos;

    private ArrayList<Monitor> monitores;
    private ArrayList<Actividad> actividades;
    private void cargarFichero(){

    }
    public void crearCampamento(int idCampamento, LocalDate fechaInicio, LocalDate fechaFinal, NivelEducativo nivelEducativo, int maxAsistentes){
        Campamento campamento = new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes);
        if(campamentos.contains(campamento)){
            throw new RuntimeException("El campamento ya existia");
        }
        campamentos.add( new Campamento(idCampamento,fechaInicio,fechaFinal,nivelEducativo,maxAsistentes));
    }

    public void crearMonitor(int identificador, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, boolean educadorEspecial){
        Monitor monitor = new Monitor(identificador,nombre,apellido1,apellido2,fechaNacimiento,educadorEspecial);
        if(monitores.contains(monitor)){
            throw  new RuntimeException("El monitor ya existía");
        }
        monitores.add(monitor);
    }

    public void crearActividad(String nombre, int identificador, NivelEducativo nivelEducativo, Horario horario, int maxParticipantes, int monitoresNecesarios){
        Actividad actividad = new Actividad(nombre,identificador,nivelEducativo,horario,maxParticipantes,monitoresNecesarios);
        if(actividades.contains(actividad)){
            throw new RuntimeException("la actividad ya existía");
        }
        actividades.add(actividad);
    }
    public boolean asociarMonitorActividad(){
        return false;
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
}
