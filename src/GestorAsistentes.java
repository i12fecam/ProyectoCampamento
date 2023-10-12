import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;


public class GestorAsistentes {
    private ArrayList<Asistente> asistentes;
    private String NombreArchivo;


    public GestorAsistentes() {
        asistentes = new ArrayList<Asistente>();

    }

    public GestorAsistentes(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
        this.asistentes = new ArrayList<>();
    }

    public String getNombreArchivo() {return NombreArchivo;}

    public void setNombreArchivo(String nombreArchivo) {
        NombreArchivo = nombreArchivo;
    }

    public void setAsistentes(ArrayList<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public ArrayList<Asistente> getAsistentes() {return asistentes;}

    public boolean darAlta(Asistente asistente) {
        if (asistente == null) {
            System.out.println("El asistente es nulo.");
            return false;
        }

        if (asistentes.contains(asistente)) {
            System.out.println("El asistente ya está dado de alta.");
            return false;
        }

        asistentes.add(asistente);
        guardarEnArchivo(asistente);
        return true;
    }
    private void guardarEnArchivo(Asistente asistente) {
        try {
            FileWriter fileWriter = new FileWriter(NombreArchivo, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Formatear los datos del asistente en una línea CSV
            String csvLine = asistente.toCSV(); // Implementa este método en la clase Asistente
            printWriter.println(csvLine);

            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //modificarAsistentes , hacemos una funcion por cada atributo a modificar?
    /*public void listar() {
        String valor;
        for (Asistente asistente : asistentes) {
            if(asistente.isAtencionEspecial()){
                valor="true";
            }else{
                valor="false";
            }
            System.out.println ("Asistente{" +
                    "identificador=" + asistente.getIdentificador() +
                    ", nombre='" + asistente.getNombre() + '\'' +
                    ", apellido1='" + asistente.getApellido1() + '\'' +
                    ", apellido2='" + asistente.getApellido2() + '\'' +
                    ", Fecha de Nacimiento:'" + asistente.getFechaNacimiento() + '\'' +
                    ",especial=" + valor +
                    '}');
        }
    }*/

    public void cargarAsistentesDesdeArchivo() {
        asistentes = new ArrayList<>(); // Inicializa la lista de asistentes

        try {
            BufferedReader reader = new BufferedReader(new FileReader(NombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(" ");
                if (datos.length == 6) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String apellido1 = datos[2];
                    String apellido2 = datos[3];
                    LocalDate fechaNacimiento = LocalDate.parse(datos[4]);
                    boolean atencionEspecial = Boolean.parseBoolean(datos[5]);

                    Asistente asistente = new Asistente(id, nombre, apellido1, apellido2, fechaNacimiento, atencionEspecial);
                    asistentes.add(asistente);
                } else {
                    System.out.println("La línea no contiene la información requerida.");
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se pudo encontrar: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void volcarFichero() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Quinte01\\IdeaProjects\\Local2\\src\\asistentes.txt"))) {
            // Itera sobre los asistentes y escribe cada uno en el archivo
            for (Asistente asistente : asistentes) {
                writer.println(asistente.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        for (Asistente asistente : asistentes) {
            System.out.println(asistente.toString());
        }
    }
}
