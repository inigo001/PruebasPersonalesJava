package entradasalida;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import beans.Dni;
import beans.Persona;

public class AlmacenamientoFicheros {

	public static void guardarPersonas(String nombreFichero, Collection<Persona> coleccionPersonas) {

		System.out.println("Iniciando escritura de datos...");
		System.out.println("Número de datos a guardar: " + coleccionPersonas.size() + "\n");

		try {

			String txtEscribir = "";

			Iterator<Persona> it = coleccionPersonas.iterator();

			Persona persona;
			while (it.hasNext()) {
				persona = it.next();
				txtEscribir += persona.toString() + ((it.hasNext()) ? "\n" : "");
			}

			System.out.println("String Creado");

			PrintWriter writer = new PrintWriter(nombreFichero, "UTF-8");
			writer.println(txtEscribir);
			writer.close();

			System.out.println("Datos Guardados correctamente en " + "\"" + nombreFichero + "\"");

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("No se ha podido escribir el fichero, inténtalo de otra manera");

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
				if (contenido.length != 3)
					throw new Exception("Error en el formato del fichero");

				contenidoDni = contenido[2].split("-");
				if (contenidoDni.length != 2)
					throw new Exception("Error en el formato del fichero");

				dni = new Dni(contenidoDni[0], contenidoDni[1].charAt(0));
				persona = new Persona(contenido[0], contenido[1], dni);

				listaPersonas.add(persona);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaPersonas;
	}
}
