import java.time.LocalDate;

public abstract class InscripcionFactory {


    public abstract InscripcionCompleta crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);

    public abstract InscripcionParcial crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
}