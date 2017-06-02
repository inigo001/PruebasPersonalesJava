package multithread;

/**
 * La clase que queremos que funcione en un hilo aparte tiene que implementar la
 * interfaz Runnable. Podemos extender la clase Thread, que ya implementa la
 * interfaz Runnable, pero es preferible hacerlo de esta manera por si queremos
 * extender nuestra clase a partir de otra.
 * 
 * @author inigo001
 *
 */
public class HelloRunnable implements Runnable {

	// Tenemos que sobreescribir el método run con el código que queremos que
	// corra cuando llamemos al hilo desde su método start
	public void run() {
		System.out.println("Hello from a thread!");
	}

	// Para inicializar nuestro hilo lo inicializamos con new Thread y después
	// como new TipoDeClase. Una vez creado, para inicializarlo utilizamos su
	// método start();
	public static void main(String args[]) {
		(new Thread(new HelloRunnable())).start();
		
		// Para saber la cantidad de procesadores que tenemos.
		System.out.println("Procesadores disponibles: " + Runtime.getRuntime().availableProcessors());
	}

}