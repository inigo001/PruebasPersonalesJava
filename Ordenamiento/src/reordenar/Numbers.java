package reordenar;

public class Numbers {

	/**
	 * Prueba de algoritmo euclideo. Devuelve el máximo común divisor de entre
	 * dos numeros que introduzcamos. El orden es indiferente.
	 * 
	 * @param firstNumber
	 *            El primer numero que queremos comparar
	 * @param secondNumber
	 *            El segundo numero que queremos comparar
	 * @return El resultado del algoritmo euclideo
	 */
	public static int euclid(int firstNumber, int secondNumber) {
		firstNumber = Math.abs(firstNumber);
		secondNumber = Math.abs(secondNumber);

		int resto;

		do {
			resto = firstNumber % secondNumber;

			firstNumber = secondNumber;
			secondNumber = resto;

		} while (resto != 0);

		return firstNumber;
	}

}
