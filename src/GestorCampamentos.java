import java.util.ArrayList;

public class GestorCampamentos {
    private ArrayList<Campamento> campamentos;


    private void cargarFichero(){

    }
    public boolean crearCampamento(){
    return false;
    }

    public boolean asociarMonitorActividad(){
        return false;
    }
    public boolean asociarActividadCampamento(){
        return false;
    }

    public boolean asociarMonitorCampamento(){
        return false;
    }
    public boolean asociarMonitorEspecialCampamento(){
        return false;
    }

    public Campamento buscarCampamento(int idCampamento) {
        for (Campamento campamento : campamentos) {
            if (campamento.getIdCampamento() == idCampamento) {
                return campamento;
            }
        }
        return null;
    }
}
