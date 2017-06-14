package serializeTeoria;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeMain {

	public static void main(String[] args) {

		Persono persono1 = new Persono("Adalberto", 12, 25);
		Persono persono2 = new Persono("Erminginio", 257, 12);
		Persono persono3 = new Persono("Osculiano", 9841, -89);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutput out = new ObjectOutputStream(bos);
			out.writeObject(persono1);
			out.flush();
			byte[] bytes = bos.toByteArray();

			Path path = Paths.get("write/pers1.persono");
			Files.write(path, bytes);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
