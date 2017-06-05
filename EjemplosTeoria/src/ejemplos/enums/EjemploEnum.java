package ejemplos.enums;

/**
 * Ejemplo de Enum con funciones y parámetros en su interior
 * 
 * @author inigo001
 *
 */
public class EjemploEnum {

	public static void main(String[] args) {
		// Creamos las variables
		PuntosCardinales miPunto1 = PuntosCardinales.ESTE;
		PuntosCardinales miPunto2 = PuntosCardinales.SUR;

		// Podemos llamar a los métodos desde aquí y nos dará el valor de su
		// contenido
		System.out.println("POSICION miPunto1: " + miPunto1.getPosicion());
		System.out.println("POSICION miPunto2: " + miPunto2.getPosicion());

		// También podemos crear un método toString dentro del enum y usarlo
		// cuando lo necesitemos.
		System.out.println("GLOBAL miPunto1: " + miPunto1);

		// Con los datos internos también podemos hacer operaciones sin ningún
		// problema.
		System.out.println(miPunto2.getGrados() - miPunto1.getGrados());
	}

}
