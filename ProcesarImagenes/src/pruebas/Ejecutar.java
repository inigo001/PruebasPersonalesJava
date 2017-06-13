package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ejecutar {

	private static final String IMAGE_ROUTE = "data/testImages/";
	private static final String WRITE_ROUTE = "write/testResult/";
	private static String imageName = "gato_3.jpg";

	public static void main(String[] args) {

		try {
			BufferedImage image = ImageIO.read(new File(IMAGE_ROUTE + imageName));

			File path = new File(WRITE_ROUTE + imageName.split("\\.")[0]);
			if (!path.exists())
				path.mkdir();

			// Creamos histogramas
			Histogram imageHisto = new Histogram(image);
			Ejecutar.buildHistograms(path, imageHisto);

			// Transformaciones de la imagen
			Ejecutar.buildOperators(path, image);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	private static void buildHistograms(File path, Histogram imageHisto) throws IOException {

		BufferedImage histo;
		File outputfile;

		// Histograma de Iluminación (Grises)
		histo = imageHisto.getHistoImage(Channel.BRIGHTNESS);
		outputfile = new File(path.getPath() + "/h1-bright.png");
		ImageIO.write(histo, "png", outputfile);

		// Histograma de luminancia
		histo = imageHisto.getHistoImage(Channel.LUMINANCE);
		outputfile = new File(path.getPath() + "/h2-luminance.png");
		ImageIO.write(histo, "png", outputfile);

		// Histograma de color rojo
		histo = imageHisto.getHistoImage(Channel.RED);
		outputfile = new File(path.getPath() + "/h3-red.png");
		ImageIO.write(histo, "png", outputfile);

		// Histograma de color verde
		histo = imageHisto.getHistoImage(Channel.GREEN);
		outputfile = new File(path.getPath() + "/h4-green.png");
		ImageIO.write(histo, "png", outputfile);

		// Histograma de color azul
		histo = imageHisto.getHistoImage(Channel.BLUE);
		outputfile = new File(path.getPath() + "/h5-blue.png");
		ImageIO.write(histo, "png", outputfile);
	}

	private static void buildOperators(File path, BufferedImage image) throws IOException {

		BufferedImage newImage;
		File outputfile;

		// Imagen invertida
		newImage = IndividualOperators.imageNegative(image);
		outputfile = new File(path.getPath() + "/op1-negative.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.greyScale(image);
		outputfile = new File(path.getPath() + "/op2-greyScale.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.imageUmbral(image, 200);
		outputfile = new File(path.getPath() + "/op3-umbral.png");
		ImageIO.write(newImage, "png", outputfile);

	}

}
