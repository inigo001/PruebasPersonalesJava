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
			Histogram imageHisto = new Histogram(image);

			String name = imageName.split("\\.")[0];

			File path = new File(WRITE_ROUTE + name);
			if (!path.exists())
				path.mkdir();

			BufferedImage histo;
			File outputfile;

			histo = imageHisto.getHistoImage(Channel.BRIGHTNESS);

			outputfile = new File(path.getPath() + "/bright-histogram.png");
			ImageIO.write(histo, "png", outputfile);

			histo = imageHisto.getHistoImage(Channel.RED);

			outputfile = new File(path.getPath() + "/red-histogram.png");
			ImageIO.write(histo, "png", outputfile);

			histo = imageHisto.getHistoImage(Channel.GREEN);

			outputfile = new File(path.getPath() + "/green-histogram.png");
			ImageIO.write(histo, "png", outputfile);

			histo = imageHisto.getHistoImage(Channel.BLUE);

			outputfile = new File(path.getPath() + "/blue-histogram.png");
			ImageIO.write(histo, "png", outputfile);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
