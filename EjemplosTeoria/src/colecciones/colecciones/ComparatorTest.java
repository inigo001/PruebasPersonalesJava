package colecciones.colecciones;

import java.lang.reflect.Method;
import java.util.Comparator;

import colecciones.conduccion.Persona;

public class ComparatorTest implements Comparator<Persona> {

	@Override
	public int compare(Persona persona1, Persona persona2) {

		if (persona1.equals(persona2)) {
			return 0;
		}

		int num = persona1.getDni().compareTo(persona2.getDni());

		if (num == 0) {
			num = persona1.getApellido().compareTo(persona2.getApellido());
			if (num == 0) {
				num = persona1.getNombre().compareTo(persona2.getNombre());
			}
		}

		return num;
	}

}
