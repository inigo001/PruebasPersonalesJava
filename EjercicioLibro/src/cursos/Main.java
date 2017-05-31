package cursos;

import java.util.Date;
import java.util.LinkedList;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciamos Programa");

		Calendar calendario = Calendar.getInstance();

		Alumno pepe = new Alumno("Pepe", "34678904X");
		Alumno andrea = new Alumno("Andrea", "17679456X", 125);

		//
		calendario.set(2014, 4, 5);
		Date fechaCurso1 = calendario.getTime();

		CursoPresencial curso1 = new CursoPresencial("Diseño de Bases de Datos", fechaCurso1, fechaCurso1, 1, 50, 20,
				1);

		curso1.matricularAlumno(pepe);
		curso1.matricularAlumno(andrea);

		System.out.println("Alumnos matriculados en Curso 1:" + curso1.getAlumnos());

		curso1.registrarAsistencia(0, pepe);

		curso1.calificar();

		System.out.println("Alumnos Aptos Curso 1: " + curso1.getAlumnosAptos());

		//

		calendario.set(2014, 4, 12);
		Date fechaInicioCurso2 = calendario.getTime();
		calendario.set(2014, 4, 16);
		Date fechaFinCurso2 = calendario.getTime();

		LinkedList<Curso> cursosObligatorios = new LinkedList<Curso>();
		cursosObligatorios.add(curso1);

		CursoOnline curso2 = new CursoOnline("Administración de Bases de Datos", fechaInicioCurso2, fechaFinCurso2, 5,
				25, 4, cursosObligatorios);

		curso2.matricularAlumno(pepe);
		curso2.matricularAlumno(andrea);

		System.out.println("Alumnos matriculados en Curso 2:" + curso2.getAlumnos());

		curso2.superarNivel(pepe);
		curso2.calificar();

		System.out.println("Alumnos Aptos Curso 2: " + curso2.getAlumnosAptos());
		
		
		//
		System.out.println(curso1.listaAlumnosOrdenada());
		

	}

}
