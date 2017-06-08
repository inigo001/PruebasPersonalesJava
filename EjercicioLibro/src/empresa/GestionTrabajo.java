package empresa;

/**
 * Clase de utilidad con herramientas para controlar a los empleados.
 * 
 * @author inigo001
 *
 */
public class GestionTrabajo {

	/**
	 * Constructor privado para que la clase no se pueda inicializar, al ser una
	 * clase de utilidad.
	 */
	private GestionTrabajo() {
	}

	/**
	 * Tratamos un empleado para que según que tipo de instancia sea haga una
	 * cosa u otra.
	 * 
	 * @param empleado
	 *            Clase abstracta empleado que puede tener dentro instancias de
	 *            sus distintas clases hijas.
	 */
	public static void tratarEmpleado(Empleado empleado) {

		// Por cada tipo de instancia creamos un if para que controle la
		// información que queremos que se muestre por pantalla y que haga las
		// funciones que cada uno contiene.

		System.out.println(empleado);

		if (empleado instanceof Administrativo) { // Administrativo
			System.out.println("Soy Administrativo");
			empleado.trabajar();
		} else if (empleado instanceof Tecnico) { // Tecnico
			System.out.println("Soy Técnico");
			empleado.trabajar();
		} else if (empleado instanceof Ingeniero) { // Ingeniero
			System.out.println("Soy Ingeniero");
			empleado.trabajar();
			((Ingeniero) empleado).disenyar();
		}

	}

}
