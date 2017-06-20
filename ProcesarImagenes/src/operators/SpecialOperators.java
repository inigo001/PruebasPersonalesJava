package operators;

import java.awt.Color;
import java.awt.image.BufferedImage;

import tools.Tools;

public class SpecialOperators {

	// Pintamos los bordes de la imagen. Nos basamos en los puntos cercanos al
	// objeto (pueden ser un número distinto) y en las diferencias de color
	// entre ellos.
	public static BufferedImage paintBorders(BufferedImage image, int neighbourLength, int colorDistance) {

		BufferedImage newImage = Tools.copyBufferedImage(image);

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {

				Color nuevoColor;

				if (Tools.checkNeighbours(i, j, image, neighbourLength, colorDistance)) {
					nuevoColor = new Color(255, 255, 255);
				} else {
					nuevoColor = new Color(0, 0, 0);
				}

				newImage.setRGB(i, j, nuevoColor.getRGB());

			}
		}

		return newImage;
	}

	public static BufferedImage colorBlocks(BufferedImage image, int blockSize) {

		BufferedImage newImage = Tools.copyBufferedImage(image);

		int[] colorArray;
		Color miColor;
		int colorRGB;

		for (int i = 0; i < newImage.getWidth(); i++) {
			for (int j = 0; j < newImage.getHeight(); j++) {

				int xSize = blockSize;
				int ySize = blockSize;

				while ((i + xSize) > newImage.getWidth()) {
					xSize--;
				}

				while ((j + ySize) > newImage.getHeight()) {
					ySize--;
				}

				colorArray = image.getRGB(i, j, xSize, ySize, null, 0, blockSize);

				int red = 0;
				int green = 0;
				int blue = 0;

				for (int color : colorArray) {

					miColor = new Color(color);

					red += miColor.getRed();
					green += miColor.getGreen();
					blue += miColor.getBlue();

				}

				red = red / (xSize * ySize);
				green = green / (xSize * ySize);
				blue = blue / (xSize * ySize);

				miColor = new Color(red, green, blue);
				colorRGB = miColor.getRGB();

				for (int k = 0; k < colorArray.length; k++) {
					colorArray[k] = colorRGB;
				}

				newImage.setRGB(i, j, xSize, ySize, colorArray, 0, blockSize);

				j += (blockSize - 1);

			}

			i += (blockSize - 1);
		}

		return newImage;

	}

	public static BufferedImage changeColorLength(BufferedImage image, int colorLength) {

		BufferedImage newImage = Tools.copyBufferedImage(image);

		colorLength = (255 / colorLength);
		Color newColor;

		int r;
		int g;
		int b;

		for (int i = 0; i < newImage.getWidth(); i++) {
			for (int j = 0; j < newImage.getHeight(); j++) {

				newColor = new Color(newImage.getRGB(i, j));

				r = ((int)(newColor.getRed() / colorLength)) * colorLength;
				g = ((int)(newColor.getGreen() / colorLength)) * colorLength;
				b = ((int)(newColor.getBlue() / colorLength)) * colorLength;

				newColor = new Color(r, g, b);

				newImage.setRGB(i, j, newColor.getRGB());

			}
		}

		return newImage;

	}

}
