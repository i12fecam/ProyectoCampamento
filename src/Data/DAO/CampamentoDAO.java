package Data.DAO;

import Data.DTO.Campamento;
import Data.Horario;

public class CampamentoDAO {
    private ProyectProperties prop;
    private ConexionBD bd;
    private Connection con;


    public CampamentoDAO(){
        prop = new ProyectProperties();
        bd = new ConexionBD();
        con = bd.getConnection(prop.getUrl(), prop.getUsername(), prop.getPassword());
    }

    public void crearCampamento (Campamento campamento){
        try{
            PreparedStatement ps = con.prepareStatement(prop.getSentente("insert_campamento"));
            ps.setDate(1,Date.valueOf(campamento.getFechaInicio()));
            ps.setDate(2, Date.valueOf(campamento.getFechaFinal()));

            if(campamento.getNivelEducativo()==NivelEducativo.INFANTIL){
                ps.setString(3,1);
            }
            else if(campamento.getNivelEducativo()==NivelEducativo.JUVENIL){
                ps.setString(3,2);
            }
            else{
                ps.setString(3,3);
            }



        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     *
     * @param campamento campamento del cuál se mira las actividades
     * @param horario horario de las actividades que se cuentan
     * @return numero de actividades del campamento segun su horario
     */
    public int getNumActividades(Campamento campamento,Horario horario){
        return 0;
    }
}
