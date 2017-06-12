package ejemplos.trycatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ErroresPrueba {

	public static void main(String[] args) {

		String cadena = null;

		int i = 21;

		try {

			i++;
			System.out.println(i);

			String url = "url";
			String user = "user";
			String password = "password";

			Connection conexion = DriverManager.getConnection(url, user, password);

			Statement stmt = conexion.createStatement();

			conexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("AQUÍ HA HABIDO UN ERROR");
		} finally {
			System.out.println("siempre lo escribiré");
		}

		System.out.println(i);

	}

}
