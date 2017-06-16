package colecciones.colecciones;

import java.util.ArrayList;
import java.util.List;

import colecciones.conduccion.Dni;
import colecciones.conduccion.Persona;

public class TestBuscarPersonas {

	public static void main(String[] args) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Persona persona1 = new Persona("Juan", "Lopez", new Dni("2233445566", 'A'));
		listaPersonas.add(persona1);
		Persona persona2 = new Persona("Marta", "Bilbao", new Dni("2233445577", 'B'));
		listaPersonas.add(persona2);
		Persona persona3 = new Persona("Juan", "Lopez", new Dni("2233445588", 'C'));
		listaPersonas.add(persona3);
		Persona persona4 = new Persona("Juan", "Lopez", new Dni("2233445599", 'D'));
		listaPersonas.add(persona4);

		Persona personaBuscar = new Persona("Juan", "Lopez", new Dni("2233445566", 'A'));

		Persona personaEncontrada = buscar(listaPersonas, personaBuscar);
		
		System.out.println(personaEncontrada);

	}

	public static Persona buscar(List<Persona> listaPersonas, Persona personaBuscar) {
		//
		Persona persona = null;
		boolean encontrado = false;
		for (int i = 0; (i < listaPersonas.size() && (!encontrado)); i++) {
			persona = listaPersonas.get(i);
			if (persona.equals(personaBuscar)) {
				encontrado = true;
			}
		}
		if (encontrado) {
			return persona;
		} else {
			return null;
		}

	}
/*
	public static Persona buscar(List<Persona> listaPersonas, Persona personaBuscar) {
		//
		Persona persona = null;
		for (int i = 0; i < listaPersonas.size(); i++) {
			persona = listaPersonas.get(i);
			if (persona.equals(personaBuscar)) {
				return persona;
			}
		}
		return null;
	}
*/
}
