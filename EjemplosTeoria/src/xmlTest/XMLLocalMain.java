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
 * Pequeña prueba de programa para leer un fichero XML, en este caso local,
 * procesarlo y crear un fichero txt con el contenido en columnas.
 * 
 * @author ZALLA
 *
 */
public class XMLLocalMain {

	/**
	 * Escribimos la ruta local de la que cogeremos el fichero XML que vamos a
	 * procesar. NO VALEN RUTAS EN RED con el método que estamos utilizando en
	 * este caso.
	 */
	private static final String RUTA_XML = "./data/ostatuak.xml";

	public static void main(String[] args) {

		// TreeMap. Es como un HashMap pero coloca los elementos de manera
		// ordenada en base al Key (<Key, Value>). NO se puede ordenar en base
		// al Value de manera sencilla puesto que el sistema está desarrollado
		// para ordenarlo (automáticamente) exclusivamente a base de la Key.
		TreeMap<String, Integer> townList = new TreeMap<String, Integer>();

		try {
			// Leemos el fichero desde la Ruta.
			File inputFile = new File(RUTA_XML);

			// -
			// No entiendo nada de lo que aparece aquí, pero por lo que parece
			// crea un documentBuilder que después parsea el fichero,
			// convirtiéndolo en un objeto de tipo Document para después poder
			// analizarlo.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// -

			// El objeto de tipo Document se basa en el estándar DOM, o eso
			// espero :S.
			// A partir de aquí vamos leyendo los elementos del nodo, utilizando
			// métodos For para iterar sobre ellos.
			// TODO buscar métodos y maneras más sencillas para no tener que
			// crear los bucles for nosotros, si no que los incorporen los
			// propios métodos.
			System.out.print("Root element: ");
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("row");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				NodeList nNode = (NodeList) nList.item(temp);

				for (int j = 0; j < nNode.getLength(); j++) {

					// En nuestro caso, al topar un elemento con nombre
					// "municipality" lo guardamos, puesto que el objetivo de
					// nuestra lista es ver el número de hostales por pueblo.
					if (nNode.item(j).getNodeName() == "municipality") {
						String townName = nNode.item(j).getTextContent();

						// En caso de no estar el hostal en la lista, lo
						// añadimos y lo pones su valor a 1. En caso de que ya
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

		// Creamos un Iterador de nuestro TreeMap. TODO No sé exactamente para
		// qué sirve :S
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

		// Este código es un código chapucero para escribir en un fichero de
		// texto plano (.txt). Durante los anteriores códigos hemos ido creando
		// un String que después escribiremos en un txt. Como curiosidad, la
		// carpeta en la que guardarlo tiene que EXISTIR, si no no escribirá en
		// ella.
		try {
			PrintWriter writer = new PrintWriter("./write/ostatu-lista-antolatua.txt", "UTF-8");
			writer.println(txtString);
			writer.close();
		} catch (IOException e) {
			System.out.println("¡!¡!¡!¡!¡!¡! - - - - Perícolo, ha habido un ERRORE. La carpetica no existe o(`O´)o ");
		}
	}

}
