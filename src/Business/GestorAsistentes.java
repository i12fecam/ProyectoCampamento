package Business;

import Data.DTO.Asistente;

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







    public GestorAsistentes() {

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
        AsistenteDAO.aña()

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

    }
}
