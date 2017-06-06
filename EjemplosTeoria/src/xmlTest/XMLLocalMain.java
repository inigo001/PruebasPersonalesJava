package xmlTest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Peque�a prueba de programa para leer un fichero XML, en este caso local,
 * procesarlo y crear un fichero txt con el contenido en columnas.
 * 
 * @author ZALLA
 *
 */
public class XMLLocalMain {

	/**
	 * Escribimos la ruta local de la que cogeremos el fichero XML que vamos a
	 * procesar. NO VALEN RUTAS EN RED con el m�todo que estamos utilizando en
	 * este caso.
	 */
	private static final String RUTA_XML = "./data/ostatuak.xml";

	public static void main(String[] args) {

		// TreeMap. Es como un HashMap pero coloca los elementos de manera
		// ordenada en base al Key (<Key, Value>). NO se puede ordenar en base
		// al Value de manera sencilla puesto que el sistema est� desarrollado
		// para ordenarlo (autom�ticamente) exclusivamente a base de la Key.
		TreeMap<String, Integer> townList = new TreeMap<String, Integer>();

		try {
			// Leemos el fichero desde la Ruta.
			File inputFile = new File(RUTA_XML);

			// -
			// No entiendo nada de lo que aparece aqu�, pero por lo que parece
			// crea un documentBuilder que despu�s parsea el fichero,
			// convirti�ndolo en un objeto de tipo Document para despu�s poder
			// analizarlo.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// -

			// El objeto de tipo Document se basa en el est�ndar DOM, o eso
			// espero :S.
			// A partir de aqu� vamos leyendo los elementos del nodo, utilizando
			// m�todos For para iterar sobre ellos.
			// TODO buscar m�todos y maneras m�s sencillas para no tener que
			// crear los bucles for nosotros, si no que los incorporen los
			// propios m�todos.
			System.out.print("Root element: ");
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("row");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				NodeList nNode = (NodeList) nList.item(temp);

				for (int j = 0; j < nNode.getLength(); j++) {

					// En nuestro caso, al topar un elemento con nombre
					// "municipality" lo guardamos, puesto que el objetivo de
					// nuestra lista es ver el n�mero de hostales por pueblo.
					if (nNode.item(j).getNodeName() == "municipality") {
						String townName = nNode.item(j).getTextContent();

						// En caso de no estar el hostal en la lista, lo
						// a�adimos y lo pones su valor a 1. En caso de que ya
						// exista simplemente sumamos al valor 1.
						if (townList.get(nNode.item(j).getTextContent()) == null) {
							townList.put(townName, 1);
						} else {
							townList.put(townName, townList.get(townName) + 1);
						}

					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(townList.size());

		// Creamos un Iterador de nuestro TreeMap. TODO No s� exactamente para
		// qu� sirve :S
		Iterator<Entry<String, Integer>> it = townList.entrySet().iterator();

		// Este va a ser el texto que escribamos
		String txtString = "#####################################################\n";
		txtString += "# PUEBLO                                | NUMERO    #\n";
		txtString += "#####################################################\n";

		// Iteramos sobre el iterador (jeje) para trabajar con los pares dentro
		// de nuestro TreeMap. Al terminar de trabajar con el pair lo quitamos
		// del propio iterador.
		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
			// System.out.println(pair.getKey() + " = " + pair.getValue());

			int sizeNum = (int) Math.log10(Double.parseDouble(pair.getValue().toString()));

			txtString += "# " + pair.getKey()
					+ (String.join("", Collections.nCopies((38 - (pair.getKey().toString().length())), " "))) + "| "
					+ String.join("", Collections.nCopies(8 - sizeNum, " ")) + pair.getValue() + " #\n";

			it.remove(); // avoids a ConcurrentModificationException
		}

		txtString += "#####################################################\n";

		System.out.println(txtString);

		// Este c�digo es un c�digo chapucero para escribir en un fichero de
		// texto plano (.txt). Durante los anteriores c�digos hemos ido creando
		// un String que despu�s escribiremos en un txt. Como curiosidad, la
		// carpeta en la que guardarlo tiene que EXISTIR, si no no escribir� en
		// ella.
		try {
			PrintWriter writer = new PrintWriter("./write/ostatu-lista-antolatua.txt", "UTF-8");
			writer.println(txtString);
			writer.close();
		} catch (IOException e) {
			System.out.println("�!�!�!�!�!�! - - - - Per�colo, ha habido un ERRORE. La carpetica no existe o(`O�)o ");
		}
	}

}
