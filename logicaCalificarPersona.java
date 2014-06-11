package logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class logicaCalificarPersona {
    
    public static void obtenerNombre(String cedula) throws Exception{
        try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre,PrimerApellido FROM PersonaFisica WHERE Cedula=?");  
                    ps.setString(1,cedula);
                    ResultSet rs = ps.executeQuery();  
                    String cats="";
                    rs.next();
                    cats+=rs.getString("Nombre")+" "+rs.getString("PrimerApellido");
                    GUI.calificarPersona.lblPersona.setText(cats);
                    rs.close();  
                    ps.close();  
            }
         catch (Exception e) {  
                throw e;  
            } 
    }

    public static void calificar(String cedula, String calificacion, String review) throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("Call iD_Persona(?)");  
            ps.setString(1,cedula);
            ResultSet rs = ps.executeQuery();  
            rs.next();
            String idPer=rs.getString("idPersonaFisica");
            
            ps = (PreparedStatement) connection.prepareStatement("Call iD_Usuario(?)");  
            ps.setString(1,logica.logicaLobbyUsuario.usuarioActual);
            rs = ps.executeQuery();  
            rs.next();
            String idUsr=rs.getString("idUsuario");
            
            ps = (PreparedStatement) connection.prepareStatement("Call insertarCalifPersFis(?,?,?,?)");  
            ps.setString(1,idPer);
            ps.setString(2,calificacion);
            ps.setString(3,review);
            ps.setString(4,idUsr);
            ps.executeQuery();
            ps.close();
            rs.close();
        }
        
        catch(Exception e){
            
        }
    }
    
}
