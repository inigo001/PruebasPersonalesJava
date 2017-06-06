package xmlTest;

import javax.xml.parsers.*;
import org.xml.sax.helpers.*;

public class XMLSaxMain {

	public static void main(String[] args) {

		try {
			// Creamos el factory, que creará el parser que vamos a utilizar
			// para parsear nuestro fichero.
			SAXParserFactory factory = SAXParserFactory.newInstance();

			// Creamos el Parser a partir del Factory que acabamos de crear.
			SAXParser saxParser = factory.newSAXParser();

			// Creamos un handler.
			// El Handler es el objeto que lleva la estructura del XML que vamos
			// a analizar. En principio tenemos que conocer la estructura del
			// XML para poder crear esta clase y trabajar con ella.
			DefaultHandler handler = new XMLSaxHandler();

			// Iniciamos el parseo del fichero con el Handler que acabamos de
			// crear. Lanzará eventos mientras parsea el fichero y nosotros los
			// "cazaremos" en la clase Handler.
			saxParser.parse("data/companyStaffers.xml", handler);

			// El handler no ocurre de manera asíncrona. Hasta que no termine de
			// parsear el fichero no llegaremos a esta parte del código.

		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}

	}

}
