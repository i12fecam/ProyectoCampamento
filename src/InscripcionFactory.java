import java.time.LocalDate;

public abstract class InscripcionFactory {
    public abstract InscripcionTardia crearInscripcionTardia(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
    public abstract InscripcionTemprana crearInscricionTemprana(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
}
