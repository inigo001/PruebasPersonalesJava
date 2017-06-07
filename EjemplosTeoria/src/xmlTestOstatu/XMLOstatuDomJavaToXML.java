package xmlTestOstatu;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLOstatuDomJavaToXML {

	public static void writeXML(ArrayList<Ostatu> ostatuak) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("ostatuak");
		rootElement.setAttribute("herria", ostatuak.get(0).getMunicipioName());

		doc.appendChild(rootElement);

		for (int i = 0; i < ostatuak.size(); i++) {

			// Elemento principal
			Element ostatuElement = doc.createElement("ostatua");
			ostatuElement.setAttribute("num", String.valueOf(i));

			// Elemento nombre
			Element ostatuName = doc.createElement("izena");
			ostatuName.appendChild(doc.createTextNode(ostatuak.get(i).getNombre()));
			ostatuElement.appendChild(ostatuName);

			// Elemento descripcion
			Element ostatuDescription = doc.createElement("deskripzioa");
			ostatuDescription.appendChild(doc.createTextNode(ostatuak.get(i).getDescripcion()));
			ostatuElement.appendChild(ostatuDescription);

			// Elemento numeros
			Element ostatuPhones = doc.createElement("telefonoak");
			int[] telefonos = ostatuak.get(i).getTelefonos();
			for (int j = 0; j < telefonos.length; j++) {
				Element telefonoa = doc.createElement("telefono");
				telefonoa.setAttribute("z", String.valueOf(j));
				telefonoa.appendChild(doc.createTextNode(String.valueOf(telefonos[j])));
				ostatuPhones.appendChild(telefonoa);
			}
			ostatuElement.appendChild(ostatuPhones);

			// Elemento lodgingType
			Element ostatuLodging = doc.createElement("mota");
			ostatuLodging.appendChild(doc.createTextNode(ostatuak.get(i).getLodging().getName()));
			ostatuElement.appendChild(ostatuLodging);

			rootElement.appendChild(ostatuElement);

		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("write/test.xml"));

		transformer.transform(source, result);

		System.out.println("File saved!");

	}

}
