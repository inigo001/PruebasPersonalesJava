package geometria;

public class Punto {
	private double x;
	private double y;

	/* CONSTRUCTORES */

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Punto() {
		this.x = 0;
		this.y = 0;
	}

	public Punto(Punto punto) {
		this.x = punto.x;
		this.y = punto.y;
	}

	/* METODOS PÚBLICOS */

	public void desplazar(double x, double y) {
		this.x += x;
		this.y += y;
	}

	// Es preferible reutilizar los métodos creados en vez de recrear la
	// funcionalidad en cada uno de los métodos sobrecargados. Da menos errores
	// y facilita la reutilización de código.
	public void desplazar(Punto punto) {
		this.desplazar(punto.x, punto.y);
	}

	public void desplazar(Direccion direccion) {
		switch (direccion) {
		case ARRIBA:
			this.desplazar(0, 1);
			break;
		case ABAJO:
			this.desplazar(0, -1);
			break;
		case DERECHA:
			this.desplazar(1, 0);
			break;
		case IZQUIERDA:
			this.desplazar(-1, 0);
			break;
		default:
			break;
		// esto es inútil puesto que en caso de que no exista el caso no hará
		// absolutamente nada, lo mismo que este default
		}
	}

	public double distancia(Punto puntoAComparar) {
		double dist;

		double opX = Math.pow(this.x - puntoAComparar.x, 2);
		double opY = Math.pow(this.y - puntoAComparar.y, 2);
		dist = Math.sqrt(opX + opY);

		return dist;
	}

	public String posicion() {
		return this.toString();
	}

	/* SET Y GET */

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	// Sobreescribimos el metodo toString. POLIMORFISMO
	// @Override. Se puede poner así para que sepa que es un override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	/* ESTATICOS */

	public static double distancia(Punto punto1, Punto punto2) {
		double dist;

		double opX = Math.pow(punto1.x - punto2.x, 2);
		double opY = Math.pow(punto1.y - punto2.y, 2);
		dist = Math.sqrt(opX + opY);

		return dist;
	}

	public static Punto mayorDistancia(Punto... puntos) {

		// Mejor inicializar el punto como Origen de coordenadas a mano en vez
		// de tirar del Constructor por defecto. Es más claro y limpio.
		Punto pOrigen = new Punto(0, 0);
		Punto pAlejado = puntos[0];

		double maxDistancia = Punto.distancia(pOrigen, pAlejado);

		for (int i = 0; i < puntos.length; i++) {

			double newDistancia = Punto.distancia(pOrigen, puntos[i]);

			if (newDistancia > maxDistancia) {
				pAlejado = puntos[i];
				maxDistancia = newDistancia;
			}
		}

		return pAlejado;
	}

}
