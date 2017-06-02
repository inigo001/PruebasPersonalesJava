package bingo;

import java.util.ArrayList;
import java.util.Collections;

public class BingoClasico extends Bingo {

	final static int BOLA_MAYOR = 90;
	final static int TAMANO_CARTON = 15;

	public BingoClasico() {
		super(BingoClasico.BOLA_MAYOR, BingoClasico.TAMANO_CARTON);
	}

	@Override
	protected boolean isAcceptable(Carton carton) {

		boolean isAcceptable = true;

		ArrayList<Integer> numerosCarton = carton.getNumerosDeCarton();
		Collections.sort(numerosCarton);

		int previousNum = numerosCarton.get(0);

		for (int i = 1; (i < numerosCarton.size()) && (isAcceptable); i++) {

			isAcceptable = ((previousNum + 1) != numerosCarton.get(i));

			previousNum = numerosCarton.get(i);
		}

		return isAcceptable;
	}

}
