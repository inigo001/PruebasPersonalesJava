package empresa;

/**
 * Un Tecnico implementa la clase Arreglador (método arreglar) y extiende la
 * clase Empleado (método trabajar).
 * 
 * Se crea de la misma manera que un empleado.
 * 
 * @author inigo001
 *
 */
public class Tecnico extends Empleado implements Arreglador {

	public Tecnico(String nombre, String apellido, int edad, Dni dni, double sueldo) {
		super(nombre, apellido, edad, dni, sueldo);
	}

	public Tecnico() {
		super();
	}

	@Override
	public void trabajar() {
		this.arreglar();
	}

	@Override
	public void arreglar() {
		System.out.println("Estoy arreglando");
	}

}
