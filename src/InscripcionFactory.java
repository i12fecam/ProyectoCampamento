public abstract class InscripcionFactory {
    public abstract InscripcionTardia crearInscripcionTardia(int idParticipante, int idCampamento, localDate fechaInscripcion, float precio);
    public abstract InscripcionTemprana crearInscricionTemprana(int idParticipante, int idCampamento, localDate fechaInscripcion, float precio);
}
