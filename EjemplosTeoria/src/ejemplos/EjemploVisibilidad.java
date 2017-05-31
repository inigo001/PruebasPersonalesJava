package ejemplos;

/**
 * Tipos de visibilidad. Existen distintos tipos de visibilidad. página nº 70
 * del libro online. Aparece explicado aquí:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * Ha tener en cuenta lo de package. Si la clase que accede a la variable forma
 * parte del mismo paquete podrá acceder a ella a menos que ésta sea privada
 * (default).
 * 
 * @author inigo001
 * @see <a href=
 *      "http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html">AccessControl</a>
 */
@SuppressWarnings("all")
public class EjemploVisibilidad {

	/**
	 * Puedes acceder desde todos lados
	 */
	public int numero1;
	/**
	 * Puedes acceder desde la clase y todas sus subclases
	 */
	protected int numero2;
	/**
	 * Solo puedes acceder a ellas desde la propia clase
	 */
	private int numero3;

	/**
	 * Es como public pero no permite acceder desde la subclase (si desde el
	 * paquete).
	 */
	/* default */ int numero4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
