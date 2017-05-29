package geometria;

public class Punto {
	private double x;
	private double y;

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

	public void desplazar(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public void desplazar(Punto punto) {
		this.x += punto.x;
		this.y += punto.y;
	}

	public void desplazar(Direccion direccion) {

		switch (direccion) {
		case ARRIBA:
			this.y++;
			break;
		case ABAJO:
			this.y--;
			break;
		case DERECHA:
			this.x++;
			break;
		case IZQUIERDA:
			this.x--;
			break;
		default:
			break;
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

		Punto pOrigen = new Punto();
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
