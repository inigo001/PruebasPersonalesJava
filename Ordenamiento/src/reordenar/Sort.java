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
	public static int[] merge(int[] array) {

		int middleIndex = (int) (array.length / 2);

		int firstArrayLength = middleIndex;
		int secondArrayLength = array.length - middleIndex;

		int[] firstArray = new int[firstArrayLength];
		int[] secondArray = new int[secondArrayLength];

		if (middleIndex > 0) {

			for (int i = 0; i < firstArrayLength; i++) {
				firstArray[i] = array[i];
			}

			for (int i = 0; i < secondArrayLength; i++) {
				secondArray[i] = array[middleIndex + i];
			}

			firstArray = merge(firstArray);
			secondArray = merge(secondArray);
		}

		int[] newArray = new int[array.length];

		int i = 0;
		int j = 0;

		while (i < (firstArrayLength - 1) && j < (secondArrayLength - 1)) {

			if (firstArray[i] < secondArray[j]) {
				newArray[i + j] = firstArray[i];
				i++;
			} else {
				newArray[i + j] = firstArray[j];
				j++;
			}

		}

		return newArray;
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
