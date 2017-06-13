package colecciones.colecciones;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import colecciones.geometria.Punto;

public class TestSortedSet {

	public static void main(String[] args) {
		Punto punto1 = new Punto(1, 2);
		Punto punto2 = new Punto(3, 4);
		Punto punto3 = new Punto(5, 6);
		Punto punto4 = new Punto(5, 7);
		Punto punto5 = new Punto(2, 4);
		Punto punto6 = new Punto(0, 10);
		SortedSet<Punto> sortedSetPuntos = new TreeSet<Punto>();
		sortedSetPuntos.add(punto1);
		sortedSetPuntos.add(punto2);
		sortedSetPuntos.add(punto3);
		sortedSetPuntos.add(punto4);
		sortedSetPuntos.add(punto5);
		sortedSetPuntos.add(punto6);
		recorrer(sortedSetPuntos);

	}

	public static void recorrer(SortedSet<Punto> sortedSetPuntos) {
		//
		Iterator<Punto> iterator = sortedSetPuntos.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// for (Punto punto : sortedSetPuntos) {
		// System.out.println(punto);
		// }
	}
}
