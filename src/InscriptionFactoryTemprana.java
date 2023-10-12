import java.time.LocalDate;

public class InscriptionFactoryTemprana extends InscripcionFactory{
    public InscripcionCompleta crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio){
        return  new InscripcionCompleta(idParticipante,idCampamento,fechaInscripcion,precio,TipoInscripcion.TEMPRANA);
    }

    public InscripcionParcial crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio){
        return new InscripcionParcial(idParticipante,idCampamento,fechaInscripcion,precio,TipoInscripcion.TEMPRANA);
    }
}
