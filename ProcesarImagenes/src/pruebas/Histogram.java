package pruebas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Histogram {

	private BufferedImage image;

	public Histogram(BufferedImage image) {
		this.image = image;
	}

	public int[] brightness() {

		int[] brightnessList = new int[256];

		for (int i = 0; i < this.image.getWidth(); i++) {
			for (int j = 0; j < this.image.getHeight(); j++) {

				Color pixelColor = new Color(this.image.getRGB(i, j));
				int pixelBrightness = (int) ((pixelColor.getRed() + pixelColor.getGreen() + pixelColor.getBlue()) / 3);

				brightnessList[pixelBrightness] = brightnessList[pixelBrightness] + 1;

			}
		}

		return brightnessList;

	}

	public BufferedImage brightnessImage() {
		return this.brightnessImage(800, 3);
	}

	public BufferedImage brightnessImage(int height, int widthMultiplier) {

		final int IMAGE_PIXEL_WIDTH = 256;

		int[] brightness = this.brightness();

		int maxBrightness = 0;

		for (int bright : brightness) {
			maxBrightness = (maxBrightness < bright) ? bright : maxBrightness;
		}

		double heightMultiplier = ((double) height / maxBrightness);

		System.out.println(heightMultiplier);

		BufferedImage histoImage = new BufferedImage(IMAGE_PIXEL_WIDTH * widthMultiplier, height,
				BufferedImage.TYPE_INT_RGB);
		this.clearBufferedImage(histoImage);

		for (int i = 0; i < IMAGE_PIXEL_WIDTH; i++) {

			for (int j = histoImage.getHeight() - 1; j > (histoImage.getHeight()
					- (brightness[i] * heightMultiplier)); j--) {

				for (int k = 0; k < widthMultiplier; k++) {
					histoImage.setRGB((i * widthMultiplier) + k, j, (new Color(127, 127, 127)).getRGB());
				}

			}
		}

		return histoImage;

	}

	private void clearBufferedImage(BufferedImage imagen) {

		for (int i = 0; i < imagen.getWidth(); i++) {

			for (int j = 0; j < imagen.getHeight(); j++) {
				imagen.setRGB(i, j, (new Color(255, 255, 255)).getRGB());
			}
		}

	}

}
