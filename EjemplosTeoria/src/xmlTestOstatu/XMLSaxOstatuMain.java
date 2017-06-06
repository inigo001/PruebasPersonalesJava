package xmlTestOstatu;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class XMLSaxOstatuMain {

	public static ArrayList<Ostatu> ostatuak;

	public static void main(String[] args) {

		ostatuak = new ArrayList<Ostatu>();

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new XMLSaxOstatuHandler();

			saxParser.parse("data/ostatuak.xml", handler);

		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}

		System.out.println(ostatuak.size());

		System.out.println(ostatuak.get(16).getDescripcion());

	}

}
