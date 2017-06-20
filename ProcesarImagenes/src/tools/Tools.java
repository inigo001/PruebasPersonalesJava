package tools;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class Tools {

	private Tools() {
	}

	public static void showArrayContent(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " -- " + array[i]);
		}

	}

	public static BufferedImage copyBufferedImage(BufferedImage image) {
		ColorModel cm = image.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = image.copyData(null);
		return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}

	public static void clearBufferedImage(BufferedImage imagen) {

		for (int i = 0; i < imagen.getWidth(); i++) {

			for (int j = 0; j < imagen.getHeight(); j++) {
				imagen.setRGB(i, j, (new Color(255, 255, 255)).getRGB());
			}
		}

	}

	public static boolean checkNeighbours(int x, int y, BufferedImage imagen, int neighbourLength, int colorDistance) {

		Color imageColor = new Color(imagen.getRGB(x, y));

		boolean noClash = true;

		for (int newX = x - neighbourLength; (newX <= x + neighbourLength) && (noClash); newX++) {

			if (newX >= 0 && newX < imagen.getWidth()) {

				for (int newY = y - neighbourLength; (newY <= y + neighbourLength) && (noClash); newY++) {

					if (newY >= 0 && newY < imagen.getHeight()) {

						Color newColor = new Color(imagen.getRGB(newX, newY));
						noClash = (checkClash(imageColor, newColor, colorDistance));

					}

				}

			}

		}

		return noClash;

	}

	private static boolean checkClash(Color oldColor, Color newColor, int colorDistance) {

		boolean redClass = (oldColor.getRed() + colorDistance > newColor.getRed()
				&& oldColor.getRed() - colorDistance < newColor.getRed());

		boolean greenClass = (oldColor.getGreen() + colorDistance > newColor.getGreen()
				&& oldColor.getGreen() - colorDistance < newColor.getGreen());

		boolean blueClass = (oldColor.getBlue() + colorDistance > newColor.getBlue()
				&& oldColor.getBlue() - colorDistance < newColor.getBlue());

		return redClass && (greenClass || blueClass) || (greenClass && blueClass);
	}

}
