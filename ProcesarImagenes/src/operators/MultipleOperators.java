package operators;

import java.awt.Color;
import java.awt.image.BufferedImage;

import tools.Tools;

public class MultipleOperators {

	private MultipleOperators() {
	}

	public static BufferedImage unite(BufferedImage... images) throws Exception {

		if (images.length < 2) {
			throw new Exception("Incluye al menos dos imágenes");
		}

		int maxWidth = 0;
		int maxHeight = 0;

		for (BufferedImage image : images) {
			maxWidth = (maxWidth < image.getWidth()) ? image.getWidth() : maxWidth;
			maxHeight = (maxHeight < image.getHeight()) ? image.getHeight() : maxHeight;
		}

		int[][] red = new int[maxWidth][maxHeight];
		int[][] green = new int[maxWidth][maxHeight];
		int[][] blue = new int[maxWidth][maxHeight];

		for (BufferedImage image : images) {

			for (int i = 0; i < image.getWidth() - 1; i++) {
				for (int j = 0; j < image.getHeight() - 1; j++) {

					Color pixelColor = new Color(image.getRGB(i, j));

					red[i][j] = red[i][j] + pixelColor.getRed();
					green[i][j] = green[i][j] + pixelColor.getGreen();
					blue[i][j] = blue[i][j] + pixelColor.getBlue();

				}
			}
		}

		BufferedImage newImage = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < newImage.getWidth() - 1; i++) {
			for (int j = 0; j < newImage.getHeight() - 1; j++) {

				Color pixelColor = new Color(red[i][j] / images.length, green[i][j] / images.length,
						blue[i][j] / images.length);

				newImage.setRGB(i, j, pixelColor.getRGB());
			}
		}

		return newImage;

	}

	public static BufferedImage spriteCreator(BufferedImage... images) {

		double blockSize = Math.sqrt(images.length);
		
		if (blockSize - (int)blockSize != 0){
			blockSize++;
		}

		int xImages = (int)blockSize;
		int yImages = (int)blockSize;

		int imageWidth = images[0].getWidth() * xImages;
		int imageHeight = images[0].getHeight() * yImages;

		BufferedImage newImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		Tools.clearBufferedImage(newImage);

		int x = 0;
		int y = 0;
		int counter = 0;

		BufferedImage image;

		while (counter < images.length) {

			while (y < yImages && counter < images.length) {

				image = images[counter];

				for (int i = 0; i < image.getWidth(); i++) {
					for (int j = 0; j < image.getHeight(); j++) {

						newImage.setRGB(i + (image.getWidth() * x), j + (image.getHeight() * y), image.getRGB(i, j));
					}
				}

				counter++;
				y++;
			}

			y = 0;
			x++;

		}

		return newImage;

	}

}
