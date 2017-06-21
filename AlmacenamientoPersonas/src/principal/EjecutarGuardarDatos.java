package principal;

import java.util.Collection;

import beans.Persona;
import colecciones.CrearColeccion;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarGuardarDatos {

	public static void main(String[] args) {

		System.out.println("EJECUNTANDO guardado de " + Configuracion.NUMERO_PERSONAS + " personas en \""
				+ Configuracion.NOMBRE_FICHERO + "\"\n");

		Collection<Persona> listaPersonas = CrearColeccion.setPersonas(Configuracion.NUMERO_PERSONAS);

		AlmacenamientoFicheros.guardarPersonas(Configuracion.NOMBRE_FICHERO, listaPersonas);
	}

}
