import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    private GestorAsistentes gestorAsistentes;
    private GestorCampamentos gestorCampamentos;
    private GestorInscripciones gestorInscripciones;

    public static void main(String[] args) {
        Main main = new Main();
        main.iniciar();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Properties prop = new Properties();
        String filename;
        //comprobar sistema operativo para poner la ruta bien
        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")){
            filename = ".\\Properties.txt";
        }else{
            filename = "./Properties.txt";
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            prop.load(reader);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo de configuración");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gestorAsistentes = new GestorAsistentes(prop.getProperty("Asis"));
        gestorCampamentos = new GestorCampamentos(prop.getProperty("Camp"));
        //gestorCampamentos = new GestorCampamentos();
        gestorInscripciones = new GestorInscripciones(prop.getProperty("Ins"));

        boolean bucle =true;
        while (bucle) {
            System.out.println("Menu principal:");
            System.out.println("1. Gestionar asistentes");
            System.out.println("2. Gestionar campamentos");
            System.out.println("3. Gestionar inscripciones");
            System.out.println("4. Salir");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    gestionarAsistentes();
                    break;
                case "2":
                    gestionarCampamentos();
                    break;
                case "3":
                    // gestionarInscripciones();
                    break;
                case "4":
                    salir();
                    bucle=false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    public void gestionarAsistentes() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones para gestionar a los asistentes:");
            System.out.println("1. Dar de alta");
            System.out.println("2. Modificar asistente");
            System.out.println("3. Listar a los asistentes actuales");
            System.out.println("0. Volver al menu principal");

            String opcion2 = scanner.nextLine();

            switch (opcion2) {
                case "1":
                    System.out.println("Dar de alta a un asistente:");

                    // Recopilar la información del asistente desde el usuario
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el salto de línea
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido 1: ");
                    String apellido1 = scanner.nextLine();
                    System.out.print("Apellido 2: ");
                    String apellido2 = scanner.nextLine();
                    System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
                    String fechaNacimientoStr = scanner.nextLine();
                    System.out.print("Atencion Especial (true/false): ");
                    boolean atencionEspecial = scanner.nextBoolean();

                    // Crear una instancia de Asistente con la información recopilada
                    Asistente nuevoAsistente = new Asistente(id, nombre, apellido1, apellido2, LocalDate.parse(fechaNacimientoStr), atencionEspecial);

                    // Dar de alta al asistente
                    gestorAsistentes.darAlta(nuevoAsistente);
                    System.out.println("Asistente dado de alta con exito.");
                    break;
                case "2":
                    // Lógica para modificar asistente
                    break;
                case "3":
                    gestorAsistentes.listar();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }
        }}

    public void gestionarCampamentos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones para gestionar los campamentos");
            System.out.println("1. Crear campamento");
            System.out.println("2. Crear monitores");
            System.out.println("3. Crear actividades");
            System.out.println("4. Asociar monitores a actividades");
            System.out.println("5. Asociar monitores a un campamento");
            System.out.println("6. Asociar monitores de atención especial a un campamento");
            System.out.println("7. Ver campamentos");
            System.out.println("8. Ver monitores");
            System.out.println("9. Ver actividades");
            System.out.println("0. Volver al menu principal");

            String opcion3 = scanner.nextLine();

            switch (opcion3) {
                case "1":
                    // Lógica para crear campamento
                    try {
                        System.out.print("Fecha de inicio (YYYY-MM-DD):");
                        String fechaIncioStr = scanner.nextLine();
                        System.out.print("Fecha de finalización (YYYY-MM-DD):");
                        String fechaFinalStr = scanner.nextLine();
                        System.out.print("Nivel educativo (Infantil, Juvenil, Adolescente):");
                        String nivelEducativoStr = scanner.nextLine();
                        NivelEducativo nivelEducativo;
                        if (nivelEducativoStr.equals("Infantil") ) {
                            nivelEducativo = NivelEducativo.INFANTIL;
                        } else if (nivelEducativoStr.equals("Juvenil")) {
                            nivelEducativo = NivelEducativo.JUVENIL;
                        } else if (nivelEducativoStr.equals("Adolescente")) {
                            nivelEducativo = NivelEducativo.ADOLESCENTE;
                        } else {
                            throw new RuntimeException("Error al capturar el nivel educativo");
                        }
                        System.out.print("Número máximo de Asistentes:");
                        int maxAsistentes = scanner.nextInt();
                        scanner.nextLine();
                        gestorCampamentos.crearCampamento(LocalDate.parse(fechaIncioStr), LocalDate.parse(fechaFinalStr), nivelEducativo, maxAsistentes);
                        gestorCampamentos.guardarFichero();
                        System.out.println("El campamento se ha creado correctamente");
                    }catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Hubo un problema creando el campamento");
                    }

                    break;
                case "2":
                    // Lógica para crear monitores
                    try {
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellido 1: ");
                        String apellido1 = scanner.nextLine();
                        System.out.print("Apellido 2: ");
                        String apellido2 = scanner.nextLine();
                        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
                        String fechaNacimientoStr = scanner.nextLine();
                        System.out.print("Atencion Especial (true/false): ");
                        boolean atencionEspecial = scanner.nextBoolean();
                        scanner.nextLine();

                        // Dar de alta al asistente
                        gestorCampamentos.crearMonitor(nombre, apellido1, apellido2, LocalDate.parse(fechaNacimientoStr), atencionEspecial);
                        System.out.println("Asistente dado de alta con exito.");
                    }catch (Exception e){
                        System.out.println("Se produjo creando el monitor");
                    }
                    break;
                case "3":
                    // Lógica para crear actividades
                    break;
                case "4":
                    // Lógica para asociar monitores a actividades
                    break;
                case "5":
                    // Lógica para asociar monitores a un campamento
                    break;
                case "6":
                    // Lógica para asociar monitores de atención especial a un campamento
                    break;
                case "7":
                    //Logica de ver Campamentos
                    gestorCampamentos.toStringCampamentos();
                    break;
                case "8":
                    //Logica de ver Monitores
                    gestorCampamentos.toStringMonitores();
                    break;
                case "9":
                    //Logica de ver Actividades
                    gestorCampamentos.toStringActividades();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }
    public void gestionarInscripciones() {    //da errores y no compila
        Scanner scanner = new Scanner(System.in);

    }
    public void salir(){

    }

}

