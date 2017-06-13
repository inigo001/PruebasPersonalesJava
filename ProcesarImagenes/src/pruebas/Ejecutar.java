package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ejecutar {

	private static final String IMAGE_ROUTE = "data/testImages/";
	private static final String WRITE_ROUTE = "write/testResult/";
	private static String imageName = "gato_2.jpg";

	public static void main(String[] args) {

		try {
			BufferedImage image = ImageIO.read(new File(IMAGE_ROUTE + imageName));
			Histogram imageHisto = new Histogram(image);

			image = imageHisto.brightnessImage();

			File outputfile = new File(WRITE_ROUTE + imageName.split("\\.")[0] + "-histogram.png");
			ImageIO.write(image, "png", outputfile);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
