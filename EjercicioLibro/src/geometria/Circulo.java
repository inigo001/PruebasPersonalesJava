package geometria;

public class Circulo {

	private Punto centro;
	private int radio;
	private double perimetro;

	private final static Punto COORD_ORIGEN = new Punto();
	private final static int DEFAULT_RADIO = 5;

	/* CONSTRUCTORES */

	public Circulo(Punto centro, int radio) {
		this.centro = new Punto(centro);
		this.radio = radio;
		this.perimetro = Circulo.calcularPerimetro(this.radio);
	}

	public Circulo() {
		this.centro = Circulo.COORD_ORIGEN;
		this.radio = Circulo.DEFAULT_RADIO;
		this.perimetro = Circulo.calcularPerimetro(this.radio);
	}

	public Circulo(Circulo circulo) {
		this.centro = circulo.centro;
		this.radio = circulo.radio;
		this.perimetro = circulo.perimetro;
	}

	/* METODOS PRIVADOS */

	/* METODOS PUBLICOS */

	public void desplazar(double x, double y) {
		this.centro.desplazar(x, y);
	}

	public void desplazar(Punto punto) {
		this.centro.desplazar(punto);
	}

	public void desplazar(Direccion direccion) {
		this.centro.desplazar(direccion);
	}

	public void escalar(int porcentaje) {
		double escala = porcentaje * 0.01;

		this.radio = (int)(this.radio * escala);
		this.perimetro = Circulo.calcularPerimetro(this.radio);
	}

	/* GET Y SET */

	public Punto getCentro() {
		return new Punto(this.centro);
	}

	public int getRadio() {
		return this.radio;
	}

	public double getPerimetro() {
		return this.perimetro;
	}

	public String toString() {
		return "(" + this.centro + "," + this.radio + ")";
	}

	/* ESTÁTICAS */

	public static double calcularPerimetro(int radio) {
		return (2 * Math.PI * radio);
	}

}
