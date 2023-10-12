import java.time.LocalDate;

public class InscripcionCompleta extends Inscripcion{

    public InscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio, TipoInscripcion tipoInscripcion) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = tipoInscripcion;
        this.horario = Horario.COMPLETA;
    }
}