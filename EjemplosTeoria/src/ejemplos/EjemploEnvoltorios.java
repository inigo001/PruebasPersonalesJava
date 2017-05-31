package ejemplos;

import java.util.ArrayList;

/**
 * Los Envoltorios (Wrappers) son Objetos relacionados con los tipos primitivos.
 * Cada tipo primitivo tiene su envoltorio asociado. A partir de Java 5 su uso
 * es mucho m�s sencillo.
 * 
 * @author inigo001
 */
@SuppressWarnings("all")
public class EjemploEnvoltorios {

	public static void main(String[] args) {

		EjemploEnvoltorios.pruebaArray();
		EjemploEnvoltorios.pruebaArrayList();
	}

	private static void pruebaArray() {
		// Los arrays no son din�micos, en caso de querer almacenar mas datos
		// que los inclu�dos, no podemos. Necesitamos un ArrayList.
		int[] arrayInts = new int[89];

		System.out.println(arrayInts);
	}

	private static void pruebaArrayList() {

		int a = 3;
		int b = 7;

		// Clases Wrapper. Convierten una variable de tipo primitivo en una de
		// tipo Objeto para poder ser a�adida en un ArrayList, pues estos no
		// permiten a�adir cosas que no sean Objetos.
		Integer aInteger = new Integer(a);
		Integer bInteger = new Integer(b);

		// Puede escribirse as�, pero es mejor escribirlos con el tipo que se le
		// introduzca
		// ArrayList<Integer> = new ArrayList<Integer>();
		ArrayList lista = new ArrayList();

		// Si intentamos hacer "lista.add(a);" no nos lo permitir�a, porque no
		// son objetos.
		// Dar�a error.
		lista.add(aInteger);
		lista.add(bInteger);

		System.out.println(lista);

		// Si queremos pasar del Integer al int tenemos que hacerlo a la
		// inversa.
		int backA = ((Integer) lista.get(0)).intValue();
		int backB = ((Integer) lista.get(1)).intValue();

		/* ------------------ */
		/* A PARTIR DE JAVA 5 */
		/* ------------------ */

		// A partir de Java 5 permite al autoboxing, para declarar los tipos de
		// objeto de manera mas sencilla, si tener que hacer lo de new
		// Integer().
		int c = 25;
		Integer cInteger = c;
		int cLoco = cInteger;

		// No hace pasarlos a int para usarlos. El compilador hace las
		// transformaciones al vuelo.
		System.out.println(aInteger + bInteger);

		// El compilador hace muchas de estas transformaciones al vuelo, por lo
		// que no hay que estar convirtiendo primitivos a objetos y a la
		// inversa.

		// Todos estos procesos funcionan con todos los tipos primitivos y sus
		// wrappers relativos
	}

}
