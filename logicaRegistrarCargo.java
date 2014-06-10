/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class logicaRegistrarCargo {
    
    public static void registarCargo(String pNombre) throws ClassNotFoundException{
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarcargo(?)");
            pstat.setString(1,pNombre);
            ResultSet rs = pstat.executeQuery();  
            
            rs.close();  
            pstat.close();  
        } catch (SQLException e) {  
            
        } 
		
	}
    
}
    
