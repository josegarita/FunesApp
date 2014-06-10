package logica;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class logicaConsultarPersonas {
	
	public static void consultar(String nombre, String priApe, String segApe, String cedula) throws Exception{
		try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("Call consultaPerFisica(?,?,?)");
            pstat.setString(1,nombre);
            pstat.setString(2,priApe);
            pstat.setString(3,cedula);
            ResultSet rs = pstat.executeQuery();  
            String cats="";
            int cont=1;
            while(rs.next()){  
            	  cats+=Integer.toString(cont)+".  "+rs.getString("Nombre")+" "+rs.getString("PrimerApellido")+" "+rs.getString("Cedula")+"\n";
                  cont++;
            }  
            GUI.consultarPersona.textArea.setText(cats);
            rs.close();  
            pstat.close();  
        } catch (Exception e) {  
            throw e;  
        } 
		GUI.consultarPersona.nom=GUI.consultarPersona.pA=GUI.consultarPersona.sA=GUI.consultarPersona.ced=null;
	}
}
