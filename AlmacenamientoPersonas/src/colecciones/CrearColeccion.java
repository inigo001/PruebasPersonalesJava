package colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import beans.Dni;
import beans.Persona;

public class CrearColeccion {

	/**
	 * Listado de nombres para crear combinaciones
	 */
	private static String[] nombres = new String[] { "Pepe", "Domingo", "Alberta", "Gerifonia", "Estudinia",
			"Adalberto", "Enriqueta", "Mikel", "I�igo", "Juan", "Chindasbinto", "Recesbinto", "Te�dulo", "Orestes",
			"Hugo", "Juan", "Jes�s", "Anacleto", "Perfinia", "Incontinencia", "Felicitaci�n", "Mar�a", "Gerundina",
			"Participia", "Onofre", "P�rfida", "Santa", "Herminia", "Erundino", "Romualda", "Rigoberta", "Eustaquia",
			"Ponciana", "Sancho", "Zigor", "Tel�sforo", "Siseguto", "Segismunda", "Ruperta", "Astonfasia", "Antonia",
			"Vicente", "Antonomasia", "Cr�dula", "Euro", "Ahmed", "Mahmud", "Petra", "Telec�ndido" };

	/**
	 * Listado de apellidos para crear combinaciones
	 */
	private static String[] apellidos = new String[] { "Perez", "Dominguez", "Albertez", "M�nguez", "Mar�n", "Mondeled",
			"M�nguez", "Bilbao", "Donostio", "L�pez", "Yuste", "Pepez", "Adalez", "Chumbo", "Pedril", "Becerro",
			"Astimburio", "Goiribeitialarri", "Zaldigoitia", "Scott", "Johns", "Idiotez", "Ruip�rez", "Pep�nez",
			"Embriaguez", "Taribinio", "�sculo", "�tropo", "Ram�rez", "Altunabeitia", "Panez", "Alto", "Sanchez",
			"Lobo", "B�ho", "Perro", "Abeja", "R�o", "Lupertino", "Girib�n", "Chumbez", "Damb�n", "Limpio", "Ingl�s",
			"Aguirre", "M�ndez", "Hoyos", "Ortega", "Tont�n" };

	//
	/**
	 * Crea una lista de 12 personas
	 * 
	 * @return
	 */
	public static List<Persona> listaPersonas() {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		CrearColeccion.buildCollection(listaPersonas, 12);
		return listaPersonas;
	}

	/**
	 * Crea una lista de personas con la cantidad seleccionada. Por favor, que
	 * sean n�meros positivos.
	 * 
	 * @param cantidad
	 * @return
	 */
	public static List<Persona> listaPersonas(int cantidad) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		CrearColeccion.buildCollection(listaPersonas, cantidad);
		return listaPersonas;
	}

	//
	public static Set<Persona> setPersonas() {
		Set<Persona> setPersonas = new HashSet<Persona>();
		CrearColeccion.buildCollection(setPersonas, 12);
		return setPersonas;
	}

	public static Set<Persona> setPersonas(int cantidad) {
		Set<Persona> setPersonas = new HashSet<Persona>();
		CrearColeccion.buildCollection(setPersonas, cantidad);
		return setPersonas;
	}

	public static SortedSet<Persona> setOrdenadoPersonas(int cantidad) {
		SortedSet<Persona> setPersonas = new TreeSet<Persona>();
		CrearColeccion.buildCollection(setPersonas, cantidad);
		return setPersonas;
	}

	public static SortedSet<Persona> setOrdenadoPersonas(int cantidad, Comparator<Persona> comparador) {
		SortedSet<Persona> setPersonas = new TreeSet<Persona>(comparador);
		CrearColeccion.buildCollection(setPersonas, cantidad);
		return setPersonas;
	}

	//
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
