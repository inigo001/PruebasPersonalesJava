package empresa;

/**
 * Un Administrativo implementa la clase ManejadorOrdenador (método teclear) y
 * extiende la clase Empleado (método trabajar)
 * 
 * Se crea de la misma manera que un empleado
 * 
 * @author inigo001
 *
 */
public class Administrativo extends Empleado implements ManejadorOrdenador {

	public Administrativo(String nombre, String apellido, int edad, Dni dni, double sueldo) {
		super(nombre, apellido, edad, dni, sueldo);
	}

	public Administrativo() {
		super();
	}

	@Override
	public void trabajar() {
		this.teclear();
	}

	@Override
	public void teclear() {
		System.out.println("Estoy tecleando");
	}

}
