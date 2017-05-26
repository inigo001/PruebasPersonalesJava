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

			numArray = Sort.substitute(numArray, mayorIndex, j);
			// Sort.substitute(numArray, mayorIndex, j);
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
				Sort.substitute(array, j, j - 1);
				j = j - 1;
			}
		}
		
		return array;

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
				substitute(numArray, j, i);
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

	private static int[] substitute(int[] array, int firstIndex, int secondIndex) {

		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;

		return array;
	}

}
