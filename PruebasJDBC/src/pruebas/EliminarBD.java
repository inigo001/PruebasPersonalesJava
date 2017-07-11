package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EliminarBD {

	public static void main(String[] args) {

		// Al atacar una base de datos tenemos 4 datos importantes para
		// conectarnos:
		//
		// - driver: Driver de la base de datos que usamos
		// - url: Url para conectarnos a la base de datos
		// - user: El usuario que se va a conectar
		// - password: Contrase�a de usuario

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/curso";
		String user = "root";
		String password = "admin";

		try {
			// El .jar ha de estar en tiempo de ejecuci�n
			// Aqu� cargamos la clase en tiempo de ejecuci�n, hacemos un LOAD.
			//
			// Al hacer un LOAD, la clase se carga en la m�quina virtual y el
			// DriverManager lo puede usar. Es el DriverManager quien despu�s
			// utiliza esta clase que estamos cargando aqu� (busca alguna clase
			// que implemente la interfaz Driver).
			Class.forName(driver);

			// Creamos la conexi�n f�sica a base de datos.
			Connection conexion = DriverManager.getConnection(url, user, password);

			// Creamos un objeto statement, un lanzador de sentencias SQL
			Statement stmt = conexion.createStatement();
			// Creamos la sentencia SQL
			String sentenciaSql = "insert into usuario(user,password) values ('cesar','cesar')";
			System.out.println("sentenciaSql:" + sentenciaSql);

			// Ejecuto la sentencia SQL contra la base de datos
			stmt.executeUpdate(sentenciaSql);

			// Cerramos los recursos que hemos abierto
			stmt.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
