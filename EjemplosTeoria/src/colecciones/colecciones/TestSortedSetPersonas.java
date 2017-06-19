package colecciones.colecciones;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import colecciones.conduccion.Dni;
import colecciones.conduccion.Persona;

public class TestSortedSetPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Persona> personas = new TreeSet<Persona>();

		Dni dni1 = new Dni("12345678", 'W');
		Persona persona1 = new Persona("Pepe", "Dom�nguez", dni1);
		// -
		Dni dni2 = new Dni("55526778", 'N');
		Persona persona2 = new Persona("Alberto", "Alb�rtez", dni2);
		// -
		Dni dni3 = new Dni("26541397", 'K');
		Persona persona3 = new Persona("Pep�n", "Pep�nez", dni3);
		// -
		Dni dni4 = new Dni("55952489", 'W');
		Persona persona4 = new Persona("Adalberto", "Embriaguez", dni4);
		// -
		Dni dni5 = new Dni("22486261", 'V');
		Persona persona5 = new Persona("Toribiano", "Ruip�rez", dni5);
		// -
		Dni dni6 = new Dni("73388489", 'K');
		Persona persona6 = new Persona("Erminginio", "Mongu�lez", dni6);
		// -
		Dni dni7 = new Dni("34219516", 'K');
		Persona persona7 = new Persona("Pepe", "P�rez", dni7);
		// -
		Dni dni8 = new Dni("12345679", 'M');
		Persona persona8 = new Persona("Erodosio", "M�nguez", dni8);
		// -
		Dni dni9 = new Dni("12345678", 'X');
		Persona persona9 = new Persona("Erodosio", "M�nguez", dni9);
		// -
		Dni dni10 = new Dni("55588871", 'P');
		Persona persona10 = new Persona("Ataulfa", "Mar�n", dni10);
		// -
		Dni dni11 = new Dni("12388952", 'P');
		Persona persona11 = new Persona("Gerifonia", "Mar�n", dni11);

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

		TestSortedSetPersonas.leerPersonas(personas);

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
