package colecciones.colecciones;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import colecciones.conduccion.Dni;
import colecciones.conduccion.Persona;

public class TestSortedSet2 {

	public static void main(String[] args) {
		//
		System.out.println("COMPARACIÓN POR CÓDIGOS");
		Persona persona1 = new Persona(1, "Juan", "Lopez", new Dni("2233445566", 'A'));
		Persona persona2 = new Persona(2, "Olatz", "Bilbao", new Dni("2233445577", 'B'));
		Persona persona3 = new Persona(3, "Marta", "Igartua", new Dni("2233445588", 'C'));
		Persona persona4 = new Persona(4, "Xabi", "Martínez", new Dni("2233445599", 'D'));
		SortedSet<Persona> sortedSetPersonasComparadasPorCodigo = new TreeSet<Persona>();
		sortedSetPersonasComparadasPorCodigo.add(persona1);
		sortedSetPersonasComparadasPorCodigo.add(persona2);
		sortedSetPersonasComparadasPorCodigo.add(persona3);
		sortedSetPersonasComparadasPorCodigo.add(persona4);
		recorrer(sortedSetPersonasComparadasPorCodigo);
		//
		System.out.println("COMPARACIÓN ALFABÉTICA");
		ComparadorPersonasPorOrdenAlfabetico comparadorPersonasPorOrdenAlfabetico = new ComparadorPersonasPorOrdenAlfabetico();
		SortedSet<Persona> sortedSetPersonasComparadasPorOrdenAlfabetico = new TreeSet<Persona>(
				comparadorPersonasPorOrdenAlfabetico);
		sortedSetPersonasComparadasPorOrdenAlfabetico.add(persona1);
		sortedSetPersonasComparadasPorOrdenAlfabetico.add(persona2);
		sortedSetPersonasComparadasPorOrdenAlfabetico.add(persona3);
		sortedSetPersonasComparadasPorOrdenAlfabetico.add(persona4);
		recorrer(sortedSetPersonasComparadasPorOrdenAlfabetico);
	}

	public static void recorrer(SortedSet<Persona> sortedSetPersonas) {
		//
		Iterator<Persona> iterator = sortedSetPersonas.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
