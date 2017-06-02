package reordenar;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numArray = createArray(50000000, 100000000);

		Principal.singleThread(numArray);
	}

	private static int[] createArray(int amount, int maximum) {

		int[] numArray = new int[amount];

		for (int i = 0; i < numArray.length; i++) {
			int newNumber = (int) (Math.random() * maximum);
			numArray[i] = newNumber;
		}

		return numArray;
	}

	private static void singleThread(int[] numArray) {
		long initialTime = System.currentTimeMillis();

		Sort.quickSort(numArray);

		System.out.println("Tiempo de tardanza: " + (System.currentTimeMillis() - initialTime));

		System.out.println("ArrayOrdenado");
		System.out.println(numArray[numArray.length - 1]);

	}

	private static class QuickSortThread implements Runnable {

		private int[] miArray;
		private int indiceSup;
		private int indiceInf;

		public QuickSortThread(int[] miArray, int indiceSup, int indiceInf) {
			this.miArray = miArray;
			this.indiceSup = indiceSup;
			this.indiceInf = indiceInf;
		}

		@Override
		public void run() {

			Sort.innerQuickSort(miArray, indiceInf, indiceSup);

		}

	}

	private static void multiThread(int[] numArray) throws InterruptedException {

		int indiceCentral = (int) (numArray.length / 2);

		Thread hilo1 = new Thread(new QuickSortThread(numArray, 0, indiceCentral), "Hilo 1");
		Thread hilo2 = new Thread(new QuickSortThread(numArray, indiceCentral + 1, numArray.length), "Hilo 2");

		hilo1.start();
		hilo2.start();

		hilo1.join();
		hilo2.join();
		
		System.out.println("terminé");

	}

	private static void showArrayContent(int[] numArray) {

		System.out.println("Array Length: " + numArray.length);
		System.out.println("Array Content:");

		for (int i = 0; i < numArray.length; i++) {
			System.out.print(numArray[i] + ", ");
		}

		System.out.println("\n");

	}

}
