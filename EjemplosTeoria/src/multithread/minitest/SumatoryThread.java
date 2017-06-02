package multithread.minitest;

public class SumatoryThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (MainProgram.miNumero <= MainProgram.MAX_NUMBER) {
			this.sumarNumero();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + " - HILO CERRADO");

	}

	private synchronized void sumarNumero() {
		MainProgram.miNumero++;

		System.out.println(Thread.currentThread().getName() + " -> " + MainProgram.miNumero);
	}

}
