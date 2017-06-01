package burbujas.geometria;

/**
 * Tipo que representa la figura geométrica Rectángulo.
 * Un rectángulo se caracteriza por su cuatro vértices y 
 * el tamaño de sus lados.
 */
public class Rectangulo {
	private Punto verticeII;
	private int ladoX;
	private int ladoY;
	
	/**
	 * Constructor que inicializa un rectángulo a partir de su
	 * vértice inferior izquierdo y el tamaño de sus lados.
	 * @param verticeII punto que representa el vértice inferior izquierdo
	 * @param ladoX tamaño del lado en x
	 * @param ladoY tamaño del lado en y
	 */
	public Rectangulo(Punto verticeII, int ladoX, int ladoY) {
		//Nos quedamos con copia para evitar el problema del aliasing
		this.verticeII = new Punto(verticeII);
		this.ladoX = ladoX;
		this.ladoY = ladoY;
	}
	
	/**
	 * Constructor que inicializa un rectángulo a partir de los valores
	 * de los vértices inferior izquierdo y superior derecho.
	 * @param verticeII punto que representa el vértice inferior izquierdo
	 * @param verticeSD punto que representa el vértice superior derecho
	 */
	public Rectangulo(Punto verticeII, Punto verticeSD) {
		this(verticeII, verticeSD.getX() - verticeII.getX(), verticeSD.getY() - verticeII.getY());
	}

	/**
	 * Método de consulta de la propiedad del lado en x.
	 * @return tamaño del lado en x
	 */
	public int getLadoX() {
		return ladoX;
	}
	
	/**
	 * Método de consulta de la propiedad del lado en y.
	 * @return tamaño del lado en y
	 */
	public int getLadoY() {
		return ladoY;
	}
	
	/**
	 * Método de consulta de la propiedad del vértice inferior izquierdo.
	 * @return punto que representa el vértice inferior izquierdo
	 */
	public Punto getVerticeII() {
		return new Punto(verticeII);
	}
	
	/**
	 * Método de consulta de la propiedad del vértice inferior derecho.
	 * @return punto que representa el vértice inferior derecho
	 */
	public Punto getVerticeID() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY());
	}
	
	/**
	 * Método de consulta de la propiedad del vértice superior derecho.
	 * @return punto que representa el vértice superior derecho
	 */
	public Punto getVerticeSD() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY() + ladoY);
	}
	
	/**
	 * Método de consulta de la propiedad del vértice superior izquierdo.
	 * @return punto que representa el vértice superior izquierdo
	 */
	public Punto getVerticeSI() {
		return new Punto(verticeII.getX(), verticeII.getY() + ladoY);
	}
	
	/**
	 * Método para desplazar un rectángulo una cantidad en cada eje.
	 * @param incX cantidad de desplazamiento en el eje x.
	 * @param incY cantidad de desplazamiento en el eje y.
	 */
	public void desplazar(int incX, int incY) {
		verticeII.desplazar(incX, incY);
	}
	
	
	/**
	 * Calcula el perímetro de un rectángulo.
	 * @return el perímetro del rectángulo
	 */
	public double getPerimetro() {
		return 2 * (ladoX + ladoY);
	}
		
}
