package colecciones.colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import colecciones.geometria.Punto;

@SuppressWarnings("all")
public class TestList {

	public static void main(String[] args) {

		// MANERA MUY OBSOLETA

		// Un vector es un como un array dinámico
		Vector vectorPuntos = new Vector();
		// Para que no dé error deberíamos escribir el tipo de vector
		// Vector<Punto> vectorPuntos = new Vector();

		// Para añadir elementos a un vector se hace con el mando add
		Punto punto1 = new Punto(1, 2);
		vectorPuntos.add(punto1);
		Punto punto2 = new Punto(3, 4);
		vectorPuntos.add(punto2);
		Punto punto3 = new Punto(5, 6);
		vectorPuntos.add(punto3);

		Punto punto = null;

		// vector.length = vector.size() - LONGITUD
		// vector[i] = vector.get(i); - RECUPERAR ELEMENTO
		// vector.add(elemento) - AÑADIR ELEMENTO

		System.out.println("VECTOR");
		for (int i = 0; i < vectorPuntos.size(); i++) {
			punto = (Punto) vectorPuntos.get(i);
			System.out.println(punto);
		}

		// MANERA OBSOLETA
		List listaPuntos = new ArrayList();
		listaPuntos.add(punto1);
		listaPuntos.add(punto2);
		listaPuntos.add(punto3);
		punto = null;
		for (int i = 0; i < listaPuntos.size(); i++) {
			punto = (Punto) listaPuntos.get(i);
			System.out.println(punto);
		}

		// MANERA BUENA
		List<Punto> listaPuntosGenericos = new ArrayList<Punto>();
		listaPuntosGenericos.add(punto1);
		listaPuntosGenericos.add(punto2);
		listaPuntosGenericos.add(punto3);
		//
		for (int i = 0; i < listaPuntosGenericos.size(); i++) {
			punto = listaPuntosGenericos.get(i);
			System.out.println(punto);
		}
		for (Punto puntoAux : listaPuntosGenericos) {
			System.out.println(puntoAux);
		}
	}

}
