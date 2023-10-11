import java.time.LocalDate;

public class InscripcionFactoryParcial extends InscripcionFactory{//quintero

    @Override
    public InscripcionTardia crearInscripcionTardia(int idParticipante,int idCampamento, LocalDate fechaInscripcion,float precio)
    {
            return new InscripcionTardia(idParticipante, idCampamento, fechaInscripcion, precio);
    }

    @Override
    public InscripcionTemprana crearInscricionTemprana(int idParticipante,int idCampamento, LocalDate fechaInscripcion,float precio)
    {
            return new InscripcionTemprana(idParticipante, idCampamento, fechaInscripcion, precio);
    }
}
