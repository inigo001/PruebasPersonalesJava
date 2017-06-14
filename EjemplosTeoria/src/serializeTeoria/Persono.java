package serializeTeoria;

import java.io.Serializable;

public class Persono implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int id;
	private transient int numero;

	public Persono(String nombre, int id, int numero) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Me llamo " + this.nombre + " y mi id es " + this.id;
	}

}
