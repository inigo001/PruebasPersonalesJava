package colecciones;

import java.text.Collator; // Usamos el Collator para que las comparaciones se hagan respetando las tíldes
import java.util.Comparator;

import beans.Persona;

public class ComparatorPersonaDni implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {

		if (p1.equals(p2)) {
			return 0;
		}

		Collator col = Collator.getInstance();

		int num = p1.getDni().compareTo(p2.getDni());

		if (num == 0) {
			num = col.compare(p1.getApellido(), p2.getApellido());
			if (num == 0) {
				num = col.compare(p1.getNombre(), p2.getNombre());
			}
		}

		return num;
	}

}
