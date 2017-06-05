package ejemplos.enums;

/**
 * Ejemplo de Enum con funciones y par�metros en su interior
 * 
 * @author inigo001
 *
 */
public class EjemploEnum {

	public static void main(String[] args) {
		// Creamos las variables
		PuntosCardinales miPunto1 = PuntosCardinales.ESTE;
		PuntosCardinales miPunto2 = PuntosCardinales.SUR;

		// Podemos llamar a los m�todos desde aqu� y nos dar� el valor de su
		// contenido
		System.out.println("POSICION miPunto1: " + miPunto1.getPosicion());
		System.out.println("POSICION miPunto2: " + miPunto2.getPosicion());

		// Tambi�n podemos crear un m�todo toString dentro del enum y usarlo
		// cuando lo necesitemos.
		System.out.println("GLOBAL miPunto1: " + miPunto1);

		// Con los datos internos tambi�n podemos hacer operaciones sin ning�n
		// problema.
		System.out.println(miPunto2.getGrados() - miPunto1.getGrados());
	}

}
