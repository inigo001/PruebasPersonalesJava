package xmlTest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLMainProgram {

	private static final String RUTA_XML = "./data/ostatuak.xml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMap<String, Integer> townList = new TreeMap<String, Integer>();

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
				// System.out.println("\nCurrent Element :");

				for (int j = 0; j < nNode.getLength(); j++) {

					if (nNode.item(j).getNodeName() == "municipality") {
						String townName = nNode.item(j).getTextContent();

						// System.out.println(townName);

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

		String txtString = "#####################################################\n";
		txtString += "# PUEBLO                                # NUMERO    #\n";
		txtString += "#####################################################\n";

		// System.out.println(txtString);

		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			// System.out.println(pair.getKey() + " = " + pair.getValue());

			int sizeNum = (int) Math.log10(Double.parseDouble(pair.getValue().toString()));

			txtString += "# " + pair.getKey()
					+ (String.join("", Collections.nCopies((38 - (pair.getKey().toString().length())), " "))) + "# "
					+ String.join("", Collections.nCopies(8 - sizeNum, " ")) + pair.getValue() + " #\n";

			it.remove(); // avoids a ConcurrentModificationException
		}
		
		txtString += "#####################################################\n";

		System.out.println(txtString);
		
		try{
		    PrintWriter writer = new PrintWriter("./write/ostatu-lista-antolatua.txt", "UTF-8");
		    writer.println(txtString);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}

}
