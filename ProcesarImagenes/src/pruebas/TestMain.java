package pruebas;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class TestMain {

	private static final String IMAGE_ROUTE = "data/testImages/";
	private static final String WRITE_ROUTE = "write/test/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			URL url1 = new URL("http://www.cats.org.uk/uploads/images/featurebox_sidebar_kids/grief-and-loss.jpg");
			URL url2 = new URL("http://www.petmd.com/sites/default/files/what-does-it-mean-when-cat-wags-tail.jpg");
			URL url3 = new URL(
					"http://static.boredpanda.com/blog/wp-content/uploads/2016/04/beautiful-fluffy-cat-british-longhair-2.jpg");

			URLConnection conn1 = url1.openConnection();
			URLConnection conn2 = url2.openConnection();
			URLConnection conn3 = url3.openConnection();

			BufferedImage img1 = ImageIO.read(conn1.getInputStream());
			BufferedImage img2 = ImageIO.read(conn2.getInputStream());
			BufferedImage img3 = ImageIO.read(conn3.getInputStream());

			BufferedImage gatoMezcla = MultipleOperators.unite(img1, img2, img3);

			File outputfile = new File(WRITE_ROUTE + "/horror.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
