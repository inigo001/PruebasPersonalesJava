package beans;

import java.text.Collator; // Usamos el Collator para que las comparaciones se hagan respetando las tíldes

public class Persona implements Comparable<Persona> {

	private String nombre;
	private String apellido;
	private Dni dni;

	// CONSTRUCTORES

	public Persona(String nombre, String apellido, Dni dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	// METODOS

	// GET Y SET

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

	public Dni getDni() {
		return this.dni;
	}

	public void setDni(Dni dni) {
		this.dni = dni;
	}

	/* OVERRIDES */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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

	@Override
	public int compareTo(Persona other) {

		if (this.equals(other)) {
			return 0;
		}

		Collator col = Collator.getInstance();

		int num = col.compare(this.getApellido(), other.getApellido());

		if (num == 0) {
			num = col.compare(this.getNombre(), other.getNombre());
			if (num == 0) {
				num = this.dni.compareTo(other.dni);
			}
		}

		return num;
	}
}