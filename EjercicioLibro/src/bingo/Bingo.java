package bingo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Bingo. Contiene una serie de números que introducimos a la hora de
 * construirlo y mediante el método girar va devolviéndonoslos.
 * 
 * @author inigo001
 *
 */
public class Bingo {

	/* VARIABLES */

	/**
	 * La bola de mayor número. Como todas las bolas numeras del 1 hasta el
	 * número mayor, sin repeticiones, esta variable también es el número máximo
	 * de bolas en el bombo.
	 */
	final private int bolaMayor;
	final private int tamanoCarton;
	private ArrayList<Integer> bombo;
	private ArrayList<Integer> bolasExtraidas;
	private int ultimaBolaExtraida;
	private ArrayList<Carton> cartones;

	/* CONSTRUCTORES */

	public Bingo(int bolaMayor, int tamanoCarton) {
		this.bolaMayor = bolaMayor;
		this.tamanoCarton = tamanoCarton;
		this.bombo = this.createBombo(bolaMayor);
		this.bolasExtraidas = new ArrayList<Integer>();
		this.ultimaBolaExtraida = 0;
	}

	private ArrayList<Integer> createBombo(int bolaMayor) {
		ArrayList<Integer> bombo = new ArrayList<Integer>();
		for (int i = 1; i <= bolaMayor; i++) {
			bombo.add(i);
		}
		// desordenamos el bombo para que sea más divertido al iniciarlo.
		Collections.shuffle(bombo);

		return bombo;
	}

	/* METODOS */

	/**
	 * Giramos el bingo para que nos dé un número aleatorio que sea parte del
	 * bombo. Una vez terminado el giro quita ese número del bombo y lo añade a
	 * las bolasExtraídas
	 * 
	 * @return Devuelve un entero que formaba parte del bombo.
	 */
	public int girar() {
		// desordenamos el arrayList bombo para que los números no estén en
		// orden.
		Collections.shuffle(this.bombo);

		// Obtenemos el primer número de la lista
		int numeroResultado = this.bombo.get(0);
		// Quitamos el numero en la primera posición de la lista. Este metodo
		// hace que el arrayList reduzca su tamaño, haciendo que los elementos
		// se recoloquen para que no haya índices vacíos.
		this.bombo.remove(0);

		// Introducimos el número que hemos conseguido en la lista de bolas
		// extraídas.
		this.bolasExtraidas.add(numeroResultado);

		return numeroResultado;
	}

	public Carton crearCarton() {
		Collections.shuffle(this.bombo);
		ArrayList<Integer> numerosDeCarton = new ArrayList<Integer>();

		Carton nuevoCarton;

		do {
			for (int i = 0; i < this.tamanoCarton; i++) {
				numerosDeCarton.add(this.bombo.get(i));
			}
			nuevoCarton = new Carton(numerosDeCarton, this.tamanoCarton);
		} while (this.cartones.contains(nuevoCarton));

		this.anadirCarton(nuevoCarton);

		return nuevoCarton;
	}

	public Carton[] crearCartones(int numeroDeCartones) {
		numeroDeCartones = (numeroDeCartones > 0) ? numeroDeCartones : 1;
		Carton[] grupoDeCartones = new Carton[numeroDeCartones];

		for (int i = 0; i < numeroDeCartones; i++) {
			grupoDeCartones[i] = this.crearCarton();
		}

		return grupoDeCartones;
	}

	public void anadirCarton(Carton carton) {
		if (!this.cartones.contains(carton)) {
			this.cartones.add(carton);
		}
	}

	/* GET Y SET */

	public int getBolaMayor() {
		return this.bolaMayor;
	}

	public int getTamanoCarton() {
		return this.tamanoCarton;
	}

	public ArrayList<Integer> getBombo() {
		return new ArrayList<Integer>(this.bombo);
	}

	public ArrayList<Integer> getBolasExtraidas() {
		return new ArrayList<Integer>(this.bolasExtraidas);
	}

	public int getUltimaBolaExtraida() {
		return this.ultimaBolaExtraida;
	}

	public ArrayList<Carton> getCartones() {
		return this.cartones;
	}

}
