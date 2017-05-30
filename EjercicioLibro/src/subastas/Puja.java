package subastas;

public class Puja {

	private Usuario pujador;
	private double valor;

	/* CONSTRUCTORES */

	public Puja(Usuario pujador, double valor) {
		this.pujador = pujador;
		this.valor = valor;
	}

	/* GET Y SET */

	public Usuario getPujador() {
		return this.pujador;
	}

	public double getValor() {
		return this.valor;
	}

	public String toString() {
		return "(" + this.pujador + "," + this.valor + "€)";
	}

}
