import java.time.LocalDate;
import java.util.ArrayList;

public class Campamento{
    private int idCampamento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private Actividad.NivelEducativo nivelEducativo;

    private int maxAsistentes;
    ArrayList<Monitor> monitores = new ArrayList<Monitor>();
    ArrayList<Actividad> actividades = new ArrayList<Actividad>();

    public Campamento() {
    }

    public Campamento(int idCampamento, LocalDate fechaInicio, LocalDate fechaFinal, Actividad.NivelEducativo nivelEducativo, int maxAsistentes) {
        this.idCampamento = idCampamento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nivelEducativo = nivelEducativo;
        this.maxAsistentes = maxAsistentes;
    }

    public int getIdCampamento() {
        return idCampamento;
    }

    public void setIdCampamento(int idCampamento) {
        this.idCampamento = idCampamento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Actividad.NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(Actividad.NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public int getMaxAsistentes() {
        return maxAsistentes;
    }

    public void setMaxAsistentes(int maxAsistentes) {
        this.maxAsistentes = maxAsistentes;
    }

    public void setMonitores(ArrayList<Monitor> monitores) {this.monitores = monitores;}

    public ArrayList<Monitor> getMonitores() {return monitores;}

    public ArrayList<Actividad> getActividades() {return actividades;}

    public void setActividades(ArrayList<Actividad> actividades) {this.actividades = actividades;}

    @Override
    public String toString() {
        return "Campamento{" +
                "idCampamento=" + idCampamento +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", nivelEducativo=" + nivelEducativo +
                ", maxAsistentes=" + maxAsistentes +
                ", monitores=" + monitores +
                ", actividades=" + actividades +
                '}';
    }

    public void asociarActividad(Actividad actividad) {
        if(actividad.getnivelEducativo== this.nivelEducativo && !actividades.containd(actividad)){
            actividades.add(actividad);
        }
    }
    public void asociarMonitor(Monitor monitor) {

    }

    public void asociarMonitorEspecial(Monitor monitor) {

    }
}