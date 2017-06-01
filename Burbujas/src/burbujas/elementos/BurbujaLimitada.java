package burbujas.elementos;


import java.awt.Color;

import burbujas.geometria.Circulo;


/** 
 * Una burbuja limitada es una burbuja que puede desplazarse hasta una determinada 
 *  cantidad. El límite de desplazamiento se establece en su construcción y no varía.
 *  Cada vez que la burbuja asciende, determina si puede seguir subiendo, esto es,
 *  si ya ha alcanzado su límite de desplazamiento. En caso de llegar al límite, 
 *  la burbuja se queda en su posición y no actualiza la velocidad actual, es decir, 
 *  no hace nada.
 * 
 */
public class BurbujaLimitada extends Burbuja {
	
	//Nueva propiedad
	private int limiteDesplazamiento;
	
	//atributo implementación
	private int cantidadDesplazamiento;
	
	/**
	 * Constructor que inicializa las propiedades de una burbuja limitada a partir
	 * de su región, velocidad máxima y el límite de desplazamiento.
	 * @param region circulo que representa la región de la burbuja limitada
	 * @param velocidadMax valor inicial de la velocidad máxima
	 * @param limiteDesplazamiento valor inicial del límite de desplazamiento
	 */
	public BurbujaLimitada(Circulo region, int velocidadMax, int limiteDesplazamiento) {
		super(region, velocidadMax);
		
		this.limiteDesplazamiento = limiteDesplazamiento;
		this.cantidadDesplazamiento = 0;
	}
	
	/**
	 * Método de consulta de la propiedad límite de desplazamiento.
	 * @return valor del límite de desplazamiento
	 */
	public int getLimiteDesplazamiento() {
		return limiteDesplazamiento;
	}
	
	/**
	 * Método que consulta si la burbuja limitada está parada.
	 * Una burbuja limitada se puede haber parado porque el jugador
	 * haya chocado o porque ha alcanzado el límite de desplazamiento.
	 * @return true si la burbuja está parada y false en caso contrario.
	 */
	public boolean isParada() {
		return (getVelocidadActual() == 0 
				|| cantidadDesplazamiento >= limiteDesplazamiento);
	}
	
	
	//Métodos adaptados 
	
	/**  Cada vez que la burbuja asciende, determina si puede seguir subiendo, esto es,
	 *  si ya ha alcanzado su límite de desplazamiento. En caso de llegar al límite, 
	 *  la burbuja se queda en su posición y no actualiza la velocidad actual, es decir, 
	 *  no hace nada.  
     */
	@Override
	public void ascender() {
			
		if (cantidadDesplazamiento < limiteDesplazamiento) {
			
			int posicionYInicial = getRegion().getCentro().getY();
			
			//llamamos al método ascender disponible en la clase padre
			super.ascender();
			
			//actualizar la cantidad de desplazamiento
			
			int posicionYFinal = getRegion().getCentro().getY();
			
			cantidadDesplazamiento += (posicionYFinal - posicionYInicial);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInfo() {
		return super.getInfo() + String.format(" - limiteDesplazamiento: %d, cantidadDesplazamiento: %d", limiteDesplazamiento, cantidadDesplazamiento); 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return Color.YELLOW;
	}
}
