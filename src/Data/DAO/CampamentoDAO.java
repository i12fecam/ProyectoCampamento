package Data.DAO;

import Data.DAO.Common.ConexionBD;
import Data.DAO.Common.ProyectProperties;
import Data.DTO.Campamento;
import Data.Horario;
import Data.NivelEducativo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

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

            if(campamento.getNivelEducativo()== NivelEducativo.INFANTIL){
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
     * @param campamento campamento del cual se mira las actividades
     * @param horario horario de las actividades que se cuentan
     * @return numero de actividades del campamento segun su horario
     */
    public int getNumActividades(Campamento campamento,Horario horario){
        return 0;
    }

    /**
     *
     * @return  Todos las camapamentos en los que se puede inscribir en esa fecha
     */
    public ArrayList<Campamento> getCampamentosInscribibles(){
        try {
            PreparedStatement ps = con.prepareStatement(prop.getSentente("get_campamentos_disponibles"));
            ResultSet rs = ps.executeQuery();
            ArrayList<Campamento> vector = new ArrayList<>();
            while(rs.next()){
                Campamento camp = new Campamento();
                camp.setIdCampamento(rs.getInt("id"));//no se si poner id o id_campamento
                camp.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                rs.getString("nivel_educativo");
                camp.setMaxAsistentes(rs.getInt("max_asistentes"));
                //aqui se podria poner la foreign key de los montores especiales y responsables
                vector.add(camp);
            }
            return vector;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
