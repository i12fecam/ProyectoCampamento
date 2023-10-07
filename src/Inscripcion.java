public abstract class Inscripcion {//abi
    protected int idParticipante;
    protected int idCampamento;
    protected localDate fechaInscripcion;
    protected float precio;
    protected TipoInscripcion tipoInscripcion;

    public Inscripcion() {
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

    public localDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(localDate fechaInscripcion) {
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
