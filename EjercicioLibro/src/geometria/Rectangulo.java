package geometria;

public class Rectangulo {

	private Punto verticeII;
	private Punto verticeSD;
	private Punto verticeSI;
	private Punto verticeID;

	private double ladoY;
	private double ladoX;

	/* CONSTRUCTORES */

	public Rectangulo(Punto verticeII, double ladoX, double ladoY) {
		this.ladoX = ladoX;
		this.ladoY = ladoY;

		this.verticeII = new Punto(verticeII);
		this.verticeSD = new Punto(this.verticeII.getX() + this.ladoX, this.verticeII.getY() + this.ladoY);
		this.verticeSI = new Punto(this.verticeII.getX(), this.verticeII.getY() + this.ladoY);
		this.verticeID = new Punto(this.verticeII.getX() + this.ladoX, this.verticeII.getY());
	}

	public Rectangulo(Punto verticeII, Punto verticeSD) {
		this.verticeII = new Punto(verticeII);
		this.verticeSD = new Punto(verticeSD);
		this.verticeSI = new Punto(this.verticeII.getX(), this.verticeSD.getY());
		this.verticeID = new Punto(this.verticeSD.getX(), this.verticeII.getY());

		this.ladoX = Punto.distancia(this.verticeII, this.verticeID);
		this.ladoY = Punto.distancia(this.verticeII, this.verticeSI);
	}

	/* METODOS PUBLICOS */

	public void desplazar(int x, int y) {
		this.verticeII.desplazar(x, y);
		this.verticeSD.desplazar(x, y);
		this.verticeSI.desplazar(x, y);
		this.verticeID.desplazar(x, y);
	}

	public void desplazar(Direccion direccion) {
		this.verticeII.desplazar(direccion);
		this.verticeSD.desplazar(direccion);
		this.verticeSI.desplazar(direccion);
		this.verticeID.desplazar(direccion);
	}

	/* SET Y GET */

	public Punto getVerticeII() {
		return new Punto(verticeII);
	}

	public Punto getVerticeSD() {
		return new Punto(verticeSD);
	}

	public Punto getVerticeSI() {
		return new Punto(verticeSI);
	}

	public Punto getVerticeID() {
		return new Punto(verticeID);
	}

	public double getLadoX() {
		return this.ladoX;
	}

	public double getLadoY() {
		return this.ladoY;
	}

	public String toString() {
		return this.verticeII + "," + this.verticeSI + "," + this.verticeSD + "," + this.verticeID;
	}

}
