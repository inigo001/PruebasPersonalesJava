package multithread;

public class SleepMessagesInterrupt {

	// InterruptedException ocurre cuando un hilo interrumpe al hilo actual
	// mientras est� en sleep
	public static void main(String args[]) throws InterruptedException {

		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// We've been interrupted: no more messages.
				System.out.println("Error de interrupci�n");
				return;
			}
			
			if(Thread.interrupted())
			{
				System.out.println("Hemos sido interrumpidos");
			}
			// Despu�s de haber pasado los 4000 milisegundos el hilo contin�a
			// con su proceso
			System.out.println(importantInfo[i]);
		}
	}
}