package empresa;

import java.util.Random;

public class Ingeniero extends Empleado implements ManejadorOrdenador, Arreglador {

	public Ingeniero(String nombre, String apellido, int edad, Dni dni, double sueldo) {
		super(nombre, apellido, edad, dni, sueldo);
	}

	public Ingeniero() {
		super();
	}

	@Override
	public void trabajar() {
		this.arreglar();
		this.teclear();
	}

	@Override
	public void arreglar() {
		System.out.println("Estoy superArreglando");
	}

	@Override
	public void teclear() {
		System.out.println("Estoy superTecleando");
	}

	public void disenyar() {
		System.out.println("Estoy superDiseñando");
	}

	public double obtenerSueldo() {
		// Devuelve el sueldo siendo entre un 0% y un 20% mayor. Para eso
		// creamos un número aleatorio entre 1 y 1.2 y multiplicamos el sueldo
		// que nos daba antes por el resultado.

		// Creamos random
		Random rand = new Random();

		// Obtenemos el sueldo desde la superclase y lo multiplicamos por el
		// número aleatorio en el rango (1 - 1.2)
		return super.obtenerSueldo() * (1 + (0.2 * rand.nextDouble()));
	}

}
