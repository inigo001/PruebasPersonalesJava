package pruebas;

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

}
