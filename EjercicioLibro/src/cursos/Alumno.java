package cursos;

import java.util.LinkedList;

/**
 * Clase Alumno. El alumno tiene un nombre, un DNI (con letra) y un saldo de
 * dinero. El alumno puede ser incluído en cursos y realizarlos, dependiendo de
 * su saldo.
 * 
 * @author inigo001
 * @version 0.1
 * @see Curso
 *
 */
public class Alumno {

	/* VARIABLES */

	/**
	 * Nombre del alumno
	 */
	private String nombre;
	/**
	 * DNI del alumno. Es un DNI en texto con una letra al final. No es
	 * obligatorio anadirlo correctamente pero es recomendable hacerlo.
	 */
	private String dni;
	/**
	 * El dinero del que dispone el alumno
	 */
	private double credito;
	/**
	 * Listado que referencia los cursos en los que está apuntado el alumno.
	 * Puede estar calificado o no, siempre se mantendrá en los cursos.
	 */
	private LinkedList<Curso> cursos;

	/* CONSTRUCTORES */

	/**
	 * @param nombre
	 *            Nombre del alumno
	 * @param dni
	 *            Dni del alumno, con letra al final. Es un String.
	 * @param credito
	 *            Dinero del que dispone el alumno. En caso de no añadir esta
	 *            variable el alumno comenzará con 100 euros de saldo.
	 */
	public Alumno(String nombre, String dni, double credito) {
		this.nombre = nombre;
		this.dni = dni;
		this.credito = credito;
		this.cursos = new LinkedList<Curso>();
	}

	public Alumno(String nombre, String dni) {
		this(nombre, dni, 100);
	}

	/* FUNCIONES PUBLICAS */

	/**
	 * Aumenta el dinero que posee el alumno.
	 * 
	 * @param credito
	 *            Credito para aumentar la cantidad de dinero que tiene el
	 *            alumno. En caso de introducir un crédito negativo el alumno
	 *            mantendrá su crédito actual.
	 */
	public void incrementarCredito(double credito) {
		this.credito = (credito > 0) ? this.credito + credito : this.credito;
	}

	/**
	 * Reduce el dinero que posee el alumno
	 * 
	 * @param credito
	 *            Credito para disminuir la cantidad de dinero que tiene el
	 *            alumno. En caso de introducir un crédito negativo el alumno
	 *            mantendrá su crédito actual.
	 */
	public void decrementarCredito(double credito) {
		this.credito = (credito > 0) ? this.credito - credito : this.credito;
	}

	/**
	 * Añade un curso al listado de cursos del alumno
	 * 
	 * @param curso
	 *            Curso al que el alumno se apunta. En caso de estar ya
	 *            apuntado, no volverá a apuntarse.
	 */
	public void anadirCurso(Curso curso) {
		if (!this.cursos.contains(curso)) {
			this.cursos.add(curso);
		}
	}

	/* SET Y GET */

	/**
	 * @return Nombre del alumno
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @return Dni del alumno
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * @return Dni numerico del alumno, a modo de entero. No contiene letras.
	 */
	public int getNumericDni() {
		return Integer.parseInt(this.dni.substring(0, this.dni.length() - 1));
	}

	/**
	 * @return Credito que posee el alumno en este momento.
	 */
	public double getCredito() {
		return this.credito;
	}

	/**
	 * @return Listado de cursos que posee el alumno.
	 */
	public LinkedList<Curso> getCursos() {
		return this.cursos;
	}

	/* PROPIAS */

	public String toString() {
		return this.nombre + " // DNI: " + this.dni + " CRÉDITO: " + this.credito + " CURSOS: " + this.cursos;
	}

}
