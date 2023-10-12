import java.time.LocalDate;

public abstract class Inscripcion {
    protected int idParticipante;
    protected int idCampamento;
    protected LocalDate fechaInscripcion;
    protected float precio;
    protected TipoInscripcion tipoInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio, TipoInscripcion tipoInscripcion) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = tipoInscripcion;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdCampamento() {
        return idCampamento;
    }

    public void setIdCampamento(int idCampamento) {
        this.idCampamento = idCampamento;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public TipoInscripcion getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(TipoInscripcion tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

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
