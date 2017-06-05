package ejemplos.enums;

/**
 * Los enums pueden tener datos añadidos mediante un constructor, además de
 * métodos asociados. Funcionarían como una clase más o menos.
 * 
 * @author inigo001
 *
 */
public enum PuntosCardinales {

	/**
	 * Cada punto del enumerado tiene un grado y un nombre que se asignan en el
	 * constructor que creamos después.
	 */
	NORTE(0, "Arriba"), SUR(180, "Abajo"), ESTE(90, "Izquierda"), OESTE(270, "Derecha");

	/**
	 * Las variables tienen que estar guardadas en algún sitio
	 */
	private int grados;
	private String posicion;

	/**
	 * Constructor del enum
	 * 
	 * @param grados
	 *            Grados en los que se encuentran los puntos cardinales
	 * @param posicion
	 *            Posición con nombres donde se encuentran los puntos cardinales
	 */
	private PuntosCardinales(int grados, String posicion) {
		this.grados = grados;
		this.posicion = posicion;
	}

	/* SET Y GET */

	/**
	 * @return Grados que tiene el enumerando
	 */
	public int getGrados() {
		return this.grados;
	}

	/**
	 * @return Posicion del enumerando
	 */
	public String getPosicion() {
		return this.posicion;
	}

	public String toString() {
		return "(" + this.grados + ") - " + this.posicion;
	}
}
