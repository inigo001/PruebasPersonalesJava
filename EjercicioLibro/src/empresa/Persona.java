package empresa;

/**
 * Clase abstracta que contiene los datos de una persona.
 * 
 * @author inigo001
 *
 */
public abstract class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private Dni dni;

	/* CONSTRUCTORES */

	public Persona(String nombre, String apellido, int edad, Dni dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
	}

	public Persona() {
		this(null, null, 0, null);
	}

	/* GET Y SET */

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Dni getDni() {
		return this.dni;
	}

	public void setDni(Dni dni) {
		this.dni = dni;
	}

	/* PROPIOS */

	public String toString() {
		return this.nombre + " " + this.apellido + " Edad: " + String.valueOf(this.edad) + " Dni: " + this.dni;
	}

}
