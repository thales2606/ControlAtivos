package FTT.EC.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
	public static Connection getConexaoMySQL() throws Exception {
		Connection connection = null;		
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost:3306";
			String mydatabase = "ControleAtivos";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase+"?useSSL=false";
			String username = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, username, password);
			return connection;		
	}
}
