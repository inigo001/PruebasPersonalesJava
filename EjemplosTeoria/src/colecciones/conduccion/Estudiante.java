package colecciones.conduccion;

public class Estudiante extends Persona
{
    private String codEstudiante;

    public Estudiante(String nombre, String apellido, Dni dni, String codEstudiante)
    {
        super(nombre, apellido, dni);
        this.codEstudiante = codEstudiante;
    }

    public void obtenerInfo()
    {
        super.obtenerInfo();
        System.out.println("Cod. Estudiante: " + codEstudiante);
    }
}