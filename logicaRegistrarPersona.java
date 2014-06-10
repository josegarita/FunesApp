package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class logicaRegistrarPersona {
    
	public static boolean comprobarCedula(String cedula){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("SELECT personaExistente(?)");
			pstat.setString(1,cedula);
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
	
	public static boolean registrar(String cedula, String nombre, String apellido, String sApellido, int genero, String fechaNacimiento, String cargo, String lugarTrabajo){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarPersonaFis(?,?,?,?,?,?,?)");
			pstat.setString(1,cedula);
			pstat.setString(2,nombre);
			pstat.setString(3,apellido);
			pstat.setString(4,sApellido);
			pstat.setString(5,fechaNacimiento);
			pstat.setString(6,Integer.toString(genero));
			pstat.setInt(7,3);
			pstat.executeQuery();
			return true;
		}
		catch(SQLException | ClassNotFoundException ex){
                    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		    return false;
		}
	}

        public static void registrarInstitucionCargo(String cargo, String institucion, String cedulaPersona){
            
        }
}
