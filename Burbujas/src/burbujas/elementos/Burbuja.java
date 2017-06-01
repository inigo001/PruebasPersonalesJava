package burbujas.elementos;

import java.awt.Color;

import burbujas.geometria.Circulo;
import burbujas.geometria.Punto;


/**
 * Una burbuja es un componente del juego que se mueve siempre en sentido vertical ascendente. 
 * El jugador podrá botar sobre las burbujas o hacerlas explotar.
 * 
 */
public class Burbuja  {
	private Circulo region;
	private final int velocidadMax;
	private int velocidadActual;
	private boolean explotada;
	
	/**
	 * Constructor que inicializa la burbuja tomando un circulo
	 * (que representa su región) y la velocidad máxima.
	 * @param region valor inicial de la región de la burbuja
	 * @param velocidadMax valor inicial de la velocidad máxima que puede alcanzar la burbuja 
	 */
	public Burbuja(Circulo region, int velocidadMax) {
		//Nos quedamos con copia para evitar el problema del aliasing
		this.region = new Circulo(region.getCentro(), region.getRadio());
		this.velocidadMax = velocidadMax;
		//inicializamos los atributos velocidadActual y explotada por legibilidad
		//no es necesario porque toman los valores por defecto de los tipos de datos
		this.velocidadActual = 0;
		this.explotada = false;
	}
	
	/**
	 * Método de consulta de la propiedad región.
	 * @return el circulo que representa la región de la burbuja
	 */
	public Circulo getRegion() {
		//Devolvemos copia para evitar el problema del aliasing
		return new Circulo(region.getCentro(), region.getRadio());
	}
	
	/**
	 * Método de establecimiento de la propiedad región.
	 * @param region nueva región de la burbuja
	 */
	protected void setRegion(Circulo region) {
		//Punto de acceso a una propiedad sólo para las subclases!!! 
		//tb visible para el resto de clases del paquete
		this.region = region;
	}
	
	/**
	 * Método de consulta de la propiedad velocidad actual.
	 * @return valor de la velocidad actual
	 */
	public int getVelocidadActual() {
		return velocidadActual;
	}
	
	/**
	 * Método de consulta de la propiedad velocidad máxima.
	 * @return valor de la velocidad máxima
	 */
	public int getVelocidadMaxima() {
		return velocidadMax;
	}

	/**
	 * Método de consulta de la propiedad explotada.
	 * @return true si la burbuja se ha explotado y false en caso contrario.
	 */
	public boolean isExplotada() {
		return explotada;
	}
	
	//Funcionalidad de la burbuja
	/** 
	 * Hace explotar la burbuja (establece la propiedad explotada a verdadero).
	 */
	public void explotar() {
		explotada = true;
	}
	
	/**
	 * Esta operación recibe como parámetro un punto que se utiliza como referencia 
	 * para situar la región de la burbuja. El resultado de la operación será que el 
	 * centro de la región de la burbuja estará situado en el punto que se establece 
	 * como parámetro.
	 * 
	 * @param posicion nuevo centro del circulo que representa la región de la burbuja
	 */
	public final void situar(Punto posicion) {
		region.desplazar(posicion);
	}
	
	/**
	 * Esta operación desplaza la región de la burbuja hacia arriba. La cantidad de 
	 * desplazamiento en el eje Y equivale a su velocidad actual. Además, incrementa 
	 * la velocidad actual en una unidad, siempre que no supere la velocidad límite.
	 */
	public void ascender() {
		
		region.desplazar(0, velocidadActual);
		
		if (velocidadActual < velocidadMax)
			++velocidadActual;
	}
	
	/**
	 * Establece la velocidad actual a 0.
	 * 
	 */
	public void chocar() {
		velocidadActual = 0;
	}
	
	/**
	 * Devuelve una cadena de texto con las información de las propiedades de la burbuja.
	 * @return cadena de texto con la información de la burbuja.
	 */
	public String getInfo() {
		return  String.format("v. actual: %d, v. límite: %d, explotada: %b", 
				getVelocidadActual(), 
				getVelocidadMaxima(),
				isExplotada());
	}
	
	/**
	 * Consulta el color con el que se representa gráficamente la burbuja.
	 * @return color de la burbuja
	 */
	public Color getColor() {
		return Color.GREEN;
	}
	
}















