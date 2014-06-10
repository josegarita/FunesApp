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
	
	public static boolean registrar(String cedula, String nombre, String apellido, String sApellido, int genero, String fechaNacimiento, String cargo, String lugarTrabajo, String categoria){
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
                        registrarInstitucionCargo(cargo, lugarTrabajo, cedula);
                        registrarCategoriaPersona(categoria, cedula);
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
                String idInstitucion, idCargo;
                try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL Id_Institucion(?)");
			pstat.setString(1,institucion);
                        ResultSet rs=pstat.executeQuery();
                        rs.next();
                        idInstitucion=rs.getString("Id_institucion");
                        
                        pstat = (PreparedStatement) connection.prepareStatement("CALL ID_cargo(?)");
			pstat.setString(1,cargo);
                        rs=pstat.executeQuery();
                        rs.next();
                        idCargo=rs.getString("idCargo");
                        
                        pstat = (PreparedStatement) connection.prepareStatement("CALL insertarInstitucionLabora(?,?,?,?)");
                        pstat.setString(1,idInstitucion);
                        pstat.setString(2,null);
                        pstat.setString(3,null);
                        pstat.setString(4,idCargo);
                        pstat.executeQuery();
                        		
		}
		catch(SQLException | ClassNotFoundException ex){
                    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
        }

        public static void registrarCategoriaPersona(String categoria, String cedulaPersona){
            String idCategoria, idPersona;
                try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
			PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL Id_Categoria(?)");
			pstat.setString(1,categoria);
                        ResultSet rs=pstat.executeQuery();
                        rs.next();
                        idCategoria=rs.getString("idCategoria");
                        
                        
                        pstat = (PreparedStatement) connection.prepareStatement("CALL Id_Persona(?)");
                        pstat.setString(1,cedulaPersona);
                        rs=pstat.executeQuery();
                        rs.next();
                        idPersona=rs.getString("idPersonaFisica");
                        
                        pstat = (PreparedStatement) connection.prepareStatement("CALL insertarCategoriaPorPersonaFisica(?,?)");
                        pstat.setString(1,idPersona);
                        pstat.setString(2,idCategoria);
                        pstat.executeQuery();                        		
		}
		catch(SQLException | ClassNotFoundException ex){
                    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
        }
        
}
