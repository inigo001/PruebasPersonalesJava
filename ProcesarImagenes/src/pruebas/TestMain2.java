package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// ESTOS HILOS SON UN POCO PELIGROSOS ASÍ QUE HAY QUE USARLOS CON PRECAUCIÓN

public class TestMain2 {

	private static final String IMAGE_ROUTE = "data/testImages/";
	private static final String WRITE_ROUTE = "write/test/";
	private static String imageName = "gato_4.jpg";

	private static File path;

	public static void main(String[] args) {

		try {
			BufferedImage image = ImageIO.read(new File(IMAGE_ROUTE + imageName));

			path = new File(WRITE_ROUTE + imageName.split("\\.")[0]);
			if (!path.exists())
				path.mkdir();

			for (int i = 1; i < 5; i++) {

				for (int j = 1; j < 30; j++) {
					Thread hilo1 = new Thread(new buildImage(image, i, j));

					hilo1.start();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public static class buildImage implements Runnable {

		private BufferedImage image;
		private int i;
		private int j;

		public buildImage(BufferedImage image, int i, int j) {
			this.image = image;
			this.i = i;
			this.j = j;
		}

		@Override
		public void run() {
			try {

				BufferedImage newImage = SpecialOperators.paintBorders(image, i, j);
				File outputfile = new File(path.getPath() + "/" + i + "-" + j + ".png");
				ImageIO.write(newImage, "png", outputfile);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
