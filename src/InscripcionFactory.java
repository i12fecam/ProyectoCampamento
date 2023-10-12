import java.time.LocalDate;

public abstract class InscripcionFactory {

    protected int idParticipante;
    protected int idCampamento;
    protected LocalDate fechaInscripcion;
    protected float precio;
    protected TipoInscripcion tipoInscripcion;
    public abstract InscripcionCompleta crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);

    public abstract InscripcionParcial crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
}