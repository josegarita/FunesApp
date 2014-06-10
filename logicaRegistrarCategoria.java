package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class logicaRegistrarCategoria {
	
	public static void Registrar(String nombre){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarCategoria(?)");
			pstat.setString(1,nombre);
			pstat.executeQuery();
		}
		catch(SQLException | ClassNotFoundException ex){
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
}
