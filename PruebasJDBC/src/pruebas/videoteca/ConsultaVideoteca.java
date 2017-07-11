package pruebas.videoteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// NO FUNTZIONA!!!!

public class ConsultaVideoteca {

	public static void main(String[] args) {

		// Al atacar una base de datos tenemos 4 datos importantes para
		// conectarnos:
		//
		// - driver: Driver de la base de datos que usamos
		// - url: Url para conectarnos a la base de datos
		// - user: El usuario que se va a conectar
		// - password: Contraseña de usuario

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/videoteca";
		String user = "root";
		String password = "admin";

		try {

			BufferedReader in = new BufferedReader(new FileReader("data/consulta.sql"));

			String query = "";

			String str;
			while ((str = in.readLine()) != null) {
				query += str;
			}

			in.close();

			Class.forName(driver);
			Connection conexion = DriverManager.getConnection(url, user, password);
			Statement stmt = conexion.createStatement();
			String sentenciaSql = query;
			System.out.println("sentenciaSql:" + sentenciaSql);

			// Esto eslo que cambia.
			// En vez de ExecuteUpdate hacemos un ExecuteQuery, que nos devuelve
			// un ResultSet
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayMas = rs.next();

			// Esto funciona como un iterator, mas menos (AUNQUE NO ES UNO).
			String consulta;
			while (hayMas) {

				consulta = "| ";

				consulta += "id:" + rs.getString(1) + " | ";
				consulta += "titulo:" + rs.getString(2) + " | ";
				consulta += "ano:" + rs.getString(3) + " | ";
				consulta += "imdb:" + rs.getString(4) + " | ";
				consulta += "soporte:" + rs.getString(5) + " | ";
				consulta += "genero:" + rs.getString(6) + " | ";

				System.out.println(consulta);

				hayMas = rs.next();
			}

			rs.close();
			stmt.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
