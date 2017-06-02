package bingo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase Bingo. Contiene una serie de n�meros que introducimos a la hora de
 * construirlo y mediante el m�todo girar va devolvi�ndonoslos.
 * 
 * @author inigo001
 *
 */
public abstract class Bingo {

	/* VARIABLES */

	/**
	 * La bola de mayor n�mero. Como todas las bolas numeras del 1 hasta el
	 * n�mero mayor, sin repeticiones, esta variable tambi�n es el n�mero m�ximo
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
		this.cartones = new ArrayList<Carton>();
	}

	/**
	 * Crea un bombo en base a la cantidad de bolas que este tiene. A�ade los
	 * n�meros desde el 1 hasta el valor de bola mayor.
	 * 
	 * @param bolaMayor
	 *            En este caso representa el n�mero de bolas que tiene el bombo.
	 * @return Devuelve una lista de bolas, desordenada.
	 */
	private ArrayList<Integer> createBombo(int bolaMayor) {
		ArrayList<Integer> bombo = new ArrayList<Integer>();
		for (int i = 1; i <= bolaMayor; i++) {
			bombo.add(i);
		}
		// desordenamos el bombo para que sea m�s divertido al iniciarlo.
		Collections.shuffle(bombo);

		return bombo;
	}

	/* METODOS */

	/**
	 * Giramos el bingo para que nos d� un n�mero aleatorio que sea parte del
	 * bombo. Una vez terminado el giro quita ese n�mero del bombo y lo a�ade a
	 * las bolasExtra�das
	 * 
	 * @return Devuelve un entero que formaba parte del bombo.
	 */
	public int girar() {
		// desordenamos el arrayList bombo para que los n�meros no est�n en
		// orden.
		Collections.shuffle(this.bombo);

		// Obtenemos el primer n�mero de la lista
		int numeroResultado = this.bombo.get(0);
		// Quitamos el numero en la primera posici�n de la lista. Este metodo
		// hace que el arrayList reduzca su tama�o, haciendo que los elementos
		// se recoloquen para que no haya �ndices vac�os.
		this.bombo.remove(0);

		// Introducimos el n�mero que hemos conseguido en la lista de bolas
		// extra�das.
		this.bolasExtraidas.add(numeroResultado);

		return numeroResultado;
	}

	/**
	 * Creamos un carton que contenga los numeros inclu�dos en el bombo del
	 * juego. El cart�n no puede tener n�meros repetidos y no puede haber uno
	 * que sea igual. Adem�s, en la subclase existe una funci�n para saber si un
	 * carton es aceptable o no dependiendo de las reglas de �ste. El cart�n es
	 * guardado en el listado de cartones que forman parte del Bingo.
	 * 
	 * @return Un cart�n (de tipo Carton) que cumpla con las condiciones.
	 * 
	 */
	public Carton crearCarton() {

		Carton nuevoCarton;

		do {
			Collections.shuffle(this.bombo);
			ArrayList<Integer> numerosDeCarton = new ArrayList<Integer>();

			for (int i = 0; i < this.tamanoCarton; i++) {
				numerosDeCarton.add(this.bombo.get(i));
			}
			nuevoCarton = new Carton(numerosDeCarton, this.tamanoCarton);

		} while (this.cartones.contains(nuevoCarton) || !this.isAcceptable(nuevoCarton));

		this.anadirCarton(nuevoCarton);

		return nuevoCarton;
	}

	/**
	 * Comprueba si un cart�n es aceptable dependiendo de las reglas del Bingo.
	 * Esta funci�n se sobreescribe en las subclases.
	 * 
	 * @param carton
	 * @return Devuelve un booleano que marca si el cart�n es aceptable o no.
	 */
	protected abstract boolean isAcceptable(Carton carton);

	/**
	 * Devuelve un n�mero de cartones determinado mediante la funci�n crear
	 * cartones en forma de array.
	 * 
	 * @param numeroDeCartones
	 *            Numero de cartones que queremos que el Bingo cree.
	 * @return Array con los cartones que hemos creado. Todos cumplen con las
	 *         condiciones de los cartones que impone el propio tipo de Bingo.
	 */
	public Carton[] crearCartones(int numeroDeCartones) {
		numeroDeCartones = (numeroDeCartones > 0) ? numeroDeCartones : 1;
		Carton[] grupoDeCartones = new Carton[numeroDeCartones];

		for (int i = 0; i < numeroDeCartones; i++) {
			grupoDeCartones[i] = this.crearCarton();
		}

		return grupoDeCartones;
	}

	/**
	 * A�ade el cart�n elegido a la lista de cartones de que tiene el propio
	 * Bingo
	 * 
	 * @param carton
	 *            El cart�n que deseamos a�adir. Est� comprobado como cart�n
	 *            aceptable.
	 */
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
