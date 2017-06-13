package pruebas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Histogram {

	private BufferedImage image;

	public Histogram(BufferedImage image) {
		this.image = image;
	}

	public int[] getColorArray(Channel channel) {

		int[] brightnessList = new int[256];

		for (int i = 0; i < this.image.getWidth(); i++) {
			for (int j = 0; j < this.image.getHeight(); j++) {

				Color pixelColor = new Color(this.image.getRGB(i, j));
				int pixelBrightness;

				switch (channel) {
				case RED:
					pixelBrightness = pixelColor.getRed();
					break;
				case GREEN:
					pixelBrightness = pixelColor.getGreen();
					break;
				case BLUE:
					pixelBrightness = pixelColor.getBlue();
					break;
				case BRIGHTNESS:
				default:
					pixelBrightness = (int) ((pixelColor.getRed() + pixelColor.getGreen() + pixelColor.getBlue()) / 3);
				}

				brightnessList[pixelBrightness] = brightnessList[pixelBrightness] + 1;

			}
		}

		return brightnessList;

	}

	public BufferedImage getHistoImage() {
		return this.getHistoImage(Channel.BRIGHTNESS, 800, 3);
	}

	public BufferedImage getHistoImage(Channel channel) {
		return this.getHistoImage(channel, 800, 3);
	}

	public BufferedImage getHistoImage(Channel channel, int height, int widthMultiplier) {

		final int IMAGE_PIXEL_WIDTH = 256;

		int[] brightness = this.getColorArray(channel);

		int maxBrightness = 0;

		for (int bright : brightness) {
			maxBrightness = (maxBrightness < bright) ? bright : maxBrightness;
		}

		double heightMultiplier = ((double) height / maxBrightness);

		BufferedImage histoImage = new BufferedImage(IMAGE_PIXEL_WIDTH * widthMultiplier, height,
				BufferedImage.TYPE_INT_RGB);
		this.clearBufferedImage(histoImage);

		for (int i = 0; i < IMAGE_PIXEL_WIDTH; i++) {

			for (int j = histoImage.getHeight() - 1; j > (histoImage.getHeight()
					- (brightness[i] * heightMultiplier)); j--) {

				for (int k = 0; k < widthMultiplier; k++) {
					histoImage.setRGB((i * widthMultiplier) + k, j, channel.getColor().getRGB());
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
