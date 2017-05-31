package cursos;

import java.util.LinkedList;
import java.util.Date;
import java.util.HashMap;

public class CursoPresencial extends Curso {

	/* VARIABLES */

	final private int cupo;
	final private int numeroAsistencias;
	private HashMap<Integer, LinkedList<Alumno>> asistenciasAlumnos;
	private int plazasLibres;

	/* CONSTRUCTORES */

	public CursoPresencial(String titulo, Date fechaInicio, Date fechaFin, int dias, double precio, int cupo,
			int numeroAsistencias) {

		super(titulo, fechaInicio, fechaFin, dias, precio);

		this.cupo = cupo;
		this.numeroAsistencias = numeroAsistencias;
		this.asistenciasAlumnos = new HashMap<Integer, LinkedList<Alumno>>();
		this.plazasLibres = cupo;
	}

	/* METODOS */

	public boolean registrarAsistencia(int dia, Alumno alumno) {

		boolean asistenciaRegistrada = true;

		asistenciaRegistrada = (dia <= this.dias) ? asistenciaRegistrada : false;
		asistenciaRegistrada = (this.alumnos.contains(alumno)) ? asistenciaRegistrada : false;

		if (asistenciaRegistrada) {
			LinkedList<Alumno> alumnosEnDia = this.asistenciasAlumnos.get(dia);
			alumnosEnDia.add(alumno);
		}

		return asistenciaRegistrada;
	}

	public int diasDeAsistencia(Alumno alumno) {

		int dias = 0;

		if (this.alumnos.contains(alumno)) {
			for (int i = 0; i < this.asistenciasAlumnos.size(); i++) {

				LinkedList<Alumno> alumnosEnDia = this.asistenciasAlumnos.get(i);
				dias = (alumnosEnDia.contains(alumno)) ? dias + 1 : dias;
			}
		}

		return dias;
	}

	public boolean isAlumnoApto(Alumno alumno) {
		int diasAsistenciaAlumno = this.diasDeAsistencia(alumno);
		return (diasAsistenciaAlumno >= this.numeroAsistencias);
	}

	public boolean matricularAlumno(Alumno alumno) {
		boolean isMatriculado = super.matricularAlumno(alumno);

		isMatriculado = (this.plazasLibres != 0) ? isMatriculado : false;

		if (isMatriculado) {
			this.alumnos.add(alumno);
			plazasLibres--;
		}

		return isMatriculado;

	}

	/* GET Y SET */

	public int getCupo() {
		return this.cupo;
	}

	public int getNumeroAsistencias() {
		return this.numeroAsistencias;
	}

	public HashMap<Integer, LinkedList<Alumno>> getAsistenciasAlumnos() {
		return this.asistenciasAlumnos;
	}

	public int getPlazasLibres() {
		return this.plazasLibres;
	}

}
