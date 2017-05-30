package cursos;

import java.util.LinkedList;

public class Alumno {

	/* VARIABLES */

	private String nombre;
	private String dni;
	private double credito;
	private LinkedList<Curso> cursos;

	/* CONSTRUCTORES */

	public Alumno(String nombre, String dni, double credito) {
		this.nombre = nombre;
		this.dni = dni;
		this.credito = credito;
		this.cursos = new LinkedList<Curso>();
	}

	public Alumno(String nombre, String dni) {
		this(nombre, dni, 0);
	}

	/* FUNCIONES PUBLICAS */

	public void incrementarCredito(double credito) {
		this.credito = this.credito + credito;
	}

	public void decrementarCredito(double credito) {
		this.credito = this.credito - credito;
	}

	public void anadirCurso(Curso curso) {
		this.cursos.add(curso);
	}

	/* SET Y GET */

	public String getNombre() {
		return this.nombre;
	}

	public String getDni() {
		return this.dni;
	}

	public double getCredito() {
		return this.credito;
	}

	public LinkedList<Curso> getCursos() {
		return this.cursos;
	}

}
