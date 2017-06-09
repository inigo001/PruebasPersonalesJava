package imageTest;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedImage imagen = null;

		try {
			imagen = ImageIO.read(new File("data/minimagen1.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Raster imageRaster = imagen.getData();

		int imageElements = imageRaster.getNumDataElements();

		// System.out.println(imageRaster.getDataBuffer().getSize());
		DataBuffer imageData = imageRaster.getDataBuffer();

		int i = 0;

		ArrayList<Integer> colors = new ArrayList<Integer>();

		while (i < imageData.getSize()) {

			int imgR = imageData.getElem(i);
			int imgG = imageData.getElem(i + 1);
			int imgB = imageData.getElem(i + 2);

			if (imgR > 128 && imgG > 128 && imgB > 128) {
				colors.add(0);
			} else {
				colors.add(1);
			}

			i = i + imageElements;

		}

		i = 0;

		int[][] pixelBlock = new int[imagen.getHeight()][imagen.getWidth()];

		for (int k = 0; k < pixelBlock.length; k++) {

			for (int j = 0; j < pixelBlock[k].length; j++) {

				pixelBlock[k][j] = colors.get(i);
				i++;

			}
		}

		String prueba = "";

		for (int k = 0; k < pixelBlock.length; k++) {

			for (int j = 0; j < pixelBlock[k].length; j++) {

				// System.out.print(pixelBlock[k][j]);
				prueba += pixelBlock[k][j];

			}

			prueba += "\n";
			// System.out.print("\n");
		}

		System.out.println(colors.size());

		BufferedWriter writer = null;

		File dibujoFile = new File("write/dibujito.txt");

		try {
			writer = new BufferedWriter(new FileWriter(dibujoFile));
			writer.write(prueba);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
