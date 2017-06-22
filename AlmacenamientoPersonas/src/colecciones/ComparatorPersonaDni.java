package colecciones;

import java.util.Comparator;

import beans.Persona;

public class ComparatorPersonaDni implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {

		if (p1.equals(p2)) {
			return 0;
		}

		int num = p1.getDni().compareTo(p2.getDni());

		if (num == 0) {
			num = p1.getApellido().compareTo(p2.getApellido());
			if (num == 0) {
				num = p1.getNombre().compareTo(p2.getNombre());
			}
		}

		return num;
	}

}
