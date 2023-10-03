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

    }
    public void asociarMonitor(Monitor monitor) {

    }

    public void asociarMonitorEspecial(Monitor monitor) {

    }
}