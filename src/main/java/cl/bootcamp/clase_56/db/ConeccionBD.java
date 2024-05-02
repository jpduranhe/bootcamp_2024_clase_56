package cl.bootcamp.clase_56.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionBD {
	
	private Connection conn;
	private static ConeccionBD instance;
	
	private ConeccionBD(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String stringConection="jdbc:mysql://localhost:3306/mascotainador";
			String user="tester";
			String pass="Prueba1234";
			conn = DriverManager.getConnection(stringConection,user,pass);
			System.out.println("Conectado a la Base de Datos");
		}catch(ClassNotFoundException ex) {
			System.out.println("Error:Driver no encontrado");
		}catch(SQLException ex) {
			System.out.println("Fallo:");
			System.out.println("SQLException:"+ ex.getMessage());
			System.out.println("SQLState:"+ ex.getSQLState());
			System.out.println("VendorError:"+ ex.getErrorCode());
		}
		
		
	}
	
	public static ConeccionBD getInstance() {
		if(instance == null) {
			System.out.println("creando la instancia");
			instance= new ConeccionBD();
		}
		
		return instance;
	}
	public Connection getConnection() {
		return this.conn;
	}

}
