import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private GestorAsistentes gestorAsistentes;
    private GestorCampamentos gestorCampamentos;
    private GestorInscripciones gestorInscripciones;
    public static  void main(String[] args){

        Scanner scanner= new Scanner (System.in);
        Properties prop = new Properties();
        String filename= "Properties.txt";


        System.out.println("Menu principal:");
        System.out.println("1.Gestionar asistentes");
        System.out.println("2.Gestionar campamentos");
        System.out.println("3.Gestionar inscripciones");

        int opcion=scanner.nextLine();

        switch (opcion){
            case 1:
                public void gestionarAsistentes();
                break;
            case 2:
                public void gestionarCampamentos();
                 break;
            case 3:
                public void gestionarInscripciones();
                break;
            default:
                System.out.println("Opcion no valida");
        }

        public void gestionarAsistentes(){
            try{
                BufferedReader reader =new BufferedReader(new FileReader(new File (filename)));
                prop.load(reader);
                String Asis=prop.getProperty("Asis");
                GestorAsistentes GestorAsistentes1 (Asis);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("Opciones para gestionar a los asistentes:");
            System.out.println("1.Dar de alta");
            System.out.pritnln("2.Modificar asistente");
            System.out.println("3.Listar a los asistentes actuales");
            System.out.println("0.Volver al menu principal");

            int opcion2=scanner.nextLine();

            switch (opcion2){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }

        }

        public void gestionarCampamentos(){
            try{
                BufferedReader reader =new BufferedReader(new FileReader(new File (filename)));
                prop.load(reader);
                String Camp=prop.getProperty("Camp");
                GestorAsistentes GestorAsistentes1 (Camp);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("Opciones para gestionar los campamentos");
            System.out.println("1.Crear campamento");
            System.out.println("2.Crear monitores");
            System.out.println("3.Crear actividades");
            System.out.println("4.Asociar monitores a actividades");
            System.out.println("5.Asociar monitores a un campamento");
            System.out.println("6.Asociar monitores de atencion especial a un campamento");
            System.out.println("0.Volver al menu principal");

            int opcion3=scanner.nextLine();
            switch (opcion3){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        public void gestionarInscripciones(){
            try{
                BufferedReader reader =new BufferedReader(new FileReader(new File (filename)));
                prop.load(reader);
                String Ins=prop.getProperty("Ins");
                GestorAsistentes GestorAsistentes1 (Ins);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }



        }

    }
}
/*
En las reservas parciales por cada cada actividad, sea de tarde o no, se cobra?
solo se cobra la de por la mañana
Debe poder crearse Actividades y Monitores fuera de los campamentos?
si
A través de la interfaz de texto, que opciones se deberian poder acceder?
no muy importante que se pueda hacer todo
Se puede serializar las clases, y por lo tanto que no se puedan leer en texto plano?
si
La asociación de un monitor con necesidades especiales a la hora de hacer una inscripcion es necesaria?
ayudaria mucho
Deberiamos hace una funcion que se llame cancelar y varie segun el tipo de inscripcion?
como desees


Pro proroperties se utiliza en el main, el main lee el ficheperties y a la hora de crear el gestor le pasa como cadena
la ruta del fichero que ha leido el main. Los gestores deben actualizar la base de datos es decir el fichero al finalizar
cada una de las opciones posibles.
 */