package cursos;

import java.util.Date;
import java.util.LinkedList;

public abstract class Curso {

	/* VARIABLES */

	protected String titulo;
	protected Date fechaInicio;
	protected Date fechaFin;
	protected int dias;
	protected double precio;
	protected LinkedList<Alumno> alumnos;
	protected LinkedList<Alumno> alumnosAptos;
	protected int numeroAlumnos;

	/* CONSTRUCTORES */

	public Curso(String titulo, Date fechaInicio, Date fechaFin, int dias, double precio) {
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.dias = dias;
		this.precio = precio;

		this.alumnos = new LinkedList<Alumno>();
		this.alumnosAptos = null;
		this.numeroAlumnos = 0;
	}

	/* METODOS */

	//
	public boolean isOver() {
		Date fechaActual = new Date();
		return (fechaActual.getTime() >= this.fechaFin.getTime());
	}

	public static boolean isOver(Curso curso) {
		return curso.isOver();
	}

	//
	public abstract boolean isAlumnoApto(Alumno alumno);

	//
	public boolean matricularAlumno(Alumno alumno) {
		boolean isMatriculado = false;

		if (alumno.getCredito() > this.precio) {
			isMatriculado = true;
		}

		return isMatriculado;
	}

	//
	public boolean calificar() {
		// Aqui va el codigo de calificacion de todos los alumnos,
		// con una iteración sobre todos ellos para darles nota.
		// Al terminarlo, devolvemos TRUE, si es que ha terminado el proceso :)

		return true;
	}

	/* SET Y GET */

	public String getTitulo() {
		return this.titulo;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public int getDias() {
		return this.dias;
	}

	public double getPrecio() {
		return this.precio;
	}

	public LinkedList<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public LinkedList<Alumno> getAlumnosAptos() {
		return this.alumnosAptos;
	}

	public int getNumeroAlumnos() {
		return this.numeroAlumnos;
	}

}
