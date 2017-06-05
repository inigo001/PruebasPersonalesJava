package geometria;

public class Circulo {

	private Punto centro;
	private int radio;
	// Las variables calculadas no tiene sentido tenerlas como variables de
	// objeto porque se recalculan con otras variables. Puede producir errores
	// porque cada vez que cambiamos los otros datos tenemos que recalcular el
	// perímetro y podemos equivocarnos.
	// Como regla de estilo, las variables calculadas (dependientes de otros
	// datos) no se crean, se crean solo aquellas que definen el objeto, en este
	// caso centro y radio.
	private double perimetro;

	private final static Punto COORD_ORIGEN = new Punto(0, 0);
	private final static int DEFAULT_RADIO = 5;

	/* CONSTRUCTORES */

	public Circulo(Punto centro, int radio) {
		this.centro = new Punto(centro);
		this.radio = radio;
		this.perimetro = Circulo.calcularPerimetro(this.radio);
	}

	public Circulo() {
		this(Circulo.COORD_ORIGEN, Circulo.DEFAULT_RADIO);
	}

	public Circulo(Circulo circulo) {
		this(circulo.centro, circulo.radio);
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

		this.radio = (int) (this.radio * escala);
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
