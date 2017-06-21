package principal;

import java.util.List;

import beans.Persona;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarLeerDatos {

	public static void main(String[] args) {

		System.out.println("EJECUNTANDO lectura de datos de personas en \"" + Configuracion.NOMBRE_FICHERO + "\"\n");

		List<Persona> listaPersonas = AlmacenamientoFicheros.obtenerPersonas(Configuracion.NOMBRE_FICHERO);

		EjecutarLeerDatos.mostrarPersonas(listaPersonas);
	}

	public static void mostrarPersonas(List<Persona> listaPersonas) {

		for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}

	}

}
