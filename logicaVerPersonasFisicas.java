package logica;
 
import static GUI.verPersonasFisicas.lblCalif;
import static GUI.verPersonasFisicas.lblCategoria;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class logicaVerPersonasFisicas {
    public static void obtenerNombre(String cedula) throws Exception{
        try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre,PrimerApellido,SegundoApellido FROM PersonaFisica WHERE Cedula=?");  
                    ps.setString(1,cedula);
                    ResultSet rs = ps.executeQuery();  
                    String cats="";
                    rs.next();
                    cats+=rs.getString("Nombre")+" "+rs.getString("PrimerApellido")+" "+rs.getString("SegundoApellido");
                    GUI.verPersonasFisicas.lblNombre.setText(cats);
                    rs.close();  
                    ps.close();  
            }
         catch (Exception e) {  
                throw e;  
            } 
    }
    
    public static void obtenerCategoria(String cedula) throws Exception{
        try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("CALL Id_Persona(?)");  
                    ps.setString(1,cedula);
                    ResultSet rs = ps.executeQuery();  
                    rs.next();
                    String idPer=rs.getString("idPersonaFisica");
                    
                    String cats="";
                    
                    ps = (PreparedStatement) connection.prepareStatement("SELECT idCategoria FROM CategoriaPorPersonaFisica WHERE idPersona=?");  
                    ps.setString(1,idPer);
                    rs = ps.executeQuery();  
                    rs.next();
                    String idCat=rs.getString("idCategoria");
                    
                    ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Categoria WHERE idCategoria=?");  
                    ps.setString(1,idCat);
                    rs = ps.executeQuery();
                    rs.next();
                    cats+=rs.getString("Nombre");
                    
                    GUI.verPersonasFisicas.lblCategoria.setText(cats);
                    rs.close();  
                    ps.close();  
            }
         catch (Exception e) {  
                throw e;  
            } 
    }

    public static void obtenerPromedio(String cedula) throws e, Exception{
        try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("CALL promedioPersFis(?)");  
                    ps.setString(1,cedula);
                    ResultSet rs = ps.executeQuery();  
                    String cats="";
                    rs.next();
                    cats+=rs.getString(1);
                   GUI.verPersonasFisicas.lblCalif.setText(cats);
                    rs.close();  
                    ps.close();  
            }
         catch (Exception e) {  
                throw e;  
            } 
        
    }
    
    public static void obtenerReviews(String cedula, String idCalificacion) throws e, Exception{
           try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("CALL Id_Persona(?)");
                    ps.setString(1,cedula);
                    ResultSet rs = ps.executeQuery();  
                    rs.next();
                    String idPersona=rs.getString(1);
                    
                    ps = (PreparedStatement) connection.prepareStatement("SELECT review FROM CalifPersFis WHERE idPersona=? AND idCalifcacion=?");  
                    ps.setString(1,idPersona);
                    ps.setString(2,idCalificacion);
                    rs = ps.executeQuery();  
                    String cats="";
                    rs.next();
                    cats+=rs.getString(1);
                    GUI.verPersonasFisicas.textArea.setText(cats);
                    rs.close();  
                    ps.close();  
            }
         catch (Exception e) {  
                throw e;  
            } 
        
    }
}
