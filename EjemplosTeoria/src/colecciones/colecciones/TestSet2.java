package colecciones.colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import colecciones.conduccion.*;

public class TestSet2 {

	public static void main(String[] args) {

		Set<Persona> personaSet = new HashSet<Persona>();

		Dni dni1 = new Dni("12345678", 'W');
		Persona persona1 = new Persona("Pepe", "Dominguez", dni1);
		// -
		Dni dni2 = new Dni("55526778", 'N');
		Persona persona2 = new Persona("Alberto", "Albertez", dni2);
		// -
		Dni dni3 = new Dni("26541397", 'K');
		Persona persona3 = new Persona("Pepín", "Pepinez", dni3);
		// -

		personaSet.add(persona1);
		personaSet.add(persona2);
		personaSet.add(persona3);
		// -

		// -
		// -
		// Caso 1. Iteramos por el set de personas. Como todas las personas que
		// hemos creado son distintas (en su creación), aparecen todas.
		// Número: 3
		TestSet2.iterarSet(personaSet);
		System.out.println("\n--  -q(`O´)p-  --\n");

		// -
		// -
		// Caso 2. Iteramos sobre el set de personas. Como persona4 apunta a
		// persona3 son claramente iguales, puesto que apuntan a la misma
		// referencia.
		// Número: 3
		Persona persona4 = persona3;
		personaSet.add(persona4);
		TestSet2.iterarSet(personaSet);
		System.out.println("\n--  -q(`O´)p-  --\n");

		// -
		// -
		// Caso 3. Añadimos una nueva persona al set de personas. Es
		// completamente distinta al resto, así que al iterar nos aparecerá.
		// Número: 4
		Dni dni5 = new Dni("53871384", 'N');
		Persona persona5 = new Persona("Adalberto", "Embriaguez", dni5);
		personaSet.add(persona5);
		TestSet2.iterarSet(personaSet);
		System.out.println("\n--  -q(`O´)p-  --\n");

		// -
		// -
		// Caso 4. Añadimos una persona con el mismo dni que la primera. El
		// único dato que utilizamos para igualar personas es el dni, y al hacer
		// referencia éste al mismo objeto, el resto de datos nos son
		// indiferentes.
		// Número: 4.
		Dni dni6 = dni1;
		Persona persona6 = new Persona("Erminginio", "Monguilez", dni6);
		personaSet.add(persona6);
		TestSet2.iterarSet(personaSet);
		System.out.println("\n--  -q(`O´)p-  --\n");

		// -
		// -
		Dni dni7 = new Dni("22558847", 'Q');
		Persona persona7 = new Persona("Pepe", "Dominguez", dni7);
		personaSet.add(persona7);
		TestSet2.iterarSet(personaSet);
		System.out.println("\n--  -q(`O´)p-  --\n");

		// -
		// -
		Dni dni8 = new Dni("55526778", 'N');
		Persona persona8 = new Persona("Alberto", "Albertez", dni8);
		personaSet.add(persona8);
		TestSet2.iterarSet(personaSet);
		System.out.println("\n--  -q(`O´)p-  --\n");

	}

	private static void iterarSet(Set<Persona> set) {

		System.out.println("LONGITUD DEL ARRAY: " + set.size() + "\n");

		Iterator<Persona> it = set.iterator();

		while (it.hasNext()) {
			Persona persona = (Persona) it.next();
			System.out.println(persona);
		}

		for (Persona persona : set) {
			System.out.println(persona);
		}
	}

}
