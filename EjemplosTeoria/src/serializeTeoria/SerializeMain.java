package serializeTeoria;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Sistema para probar el concepto de Serializable, adem�s de utilizar un poco
 * los sistemas de encriptaci�n.
 * 
 * @author inigo001
 *
 */
public class SerializeMain {

	/**
	 * Clave con la que encriptamos las clases serializadas. Por lo que parece
	 * si que las encripta de aquella manera y es funcional.
	 */
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't',
			'K', 'e', 'y' };

	public static void main(String[] args) {

		// Crea los ficheros y los guarda dentro de la carpeta write
		SerializeMain.crearFicherosPersonos();

		// Recoge uno de los fichores y lee su contenido.
		SerializeMain.cargarFicherosPersonos();
	}

	/**
	 * Crea ficheros a partir de una serie de objetos de tipo Persono y los
	 * guarda en ficheros como cadenas de bytes cifradas.
	 */
	private static void crearFicherosPersonos() {

		// Creamos una lista de Personos. En este caso abr� 3.
		// Los Personos se explican en su propia clase.
		List<Persono> personos = SerializeMain.crearPersonos();

		try {

			for (int i = 0; i < personos.size(); i++) {

				// Convierte el objeto Persono que hemos cogido y lo
				// transformamos en una cadena de bytes.
				byte[] bytes = SerializeMain.createByteArray(personos.get(i));
				// Ciframos esa cadena de bytes
				bytes = SerializeMain.encrypt(bytes);

				// Guardamos el fichero con extensi�n persono dentro de la
				// carpeta write. Abri�ndola con un lector de textos solo
				// muestra basura ininteligible.
				Path path = Paths.get("write/pers" + i + ".persono");
				Files.write(path, bytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea una lista de objetos de tipo Persono con sus datos introducidos.
	 * 
	 * @return Lista de objetos de tipo Persona
	 */
	private static List<Persono> crearPersonos() {
		List<Persono> personos = new ArrayList<Persono>();

		Persono persono1 = new Persono("Adalberto", 12, 25);
		Persono persono2 = new Persono("Erminginio", 257, 12);
		Persono persono3 = new Persono("Osculiano", 9841, -89);

		personos.add(persono1);
		personos.add(persono2);
		personos.add(persono3);

		System.out.println("Antes: " + persono1);

		return personos;
	}

	/**
	 * Crea un array de bytes a partir de un objeto persona, serializ�ndolo.
	 * 
	 * @param persono
	 *            Objeto que queremos convertir
	 * @return Array de bytes con el contenido del objeto
	 * @throws IOException
	 *             Excepci�n que lanza el m�todo writeObject, en caso de que el
	 *             objeto que le estamos pasando no tenga nada, �no?
	 */
	private static byte[] createByteArray(Persono persono) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject(persono);
		out.flush();
		return bos.toByteArray();
	}

	/**
	 * Carga un fichero de bytes con el contenido serializado de un objeto de
	 * tipo Persona y lee su contenido, mostr�ndolo en la consola.
	 */
	private static void cargarFicherosPersonos() {

		// Cogemos la posici�n en la que se encuentra nuestro objeto de tipo
		// persona.
		Path personoPath = Paths.get("write/pers1.persono");

		try {
			// Leemos su contenido en bytes. Si no hay nada en ese path lanza
			// una excepci�n.
			byte[] bytes = Files.readAllBytes(personoPath);

			// Descifra el contenido de los bytes.
			bytes = SerializeMain.decrypt(bytes);

			// Lee el array de bytes, lo convierte en un objeto y despu�s
			// casteamos ese objeto a tipo Persono, puesto que en principio
			// deber�a ser instancia de �ste.
			// (a�n as� mejor hacer un instanceof)
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			ObjectInputStream is = new ObjectInputStream(in);
			Persono miPersono = (Persono) is.readObject();

			// Mostramos en consola el contenido del array.
			System.out.println("Despu�s: " + miPersono);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cifrar array de bytes
	 * 
	 * @param bytes
	 *            Contenido a cifrar
	 * @return Contenido cifrado
	 * @throws Exception
	 *             Hay muchas excepciones que no vamos a comentar ahora.
	 */
	public static byte[] encrypt(byte[] bytes) throws Exception {
		Key key = new SecretKeySpec(keyValue, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(bytes);
		return encVal;
	}

	/**
	 * Descifrar array de bytes
	 * 
	 * @param bytes
	 *            Contenido a descifrar
	 * @return Contenido descifrado.
	 * @throws Exception
	 *             Hay muchas excepciones que no vamos a comentar ahora.
	 */
	public static byte[] decrypt(byte[] bytes) throws Exception {
		Key key = new SecretKeySpec(keyValue, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, key);

		byte[] decValue = c.doFinal(bytes);
		return decValue;
	}

}
