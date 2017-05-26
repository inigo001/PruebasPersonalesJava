package geom2d;

public class Circulo extends Figura2D {
	private double radio;

	public Circulo() {
		this.radio = 0;
	}

	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double area() {
		return Math.PI * radio * radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
}
