package pruebas;

import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;

import javax.imageio.ImageIO;

import operators.IndividualOperators;
import operators.MultipleOperators;

public class TestMain1 {

	private static SecureRandom random = new SecureRandom();

	private static final String WRITE_ROUTE = "write/test/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			String path = WRITE_ROUTE + TestMain1.createId();

			URL url1 = new URL("http://www.cats.org.uk/uploads/images/featurebox_sidebar_kids/grief-and-loss.jpg");
			URL url2 = new URL(
					"http://3.bp.blogspot.com/-_UbmAARUEPU/VM34c4kas-I/AAAAAAAABu8/kj3It8HxV5c/s1600/pisoi%2Bnoi%2Bapartinatori%2B3.jpg");
			URL url3 = new URL(
					"http://static.boredpanda.com/blog/wp-content/uploads/2016/04/beautiful-fluffy-cat-british-longhair-2.jpg");

			URLConnection conn1 = url1.openConnection();
			URLConnection conn2 = url2.openConnection();
			URLConnection conn3 = url3.openConnection();

			BufferedImage img1 = ImageIO.read(conn1.getInputStream());
			BufferedImage image2 = ImageIO.read(conn2.getInputStream());
			BufferedImage img3 = ImageIO.read(conn3.getInputStream());

			BufferedImage gatoMezcla = IndividualOperators.dramaticGreyScale(image2, -0.45, 0.75, 0.70);

			File outputfile = new File(path + "fdaf1.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.dramaticGreyScale(image2, -0.20, -0.20, 1.40);

			outputfile = new File(path + "fdaf2.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.luminanceGrey(image2);

			outputfile = new File(path + "fdaf3_lum.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.dramaticGreyScale(image2, 0.65, 0.10, 0.25);

			outputfile = new File(path + "fdaf4_lum.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.greyScale(image2);

			outputfile = new File(path + "fdaf5_grey.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

			gatoMezcla = IndividualOperators.maximumContrastGrey(image2);

			outputfile = new File(path + "fdaf6_maXIMUM.png");
			ImageIO.write(gatoMezcla, "png", outputfile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String createId() {
		return new BigInteger(130, random).toString(32);
	}

}
