package xmlTest;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLMainProgram {

	private static final String RUTA_XML = "./data/ostatuak.xml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> townList = new HashMap<String, Integer>();

		try {
			File inputFile = new File(RUTA_XML);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			System.out.print("Root element: ");
			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("row");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				NodeList nNode = (NodeList) nList.item(temp);
				System.out.println("\nCurrent Element :");

				for (int j = 0; j < nNode.getLength(); j++) {

					if (nNode.item(j).getNodeName() == "municipality") {
						String townName = nNode.item(j).getTextContent();

						System.out.println(townName);

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
				
		Iterator it = townList.entrySet().iterator();

		while (it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

}
