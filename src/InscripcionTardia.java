import java.time.LocalDate;

public abstract class InscripcionTardia extends InscripcionFactory{

    public InscripcionTardia(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = TipoInscripcion.TARDIA;
    }

    public String toString(){
        return "InscripcionTardia{" +
                "idParticipante=" + idParticipante +
                ", idCampamento=" + idCampamento +
                ", fechaInscripcion=" + fechaInscripcion +
                ", precio=" + precio +
                ", tipoInscripcion=" + tipoInscripcion +
                '}';
    }
}
