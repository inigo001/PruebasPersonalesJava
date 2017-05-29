package tragaperras;

import java.util.Arrays;
import java.util.Random;

public class Maquina {

	private Fruta[] combinacion;
	private double precio;
	private double credito;
	private Premio[] premios;

	/* CONSTRUCTOR */

	public Maquina(int numCasillas, double precio, Premio... premios) {
		this.combinacion = new Fruta[numCasillas];
		this.precio = precio;
		this.credito = 0;
		this.premios = premios;
	}

	/* METODOS PRIVADOS */

	private void reducirSaldo() {
		this.credito -= this.precio;
	}

	private void generarCombinacion() {
		Random generador = new Random();
		Fruta[] frutas = Fruta.values();

		for (int i = 0; i < this.combinacion.length; i++) {
			int index = generador.nextInt(5);
			this.combinacion[i] = frutas[index];
		}
	}

	private double dineroPremio() {

		double dineroPremio = 0;

		for (int i = 0; i < premios.length; i++) {
			if (Arrays.equals(this.combinacion, premios[i].getCombinacion())) {
				dineroPremio = premios[i].getDinero();
			}
		}

		return dineroPremio;
	}

	/* METODOS PUBLICOS */

	public void incrementarCredito(double extraCredito) {
		this.credito += extraCredito;
	}

	public void cobrar() {
		this.credito = 0;
	}

	public Fruta[] jugar() {
		Fruta[] combinacionPartida = null;

		if (this.precio <= this.credito) {

			this.reducirSaldo();
			this.generarCombinacion();

			double dinero = this.dineroPremio();

			if (dinero > 0) {
				this.credito += dinero;
			}

			combinacionPartida = Arrays.copyOf(this.combinacion, this.combinacion.length);
		}

		return combinacionPartida;
	}

	/* GET Y SET */

	public Fruta[] getCasillas() {
		return Arrays.copyOf(this.combinacion, this.combinacion.length);
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCredito() {
		return this.credito;
	}

	public Premio[] getPremios() {
		return this.premios;
	}

}
