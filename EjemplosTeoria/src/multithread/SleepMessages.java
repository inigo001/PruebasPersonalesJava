package multithread;

public class SleepMessages {

	// InterruptedException ocurre cuando un hilo interrumpe al hilo actual
	// mientras est� en sleep
	public static void main(String args[]) throws InterruptedException {

		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			// sleep detiene el hilo actual durante el tiempo indicado en
			// milisegundos. No es preciso porque depende de los tiempos del
			// procesador y SO, pero es una buena aproximaci�n para marcar los
			// tiempos.
			Thread.sleep(4000);

			// Despu�s de haber pasado los 4000 milisegundos el hilo contin�a
			// con su proceso
			System.out.println(importantInfo[i]);
		}
	}
}