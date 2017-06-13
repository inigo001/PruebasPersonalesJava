package coleccionescolecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import colecciones.conduccion.Dni;
import colecciones.conduccion.Persona;

public class TestMap {

	public static void main(String[] args) {
		Map<Integer, Persona> mapPersonas = new HashMap<Integer, Persona>();
		Persona persona1 = new Persona(1, "Juan", "Lopez", new Dni("2233445566", 'A'));
		mapPersonas.put(1, persona1);
		Persona persona2 = new Persona(2, "Marta", "Bilbao", new Dni("2233445577", 'B'));
		mapPersonas.put(2, persona2);
		Persona persona3 = new Persona(3, "Oscar", "Igartua", new Dni("2233445588", 'C'));
		mapPersonas.put(3, persona3);
		Persona persona4 = new Persona(4, "Aritz", "Arretxe", new Dni("2233445599", 'D'));
		mapPersonas.put(4, persona4);

		Integer codPersonaBuscar = 3;

		Persona personaEncontrada = mapPersonas.get(codPersonaBuscar);

		System.out.println(personaEncontrada);

		Map<ClavePrimaria, Persona> mapPersonas2 = new HashMap<ClavePrimaria, Persona>();
		mapPersonas2.put(new ClavePrimaria("1", "2"), persona1);
		mapPersonas2.put(new ClavePrimaria("3", "4"), persona2);
		mapPersonas2.put(new ClavePrimaria("5", "6"), persona3);
		mapPersonas2.put(new ClavePrimaria("7", "8"), persona4);

		ClavePrimaria clavePrimariaPersonaBuscar = new ClavePrimaria("1", "2");

		Persona personaEncontrada2 = mapPersonas2.get(clavePrimariaPersonaBuscar);

		System.out.println(personaEncontrada2);

	}
}
