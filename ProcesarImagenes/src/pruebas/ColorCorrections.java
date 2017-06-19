package pruebas;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorCorrections {

	public static BufferedImage contrastImage(BufferedImage image, int bot, int top) {

		BufferedImage newImage = Tools.copyBufferedImage(image);

		Color color = null;
		int r;
		int g;
		int b;

		int range = top - bot;
		double multiplier = (double) 255 / range;

		for (int i = 0; i < newImage.getWidth(); i++) {
			for (int j = 0; j < newImage.getHeight(); j++) {

				color = new Color(newImage.getRGB(i, j));
				
				r = (int) ((color.getRed() - bot) * multiplier);
				g = (int) ((color.getGreen() - bot) * multiplier);
				b = (int) ((color.getBlue() - bot) * multiplier);
				
				r = (r > top) ? 255 : r;
				r = (r < bot) ? 0 : r;
				
				g = (g > top) ? 255 : g;
				g = (g < bot) ? 0 : g;
				
				b = (b > top) ? 255 : b;
				b = (b < bot) ? 0 : b;
				
				color = new Color(r, g, b);
				
				newImage.setRGB(i, j, color.getRGB());

			}
		}

		return newImage;

	}

}
