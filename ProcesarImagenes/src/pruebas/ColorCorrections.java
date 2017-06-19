package pruebas;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorCorrections {

	public static BufferedImage contrastImage(BufferedImage image) {

		Histogram imageHisto = new Histogram(image);

		int[] histo = null;
		int upCol = 0;
		int loCol = 0;

		double redScaler;
		int redMin;
		double greenScaler;
		int greenMin;
		double blueScaler;
		int blueMin;

		//
		histo = imageHisto.getColorArray(Channel.RED);
		upCol = 0;
		loCol = 0;

		for (int i = 1; i < histo.length - 1; i++) {
			upCol = (histo[i] < histo[upCol]) ? upCol : i;
			loCol = (histo[i] > histo[loCol]) ? loCol : i;
		}

		redScaler = (255 / (upCol - loCol));
		redMin = loCol;

		System.out.println(upCol);
		System.out.println(loCol);

		//
		histo = imageHisto.getColorArray(Channel.GREEN);
		upCol = 0;
		loCol = 0;

		for (int i = 1; i < histo.length - 1; i++) {
			upCol = (histo[i] < histo[upCol]) ? upCol : i;
			loCol = (histo[i] > histo[loCol]) ? loCol : i;
		}

		System.out.println(upCol);
		System.out.println(loCol);

		greenScaler = (255 / (upCol - loCol));
		greenMin = loCol;

		//
		histo = imageHisto.getColorArray(Channel.BLUE);
		upCol = 0;
		loCol = 0;

		for (int i = 1; i < histo.length - 1; i++) {
			upCol = (histo[i] < histo[upCol]) ? upCol : i;
			loCol = (histo[i] > histo[loCol]) ? loCol : i;
		}

		System.out.println(upCol);
		System.out.println(loCol);

		blueScaler = ((double)255 / (upCol - loCol));
		blueMin = loCol;

		//

		BufferedImage newImage = Tools.copyBufferedImage(image);

		int r;
		int g;
		int b;
		Color imageColor = null;

		for (int i = 0; i < newImage.getWidth(); i++) {
			for (int j = 0; j < newImage.getHeight(); j++) {

				imageColor = new Color(newImage.getRGB(i, j));

				r = (int) ((imageColor.getRed() - redMin) * redScaler);
				g = (int) ((imageColor.getGreen() - greenMin) * greenScaler);
				b = (int) ((imageColor.getBlue() - blueMin) * blueScaler);

				System.out.println("imgBlue: " + imageColor.getBlue() + "  b: " + b);

				Color newColor = new Color(r, g, b);

				newImage.setRGB(i, j, newColor.getRGB());

			}
		}

		return newImage;
	}

}
