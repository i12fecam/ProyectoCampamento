import java.util.ArrayList;
/**
 * Activity class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Actividad {
    private String nombre;
    public enum NivelEducativo {
        INFANTIL,
        JUVENIL,
        ADOLESCENTE
    }
    private NivelEducativo nivelEducativo;
    public enum Horario {
        MANIANA,
        TARDE
    }
    private Horario horario;
    private int maxParticipantes;
    private int monitoresNecesarios;

    ArrayList<Monitor> monitores = new ArrayList<Monitor>();


    public Actividad() {
    }

    public Actividad(String nombre, NivelEducativo nivelEducativo, Horario horario, int maxParticipantes, int monitoresNecesarios) {
        this.nombre = nombre;
        this.nivelEducativo = nivelEducativo;
        this.horario = horario;
        this.maxParticipantes = maxParticipantes;
        this.monitoresNecesarios = monitoresNecesarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public int getMonitoresNecesarios() {
        return monitoresNecesarios;
    }

    public void setMonitoresNecesarios(int monitoresNecesarios) {
        this.monitoresNecesarios = monitoresNecesarios;
    }

    public ArrayList<Monitor> getMonitores() {return monitores;}

    public void setMonitores(ArrayList<Monitor> monitores) {this.monitores = monitores;}

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", nivelEducativo=" + nivelEducativo +
                ", horario=" + horario +
                ", maxParticipantes=" + maxParticipantes +
                ", monitoresNecesarios=" + monitoresNecesarios +
                ", monitores=" + monitores +
                '}';
    }


    public void asociarMonitor(Monitor monitor) {
        if (!monitores.contains(monitor)) {
            monitores.add(monitor);
        } else {
            throw new RuntimeException("Este monitor ya esta añadido");
        }
    }
}
