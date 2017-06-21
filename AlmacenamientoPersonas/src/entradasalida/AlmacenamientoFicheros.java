package entradasalida;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.Dni;
import beans.Persona;

public class AlmacenamientoFicheros {

	public static void guardarPersonas(String nombreFichero, List<Persona> listaPersonas) {

		String txtEscribir = "";

		Iterator<Persona> it = listaPersonas.iterator();

		Persona persona;
		while (it.hasNext()) {
			persona = it.next();
			txtEscribir += persona.toString() + ((it.hasNext()) ? "\n" : "");
		}

		try {
			PrintWriter writer = new PrintWriter(nombreFichero, "UTF-8");
			writer.println(txtEscribir);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static List<Persona> obtenerPersonas(String nombreFichero) {

		List<Persona> listaPersonas = new ArrayList<Persona>();

		try {
			Path path = Paths.get(nombreFichero);
			List<String> listText = Files.readAllLines(path);

			Persona persona;
			Dni dni;
			String[] contenido;
			String[] contenidoDni;
			for (String texto : listText) {

				contenido = texto.split("\\s");
				contenidoDni = contenido[2].split("-");

				dni = new Dni(contenidoDni[0], contenidoDni[1].charAt(0));
				persona = new Persona(contenido[0], contenido[1], dni);

				listaPersonas.add(persona);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaPersonas;

	}

}
