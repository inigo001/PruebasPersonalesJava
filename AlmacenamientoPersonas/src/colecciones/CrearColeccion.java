package colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import beans.Dni;
import beans.Persona;

public class CrearColeccion {

	private static String[] nombres = new String[] { "Pepe", "Domingo", "Alberta", "Gerifonia", "Estudinia",
			"Adalberto", "Enriqueta", "Mikel", "I�igo", "Juan", "Chindasbinto", "Recesbinto", "Te�dulo", "Orestes",
			"Hugo", "Juan", "Jes�s", "Anacleto", "Perfinia", "Incontinencia", "Felicitaci�n", "Mar�a", "Gerundina",
			"Participia", "Onofre", "P�rfida", "Santa", "Herminia", "Erundino", "Romualda", "Rigoberta", "Eustaquia",
			"Ponciana", "Sancho", "Zigor", "Tel�sforo", "Siseguto", "Segismunda" };

	private static String[] apellidos = new String[] { "Perez", "Dominguez", "Albertez", "M�nguez", "Mar�n", "Mondeled",
			"M�nguez", "Bilbao", "Donostio", "L�pez", "Yuste", "Pepez", "Adalez", "Chumbo", "Pedril", "Becerro",
			"Astimburio", "Goiribeitialarri", "Zaldigoitia", "Scott", "Johns", "Idiotez", "Ruip�rez", "Pep�nez",
			"Embriaguez", "Taribinio", "�sculo", "�tropo", "Ram�rez", "Altunabeitia", "Panez", "Alto", "Sanchez",
			"Lobo", "B�ho" };

	public static List<Persona> listaPersonas() {

		List<Persona> listaPersonas = new ArrayList<Persona>();

		// -
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
		Persona persona8 = new Persona("Ambrosio", "Tarabinio", dni8);
		// -
		Dni dni9 = new Dni("12345678", 'X');
		Persona persona9 = new Persona("Erodosio", "M�nguez", dni9);
		// -
		Dni dni10 = new Dni("55588871", 'P');
		Persona persona10 = new Persona("Ataulfa", "Mar�n", dni10);
		// -
		Dni dni11 = new Dni("12388952", 'P');
		Persona persona11 = new Persona("Gerifonia", "�scula", dni11);

		listaPersonas.add(persona1);
		listaPersonas.add(persona2);
		listaPersonas.add(persona3);
		listaPersonas.add(persona4);
		listaPersonas.add(persona5);
		listaPersonas.add(persona6);
		listaPersonas.add(persona7);
		listaPersonas.add(persona8);
		listaPersonas.add(persona9);
		listaPersonas.add(persona10);
		listaPersonas.add(persona11);

		return listaPersonas;

	}

	public static List<Persona> listaPersonas(int cantidad) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		CrearColeccion.buildCollection(listaPersonas, cantidad);
		return listaPersonas;
	}

	public static Set<Persona> setPersonas(int cantidad) {
		Set<Persona> setPersonas = new TreeSet<Persona>();
		CrearColeccion.buildCollection(setPersonas, cantidad);
		return setPersonas;
	}

	private static void buildCollection(Collection<Persona> coleccionPersonas, int cantidad) {

		Dni dni;
		Persona persona;
		int random;
		String nombre;
		String apellido;
		for (int i = 0; i < cantidad; i++) {

			random = ThreadLocalRandom.current().nextInt(0, CrearColeccion.nombres.length);
			nombre = CrearColeccion.nombres[random];
			random = ThreadLocalRandom.current().nextInt(0, CrearColeccion.apellidos.length);
			apellido = CrearColeccion.apellidos[random];
			random = ThreadLocalRandom.current().nextInt(10000000, 100000000);

			dni = new Dni(random);
			persona = new Persona(nombre, apellido, dni);

			coleccionPersonas.add(persona);
		}

	}

}
