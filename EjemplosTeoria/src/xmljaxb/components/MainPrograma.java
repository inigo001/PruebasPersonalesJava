package xmljaxb.components;

import xmljaxb.classes.*; // Clases creadas por XJC

import java.util.ArrayList; // Maravilloso ArrayList

// Cosas para los XML.
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class MainPrograma {

	// TODO Por hacer
	public static void main(String[] args) {

		try {

			// Creamos el contexto Jax de la clase que queremos. En este caso
			// sería conveniente que fuera la clase que agrupa la mayoría de del
			// contenido del XML.
			final JAXBContext jc = JAXBContext.newInstance(Rows.class);
			// No se que es un unmarshaller, pero ya lo veremos.
			final Unmarshaller u = jc.createUnmarshaller();

			// El Stream de datos. Cada sistema utiliza sus propias locuras para
			// marcar la ruta, así que éste es el que, de todos, más sencillo
			// resulta.
			Source source = new StreamSource("data/desfibriladoreak.xml");

			// Creamos un elemento de tipo JaxBElement con la clase que nos a
			// creado XJC. Unmarshaleamos ( ¿(*.*)? ) los datos del XML teniendo
			// en cuenta la clase que estamos usando.
			JAXBElement<Rows> menuElement = u.unmarshal(source, Rows.class);

			// Creamos una lista con los elementos internos. Esta lista se
			// compone de objetos de clase Row, creada con XJC y con métodos
			// bastante sencillos de aprender a utilizar.
			ArrayList<Row> listRow = (ArrayList<Row>) menuElement.getValue().getRow();

			// Podemos acceder a los elementos del objeto usando los métodos que
			// el XJC nos ha creado anteriormente.
			System.out.println(listRow.get(8).getErakunde());

		} catch (JAXBException e) {

			e.printStackTrace();
		}

	}

}
