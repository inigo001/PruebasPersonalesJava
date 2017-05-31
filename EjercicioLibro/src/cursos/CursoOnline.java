package cursos;

import java.util.LinkedList;
import java.util.Date;
import java.util.HashMap;

public class CursoOnline extends Curso {

	/* VARIABLES */

	final private int nivelMaximo;
	private HashMap<Alumno, Integer> listadoAlumnosNota;
	final private LinkedList<Curso> cursosNecesarios;

	/* CONSTRUCTORES */

	public CursoOnline(String titulo, Date fechaInicio, Date fechaFin, int dias, double precio, int nivelMaximo,
			LinkedList<Curso> cursosNecesarios) {

		super(titulo, fechaInicio, fechaFin, dias, precio);

		this.nivelMaximo = nivelMaximo;
		this.listadoAlumnosNota = new HashMap<Alumno, Integer>();
		this.cursosNecesarios = cursosNecesarios;
	}

	/* METODOS */

	public int comprobarNivelAlumno(Alumno alumno) {

		Object keyResult = listadoAlumnosNota.get(alumno);
		int nivelAlumno = (keyResult != null) ? (int) keyResult : -1;
		return nivelAlumno;
	}

	public boolean superarNivel(Alumno alumno) {

		int nivelAlumno = this.comprobarNivelAlumno(alumno);
		boolean superaNivel = false;

		if (nivelAlumno != -1) {
			superaNivel = ((nivelAlumno + 1) <= this.nivelMaximo);
			nivelAlumno = (superaNivel) ? nivelAlumno++ : nivelAlumno;
		}

		return superaNivel;
	}

	public boolean isAlumnoApto(Alumno alumno) {

		int nivelAlumno = this.comprobarNivelAlumno(alumno);
		return (nivelAlumno >= (nivelMaximo * 0.5));
	}

	public boolean matricularAlumno(Alumno alumno) {
		boolean isMatriculado = super.matricularAlumno(alumno);

		for (int i = 0; i < cursosNecesarios.size(); i++) {
			if (cursosNecesarios.get(i).isAlumnoApto(alumno)) {
				isMatriculado = false;
			}
		}

		if (isMatriculado) {
			this.alumnos.add(alumno);
		}

		return isMatriculado;
	}

	/* GET Y SET */

	public int getNivel() {
		return this.nivelMaximo;
	}

	public HashMap<Alumno, Integer> getListadoAlumnosNota() {
		return this.listadoAlumnosNota;
	}

	public LinkedList<Curso> getCursosNecesarios() {
		return this.cursosNecesarios;
	}

	/* PROPIAS */

	public CursoOnline clone() {
		Date fechaInicio = (Date) this.fechaInicio.clone();
		Date fechaFin = (Date) this.fechaFin.clone();
		LinkedList<Curso> cursosNecesarios = new LinkedList<Curso>(this.cursosNecesarios);

		CursoOnline nuevoCursoOnline = new CursoOnline(this.titulo, fechaInicio, fechaFin, this.dias, this.precio, this.nivelMaximo,
				cursosNecesarios);

		return nuevoCursoOnline;
	}

}
