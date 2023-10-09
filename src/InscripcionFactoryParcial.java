public class InscripcionFactoryParcial extends InscripcionFactory{//quintero

    private ListaCampamentos listacampamentos;

    public InscripcionFactoryParcial(ListaCampamentos listacampamentos) {
        this.listacampamentos = listacampamentos;
    }

    @Override
    public InscripcionTardia crearInscripcionTardia(int idParticipante,int idCampamento, LocalDate FechaInscripcion,float precio)
    {
        Campamento campamento =listacampamentos.buscarCampamento(idCampamento);
        LocalDate fechaLimiteTardia = campamento.getFechaInicio().minusDays(15); // Calcular la fecha límite (15 días antes)

        LocalDate fechaInicioCampamento = campamento.getFechaInicio();

        if (fechaInicioCampamento.isAfter(fechaLimiteTardia) && fechaInscripcion.isBefore(fechaInicioCampamento)) {
            // La inscripción se hizo con menos de 15 días de antelación.
            return new InscripcionTardia(idParticipante, idCampamento, fechaInscripcion, precio);
        } else {

            throw new IllegalArgumentException("La inscripción tardía debe realizarse con menos de 15 días de antelación.");
        }
    }

    @Override
    public InscripcionTemprana crearInscricionTemprana(int idParticipante,int idCampamento, LocalDate FechaInscripcion,float precio)
    {
        Campamento campamento = listacampamentos.buscarCampamento(idCampamento);
        LocalDate fechaLimiteTemprana = campamento.getFechaInicio().minusDays(15); // Calcular la fecha límite (15 días antes)

        LocalDate fechaInicioCampamento = campamento.getFechaInicio();

        if (fechaInicioCampamento.isBefore(fechaLimiteTemprana) && fechaInscripcion.isAfter(fechaInicioCampamento).minusHours(48)) {
            // La inscripción se hizo con mas de 15 días de antelación.
            // La inscripción se hizo con al menos 48 horas de antelación de la fecha de inicio del Campamento
            return new InscripcionTemprana(idParticipante, idCampamento, fechaInscripcion, precio);
        } else {
            throw new IllegalArgumentException("La inscripción temprana debe realizarse con más de 15 días de antelación y al menos 48 horas antes del inicio del Campamento");
        }
    }
}
