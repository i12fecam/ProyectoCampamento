import java.util.Date;

public class Asistente {

    private int id;

    static private String species;

    private String name;

    private String surname;

    private Date FechaNacimiento;

    boolean atencionpersonal;

    public Asistente() {
    }

    public int getId() {
        return id;
    }

    public static String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public boolean isAtencionpersonal() {
        return atencionpersonal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setSpecies(String species) {
        Asistente.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public void setAtencionpersonal(boolean atencionpersonal) {
        this.atencionpersonal = atencionpersonal;
    }
}
