
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
    
    public static void RegisrtarCargo(String pNombre) throws ClassNotFoundException{
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarCargo(?)");
            pstat.setString(1,pNombre);
            ResultSet rs = pstat.executeQuery();  
            
            rs.close();  
            pstat.close();  
        } catch (SQLException e) {  
            
        } 
		GUI.consultarPersona.nom=GUI.consultarPersona.pA=GUI.consultarPersona.sA=GUI.consultarPersona.ced=null;
	}
    
}
    
