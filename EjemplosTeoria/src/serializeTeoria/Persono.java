package serializeTeoria;

import java.io.Serializable;

public class Persono implements Serializable {

	/**
	 * Cada objeto serializable conviene que traiga un número que indique que
	 * versión de clase es. De esa manera, las serializaciones de objetos no
	 * chocarán en caso de haber cambiado cosas.
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private int id;

	/**
	 * Una variable con "transient" no será serializada, por tanto se
	 * inicializará a cero en caso de traerlo a la clase.
	 */
	private transient int numero;

	public Persono(String nombre, int id, int numero) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.numero = numero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getId() {
		return this.id;
	}

	public int getNumero() {
		return this.numero;
	}

	// Metodo para comprobar contenido.
	public String toString() {
		return "Me llamo " + this.nombre + " y mi id es " + this.id + ". Mi número es además el " + this.numero;
	}

}
