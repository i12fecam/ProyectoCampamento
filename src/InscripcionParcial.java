import java.time.LocalDate;

public class InscripcionParcial extends Inscripcion {


    private int duracion;

    public InscripcionParcial() {
    }

    public InscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio, int duracion) {
        super(idParticipante, idCampamento, fechaInscripcion, precio, TipoInscripcion.PARCIAL);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }
}