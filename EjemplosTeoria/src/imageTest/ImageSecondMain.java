package imageTest;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class ImageSecondMain {

	public static void main(String[] args) {

		BufferedImage imagen = null;

		try {
			imagen = ImageIO.read(new File("data/minimagen2.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// ImageSecondMain.blackWhiteImage(imagen);
		// ImageSecondMain.createNewImage(imagen);
		ImageSecondMain.invertirColores(imagen);

		try {
			File outputfile = new File("write/mi_imagen.png");
			ImageIO.write(imagen, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected static void blackWhiteImage(BufferedImage imagen) {

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				int newBaseColor = (int) ((imageColor.getRed() + imageColor.getGreen() + imageColor.getBlue()) / 3);

				Color newColor = new Color(newBaseColor, newBaseColor, newBaseColor);

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	protected static void mainColor(BufferedImage imagen) {

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor = null;

				if (imageColor.getRed() > imageColor.getBlue() && imageColor.getRed() > imageColor.getGreen()) {
					newColor = new Color(255, 0, 0);
				} else if (imageColor.getGreen() > imageColor.getBlue()
						&& imageColor.getGreen() > imageColor.getRed()) {
					newColor = new Color(0, 255, 0);
				} else if (imageColor.getBlue() > imageColor.getRed() && imageColor.getBlue() > imageColor.getGreen()) {
					newColor = new Color(0, 0, 255);
				} else {
					newColor = new Color(255, 255, 255);
				}

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}

	}

	protected static void changeColors(BufferedImage imagen) {
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor = new Color(imageColor.getGreen(), imageColor.getBlue(), imageColor.getRed());

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	protected static void blackOrWhite(BufferedImage imagen) {

		ImageSecondMain.blackWhiteImage(imagen);

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor = null;

				if (imageColor.getRed() > 127) {
					newColor = new Color(0, 0, 0);
				} else {
					newColor = new Color(255, 255, 255);
				}

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}

	}

	protected static void createNewImage(BufferedImage imagen) {

		BufferedImage nuevaImagen = new BufferedImage(imagen.getWidth(), imagen.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color nuevoColor;

				if (comprobarVecinos(i, j, imagen)) {
					nuevoColor = new Color(255, 255, 255);
				} else {
					nuevoColor = new Color(0, 0, 0);
				}

				nuevaImagen.setRGB(i, j, nuevoColor.getRGB());

			}
		}

		try {
			File outputfile = new File("write/otra_prueba.png");
			ImageIO.write(nuevaImagen, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected static void redChannel(BufferedImage imagen) {
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor = new Color(imageColor.getRed(), 0, 0);

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	protected static void multiChannel(BufferedImage imagen) {
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor;

				if (imageColor.getRed() > imageColor.getBlue() && imageColor.getRed() > imageColor.getGreen()) {
					newColor = new Color(imageColor.getRed(), 0, 0);
				} else if (imageColor.getGreen() > imageColor.getBlue()
						&& imageColor.getGreen() > imageColor.getRed()) {
					newColor = new Color(0, imageColor.getGreen(), 0);
				} else if (imageColor.getBlue() > imageColor.getRed() && imageColor.getBlue() > imageColor.getGreen()) {
					newColor = new Color(0, 0, imageColor.getBlue());
				} else {
					newColor = imageColor;
				}

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	protected static void invertirColores(BufferedImage imagen) {
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor = new Color(255 - imageColor.getRed(), 255 - imageColor.getGreen(),
						255 - imageColor.getBlue());

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	private static boolean comprobarVecinos(int x, int y, BufferedImage imagen) {

		final int COLOR_LENGTH = 1;

		Color imageColor = new Color(imagen.getRGB(x, y));

		boolean noClash = true;

		for (int newX = x - COLOR_LENGTH; (newX <= x + COLOR_LENGTH) && (noClash); newX++) {

			if (newX >= 0 && newX < imagen.getWidth()) {

				for (int newY = y - COLOR_LENGTH; (newY <= y + COLOR_LENGTH) && (noClash); newY++) {

					if (newY >= 0 && newY < imagen.getHeight()) {

						Color newColor = new Color(imagen.getRGB(newX, newY));
						noClash = (checkClass(imageColor, newColor));

					}

				}

			}

		}

		return noClash;

	}

	private static boolean checkClass(Color oldColor, Color newColor) {
		final int COLOR_RANGE = 13;

		boolean redClass = (oldColor.getRed() + COLOR_RANGE > newColor.getRed()
				&& oldColor.getRed() - COLOR_RANGE < newColor.getRed());

		boolean greenClass = (oldColor.getGreen() + COLOR_RANGE > newColor.getGreen()
				&& oldColor.getGreen() - COLOR_RANGE < newColor.getGreen());

		boolean blueClass = (oldColor.getBlue() + COLOR_RANGE > newColor.getBlue()
				&& oldColor.getBlue() - COLOR_RANGE < newColor.getBlue());

		return (redClass && greenClass && blueClass);
	}

}
