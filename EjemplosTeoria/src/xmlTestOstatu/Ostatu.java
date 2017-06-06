package xmlTestOstatu;

public class Ostatu {

	private String nombre;
	private String descripcion;
	private Municipio municipio;

	public Ostatu(String nombre, String descripcion, Municipio municipio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.municipio = municipio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

}
