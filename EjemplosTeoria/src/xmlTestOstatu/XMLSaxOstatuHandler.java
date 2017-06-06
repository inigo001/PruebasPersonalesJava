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

	private String ostatuName;
	private String ostatuDesc;

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

			Ostatu ostatuBerria = new Ostatu(ostatuName, ostatuDesc, municipio);
			XMLSaxOstatuMain.ostatuak.add(ostatuBerria);

			System.out.println(townList.size());
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
		}
	}

}
