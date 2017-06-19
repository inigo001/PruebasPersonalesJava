package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ejecutar {

	private static final String IMAGE_ROUTE = "data/testImages/";
	private static final String WRITE_ROUTE = "write/testResult/";
	private static String imageName = "gato_6.jpg";

	public static void main(String[] args) {

		try {
			BufferedImage image = ImageIO.read(new File(IMAGE_ROUTE + imageName));

			File path = new File(WRITE_ROUTE + imageName.split("\\.")[0]);
			if (!path.exists())
				path.mkdir();

			// Creamos histogramas
			Histogram imageHisto = new Histogram(image);
			// Ejecutar.buildHistograms(path, imageHisto);

			// Transformaciones de la imagen
			// Ejecutar.buildOperators(path, image);

			// Mezcla de imágenes
			// Ejecutar.multipleOperators(path, image);

			// Ejecutar.specialOperators(path, image);

			Ejecutar.colorCorrections(path, image);

		} catch (Exception e) {
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
		newImage = IndividualOperators.imageUmbral(image, 100);
		outputfile = new File(path.getPath() + "/op3-umbral.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.imageInvertedUmbral(image, 100);
		outputfile = new File(path.getPath() + "/op4-invertedUmbral.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.imageBinaryUmbral(image, 90, 130);
		outputfile = new File(path.getPath() + "/op5-binaryUmbral.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.imageInvertedBinaryUmbral(image, 90, 130);
		outputfile = new File(path.getPath() + "/op6-invertedBinaryUmbral.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.greyImageUmbral(image, 70, 200);
		outputfile = new File(path.getPath() + "/op7-greyImageUmbral.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.invertedGreyImageUmbral(image, 70, 200);
		outputfile = new File(path.getPath() + "/op8-invertedGreyImageUmbral.png");
		ImageIO.write(newImage, "png", outputfile);

		// Histograma de Iluminación (Grises)
		newImage = IndividualOperators.extensionUmbral(image, 70, 200);
		outputfile = new File(path.getPath() + "/op9-extensionUmbral.png");
		ImageIO.write(newImage, "png", outputfile);

		newImage = SpecialOperators.paintBorders(image, 1, 10);
		outputfile = new File(path.getPath() + "/op10-imageSides.png");
		ImageIO.write(newImage, "png", outputfile);

	}

	private static void multipleOperators(File path, BufferedImage image) throws Exception {

		File outputfile;

		// Histograma de Iluminación (Grises)
		BufferedImage binaryUmbral = IndividualOperators.imageUmbral(image, 20);

		BufferedImage comboImage = MultipleOperators.unite(binaryUmbral, image);

		outputfile = new File(path.getPath() + "/test1-comboImage1.png");
		ImageIO.write(comboImage, "png", outputfile);

		//
		BufferedImage umbral = IndividualOperators.imageInvertedUmbral(image, 120);
		BufferedImage border = SpecialOperators.paintBorders(image, 1, 10);

		comboImage = MultipleOperators.unite(umbral, border);

		outputfile = new File(path.getPath() + "/test2-comboImage2.png");
		ImageIO.write(comboImage, "png", outputfile);

	}

	private static void specialOperators(File path, BufferedImage image) throws Exception {

		BufferedImage newImage;
		File outputfile;

		// Imagen invertida
		newImage = SpecialOperators.colorBlocks(image, 32);
		outputfile = new File(path.getPath() + "/blocks.png");
		ImageIO.write(newImage, "png", outputfile);

		// Imagen invertida
		newImage = SpecialOperators.changeColorLength(image, 3);
		outputfile = new File(path.getPath() + "/colors.png");
		ImageIO.write(newImage, "png", outputfile);
	}

	private static void colorCorrections(File path, BufferedImage image) throws Exception {

		BufferedImage newImage;
		File outputfile;
		
		newImage = ColorCorrections.contrastImage(image);
		outputfile = new File(path.getPath() + "/colorCorrBad.png");
		ImageIO.write(newImage, "png", outputfile);

	}
}
