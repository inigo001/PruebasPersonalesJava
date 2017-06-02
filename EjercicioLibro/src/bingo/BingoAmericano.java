package bingo;

import java.util.ArrayList;

public class BingoAmericano extends Bingo {

	final static int BOLA_MAYOR = 90;
	final static int TAMANO_CARTON = 15;

	public BingoAmericano() {
		super(BingoAmericano.BOLA_MAYOR, BingoAmericano.TAMANO_CARTON);
	}

	@Override
	protected boolean isAcceptable(Carton carton) {

		ArrayList<Integer> numerosCarton = carton.getNumerosDeCarton();
		int sumaNumeros = 0;

		for (int i = 0; i < numerosCarton.size(); i++) {
			sumaNumeros = sumaNumeros + numerosCarton.get(i);
		}

		boolean isAcceptable = ((sumaNumeros / numerosCarton.size()) <= 50);

		return isAcceptable;
	}

	/*
	 * (non-Javadoc) Esto es un chapuza
	 * 
	 * @see bingo.Bingo#girar()
	 */
	@Override
	public int girar() {

		int previousNumber = -1;
		int numeroExtraido;

		boolean areConsecutive;

		do {
			areConsecutive = false;
			numeroExtraido = super.girar();

			if ((previousNumber + 1 == numeroExtraido)) {
				areConsecutive = true;
				previousNumber = numeroExtraido;
				this.anadirBola(numeroExtraido);
			}

		} while (areConsecutive);

		return numeroExtraido;
	}

}
