package compressiontest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.zip.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Tools {

	/**
	 * Clave de cifrado
	 */
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'W', '-', 't', 'S', 'e', 'c', 'r', 'e', 't',
			'K', 'e', 'V' };

	/**
	 * @param is
	 *            InputStream del fichero
	 * @return Devuelve un array de bytes
	 * @throws Exception
	 */
	public static byte[] inputStreamToBytes(InputStream is) throws Exception {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		buffer.flush();

		return buffer.toByteArray();
	}

	public static InputStream bytesToInputStream(byte[] bytes) {
		InputStream is = new ByteArrayInputStream(bytes);
		return is;
	}

	public static byte[] compress(byte[] bytes) throws Exception {
		Deflater deflater = new Deflater();
		deflater.setInput(bytes);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);

		deflater.finish();
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer); // returns the generated
													// code... index
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();

		deflater.end();

		return output;
	}

	public static byte[] decompress(byte[] bytes) throws Exception {
		Inflater inflater = new Inflater();
		inflater.setInput(bytes);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);
		byte[] buffer = new byte[1024];
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();

		inflater.end();

		return output;
	}

	public static byte[] encrypt(byte[] bytes) throws Exception {
		Key key = new SecretKeySpec(keyValue, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(bytes);
		return encVal;
	}

	public static byte[] decrypt(byte[] bytes) throws Exception {
		Key key = new SecretKeySpec(keyValue, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, key);

		byte[] decValue = c.doFinal(bytes);
		return decValue;
	}

	public static byte[] compressAndEncrypt(byte[] bytes) throws Exception {
		bytes = Tools.compress(bytes);
		return Tools.encrypt(bytes);
	}

	public static byte[] decompressAndDescrypt(byte[] bytes) throws Exception {
		bytes = Tools.decrypt(bytes);
		return Tools.decompress(bytes);
	}

	public static void writeFile(byte[] bytes, String pathName) throws Exception {
		Path path = Paths.get(pathName);
		Files.write(path, bytes);
	}

}
