package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsultarBD {

	public static void main(String[] args) {

		// Al atacar una base de datos tenemos 4 datos importantes para
		// conectarnos:
		//
		// - driver: Driver de la base de datos que usamos
		// - url: Url para conectarnos a la base de datos
		// - user: El usuario que se va a conectar
		// - password: Contraseña de usuario

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/curso";
		String user = "root";
		String password = "admin";

		try {

			Class.forName(driver);
			Connection conexion = DriverManager.getConnection(url, user, password);
			Statement stmt = conexion.createStatement();
			String sentenciaSql = "select user,password from usuario";
			System.out.println("sentenciaSql:" + sentenciaSql);

			// Esto eslo que cambia.
			// En vez de ExecuteUpdate hacemos un ExecuteQuery, que nos devuelve un ResultSet
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayMas = rs.next();

			// Esto funciona como un iterator, mas menos (AUNQUE NO ES UNO).
			while (hayMas) {
				System.out.println("usuario:" + rs.getString(1));
				System.out.println("password:" + rs.getString(2));
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
