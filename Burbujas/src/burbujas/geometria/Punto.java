package burbujas.geometria;

//Importamos propiedades static
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
//tambien se podría import static java.lang.Math.*; para importar todas

/**
 * Representa un Punto en el espacio bidimensional.
 * Un punto se caracteriza por su coordenada x y su coordenada y.
 */
public class Punto {
	//Definición de propiedades (atributos)
	//Principio ocultamiento información --> atributos privados
	private int x;
	private int y;

	/**
	 * Constructor que inicializa las dos coordenadas.
	 * @param x valor inicial de la coordenada x
	 * @param y valor inicial de la coordenada y
	 */
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor sin argumentos. Crea el punto (0,0)
	 */
	public Punto() {
		//Reutilización de constructores
		//invocamos al constructor con dos argumentos
		this(0, 0);
	}

	/**
	 * Constructor de copia. Crea un nuevo objeto con los mismos valores
	 * que el objeto que recibe como parámetro.
	 * @param punto punto del que se toman los valores iniciales de x e i
	 */
	public Punto(Punto punto) {
		this(punto.x, punto.y);
	}

	/**
	 * Método de consulta de la coordenada X.
	 * @return valor de la coordenada X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Método de consulta de la coordenada Y.
	 * @return valor de la coordenada Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Método de establecimiento de la coordenada X.
	 * @param x nuevo valor de la coordenada X
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Método de establecimiento de la coordenada Y.
	 * @param y nuevo valor de la coordenada Y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Deplaza el punto una cantidad en cada eje.
	 * @param incX cantidad de desplazamiento en el eje X
	 * @param incY cantidad de desplazamiento en el eje Y
	 */
	public void desplazar(int incX, int incY) {
		x = x + incX;
		y += incY;
	}

	/**
	 * Desplaza el punto en una dirección.
	 * @param direccion Dirección de desplazamiento
	 */
	public void desplazar(Direccion direccion) {
		switch (direccion) {
		case ARRIBA:
			desplazar(0, 1);
			break;
		case ABAJO:
			desplazar(0, -1);
			break;
		case DERECHA:
			desplazar(1, 0);
			break;
		case IZQUIERDA:
			desplazar(-1, 0);
			break;
		default:
			break;
		}
	}

	/**
	 * Calcula la distancia entre dos puntos.
	 * @param otroPunto punto al que queremos calcular la distancia
	 * @return distancia entre los dos puntos
	 */
	public double distancia(Punto otroPunto) {
		// Importamos las propiedades estáticas
		// para no tener que poner delante
		// de las operaciones sqrt y pow el nombre de la clase Math
		return sqrt(pow(x - otroPunto.x, 2) + pow(y - otroPunto.y, 2));
	}

	/**
	 * Devuelve el punto más alejado de la posición (0,0).
	 * @param puntos lista variable de puntos.
	 * @return Punto más alejado del origen de coordenadas
	 */
	public static Punto mayorDistancia(Punto... puntos) {
		Punto origen = new Punto(0, 0);
		double maxDistancia = -1;
		Punto masLejos = null;

		for (Punto punto : puntos) {
			double distanciaActual = origen.distancia(punto);
			if (distanciaActual > maxDistancia) {
				maxDistancia = distanciaActual;
				masLejos = punto;
			}
		}
		return masLejos;
	}

}
