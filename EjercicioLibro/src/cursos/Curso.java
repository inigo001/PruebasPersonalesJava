package cursos;

import java.util.Date;
import java.util.LinkedList;

/**
 * Clase abstracta Curso. Contiene los datos principales de un curso como su
 * título, la fecha de inicio, etc... Contiene Alumnos La funcionalidad
 * principal se encuentra en las clases hijas
 * 
 * @author inigo001
 * @version 0.1
 * @see Alumno
 * @see CursoOnline
 * @see CursoPresencial
 */
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
		this.fechaInicio = (Date) fechaInicio.clone();
		this.fechaFin = (Date) fechaFin.clone();
		this.dias = dias;
		this.precio = precio;

		this.alumnos = new LinkedList<Alumno>();
		this.alumnosAptos = new LinkedList<Alumno>();
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
	public boolean matricularAlumno(Alumno alumno) {
		boolean isMatriculado = false;

		if (alumno.getCredito() > this.precio) {
			isMatriculado = true;
		}

		return isMatriculado;
	}

	//
	public boolean calificar() {

		for (int i = 0; i < this.alumnos.size(); i++) {
			Alumno alumno = this.alumnos.get(i);

			if (this.isAlumnoApto(alumno)) {
				this.alumnosAptos.add(alumno);
			}
		}
		return true;
	}

	//
	public abstract boolean isAlumnoApto(Alumno alumno);

	// * \\

	public LinkedList<Alumno> listaAlumnosOrdenada() {
		LinkedList<Alumno> listaAlumnos = new LinkedList<Alumno>(this.alumnos);
		listaAlumnos.sort(new ComparadorAlumnos());
		return listaAlumnos;
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
		return (this.alumnosAptos.size() > 0) ? this.alumnosAptos : null;
	}

	public int getNumeroAlumnos() {
		return this.numeroAlumnos;
	}

	/* PROPIOS */

	public String toString() {
		return this.titulo;
	}

}
