package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String driver = "";
	private static String usuario = "JD026";
	private static String contraseña = "123456";
	
	public static Connection getConnection() throws SQLException{
		try {
			Connection cn = DriverManager.getConnection(url, usuario, contraseña);
			return cn;
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException(e);
		}
	}
	/*PARA COMPROBAR LA CONEXION
	public static void main(String [] args) {
		try {
			getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}