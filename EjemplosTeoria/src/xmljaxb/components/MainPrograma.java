package xmljaxb.components;

import xmljaxb.classes.*; // Clases creadas por XJC

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

// Cosas para los XML.
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class MainPrograma {

	// TODO Por hacer
	public static void main(String[] args) throws FileNotFoundException {

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
			List<Row> listRow = menuElement.getValue().getRow();

			// Podemos acceder a los elementos del objeto usando los métodos que
			// el XJC nos ha creado anteriormente.
			System.out.println(listRow.get(8).getErakunde());

			// -
			// -
			// Añadimos nuevos datos a la lista de Rows
			MainPrograma.addNewData(listRow);

			// Creamos un marshaller
			Marshaller m = jc.createMarshaller();

			// Elegimos el lugar en el que queremos escribir la información
			OutputStream os = new FileOutputStream("write/test-ostatu.xml");
			// Elegimos el JAXBElement (el nuestro que hemos modificado) y lo
			// escribimos en el OutputStream que hemos decidido.
			m.marshal(menuElement, os);
			// Cerramos el OutputStream
			os.close();

		} catch (JAXBException | IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Añadimos a la lista de Row's un nuevo elemento. Esta lista no es una
	 * nueva, si no que es una referencia a la lista del JaxbContext, por lo que
	 * los cambios que le hagamos se mantendrán en ésta sin la necesidad de
	 * hacer un set. De esta manera es posible cambiar el contenido y actualizar
	 * el XML con facilidad :)
	 * 
	 * @param list
	 * @return
	 */
	private static List<Row> addNewData(List<Row> list) {

		Row newRow = new Row();

		newRow.setErakunde("Tururu");
		newRow.setHelbidea("Mugururu");
		newRow.setKokapena("Irituru");
		newRow.setModelo("Astrofasio");
		newRow.setNum((short) (list.size() + 1));
		newRow.setOrdutegia("1245781");
		newRow.setProbintzia("Elbaf");
		newRow.setSeriezenbakia("12345664312");
		newRow.setUdalerria("Galdakao");
		newRow.setXetrs89(489651f);
		newRow.setYetrs89(4516789f);

		list.add(newRow);

		return list;

	}

}
