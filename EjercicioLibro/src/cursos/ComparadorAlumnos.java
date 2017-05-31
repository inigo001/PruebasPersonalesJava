package cursos;

import java.util.Comparator;

public class ComparadorAlumnos implements Comparator<Alumno> {

	public int compare(Alumno alum1, Alumno alum2) {
		int alum1Dni = alum1.getNumericDni();
		int alum2Dni = alum2.getNumericDni();
		if (alum1Dni > alum2Dni) {
			return 1;
		} else if (alum1Dni < alum2Dni) {
			return -1;
		} else {
			return 0;
		}
	}

}
