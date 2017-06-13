package colecciones.conduccion;

public class PersonaConductora extends Persona implements Conductor
{
    public PersonaConductora(String nombre, String apellido, Dni dni)
    {
        super(nombre, apellido, dni);
    }

    public void conducir()
    {
        System.out.println(this.getNombre() + "está conduciendo");
    }
}