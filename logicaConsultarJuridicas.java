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
import javax.swing.JOptionPane;

/**
 *
 * @author JoseGarita
 */
public class logicaConsultarJuridicas {
    public static void consultar(String pNombre, String pCedula) throws Exception{
            try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("Call consultaPerJuridica(?,?)");
            pstat.setString(1,pNombre);
            pstat.setString(2,pCedula);
            ResultSet rs = pstat.executeQuery();  
            String cats="";
            int cont=1;
            while(rs.next()){  
            	  cats+=Integer.toString(cont)+".  "+rs.getString("Nombre")+" "+rs.getString("Cedula")+"\n";
                  cont++;
            }  
            GUI.MostrarPersonaJuridica.getTextAreaMostrar().setText(cats);
            rs.close();  
            pstat.close();  
        } catch (ClassNotFoundException | SQLException e) {  
                JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "ERROR", 3);
        } 
		GUI.consultarPersona.nom=GUI.consultarPersona.pA=GUI.consultarPersona.sA=GUI.consultarPersona.ced=null;
	}
}
