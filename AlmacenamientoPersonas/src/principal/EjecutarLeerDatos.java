package principal;

import java.util.List;

import beans.Persona;
import config.Configuracion;
import entradasalida.AlmacenamientoFicheros;

public class EjecutarLeerDatos {

	public static void main(String[] args) {

		List<Persona> listaPersonas = AlmacenamientoFicheros.obtenerPersonas(Configuracion.NOMBRE_FICHERO);

		EjecutarLeerDatos.mostrarPersonas(listaPersonas);

	}

	public static void mostrarPersonas(List<Persona> listaPersonas) {

		for (Persona persona : listaPersonas) {
			System.out.println(persona + "  456f ad456f asd789");
		}

	}

}
