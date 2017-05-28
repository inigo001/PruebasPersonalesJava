package reordenar;

public class Sort {

	public static int[] bubble(int[] numArray) {

		for (int j = numArray.length - 1; j >= 0; j--) {

			int mayorIndex = 0;

			for (int i = 1; i <= j; i++) {
				if (numArray[i] >= numArray[mayorIndex]) {
					mayorIndex = i;
				}
			}

			numArray = Sort.swap(numArray, mayorIndex, j);
			// Sort.swap(numArray, mayorIndex, j);
		}

		return numArray;
	}

	public static int[] quickSort(int[] numArray) {

		int indiceInferior = 0;
		int indiceSuperior = numArray.length - 1;

		Sort.innerQuickSort(numArray, indiceInferior, indiceSuperior);

		return numArray;
	}

	public static int[] insertion(int[] array) {

		for (int i = 0; i < array.length; i++) {

			int j = i;

			while ((j > 0) && (array[j - 1] > array[j])) {
				Sort.swap(array, j, j - 1);
				j = j - 1;
			}
		}
		return array;
	}

	public static int[] selection(int[] array) {
		for (int i = 0; i < array.length; i++) {

			int menorIndex = i;

			for (int j = i; j < array.length; j++) {
				if (array[menorIndex] > array[j]) {
					menorIndex = j;
				}
			}

			Sort.swap(array, menorIndex, i);
		}

		return array;
	}

	// ARREGLAME
	public static void merge(int[] array) {

		if (array.length <= 1) {
			return;
		}

		int halfArray = (int) (array.length / 2);

		int[] leftArray = new int[halfArray];
		int[] rightArray = new int[array.length - halfArray];

		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = array[i];
		}

		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = array[halfArray + i];
		}

		Sort.merge(leftArray);
		Sort.merge(rightArray);

		int i = 0;
		int j = 0;

		while (i < leftArray.length && j < rightArray.length) {

			if (leftArray[i] > rightArray[j]) {
				array[i + j] = rightArray[j];
				j++;
			} else {
				array[i + j] = leftArray[i];
				i++;
			}
		}

		while (i < leftArray.length) {
			array[i + j] = leftArray[i];
			i++;
		}
		while (j < rightArray.length) {
			array[i + j] = rightArray[j];
			j++;
		}

		return;

	}

	private static void innerQuickSort(int[] numArray, int indiceInferior, int indiceSuperior) {
		int i = indiceInferior;
		int j = indiceSuperior;

		int pivote = numArray[indiceInferior + (int) ((indiceSuperior - indiceInferior) / 2)];

		while (i <= j) {

			while (numArray[i] < pivote) {
				i++;
			}
			while (numArray[j] > pivote) {
				j--;
			}
			if (i <= j) {
				swap(numArray, j, i);
				i++;
				j--;
			}
		}

		if (indiceInferior < j) {
			Sort.innerQuickSort(numArray, indiceInferior, j);
		}
		if (i < indiceSuperior) {
			Sort.innerQuickSort(numArray, i, indiceSuperior);
		}
	}

	private static int[] swap(int[] array, int firstIndex, int secondIndex) {

		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;

		return array;
	}

}
