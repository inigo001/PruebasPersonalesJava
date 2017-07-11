package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertarBDPrepared {

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

			// Parametrizamos la secuencia SQL para poder insertar cualquier
			// valor sin problema.
			// De esta amnera no hay que compilar cada vez que queramos una
			// sentencia SQL (los INSERT si que los tenemos que re-repetir :O).
			String sentenciaSql = "insert into usuario(user,password) values (?,?)";

			System.out.println("sentenciaSql:" + sentenciaSql);

			PreparedStatement pStmt = conexion.prepareStatement(sentenciaSql);
			pStmt.setString(1, "iker");
			pStmt.setString(2, "iker");
			pStmt.executeUpdate();

			pStmt.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
