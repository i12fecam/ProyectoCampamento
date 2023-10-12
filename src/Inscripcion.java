import java.time.LocalDate;
/**
 * Inscripcion class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public abstract class Inscripcion {//abi
    protected int idParticipante;
    protected int idCampamento;
    protected LocalDate fechaInscripcion;
    protected float precio;
    protected TipoInscripcion tipoInscripcion;


    /**
     * empty(default) constructor
     */
    public Inscripcion() {
    }

    /**
     * @return idParticipante
     */
    public int getIdParticipante() {
        return idParticipante;
    }
    /*Getters and setters*/
    /**
     * @param idParticipante
     */
    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    /**
     * @return idCampamento
     */
    public int getIdCampamento() {
        return idCampamento;
    }

    /**
     * @param idCampamento
     */
    public void setIdCampamento(int idCampamento) {
        this.idCampamento = idCampamento;
    }

    /**
     * @return fechaInscripcion
     */
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * @param fechaInscripcion
     */
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return tipoInscripcion
     */
    public TipoInscripcion getTipoInscripcion() {
        return tipoInscripcion;
    }

    /**
     * @param tipoInscripcion
     */
    public void setTipoInscripcion(TipoInscripcion tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

    /**
     * @return toda la información de la clase inscripcion
     */
    @Override
    public String toString() {
        return "Inscripcion{" +
                "idParticipante=" + idParticipante +
                ", idCampamento=" + idCampamento +
                ", fechaInscripcion=" + fechaInscripcion +
                ", precio=" + precio +
                ", tipoInscripcion=" + tipoInscripcion +
                '}';
    }
}
