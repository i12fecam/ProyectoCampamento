import java.util.ArrayList;
import java.util.List;

public class ListaCampamentos {
    private List<Campamento> campamentos = new ArrayList<>();

    // Agregar un campamento a la lista
    public void agregarCampamento(Campamento campamento) {
        campamentos.add(campamento);
    }

    // Buscar un campamento por su ID
    public Campamento buscarCampamento(int idCampamento) {
        for (Campamento campamento : campamentos) {
            if (campamento.getIdCampamento() == idCampamento) {
                return campamento;
            }
        }
        return null;
    }
}
