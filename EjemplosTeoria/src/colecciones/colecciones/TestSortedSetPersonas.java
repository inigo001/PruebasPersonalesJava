package colecciones.colecciones;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import colecciones.conduccion.Dni;
import colecciones.conduccion.Persona;

public class TestSortedSetPersonas {

	public static void main(String[] args) {

		// -
		Dni dni1 = new Dni("12345678", 'W');
		Persona persona1 = new Persona("Pepe", "Domínguez", dni1);
		// -
		Dni dni2 = new Dni("55526778", 'N');
		Persona persona2 = new Persona("Alberto", "Albértez", dni2);
		// -
		Dni dni3 = new Dni("26541397", 'K');
		Persona persona3 = new Persona("Pepín", "Pepínez", dni3);
		// -
		Dni dni4 = new Dni("55952489", 'W');
		Persona persona4 = new Persona("Adalberto", "Embriaguez", dni4);
		// -
		Dni dni5 = new Dni("22486261", 'V');
		Persona persona5 = new Persona("Toribiano", "Ruipérez", dni5);
		// -
		Dni dni6 = new Dni("73388489", 'K');
		Persona persona6 = new Persona("Erminginio", "Monguílez", dni6);
		// -
		Dni dni7 = new Dni("34219516", 'K');
		Persona persona7 = new Persona("Pepe", "Pérez", dni7);
		// -
		Dni dni8 = new Dni("12345679", 'M');
		Persona persona8 = new Persona("Erodosio", "Mínguez", dni8);
		// -
		Dni dni9 = new Dni("12345678", 'X');
		Persona persona9 = new Persona("Erodosio", "Mínguez", dni9);
		// -
		Dni dni10 = new Dni("55588871", 'P');
		Persona persona10 = new Persona("Ataulfa", "Marín", dni10);
		// -
		Dni dni11 = new Dni("12388952", 'P');
		Persona persona11 = new Persona("Gerifonia", "Marín", dni11);

		// -
		Set<Persona> personas = new TreeSet<Persona>();

		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		personas.add(persona4);
		personas.add(persona5);
		personas.add(persona6);
		personas.add(persona7);
		personas.add(persona8);
		personas.add(persona9);
		personas.add(persona10);
		personas.add(persona11);

		// -
		Comparator<Persona> compaPersonas = new ComparatorTest();
		Set<Persona> personillas = new TreeSet<Persona>(compaPersonas);

		personillas.add(persona1);
		personillas.add(persona2);
		personillas.add(persona3);
		personillas.add(persona4);
		personillas.add(persona5);
		personillas.add(persona6);
		personillas.add(persona7);
		personillas.add(persona8);
		personillas.add(persona9);
		personillas.add(persona10);
		personillas.add(persona11);

		// -
		TestSortedSetPersonas.leerPersonas(personas);
		System.out.println("-- :_:_: --");
		TestSortedSetPersonas.leerPersonas(personillas);

	}

	private static void leerPersonas(Set<Persona> personas) {

		Iterator<Persona> it = personas.iterator();

		Persona persona = null;
		while (it.hasNext()) {
			persona = it.next();
			System.out.println(persona);
		}

	}

}
