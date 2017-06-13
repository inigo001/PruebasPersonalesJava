package colecciones.geometria;

public class Punto {
	//
	public static double X_DEFECTO = 0;
	public static double Y_DEFECTO = 0;
	//
	private double x;
	private double y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Punto() {
		this(X_DEFECTO, Y_DEFECTO);
	}

	public Punto(Punto punto) {
		this(punto.x, punto.y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distancia(Punto punto) {
		double diferenciaX = punto.x - this.x;
		double diferenciaY = punto.y - this.y;
		return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
	}

	public double distancia(double x, double y) {
		double diferenciaX = x - this.x;
		double diferenciaY = y - this.y;
		return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
	}

	public static double distancia(Punto punto1, Punto punto2) {
		return Math.sqrt(punto1.distancia(punto2));
	}

	public Punto puntoMasCercano(Punto[] otrosPuntos) {
		Punto puntoMasCercano = otrosPuntos[0];
		double distanciaMinima = distancia(otrosPuntos[0]);
		for (int i = 1; i < otrosPuntos.length; i++) {
			double distancia = distancia(otrosPuntos[i]);
			if (distancia < distanciaMinima) {
				distancia = distanciaMinima;
				puntoMasCercano = otrosPuntos[i];
			}
		}
		return puntoMasCercano;
	}

	public void trasladar(Vector vectorDesplazamiento) {
		this.x = this.x + vectorDesplazamiento.getA();
		this.y = this.y + vectorDesplazamiento.getB();
	}

	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
}