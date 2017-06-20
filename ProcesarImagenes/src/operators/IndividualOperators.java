package operators;

import java.awt.Color;
import java.awt.image.BufferedImage;

import tools.Tools;

public class IndividualOperators {

	private IndividualOperators() {

	}

	// Imagen en escala de grises

	public static BufferedImage greyScale(BufferedImage image) {

		BufferedImage greyScaleImage = Tools.copyBufferedImage(image);

		for (int i = 0; i < greyScaleImage.getWidth(); i++) {
			for (int j = 0; j < greyScaleImage.getHeight(); j++) {

				Color imageColor = new Color(greyScaleImage.getRGB(i, j));
				int newBaseColor = (int) ((imageColor.getRed() + imageColor.getGreen() + imageColor.getBlue()) / 3);
				Color newColor = new Color(newBaseColor, newBaseColor, newBaseColor);
				greyScaleImage.setRGB(i, j, newColor.getRGB());
			}
		}

		return greyScaleImage;
	}

	// Negativo de la imagen

	public static BufferedImage imageNegative(BufferedImage image) {

		BufferedImage negativeImage = Tools.copyBufferedImage(image);

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {

				Color imageColor = new Color(negativeImage.getRGB(i, j));

				Color newColor = new Color(255 - imageColor.getRed(), 255 - imageColor.getGreen(),
						255 - imageColor.getBlue());

				negativeImage.setRGB(i, j, newColor.getRGB());
			}
		}

		return negativeImage;
	}

	// Imagen en blanco y negro con en base a un color. Lo hace en base a una
	// imagen en escala de grises que crea antes.

	public static BufferedImage imageUmbral(BufferedImage image, int umbral) {
		return IndividualOperators.umbral(image, umbral, umbral, false);
	}

	public static BufferedImage imageInvertedUmbral(BufferedImage image, int umbral) {
		return IndividualOperators.umbral(image, umbral, umbral, true);
	}

	public static BufferedImage imageBinaryUmbral(BufferedImage image, int lowerLimit, int upperLimit) {
		return IndividualOperators.umbral(image, lowerLimit, upperLimit, false);
	}

	public static BufferedImage imageInvertedBinaryUmbral(BufferedImage image, int lowerLimit, int upperLimit) {
		return IndividualOperators.umbral(image, lowerLimit, upperLimit, true);
	}

	private static BufferedImage umbral(BufferedImage image, int umbralDown, int umbralUp, boolean inverted) {
		BufferedImage umbralImage = IndividualOperators.greyScale(image);

		for (int i = 0; i < umbralImage.getWidth(); i++) {
			for (int j = 0; j < umbralImage.getHeight(); j++) {

				Color imageColor = new Color(umbralImage.getRGB(i, j));

				if (imageColor.getRed() > umbralUp) {
					imageColor = (!inverted) ? new Color(255, 255, 255) : new Color(0, 0, 0);
				} else if (imageColor.getRed() < umbralDown && !(umbralUp <= umbralDown)) {
					imageColor = (!inverted) ? new Color(255, 255, 255) : new Color(0, 0, 0);
				} else {
					imageColor = (inverted) ? new Color(255, 255, 255) : new Color(0, 0, 0);
				}

				umbralImage.setRGB(i, j, imageColor.getRGB());

			}
		}

		return umbralImage;
	}

	// Umbral en escala de grises

	public static BufferedImage greyImageUmbral(BufferedImage image, int lowerLimit, int upperLimit) {
		return IndividualOperators.greyUmbral(image, lowerLimit, upperLimit, false);
	}

	public static BufferedImage invertedGreyImageUmbral(BufferedImage image, int lowerLimit, int upperLimit) {
		return IndividualOperators.greyUmbral(image, lowerLimit, upperLimit, true);
	}

	private static BufferedImage greyUmbral(BufferedImage image, int umbralDown, int umbralUp, boolean inverted) {

		BufferedImage umbralImage = IndividualOperators.greyScale(image);

		for (int i = 0; i < umbralImage.getWidth(); i++) {
			for (int j = 0; j < umbralImage.getHeight(); j++) {

				Color imageColor = new Color(umbralImage.getRGB(i, j));

				if (imageColor.getRed() > umbralUp) {
					imageColor = new Color(255, 255, 255);
				} else if (imageColor.getRed() < umbralDown && !(umbralUp <= umbralDown)) {
					imageColor = new Color(255, 255, 255);
				} else if (inverted) {
					imageColor = new Color(255 - imageColor.getRed(), 255 - imageColor.getGreen(),
							255 - imageColor.getBlue());
				}

				umbralImage.setRGB(i, j, imageColor.getRGB());

			}
		}

		return umbralImage;
	}

	// Umbral escala de grises color completo

	public static BufferedImage extensionUmbral(BufferedImage image, int lowerLimit, int upperLimit) {
		return IndividualOperators.extension(image, lowerLimit, upperLimit, false);
	}

	private static BufferedImage invertedExtensionUmbral(BufferedImage image, int lowerLimit, int upperLimit) {
		return IndividualOperators.extension(image, lowerLimit, upperLimit, true);
	}

	private static BufferedImage extension(BufferedImage image, int umbralDown, int umbralUp, boolean inverted) {

		BufferedImage umbralImage = (!inverted) ? IndividualOperators.greyImageUmbral(image, umbralDown, umbralUp)
				: IndividualOperators.invertedGreyImageUmbral(image, umbralDown, umbralUp);

		int multiplier = (255 / (umbralUp - umbralDown));

		for (int i = 0; i < umbralImage.getWidth(); i++) {
			for (int j = 0; j < umbralImage.getHeight(); j++) {

				Color imageColor = new Color(umbralImage.getRGB(i, j));

				if (imageColor.getRed() <= umbralUp && imageColor.getRed() >= umbralDown) {

					int colorNumber = (imageColor.getRed() - umbralDown) * multiplier;
					imageColor = new Color(colorNumber, colorNumber, colorNumber);

				}

				umbralImage.setRGB(i, j, imageColor.getRGB());

			}
		}

		return umbralImage;
	}


}
