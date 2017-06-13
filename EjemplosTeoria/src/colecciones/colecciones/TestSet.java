package colecciones.colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import colecciones.geometria.Punto;

public class TestSet {

	public static void main(String[] args) {

		Punto punto1 = new Punto(1, 2);
		Punto punto2 = new Punto(1, 2);
		Punto punto3 = new Punto(5, 6);
		Set<Punto> setPuntos = new HashSet<>();
		setPuntos.add(punto1);
		boolean anyadido = setPuntos.add(punto2);
		setPuntos.add(punto3);
		recorrer(setPuntos);

	}

	public static void recorrer(Set<Punto> setPuntos) {
		//
		Iterator<Punto> iterator = setPuntos.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		for (Punto punto : setPuntos) {
			System.out.println(punto);
		}
	}

}
