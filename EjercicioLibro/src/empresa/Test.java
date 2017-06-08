package empresa;

public class Test {

	public static void main(String[] args) {

		// Creamos tres Empleados, cada uno de distinto tipo. Los datos
		// introducidos son chorradas y no muy adecuados xD.
		// Una vez creados les hacemos trabajar.
		Dni dniAdministrativo = new Dni(12345678, 'X');
		Administrativo administrativo = new Administrativo("Pepe", "Perez", 45, dniAdministrativo, 125);

		administrativo.trabajar();

		Dni dniTecnico = new Dni(12383678, 'Ñ');
		Tecnico tecnico = new Tecnico("Adolfo", "Ruinez", 12, dniTecnico, 256);

		tecnico.trabajar();

		Dni dniIngeniero = new Dni(19133678, 'V');
		Ingeniero ingeniero = new Ingeniero("Bartolo", "Iñiguez", 97, dniIngeniero, 100);

		ingeniero.trabajar();

		System.out.println("\n// - //\n");

		// Mostramos el sueldo de cada uno de los Empleados mediante el método
		// obtenerSueldo. El sueldo del ingeniero no será equivalente al que
		// hemos introducido en el constructor, puesto que en su sobreescritura
		// del método lo aumentamos entre un 0% y um 20%.
		System.out.println("Sueldo administrativo: " + administrativo.obtenerSueldo());
		System.out.println("Sueldo tecnico: " + tecnico.obtenerSueldo());
		System.out.println("Sueldo ingeniero: " + ingeniero.obtenerSueldo());

		System.out.println("\n// - //\n");

		// Gestionamos cada uno de los empleados. La clase GestionTrabajo
		// explica el funcionamiento de estos métodos.
		GestionTrabajo.tratarEmpleado(administrativo);
		GestionTrabajo.tratarEmpleado(tecnico);
		GestionTrabajo.tratarEmpleado(ingeniero);

	}

}
