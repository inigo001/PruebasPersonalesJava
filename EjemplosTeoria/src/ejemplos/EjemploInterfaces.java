package ejemplos;

import javax.swing.*;
import java.awt.FlowLayout;

/**
 * Pequeño ejemplo de manejo de interfaces, con un pequeño proyecto de interfaz
 * un poco de aquella manera. Extiende JFrame para poder crear una interfaz a
 * través de él. Tenemos que extender swing en conjunto, pues es la biblioteca
 * que trae consigo todos los componentes que vamos a utilizar.
 * 
 * @author inigo001
 *
 */
@SuppressWarnings("all")
public class EjemploInterfaces extends JFrame {

	/**
	 * El constructor de la interfaz. En principio no lo creamos nuevo si no que
	 * hacemos referencia a la superclase (JFrame) y al inicializarla así
	 * podemos después, en el interior del constructor, hacer referencia a sus
	 * métodos.
	 */
	public EjemploInterfaces() {
		// Llamamos a la SuperClase JFrame y en su constructor le introducimos
		// un String que será el texto superior de la ventana.
		super("Main Frame");

		// Al inicializar podemos usar los métodos de JFrame para adaptar los
		// tamaños de pantalla, que ocurre al pulsar el botón cerrar, el Layout
		// etc... Podemos definirlas también, en vez de con "this." usando
		// "super."
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		this.setLayout(flo);

		// Estas funciones las he definido en esta clase, así que son parte
		// de esta clase y no de la superclase.
		this.setLookAndFeel();
		this.addItemsToFrame();
		this.addItemsToPanel().setLayout(flo);

		this.setVisible(true);

	}

	/**
	 * Página 191 del libro. El objetivo es ponerle un estilo a los botones y
	 * demás. Éste es exageradamente feo, pero es lo que nos toca con estas
	 * mierdas de Java.
	 */
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
			// ignoramos error
		}
	}

	/**
	 * Creamos una serie de objetos y los añadimos al JFrame, en este caso
	 * "this", puesto que esta misma clase es hija de JFrame. Para añadir
	 * objetos a un frame ponemos jFrame.add(item).
	 * 
	 * Cada objeto tiene sus propias propiedades.
	 */
	private void addItemsToFrame() {
		JButton okButton = new JButton("OK");
		this.add(okButton);
		JButton playButton = new JButton("Play");
		this.add(playButton);
		JButton stopButton = new JButton("Stop");
		this.add(stopButton);

		JSeparator separator = new JSeparator();
		this.add(separator);

		JLabel pageLabel = new JLabel("Hola soy un label:", JLabel.CENTER);
		this.add(pageLabel);

		JTextField textField = new JTextField(20);
		textField.setText("pepefdusaio");
		this.add(textField);
	}

	/**
	 * Creamos un panel al que le añadimos un label. Un panel es un bloque que
	 * se introduce dentro de un JFrame. Para poder hacerlo tenemos que darle a
	 * jFrame.add(jPanel).
	 * 
	 * @return Devolvemos un JPanel para poder darle el mismo setLayout que
	 *         hemos dado arriba. Esto es un chapuza.
	 */
	private JPanel addItemsToPanel() {

		JPanel nuevoPanel = new JPanel();
		nuevoPanel.setSize(50, 50);

		JLabel pageLabel = new JLabel("TEXTO:", JLabel.CENTER);
		nuevoPanel.add(pageLabel);

		this.add(nuevoPanel);

		return nuevoPanel;

	}

	/**
	 * La clase tiene su propio main porque ella se autoinicia.
	 * 
	 * @param args
	 *            Los argumentos me los paso por el forro
	 */
	public static void main(String[] args) {
		EjemploInterfaces frame = new EjemploInterfaces();
	}

}
