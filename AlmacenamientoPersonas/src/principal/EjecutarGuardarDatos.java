package principal;

import java.util.List;

import beans.Persona;
import colecciones.CrearColeccion;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarGuardarDatos {

	public static void main(String[] args) {

		List<Persona> listaPersonas = CrearColeccion.listaPersonas(30);

		AlmacenamientoFicheros.guardarPersonas(Configuracion.NOMBRE_FICHERO, listaPersonas);
	}

}
