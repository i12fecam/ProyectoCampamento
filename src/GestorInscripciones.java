import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * GestorInscripciones class
 * @author Noelia Ruiz
 * @author Antonio Javier Quintero
 * @author Abigail Fernández
 * @author Fátima Caballero
 * */
public class GestorInscripciones {
    /*Attributes*/
    private ArrayList<Inscripcion> inscripciones;
    private String NombreArchivo;


    /**
     * Parametrized constructor
     * @param NombreArchivo
     */
    public GestorInscripciones( String NombreArchivo){

        this.NombreArchivo = NombreArchivo;
        this.inscripciones = new ArrayList<>();
        FileInputStream fileInputStream
                = null;
        if(new File(NombreArchivo).length() != 0){

            try {
                fileInputStream = new FileInputStream(NombreArchivo);

                ObjectInputStream objectInputStream
                        = new ObjectInputStream(fileInputStream);
                GestorInscripciones gestor = (GestorInscripciones) objectInputStream.readObject();
                objectInputStream.close();
                this.inscripciones = gestor.inscripciones;
            } catch (FileNotFoundException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void guardarFichero(){
        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(NombreArchivo);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*Getters and Setters*/

    /**
     * @param nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }

    /**
     * @param inscripciones
     */
    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * @return NombreArchivo
     */
    public String getNombreArchivo() {return NombreArchivo;}

    /**
     * @return inscripciones
     */
    public ArrayList<Inscripcion> getInscripciones() {return inscripciones;}




/*
    /**
     * @param gestorCampamentos
     * @param gestorAsistentes
     * @param idAsistente
     * @param idCampamento
     * @param fechaInscripcion
     * @param horario
     */
    /*public void crearInscripcion(GestorCampamentos gestorCampamentos,GestorAsistentes gestorAsistentes,int idAsistente, int idCampamento, LocalDate fechaInscripcion,Horario horario){
        Campamento campamento = gestorCampamentos.getCampamentos().get(idCampamento);
        Asistente asistente = gestorAsistentes.getAsistentes().get(idAsistente);
        float precio;
        boolean tardia;
        //mirar si es tardia

        //comprobar si necesita monitor especial
        if(asistente.isAtencionEspecial() && !campamento.tieneMonitorEspecial()){
            //añadir monitor especial al campamento
        }
        //calcular precio
        if(horario == Horario.PARCIAL){
            precio = 100;
            ArrayList<Actividad> actividades = campamento.getActividades();
            for (Actividad it:actividades){
                if (it.getHorario() == Horario.PARCIAL){
                    precio+=20;
                }
            }
        }else{
            precio = 300;
        }
        //se crea la inscripción
        if(horario == Horario.PARCIAL){
            InscripcionFactoryParcial fabrica = new InscripcionFactoryParcial();

        }
        else if(horario == Horario.COMPLETA){
            InscripcionFactoryCompleta fabrica = new InscripcionFactoryCompleta();
        }
    }
    */


    /**
     * Metodo que permite consultar los campamentos disponibles
     * @param gestor
     * @return lista de campamentos disponibles
     */
    public ArrayList<Campamento> consultarCampamentosDisponibles(GestorCampamentos gestor) {
        ArrayList<Campamento> campamentosDisponibles = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now(); // Obtén la fecha actual
        for (Campamento it : gestor.getCampamentos()) {
            if (fechaActual.isBefore(it.getFechaInicio()) && // Campamento no ha comenzado
                    it.getNumAsistentes() < it.getMaxAsistentes()) { // Plazas disponibles
                campamentosDisponibles.add(it);
            }
        }

        return campamentosDisponibles;
    }

}
