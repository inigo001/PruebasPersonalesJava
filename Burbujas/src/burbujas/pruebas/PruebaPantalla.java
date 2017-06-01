package burbujas.pruebas;

import burbujas.simulador.Pantalla;

import java.awt.Point;
import java.util.TimerTask;
import java.util.Timer;

import java.awt.Color;

public class PruebaPantalla {

	public static boolean teclaPulsada = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pantalla miPantalla = new Pantalla(350, 350);

		Point punto = new Point(50, 50);
		Color color = new Color(150, 150, 150);

		miPantalla.addCirculo(punto, 30, color);
		miPantalla.addCirculo(new Point(250, 250), 55, new Color(255, 0, 0));

		miPantalla.setBarraEstado("HOLA HOLA");

		miPantalla.dibujar();

		// Cuidado con esto, que no funciona como debe :S. Necesita algo de tipo
		// listener para poder usarlo con todas las de la ley.
		System.out.println(miPantalla.hayTecla());

		Timer miTimer = new Timer();

		miTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				teclaPulsada = miPantalla.hayTecla();
			}
		}, 0, 100);

		while (!teclaPulsada) {
			System.out.println("fduasio");

			if (teclaPulsada) {
				// System.out.println(miPantalla.leerTecla());
				System.out.println("jejeje");
				teclaPulsada = true;
			}
		}
		System.out.println("Pepe");
	}

}
