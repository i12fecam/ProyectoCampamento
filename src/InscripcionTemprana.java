public class InscripcionTemprana extends Inscripcion{//noe
    public InscripcionTemprana(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = TipoInscripcion.TEMPRANA;
    }

    @Override
    public String toString() {
        return "InscripcionTemprana{" +
                "idParticipante=" + idParticipante +
                ", idCampamento=" + idCampamento +
                ", fechaInscripcion=" + fechaInscripcion +
                ", precio=" + precio +
                ", tipoInscripcion=" + tipoInscripcion +
                '}';
    }
}
}
