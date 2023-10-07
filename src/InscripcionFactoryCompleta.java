import java.time.LocalDate;

public class InscripcionFactoryCompleta extends InscripcionFactory{//abi
    @Override
    public InscripcionTardia crearInscripcionTardia(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio) {
        return null;
    }

    @Override
    public InscripcionTemprana crearInscricionTemprana(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio) {
        return null;
    }
}
