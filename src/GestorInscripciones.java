import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Monitor class
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
     * Empty (default) constructor
     * */
    public GestorInscripciones(){

    }

    /**
     * Parametrized constructor
     * @param NombreArchivo
     */
    public GestorInscripciones( String NombreArchivo){
        this.NombreArchivo=NombreArchivo;
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

    private void cargarFichero(){

    }


    /**
     * @param gestorCampamentos
     * @param gestorAsistentes
     * @param idAsistente
     * @param idCampamento
     * @param fechaInscripcion
     * @param horario
     */
    public void crearInscripcion(GestorCampamentos gestorCampamentos,GestorAsistentes gestorAsistentes,int idAsistente, int idCampamento, LocalDate fechaInscripcion,Horario horario){
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
    public void consultarCampamentos(){
    //Consultan los que aún no han empezado y tienen plazas disponibles


    }
}
