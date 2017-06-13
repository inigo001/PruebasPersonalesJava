package pruebas;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class IndividualOperators {

	private IndividualOperators() {

	}

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

	public static BufferedImage imageUmbral(BufferedImage image, int umbral) {

		BufferedImage umbralImage = IndividualOperators.greyScale(image);

		for (int i = 0; i < umbralImage.getWidth(); i++) {
			for (int j = 0; j < umbralImage.getHeight(); j++) {

				Color imageColor = new Color(umbralImage.getRGB(i, j));

				if (imageColor.getRed() > umbral) {
					imageColor = new Color(255, 255, 255);
				} else {
					imageColor = new Color(0, 0, 0);
				}

				umbralImage.setRGB(i, j, imageColor.getRGB());

			}
		}

		return umbralImage;

	}

}
