package cursos;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciamos Programa");

		Curso curso = new Curso("pepe", new Date(), new Date(), 51324, 12);

		System.out.println(Curso.isOver(curso));
		System.out.println(curso.isOver());
	}

}
