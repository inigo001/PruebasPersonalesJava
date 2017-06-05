package reordenar;

public class ThreadedReorder {

	public static final int MAX_THREADS = 4;
	public static int numberOfThreads;

	public static void main(String[] args) throws InterruptedException {

		// Aquí creamos un Array. El número máximo está cerca de los 2000
		// millones. si son 2000 millones de bytes nos tragamos 2 Gigas de
		// memoria, pero cada int ocupa 4 bytes, por lo que son 8 Gigas de RAM
		// que nos tragamos xD. Cuidado con esto en ordenadorcitos tontorrones
		// xD.

		int arrayLength = (args.length > 0) ? Integer.parseInt(args[0]) : 10000000;

		int[] numArray = createArray(arrayLength, 100000000);

		// System.out.println(numArray[110000000]);

		numberOfThreads = (args.length >= 2) ? Integer.parseInt(args[1]) : ThreadedReorder.MAX_THREADS;

		long initialTime = System.currentTimeMillis();

		innerQuickSort(numArray, 0, numArray.length - 1);

		System.out.println("Tiempo de tardanza: " + (System.currentTimeMillis() - initialTime));

	}

	private static int[] createArray(int amount, int maximum) {

		int[] numArray = new int[amount];

		for (int i = 0; i < numArray.length; i++) {
			int newNumber = (int) (Math.random() * maximum);
			numArray[i] = newNumber;
		}

		return numArray;
	}

	private static class QuickSortThread implements Runnable {

		public int[] miArray;
		public int indiceSuperior;
		public int indiceInferior;

		public QuickSortThread(int[] miArray, int indiceInferior, int indiceSuperior) {
			this.miArray = miArray;
			this.indiceInferior = indiceInferior;
			this.indiceSuperior = indiceSuperior;
		}

		@Override
		public void run() {
			Sort.innerQuickSort(miArray, indiceInferior, indiceSuperior);
		}

	}

	private static void innerQuickSort(int[] numArray, int indiceInferior, int indiceSuperior)
			throws InterruptedException {
		int i = indiceInferior;
		int j = indiceSuperior;

		int numeroInferior = numArray[0];
		int numeroSuperior = numArray[0];

		for (int k = 1; k < numArray.length; k++) {
			if (numArray[k] > numeroSuperior) {
				numeroSuperior = numArray[k];
			} else if (numArray[k] < numeroInferior) {
				numeroInferior = numArray[k];
			}
		}

		int pivote = (int) (numeroInferior + ((numeroSuperior - numeroInferior) * 0.5));

		while (i <= j) {

			while (numArray[i] < pivote) {
				i++;
			}
			while (numArray[j] > pivote) {
				j--;
			}
			if (i <= j) {
				Sort.swap(numArray, j, i);
				i++;
				j--;
			}
		}

		if (numberOfThreads > 0) {
			Thread hilo1 = new Thread(new QuickSortThread(numArray, 0, j));
			Thread hilo2 = new Thread(new QuickSortThread(numArray, i, numArray.length - 1));

			hilo1.start();
			hilo2.start();

			hilo1.join();
			hilo2.join();

			numberOfThreads = numberOfThreads - 2;
		} else {

			if (indiceInferior < j) {
				Sort.innerQuickSort(numArray, indiceInferior, j);
			}
			if (i < indiceSuperior) {
				Sort.innerQuickSort(numArray, i, indiceSuperior);
			}
		}

	}

}
