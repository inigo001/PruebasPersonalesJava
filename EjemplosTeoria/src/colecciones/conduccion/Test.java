package colecciones.conduccion;

public class Test
{
    public static void main(String[] args)
    {
        Dni dni = new Dni("27383444", 'R');
        Persona persona = new Persona("Roberto", "Martin", dni);
        persona.obtenerInfo();

        Dni dni2 = new Dni("83224112",'A');
        Estudiante estudiante = new Estudiante("Maria", "Perez", dni2, "223");
        estudiante.obtenerInfo();

        Dni dni3 = new Dni("12345678",'X');
        Conductor personaConductora = new PersonaConductora("Jose", "Salgado", dni3);
        personaConductora.conducir();

        Dni dni4 = new Dni("87654321",'Y');
        Persona e = new Estudiante("Javi", "Lopez", dni4, "432");
        e.obtenerInfo();
    }
}