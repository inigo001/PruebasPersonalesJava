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

	/**
	 * @param position
	 *            Introducimos la posicion del numero que estamos buscando
	 *            dentro de la sucesión de Fibonacci
	 *
	 * @return Devuelve el número en la posición seleccionada
	 */
	public static int fibonacci(int position) {
		// Reducimos la posicion
		position--;

		int i = 1;
		int j = 0;

		for (int k = 0; k < position; k++) {
			int temp = i + j;
			j = i;
			i = temp;
		}

		return j;
	}

}
