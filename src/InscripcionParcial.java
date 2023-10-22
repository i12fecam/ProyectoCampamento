import Data.DTO.Inscripcion;
import Data.Horario;
import Data.TipoInscripcion;

import java.time.LocalDate;
/**
 * InscripcionParcial class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public class InscripcionParcial extends Inscripcion {
    /**
     * Parametrized constructor
     * @param idParticipante
     * @param idCampamento
     * @param fechaInscripcion
     * @param precio
     * @param tipoInscripcion
     */
    public InscripcionParcial(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio, TipoInscripcion tipoInscripcion) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = tipoInscripcion;
        this.horario = Horario.PARCIAL;
    }

}