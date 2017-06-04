package reordenar;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int[] numArray = createArray(50000000, 100000000);
		int[] arraySingle = numArray.clone();

		System.out.println(numArray[25]);
		System.out.println(arraySingle[25]);

		Principal.singleThread(arraySingle);
		Principal.multiThread(numArray);

		System.out.println(arraySingle[250]);
		System.out.println(numArray[250]);

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
	}

	private static class QuickSortThread implements Runnable {

		public int[] miArray;
		public int indiceSuperior;
		public int indiceInferior;

		public QuickSortThread(int[] miArray , int indiceInferior, int indiceSuperior) {
			this.miArray = miArray;
			this.indiceInferior = indiceInferior;
			this.indiceSuperior = indiceSuperior;
		}

		@Override
		public synchronized void run() {
			Sort.innerQuickSort(miArray, indiceInferior, indiceSuperior);
		}

	}

	private static void multiThread(int[] numArray) throws InterruptedException {

		long initialTime = System.currentTimeMillis();
		
		int i = 0;
		int j = numArray.length - 1;
		int indiceCentral = (int) (numArray.length / 2);

		int pivote = numArray[indiceCentral];

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
		
		Thread hilo1 = new Thread(new QuickSortThread(numArray, 0, j));
		Thread hilo2 = new Thread(new QuickSortThread(numArray, i, numArray.length - 1));
				
		hilo1.start();
		hilo2.start();
		
		hilo1.join();
		hilo2.join();

		System.out.println("Tiempo de tardanza: " + (System.currentTimeMillis() - initialTime));
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
