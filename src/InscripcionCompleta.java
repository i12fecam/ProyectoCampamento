import java.time.LocalDate;
/**
 * InscripcionCompleta class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public class InscripcionCompleta extends Inscripcion{

    /**
     * Parametrized constructor
     * @param idParticipante
     * @param idCampamento
     * @param fechaInscripcion
     * @param precio
     * @param tipoInscripcion
     */
    public InscripcionCompleta(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio, TipoInscripcion tipoInscripcion) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = tipoInscripcion;
        this.horario = Horario.COMPLETA;
    }
}