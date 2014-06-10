package logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class logicaConsultaPorCategoria {
    
    public static void consultar(String categoria) throws Exception{
         try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("Call consultaTipoCategoriaFisica(?)");  
                    ps.setString(1,categoria);
                    ResultSet rs = ps.executeQuery();  
                    String cats="";
                    
                    int cont=1;
                    while(rs.next()){  
                          cats+=Integer.toString(cont)+".  "+rs.getString("Nombre")+" "+rs.getString("PrimerApellido")+" "+rs.getString("Cedula")+"\n\n";
                          cont++;
                    } 
                    
                    ps=(PreparedStatement) connection.prepareStatement("Call consultaTipoCategoriaJuridica(?)");  
                    ps.setString(1,categoria);
                    while(rs.next()){  
                          cats+=Integer.toString(cont)+".  "+rs.getString("Nombre")+" "+rs.getString("Cedula")+"\n";
                          cont++;
                    } 
                    GUI.consultaPorCategoria.textArea.setText(cats);
                    rs.close();  
                    ps.close();  
            }
         catch (Exception e) {  
                throw e;  
            } 
    }
}
