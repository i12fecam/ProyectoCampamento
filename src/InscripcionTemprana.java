import java.time.LocalDate;
/**
 * InscripcionTemprana class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public abstract class InscripcionTemprana extends InscripcionFactory{
    /**
     * Parametrized constructor
     * @param idParticipante
     * @param idCampamento
     * @param fechaInscripcion
     * @param precio
     */
    public InscripcionTemprana(int idParticipante, int idCampamento, LocalDate fechaInscripcion, float precio) {
        this.idParticipante = idParticipante;
        this.idCampamento = idCampamento;
        this.fechaInscripcion = fechaInscripcion;
        this.precio = precio;
        this.tipoInscripcion = TipoInscripcion.TEMPRANA;
    }

    /**
     * @return toda la informacion de inscripcion
     */

    public String toString() {
        return "InscripcionTemprana{" +
                "idParticipante=" + idParticipante +
                ", idCampamento=" + idCampamento +
                ", fechaInscripcion=" + fechaInscripcion +
                ", precio=" + precio +
                ", tipoInscripcion=" + tipoInscripcion +
                '}';
    }
}

