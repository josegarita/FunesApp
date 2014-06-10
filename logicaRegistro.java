package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class logicaRegistro {
	
	public static boolean comprobarNick(String nick){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("SELECT usuarioDisponible(?)");
			pstat.setString(1,nick);
			ResultSet res = pstat.executeQuery();
			res.next();
			return res.getBoolean(1);
		}
		catch(SQLException | ClassNotFoundException ex){
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
			return false;
		}
	}
	
	public static boolean comprobarContraseñas(String pass, String passConfirmacion){
		return pass.equals(passConfirmacion);
	}
	
	public static void Registrar(String nombre, String apellido, String nick, String pass, boolean privado){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertUsuario(?,?,?,?)");
			pstat.setString(1,nombre);
			pstat.setString(2,pass);
			pstat.setString(3,nick);
			pstat.setBoolean(4,privado);
			pstat.executeQuery();
		}
		catch(SQLException | ClassNotFoundException ex){
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
}
