package principal;

import java.util.Collection;

import beans.Persona;
import colecciones.ComparatorPersonaNombre;
import colecciones.CrearColeccion;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarGuardarDatos {

	public static void main(String[] args) {

		if (Configuracion.NUMERO_PERSONAS > 0) {
			System.out.println("EJECUNTANDO guardado de " + Configuracion.NUMERO_PERSONAS + " personas en \""
					+ Configuracion.NOMBRE_FICHERO + "\"\n");

			Collection<Persona> listaPersonas = CrearColeccion.setOrdenadoPersonas(Configuracion.NUMERO_PERSONAS,
					new ComparatorPersonaNombre());

			AlmacenamientoFicheros.guardarPersonas(Configuracion.NOMBRE_FICHERO, listaPersonas);
		} else {
			System.out.println(
					"¿Eres tan idiota como para querer crear una lista sin valores? Por favor, vuelve a intentarlo y ten un poco más de cabeza.");
		}

	}

}
