package colecciones.conduccion;

import java.util.ArrayList;
import java.util.List;

public class EjecMain {

	public static void main(String[] args) {

		List<Persona> listadoDePersonas = EjecMain.cargarListaPersonas();

		System.out.println(" -- ");

		EjecMain.recorrerPersonas(listadoDePersonas);

	}

	public static List<Persona> cargarListaPersonas() {
		List<Persona> personas = new ArrayList<Persona>();

		// Persona 1
		Dni dniPersona1 = new Dni("12345678", 'Z');
		Persona persona1 = new Persona("Pepe", "Perez", dniPersona1);

		System.out.println("Persona1: " + persona1);

		// Persona 2
		Dni dniPersona2 = new Dni("789645616", 'V');
		Persona persona2 = new Persona("Adolfo", "Adolfez", dniPersona2);

		System.out.println("Persona2: " + persona2);

		// Persona 3
		Dni dniPersona3 = new Dni("97165616", 'V');
		Persona persona3 = new Persona("Benito", "Benitez", dniPersona3);

		System.out.println("Persona3: " + persona3);

		// Persona 4
		Dni dniPersona4 = new Dni("48951689", 'P');
		Persona persona4 = new Persona("Herminia", "Belabieta", dniPersona4);

		System.out.println("Persona4: " + persona4);

		// Añadimos personas
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		personas.add(persona4);

		System.out.println("Size de personas: " + personas.size());

		// Devolvemos array de personas
		return personas;
	}

	public static void recorrerPersonas(List<Persona> personas) {

		// Es preferible crear una variable temporal fuera del iterador en vez
		// de dentro de éste, puesto que resulta más eficiente.
		Persona persona = null;

		for (int i = 0; i < personas.size(); i++) {
			persona = personas.get(i);
			System.out.println("Persona número " + i + ": " + persona);
		}

	}

}
