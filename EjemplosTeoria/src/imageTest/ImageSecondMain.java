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

		ImageSecondMain.blackWhiteImage(imagen);

		try {
			File outputfile = new File("write/mi_imagen.png");
			ImageIO.write(imagen, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void blackWhiteImage(BufferedImage imagen) {

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				int newBaseColor = (int) ((imageColor.getRed() + imageColor.getGreen() + imageColor.getBlue()) / 3);

				Color newColor = new Color(newBaseColor, newBaseColor, newBaseColor);

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	private static void mainColor(BufferedImage imagen) {

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

	private static void changeColors(BufferedImage imagen) {
		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

				Color imageColor = new Color(imagen.getRGB(i, j));

				Color newColor = new Color(imageColor.getGreen(), imageColor.getBlue(), imageColor.getRed());

				imagen.setRGB(i, j, newColor.getRGB());

			}
		}
	}

	private static void blackOrWhite(BufferedImage imagen) {

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

	private static void createNewImage(BufferedImage imagen) {

		BufferedImage nuevaImagen = new BufferedImage(imagen.getWidth(), imagen.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < imagen.getWidth(); i++) {
			for (int j = 0; j < imagen.getHeight(); j++) {

			}
		}

	}

	private static boolean comprobarVecinos(int x, int y, BufferedImage imagen) {

		Color imageColor = new Color(imagen.getRGB(x, y));

		// Color SI
		int newX = x - 1;
		int newY = y - 1;

		if (newX >= 0 && newY >= 0) {
			Color newColor = new Color(imagen.getRGB(newX, newY));

		}

	}

	private static boolean checkClass(Color oldColor, Color newColor) {
		final int COLOR_RANGE = 25;

		boolean redClass = (oldColor.getRed() + COLOR_RANGE > newColor.getRed()
				&& oldColor.getRed() - COLOR_RANGE < newColor.getRed());

		boolean greenClass = (oldColor.getGreen() + COLOR_RANGE > newColor.getGreen()
				&& oldColor.getGreen() - COLOR_RANGE < newColor.getGreen());

		boolean blueClass = (oldColor.getBlue() + COLOR_RANGE > newColor.getBlue()
				&& oldColor.getBlue() - COLOR_RANGE < newColor.getBlue());

		return (redClass && greenClass && blueClass);
	}

}
