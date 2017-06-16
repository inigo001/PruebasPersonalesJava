package colecciones.conduccion;

public class Persona {
	private Integer codPersona;
	private String nombre;
	private String apellido;
	private Dni dni;

	public Persona(String nombre, String apellido, Dni dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public Persona(Integer codPersona, String nombre, String apellido, Dni dni) {
		super();
		this.codPersona = codPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public void obtenerInfo() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		dni.obtenerInfo();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Dni getDni() {
		return dni;
	}

	public void setDni(Dni dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Persona other = (Persona) obj;

		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido + " " + dni;
	}
}