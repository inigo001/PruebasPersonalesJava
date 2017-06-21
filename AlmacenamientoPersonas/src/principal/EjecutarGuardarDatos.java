package principal;

import java.util.List;

import beans.Persona;
import colecciones.CrearColeccion;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarGuardarDatos {

	public static void main(String[] args) {

		System.out.println("EJECUNTANDO guardado de " + Configuracion.NUMERO_PERSONAS + " personas en \""
				+ Configuracion.NOMBRE_FICHERO + "\"\n");

		List<Persona> listaPersonas = CrearColeccion.listaPersonas(Configuracion.NUMERO_PERSONAS);

		AlmacenamientoFicheros.guardarPersonas(Configuracion.NOMBRE_FICHERO, listaPersonas);
	}

}
