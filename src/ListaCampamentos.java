import java.util.ArrayList;
import java.util.List;

/**
 * ListaCampamentos class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class ListaCampamentos {
    /*Attributes*/
    private List<Campamento> campamentos = new ArrayList<>();

    /**
     * Agregar un campamento a la lista
     * @param campamento
     */
    public void agregarCampamento(Campamento campamento) {
        campamentos.add(campamento);
    }

    /**
     * Buscar un campamento por su ID
     * @param idCampamento
     * @return campamento si campamento.getIdCampamento() == idCampamento y si no null
     */
    public Campamento buscarCampamento(int idCampamento) {
        for (Campamento campamento : campamentos) {
            if (campamento.getIdCampamento() == idCampamento) {
                return campamento;
            }
        }
        return null;
    }
}
