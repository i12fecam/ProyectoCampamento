import java.time.LocalDate;
/**
 * InscripcionFactory class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public abstract class InscripcionFactory {


    /**
     * Metodo que crea una inscripcion de tipo completa
     * @param idParticipante
     * @param idCampamento
     * @param fechaInscripcion
     * @param precio
     */
    public abstract InscripcionCompleta crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
    /**
     * Metodo que crea una inscripcion de tipo parcial
     * @param idParticipante
     * @param idCampamento
     * @param fechaInscripcion
     * @param precio
     */
    public abstract InscripcionParcial crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio);
}