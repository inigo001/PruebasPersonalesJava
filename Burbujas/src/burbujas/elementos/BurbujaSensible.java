package burbujas.elementos;

import java.awt.Color;

import burbujas.geometria.Circulo;

/**  
 *  Una burbuja sensible es una burbuja que se caracteriza por quedar detenida un 
 *   cierto tiempo cada vez que recibe un choque. Esta cantidad de tiempo es una 
 *   constante para este tipo de burbujas que denominamos tiempo de espera. 
 *   Una burbuja sensible almacena una marca de tiempo con el instante en el que
 *   han recibido el último choque. El método ascender sólo será efectivo si ha
 *   transcurrido el tiempo de espera desde el último choque. Finalmente, 
 *   se puede consultar si una burbuja sensible está en su tiempo de espera 
 *   tras recibir un choque.
 */

public class BurbujaSensible extends Burbuja {
	
	private final static int TIEMPO_ESPERA = 2000; //mlsgdos
	
	private long instanteChoque;
	
	/**
	 * Constructor que inicializa las propiedades de una burbuja sensible
	 * a partir de la región y la velocidad máxima.
	 * @param region circulo que representa la región de la burbuja
	 * @param velocidadMaxima valor inicial de la velocidad máxima
	 */
	public BurbujaSensible(Circulo region, int velocidadMaxima) {
		super(region, velocidadMaxima);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void chocar() {
		instanteChoque = System.currentTimeMillis();
		
		super.chocar();
	}
	
	/**
	 * Método que permite consultar si la burbuja está parada en el escenario.
	 * Está en espera durante 2 sgds cuando recibe un choque.
	 * @return true si ha recibido un choque y está parada y false en caso contrario
	 */
	public boolean isEnEspera() {
		
		return instanteChoque > 0;
	}
	
	/**
	 * Modifica el comportamiento del ascenso del padre puesto que depende de si está o no en espera.
	 * Si la burbuja no está en espera asciende normalmente (comportamiento igual al padre), 
	 * pero si está en espera tendremos que comprobar si ha pasado el tiempo de espera (2 sgds).
	 * Si ha pasado el tiempo de espera puede reanudar el ascenso, y en caso contrario debe seguir 
	 * en espera (no hace nada).
	 */
	@Override
	public void ascender() {
		if (!isEnEspera()) {
		  
			super.ascender();
		
		} else {
			long ahora = System.currentTimeMillis();
			if (ahora - instanteChoque >= TIEMPO_ESPERA) {
				super.ascender();
				instanteChoque = 0;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInfo() {
		return super.getInfo() + " - EnEspera? " + isEnEspera();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return Color.GRAY;
	}
}
