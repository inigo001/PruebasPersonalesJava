package compressiontest;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CompressionMain {

	public static void main(String[] args) {

		try {
			URL url = new URL(
					"http://opendata.euskadi.eus/contenidos/ds_eventos/agenda_cultura_euskadi/es_kultura/adjuntos/kulturklik.xml");

			URLConnection conn = url.openConnection();

			byte[] bytes = Tools.inputStreamToBytes(conn.getInputStream());
			byte[] newBytes = Tools.compressAndEncrypt(bytes);

			Tools.writeFile(newBytes, "write/compressedXML.mdio");

			byte[] oldBytes = Tools.decompressAndDescrypt(newBytes);

			Tools.writeFile(oldBytes, "write/mixml.xml");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
