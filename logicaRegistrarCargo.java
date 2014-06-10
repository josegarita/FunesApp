package logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JoseGarita
 */
public class RegistrarCargo {
    
    public static void regisrtarCargo(String pNombre) throws ClassNotFoundException{
        try {  
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
	            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarCargo(?)");
	            pstat.setString(1,pNombre);
	            ResultSet rs = pstat.executeQuery();  
	            rs.close();  
	            pstat.close();  
        }
        catch(SQLException | ClassNotFoundException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
	}
    
}
    
