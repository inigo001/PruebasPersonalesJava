package xmlTestOstatu;

import java.util.Arrays;

public class Ostatu {

	private String nombre;
	private String descripcion;
	private int[] telefonos;
	private Municipio municipio;
	private Lodging lodging;

	/* CONSTRUCTORES */

	public Ostatu(String nombre, String descripcion, Municipio municipio, int[] telefonos, Lodging lodging) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.municipio = municipio;
		this.telefonos = telefonos;
		this.lodging = lodging;
	}

	/* METODOS */

	private String getStringTelefonos() {
		return Arrays.toString(this.telefonos);
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

	public String getMunicipioName() {
		return this.municipio.getName();
	}

	public int[] getTelefonos() {
		return this.telefonos.clone();
	}

	public Lodging getLodging() {
		return this.lodging;
	}

	/* PROPIAS */

	public String toString() {
		return "Nombre: " + this.nombre + " <-> Descripcion: " + this.descripcion.substring(0, 60)
				+ "... <-> Municipio: " + this.municipio + " <-> Tel�fono: " + this.getStringTelefonos() + " <-> LodgingId: " + this.lodging.getName();
	}

}
