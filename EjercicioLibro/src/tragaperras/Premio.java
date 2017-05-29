package tragaperras;

import java.util.Arrays;

public class Premio {

	private Fruta[] combinacion;
	private double dinero;

	/* CONSTRUCTORES */

	public Premio(Fruta[] combinacion, double dinero) {
		this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
		this.dinero = dinero;
	}

	/* GET Y SET */

	public Fruta[] getCombinacion() {
		return Arrays.copyOf(this.combinacion, this.combinacion.length);
	}

	public double getDinero() {
		return this.dinero;
	}

}
