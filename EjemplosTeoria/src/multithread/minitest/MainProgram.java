package multithread.minitest;

/**
 * Tenemos un programa principal que crea dos hilos de tipo SumatoryThread. Cada
 * hilo suma al long miNumero 1 cada 1000 milisegundos, pero lo hacen con una
 * diferencia de medio segundo. Cada 5 segundos el hilo principal escribe el
 * número actual.
 * 
 * @author inigo001
 *
 */
public class MainProgram {

	static long miNumero;
	final static long MAX_NUMBER = 50;

	public static void main(String[] args) throws InterruptedException {

		MainProgram.miNumero = -1;

		// Creamos el primer hilo y lo iniciamos.
		System.out.println("Iniciamos primer HILO");

		Thread hilo1 = new Thread(new SumatoryThread(), "PRIM");
		hilo1.start();

		// Dormimos el hilo principal durante 500 segundos
		Thread.sleep(500);

		// Creamos el segundo hilo y lo iniciamos-
		System.out.println("Iniciamos segundo HILO");

		Thread hilo2 = new Thread(new SumatoryThread(), "SEGU");
		hilo2.start();

		// Dormimos el hilo principal para que el segundo hilo sea el que está
		// actualmente funcionando.
		Thread.sleep(1);

		// Creamos un bucle while en el hilo principal que, cada 5 segundos
		// (aunque al principio una vez) lanza un texto diciendo a cuanto está
		// el numero. Cuando el primer hilo se detenga, el hilo principal
		// también lo hace.
		// TODO Esto hay que mirarlo puesto que sería mejor que el hilo
		// principal se detuviese al terminar cualquier de los hilos (y al
		// ocurrir esto, se detuviesen el resto de hilos.
		while (MainProgram.miNumero <= MainProgram.MAX_NUMBER) {
			System.out.println(Thread.currentThread().getName() + " -> " + MainProgram.miNumero);
			hilo1.join(5000);
		}
		
		System.out.println(Thread.currentThread().getName() + " - HILO CERRADO");

	}

}
