package xmlTestOstatu;

public class Ostatu {

	private String nombre;
	private String descripcion;
	private Municipio municipio;

	/* CONSTRUCTORES */

	public Ostatu(String nombre, String descripcion, Municipio municipio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.municipio = municipio;
	}

	/* GET Y SET */

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	/* PROPIAS */

	public String toString() {
		return "Nombre: " + this.nombre + " <-> Descripcion: " + this.descripcion.substring(0, 30) + "... <-> Municipio: "
				+ this.municipio;
	}

}
