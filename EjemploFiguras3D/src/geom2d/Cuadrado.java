package geom2d;

public class Cuadrado extends Figura2D {
	private double lado;

	public Cuadrado() {
		this.lado = 0;
	}

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public double area() {
		return lado * lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
}
