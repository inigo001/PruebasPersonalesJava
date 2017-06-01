package burbujas.elementos;

import java.awt.Color;

import burbujas.geometria.Circulo;

/** 
 *  Una burbuja creciente es una burbuja débil que va aumentando 
 *  el radio de su región en 25% cada vez que soporta un bote 
 *  (se aplica la operación chocar). Dado que es una burbuja débil, 
 *  este tipo de burbujas explota cuando ha recibido un número de botes
 *  igual a su tamaño inicial (radio de su región).
 *
 */
public class BurbujaCreciente extends BurbujaDebil {
	
	private final static int PORCENTAJE_CRECIMIENTO = 125;

	/**
	 * Constructor que inicializa las propiedades de una burbuja creciente
	 * a partir de la región y la velocidad máxima.
	 * A pesar de que es un tipo de burbuja débil en la que se tiene que establecer
	 * la propiedad de botes restantes, esta información no se tiene que pasar como
	 * parámetro porque se sabe que para toda burbuja creciente el número de botes 
	 * restates coincide con el valor inicial de su radio.
	 * @param region circulo que representa la región de la burbuja
	 * @param velocidadMax valor inicial de la velocidad máxima
	 */
	public BurbujaCreciente(Circulo region, int velocidadMax) {
		//Ejemplo de constructor de una clase descendiente que tiene menos argumentos
		//que el constructor del padre
		super(region, velocidadMax, region.getRadio());
	}
	
	
	/**
	 * Modifica el comportamiento del método heredado del padre para tener en cuenta
	 * el crecimiento de la burbuja cada vez que recibe un choque.
	 */
	@Override
	public void chocar() {
		// En cada choque aumentar el radio de la región
		Circulo region = getRegion();
		
		region.escalar(PORCENTAJE_CRECIMIENTO);
		
		setRegion(region);
		
		//Comportarme igual que una burbuja debil comprobando los botes restantes
		//si botes restantes == 0 --> explota()
		super.chocar();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
}
