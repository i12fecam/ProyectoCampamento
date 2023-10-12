import java.time.LocalDate;

public abstract class InscripcionFactory {

    protected int idParticipante;
    protected int idCampamento;
    protected LocalDate fechaInscripcion;
    protected float precio;
    protected TipoInscripcion tipoInscripcion;
    public abstract InscripcionTardia crearInscripcionTardia(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);

    public abstract InscripcionTemprana crearInscripcionTemprana(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
}