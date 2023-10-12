import java.time.LocalDate;

public class InscripcionCompleta extends Inscripcion{

    private int duracion;
    public InscripcionCompleta(){}
    public InscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio, int duracion) {
        super(idParticipante, idCampamento, fechaInscripcion, precio,TipoInscripcion.COMPLETA);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }
}