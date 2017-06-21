package principal;

import java.util.Collection;

import beans.Persona;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarLeerDatos {

	public static void main(String[] args) {

		System.out.println("EJECUNTANDO lectura de datos de personas en \"" + Configuracion.NOMBRE_FICHERO + "\"\n");

		Collection<Persona> listaPersonas = AlmacenamientoFicheros.obtenerPersonas(Configuracion.NOMBRE_FICHERO);

		EjecutarLeerDatos.mostrarPersonas(listaPersonas);
	}

	public static void mostrarPersonas(Collection<Persona> listaPersonas) {

		for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}

	}

}
