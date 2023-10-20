import Data.TipoInscripcion;

import java.time.LocalDate;
/**
 * InscripcionFactoryTardia class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public class InscriptionFactoryTardia extends InscripcionFactory{

    /**
     * Crea una inscripción completa con los parámetros especificados y un tipo de inscripción "TARDIA".
     *
     * @param idParticipante El identificador del participante.
     * @param idCampamento El identificador del campamento.
     * @param fechaInscripcion La fecha de inscripción.
     * @param precio El precio de la inscripción.
     * @return Una nueva instancia de InscripcionCompleta creada con los parámetros proporcionados
     * y con el tipo de inscripción establecido como "TARDIA".
     */
    public InscripcionCompleta crearInscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio){
         return  new InscripcionCompleta(idParticipante,idCampamento,fechaInscripcion,precio, TipoInscripcion.TARDIA);
    }
    /**
     * Crea una inscripción parcial con los parámetros especificados y un tipo de inscripción "TARDIA".
     *
     * @param idParticipante El identificador del participante.
     * @param idCampamento El identificador del campamento.
     * @param fechaInscripcion La fecha de inscripción.
     * @param precio El precio de la inscripción.
     * @return Una nueva instancia de InscripcionParcial creada con los parámetros proporcionados
     * y con el tipo de inscripción establecido como "TARDIA".
     */
    public InscripcionParcial crearInscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio){
        return new InscripcionParcial(idParticipante,idCampamento,fechaInscripcion,precio,TipoInscripcion.TARDIA);
    }
}
