package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import operators.IndividualOperators;
import operators.MultipleOperators;

public class TestMain1 {

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

			BufferedImage gatoMezcla = IndividualOperators.dramaticGreyScale(img3, -0.45, 0.75, 0.70);

			File outputfile = new File(WRITE_ROUTE + "/fdaf1.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.dramaticGreyScale(img3, -0.20, -0.20, 1.40);

			outputfile = new File(WRITE_ROUTE + "/fdaf2.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.luminanceGrey(img3);

			outputfile = new File(WRITE_ROUTE + "/fdaf3_lum.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.dramaticGreyScale(img3, 0.65, 0.10, 0.25);

			outputfile = new File(WRITE_ROUTE + "/fdaf4_lum.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.greyScale(img3);

			outputfile = new File(WRITE_ROUTE + "/fdaf5_grey.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
