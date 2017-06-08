package empresa;

/**
 * Clase abstracta empleado
 * 
 * @author inigo001
 *
 */
public abstract class Empleado extends Persona {

	/**
	 * Guarda el número de empleados en la empresa. Aumenta cada vez que se
	 * instancia un nuevo empleado. También sirve para marcar el código de
	 * empleado.
	 */
	private static int numEmpleados = 0;

	/**
	 * Al crear un Empleado se le añade a este el contenido actual de
	 * numEmpleados.
	 */
	private int codEmpleado;
	private double sueldo;

	/* CONSTRUCTORES */

	public Empleado(String nombre, String apellido, int edad, Dni dni, double sueldo) {
		super(nombre, apellido, edad, dni);
		this.sueldo = sueldo;

		this.anadirCodigoEmpleado();
	}

	public Empleado() {
		super();
		this.sueldo = 0;

		this.anadirCodigoEmpleado();
	}

	/**
	 * Añade el código de empleado a al empleado y aumenta el número de
	 * empleados en 1
	 */
	private void anadirCodigoEmpleado() {
		Empleado.numEmpleados++;
		this.codEmpleado = Empleado.numEmpleados;
	}

	/* METODOS */

	/**
	 * Método abstracto. Cada implementación lo pondrá como le dé la gana.
	 */
	public abstract void trabajar();

	/* GET Y SET */

	/**
	 * Devuelve el sueldo del empleado
	 * 
	 * @return Double con el sueldo del empleado.
	 */
	public double obtenerSueldo() {
		return this.sueldo;
	}

	public int getCodEmpleado() {
		return this.codEmpleado;
	}

	/* PROPIOS */

	public String toString() {
		return "Código: " + this.codEmpleado + " Nombre: " + super.toString() + " Sueldo: " + this.obtenerSueldo();
	}

}
