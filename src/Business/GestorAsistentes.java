package Business;

import Data.DTO.Asistente;
import Data.DAO.AsistenteDAO;
import java.io.*;
import java.util.ArrayList;
/**
 * GestorAsistentes class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */

public class GestorAsistentes implements Serializable{
    /*Attributes*/



    private AsistenteDAO asistenteDAO;



    public GestorAsistentes() {
        this.asistenteDAO = new AsistenteDAO();
    }







    /**
     * Método que permite dar de alta a un asistente
     * @param asistente
     * @return true excepto si el asistente ya esta dado de alta o es nulo que retorna false
     */
    public boolean darAlta(Asistente asistente) {
        if (asistente == null) {
            System.out.println("El asistente es nulo.");
            return false;
        }

        asistenteDAO.crear(asistente);
        //guardarFichero();
        return true;
    }

    /**
     * Metodo que permite modificar un asistente
     * @param asistente
     */
    public void ModificarAsistente(Asistente asistente) {

        System.out.println("No se encontró ningún asistente con ese id.");
    }



    /**
     * Método que nos permite listar a los asistentes
     */
    public void listar() {
        ArrayList<Asistente> listaAsistentes = asistenteDAO.listar();

        for (Asistente asistente : listaAsistentes) {
            System.out.println("ID: " + asistente.getIdentificador());
            System.out.println("Nombre: " + asistente.getNombre());
            System.out.println("Fecha de nacimiento: " + asistente.getFechaNacimiento());
            System.out.println("Atención especial: " + (asistente.isAtencionEspecial() ? "Sí" : "No"));
            System.out.println("Apellidos: " + asistente.getApellido1() + " " + asistente.getApellido2());
            System.out.println("--------------------------------------");
        }
    }

    public Asistente getAsistente(int id){
        return null;
    }
}
