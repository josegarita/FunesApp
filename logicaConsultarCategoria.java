package logica;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class logicaConsultarCategoria {
	
	public static void consultar() throws Exception{
            try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("Call consultaCategoria()");  
                    ResultSet rs = ps.executeQuery();  
                    String cats="";
                    int cont=1;
                    while(rs.next()){  
                          cats+=Integer.toString(cont)+".  "+rs.getString("Nombre")+"\n";
                          cont++;
                    }  
                    GUI.consultarCategoria.textArea.setText(cats);
                    rs.close();  
                    ps.close();  
            }
            catch (Exception e) {  
                throw e;  
            } 
	}
}
