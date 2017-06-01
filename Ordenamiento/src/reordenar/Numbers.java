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

	/**
	 * Algoritmo loco para descubrir si un número es primo o no. Es un poco
	 * cutre porque recorre todos los números posibles, sumándolos. TODO hacerlo
	 * mejor.
	 * 
	 * @param number
	 *            Numero a analizar
	 * @return Devuelve true si es primo o false si no lo es.
	 */
	public static boolean isPrime(int number) {
		boolean isPrime = true;

		if (number <= 0) {
			isPrime = false;
		}
		if (number > 3 && isPrime) {
			for (int i = 2; (i < number * 0.5) && (isPrime); i++) {
				isPrime = !((number % i) == 0);
			}
		}
		return isPrime;
	}

}
