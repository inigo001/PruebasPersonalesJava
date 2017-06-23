package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import operators.MultipleOperators;

public class CrearSprites {

	public static void main(String[] args) throws IOException {

		System.out.println("Iniciando creación de Sprites");

		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles();

		String[] nameSplit;
		BufferedImage image;
		List<BufferedImage> imagesList = new ArrayList<BufferedImage>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				nameSplit = listOfFiles[i].getName().split("\\.");

				if (nameSplit[nameSplit.length - 1].equals("png")) {
					image = ImageIO.read(listOfFiles[i]);
					imagesList.add(image);
				}

			}
		}

		BufferedImage[] images = new BufferedImage[imagesList.size()];
		imagesList.toArray(images);

		image = MultipleOperators.spriteCreator(images);

		File outputfile = new File(folder.getPath() + "/sprite.png");
		ImageIO.write(image, "png", outputfile);

	}

}
