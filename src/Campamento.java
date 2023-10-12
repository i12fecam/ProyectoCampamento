import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Campament class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class Campamento{
    /*Attributes*/
    private int idCampamento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private NivelEducativo nivelEducativo;
    private int numAsistentes;
    private int maxAsistentes;
    private ArrayList<Monitor> monitores = new ArrayList<Monitor>();
    private ArrayList<Actividad> actividades = new ArrayList<Actividad>();

    /**
     * Empty (default) constructor
     * */
    public Campamento() {
    }

    /**
     * Parameterized constructor
     * @param idCampamento id del campamento
     * @param fechaInicio fecha de inicio del campamento
     * @param fechaFinal fecha de fin del campamento
     * @param nivelEducativo nivel educativo que tiene el campamento
     * @param maxAsistentes numero maximo de asistentes del campamento
     */
    public Campamento(int idCampamento, LocalDate fechaInicio, LocalDate fechaFinal, NivelEducativo nivelEducativo, int maxAsistentes,int numAsistentes) {
        if(fechaFinal.isAfter(fechaInicio)){
            throw new RuntimeException("Las fechas no tienen sentido");
        }
        this.idCampamento = idCampamento;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.nivelEducativo = nivelEducativo;
        this.maxAsistentes = maxAsistentes;
        this.numAsistentes = 0;
    }

    /**
     *
     * @return El id del campamento
     */
    public int getIdCampamento() {
        return idCampamento;
    }

    /**
     * Establece el id del campamento
     * @param idCampamento
     */
    public void setIdCampamento(int idCampamento) {
        this.idCampamento = idCampamento;
    }

    /**
     *
     * @return Fecha de inicio del campamento
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del campamento
     * @param fechaInicio
     */

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @return Fecha de cierre del campamento
     */
    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Establece la fecha de cierre del campamento
     * @param fechaFinal
     */
    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     *
     * @return Nivel educativo del campamento
     */
    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    /**
     * Establece el nivel educativo que tiene el campamento
     * @param nivelEducativo
     */
    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    /**
     *
     * @return Numero maximo de asistentes
     */
    public int getMaxAsistentes() {
        return maxAsistentes;
    }

    /**
     * Establece el número maximo de asistentes
     * @param maxAsistentes
     */
    public void setMaxAsistentes(int maxAsistentes) {
        this.maxAsistentes = maxAsistentes;
    }

    /**
     * Establece la lista con los monitores del campamento
     * @param monitores
     */
    public void setMonitores(ArrayList<Monitor> monitores) {this.monitores = monitores;}

    /**
     *
     * @return Lista con los monitores del campamento
     */
    public ArrayList<Monitor> getMonitores() {return monitores;}

    /**
     *
     * @return Lista con las actividades del campamento
     */
    public ArrayList<Actividad> getActividades() {return actividades;}

    /**
     * Establece la lista con las actividades del campamento
     * @param actividades
     */
    public void setActividades(ArrayList<Actividad> actividades) {this.actividades = actividades;}

    /**
     * @return numAsistentes
     */
    public int getNumAsistentes() {
        return numAsistentes;
    }

    /**
     * @param numAsistentes
     */
    public void setNumAsistentes(int numAsistentes) {
        this.numAsistentes = numAsistentes;
    }

    /**
     * Imprime la informacion del campamento
     * @return Cadena con la informacion del campamento
     */

    @Override
    public String toString() {
        return "Campamento{" +
                "idCampamento=" + idCampamento +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", nivelEducativo=" + nivelEducativo +
                ", numAsistentes=" + numAsistentes +
                ", maxAsistentes=" + maxAsistentes +
                ", monitores=" + monitores +
                ", actividades=" + actividades +
                '}';
    }

    /**
     * Método para asociar una activad al campamento. La actividad se añade si esta es del mismo nivel educativo que el
     * campamento y si previamente no se encuentra añadida a la lista de actividades de dicho campamento
     * @param actividad La actividad que se desea asociar
     */
    public void asociarActividad(Actividad actividad) {
        if(actividad.getNivelEducativo()== this.nivelEducativo && !actividades.contains(actividad)){
            actividades.add(actividad);
        }
    }

    /**
     * Método para asociar un monitor al campamento. Un monitor se añade a la lista si no se encuentra en la lista de
     * monitores del campamento y si es un monitor encargado.
     * @param monitor Monitor que se desea ascoiar
     */
    public void asociarMonitor(Monitor monitor) {
        boolean monitorEncargadoActividad=false;
        for (Actividad it : actividades) {
            if (it.getMonitores().contains(monitor)) {
                monitorEncargadoActividad=true;
                break;
            }
        }
        if (monitorEncargadoActividad && !monitores.contains(monitor)) {
            monitores.add(monitor);
        } else {
            throw new RuntimeException("El monitor no está asociado a ninguna actividad del campamento, no se permite añadirlo");
        }
    }

    /**
     *
     * Método para asociar un monitor especial al campamento. Este se añade a la lista de monitores si no se encuentra
     * previamente añadido como monitor para ese mismo campamento y si es monitor especial
     * @param monitorEspecial Monitor especial que se desea asociar
     */
    public void asociarMonitorEspecial(Monitor monitorEspecial) {
        for (Actividad it : actividades) {
            if (it.getMonitores().contains(monitorEspecial)) {
                throw new RuntimeException("El monitor especial no puede estar asociado a ninguna actividad, no se puede añadir");
            }
        }
        if (!monitores.contains(monitorEspecial) && monitorEspecial.isEducadorEspecial()) {
            monitores.add(monitorEspecial);
        } else {
            throw new RuntimeException("El monitor ya está asociado o no es educador especial");
        }
    }
    public boolean equals (Campamento campamento) {
        return campamento.idCampamento == this.idCampamento;

    }
    public boolean tieneMonitorEspecial(){
        for(Monitor it:monitores){
            if(it.isEducadorEspecial()){
                return true;
            }
        }
        return false;
    }

    /**
     * Método que nos permite incrementar el numero de asistentes de un campamento
     */
    public void anadirAsistenteCampamento() {
        if (comprobarAsistentes()) {
            numAsistentes++;
        }
    }

    /**
     * Método para anadir comprobar si el numero de asistentes a un campamento es menor que el numero maximo de asistentes
     * @return true si numAsistentes<maxAsistentes, si no devuelve false
     */
    public boolean comprobarAsistentes() {
        if (numAsistentes < maxAsistentes) {
            return true;
        }
        return false;
    }
}



