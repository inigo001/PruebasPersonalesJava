package xmljaxb.components;

import xmljaxb.classes.*;
import javax.xml.bind.*;

public class MainPrograma {

	
	// TODO Por hacer
	public static void main(String[] args) {

		try {
			final JAXBContext jc = JAXBContext.newInstance(Rows.class);
			final Unmarshaller u = jc.createUnmarshaller();

			System.out.println(u);

			final JAXBElement<Rows> menuElement = (JAXBElement<Rows>) u
					.unmarshal(MainPrograma.class.getResourceAsStream("./data/desfibriladoreak.xml"));

			System.out.println("Nombre: " + menuElement.getValue().getNum());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
