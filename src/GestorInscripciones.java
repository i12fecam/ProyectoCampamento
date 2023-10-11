import java.time.LocalDate;
import java.util.ArrayList;

public class GestorInscripciones {
    private ArrayList<Inscripcion> inscripciones;
    private String NombreArchivo;

    public GestorInscripciones(){

    }

    public GestorInscripciones( String NombreArchivo){
        this.NombreArchivo=NombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public String getNombreArchivo() {return NombreArchivo;}

    public ArrayList<Inscripcion> getInscripciones() {return inscripciones;}

    private void cargarFichero(){

    }
    public GestorInscripciones() {
    }

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

    }
}
