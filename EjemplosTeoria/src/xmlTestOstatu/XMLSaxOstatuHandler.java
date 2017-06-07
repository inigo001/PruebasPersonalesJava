package xmlTestOstatu;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLSaxOstatuHandler extends DefaultHandler {

	private boolean rowFlag = false;

	private boolean nameFlag = false;
	private boolean descFlag = false;
	private boolean townFlag = false;
	private boolean townCodeFlag = false;
	private boolean territoryFlag = false;
	private boolean phoneFlag = false;

	private String ostatuName;
	private String ostatuDesc;
	private int[] phoneNumbers;

	private String townName;
	private int townCode;
	private String townTerr;

	private ArrayList<Municipio> townList = new ArrayList<Municipio>();

	//

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.checkFlags(qName);

		if (qName == "row") {
			ostatuName = "";
			ostatuDesc = "";
			townName = "";
			townTerr = "";
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		this.checkFlags(qName);

		if (qName == "row" && qName != "rows") {

			Municipio municipio = new Municipio(townName, townCode, Territory.valueOf(townTerr));

			if (townList.contains(municipio)) {
				for (int i = 0; i < townList.size(); i++) {
					if (townList.get(i).equals(municipio)) {
						municipio = townList.get(i);
					}

				}
			} else {
				townList.add(municipio);
			}

			Ostatu ostatuBerria = new Ostatu(ostatuName, ostatuDesc, municipio, phoneNumbers);
			XMLSaxOstatuMain.ostatuak.add(ostatuBerria);
		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		// System.out.print(new String(ch, start, length));

		if (nameFlag) {
			ostatuName += new String(ch, start, length);
		} else if (descFlag) {
			ostatuDesc += new String(ch, start, length);
		} else if (townFlag) {
			townName += new String(ch, start, length);
		} else if (townCodeFlag) {
			townCode = Integer.parseInt(new String(ch, start, length));
		} else if (territoryFlag) {
			townTerr += new String(ch, start, length);
		} else if (phoneFlag) {
			// Como hay campos con más de un teléfono, escritos cada uno de una
			// manera diferente y separados igual, hay que hacer todo este rollo
			// para que quede correctamente alineado.

			// 1. Hay teléfonos con los números juntos (944401122) o con ellos
			// separados (94 440 1 122), cada uno a su manera.
			String numbers = (new String(ch, start, length)).replaceAll("\\s+", "");
			// 2. Cuando hay más de un número, el sistema lo separa con un
			// guión, o eso en la mayoría de casos.
			String[] numbersSplit = numbers.split("-");
			ArrayList<Integer> numberArray = new ArrayList<Integer>();

			// 3. En algún extraño caso los números están separados por líneas
			// pero algún hueco está vacío. para evitar esto miro si el número
			// es igual a 9 (la longitud normal de un número) y si es así lo
			// guardo, si no a hacer puñetas.
			for (String number : numbersSplit) {
				if (number.length() == 9) {
					numberArray.add(Integer.parseInt(number));
				}
			}

			// Convierto el arrayList en un array normal. Hay que hacer algunos
			// cambios puesto que el array es de int mientras que el ArrayList
			// es de objetos de tipo Integer.
			phoneNumbers = new int[numberArray.size()];
			for (int i = 0; i < numberArray.size(); i++) {
				phoneNumbers[i] = numberArray.get(i);
			}
		}
	}

	private void checkFlags(String qName) {
		switch (qName) {
		case "row":
			rowFlag = !rowFlag;
			break;
		case "documentname":
			nameFlag = !nameFlag;
			break;
		case "turismdescription":
			descFlag = !descFlag;
			break;
		case "municipality":
			townFlag = !townFlag;
			break;
		case "municipalitycode":
			townCodeFlag = !townCodeFlag;
			break;
		case "territory":
			territoryFlag = !territoryFlag;
			break;
		case "phonenumber":
			phoneFlag = !phoneFlag;
			break;
		}
	}

}
