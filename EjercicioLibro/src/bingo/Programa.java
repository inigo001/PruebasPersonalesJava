package bingo;

/**
 * @author inigo001
 * 
 * @see <a href="http://dis.um.es/docencia/poo/wiki/lib/exe/fetch.php?media=curso2016:ejercicio4-bingo.pdf">Bingo</a>
 *
 */
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Bingo bingo = new Bingo(50, 12);
		// System.out.println(bingo.girar());

		BingoAmericano bingoAmericano = new BingoAmericano();

		bingoAmericano.crearCartones(15);

		do {
			bingoAmericano.girar();
		} while (!bingoAmericano.getFinalizado());

		System.out.println(bingoAmericano.getBolasExtraidas());
		System.out.println(bingoAmericano.getCartonesBingo());

	}

}
