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

}
