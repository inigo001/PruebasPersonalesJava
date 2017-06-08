package empresa;

/**
 * Dni. No controla si es un Dni correcto o no.
 * 
 * @author inigo001
 *
 */
public class Dni {

	/**
	 * Numero entero, no hay control sobre su contenido
	 */
	private int numero;
	/**
	 * Letra final. Recordar que para introducir un char hay que escribirlo
	 * entre comillas simples: 'a'
	 */
	private char letra;

	/* CONSTRUCTORES */

	public Dni(int numero, char letra) {
		this.numero = numero;
		this.letra = letra;
	}

	public Dni(Dni dni) {
		this(dni.numero, dni.letra);
	}

	/* PROPIOS */

	public String toString() {
		return String.valueOf(this.numero) + this.letra;
	}

}
