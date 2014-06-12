package logica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class logicaRegistrarEntidad {
    private static String _Pais;
    private static String _Provincia;
    private static String _Canton;
    private static String _Distrito;
    private static String _idPersona;
    
    public static void registrarEntidad(String pNombre, String pCedula, String pPais, String pProvincia, String pCanton, String pDistrito, String pCategoria, String pSeñal) throws ClassNotFoundException{
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarPersonaJuridica(?,?)");
            pstat.setString(1,pNombre);
            pstat.setString(2,pCedula); 
            ResultSet rs=pstat.executeQuery();
            
            pstat = (PreparedStatement) connection.prepareStatement("CALL Id_pais(?)");
            pstat.setString(1,pPais);
            rs=pstat.executeQuery();
            rs.next();
            _Pais=rs.getString("idPais");

            pstat = (PreparedStatement) connection.prepareStatement("CALL ID_Provincia(?)");
            pstat.setString(1,pProvincia);
            rs=pstat.executeQuery();
            rs.next();
            _Provincia=rs.getString("idProvincia");
            
            pstat = (PreparedStatement) connection.prepareStatement("CALL ID_Canton(?)");
            pstat.setString(1,pCanton);
            rs=pstat.executeQuery();
            rs.next();
            _Canton=rs.getString("idCanton");
            
            pstat = (PreparedStatement) connection.prepareStatement("CALL ID_Distrito(?)");
            pstat.setString(1,pDistrito);
            rs=pstat.executeQuery();
            rs.next();
            _Distrito =rs.getString("idDistrito");
            
            pstat = (PreparedStatement) connection.prepareStatement("CALL Id_PersonaJuridica(?)");
            pstat.setString(1,pCedula);
            rs=pstat.executeQuery();
            rs.next();
            _idPersona =rs.getString("idPersonaJuridica");
            rs.close();
            pstat.close();
            connection.close();
            insertarDirecciones(_idPersona,_Pais, _Provincia, _Canton, _Distrito, pSeñal);
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null, "Error: "+ e.toString(), "ERROR", 3);
        } 
		
	}
    private static void insertarDirecciones(String pIdPersonaJur,String pPais, String pProvincia, String pCanton, String pDistrito, String pSeñal) throws ClassNotFoundException{
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement pstat = (PreparedStatement) connection.prepareStatement("CALL insertarDireccion(?,?,?,?,?,?,?)");
            pstat.setString(1,pPais);
            pstat.setString(2,pCanton);
            pstat.setString(3,pProvincia);
            pstat.setString(4,"1");
            pstat.setString(5,pSeñal);
            pstat.setString(6,pIdPersonaJur);
            pstat.setString(7,pDistrito);
            ResultSet rs = pstat.executeQuery();  
            rs.close();  
            pstat.close();  
            JOptionPane.showMessageDialog(null, "Correcta insercion ", "Aceptado", 1);
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error: "+ e.toString(), "ERROR", 3);
            
        } 
		
    }//CALL `funes`.`insertarDireccion`(<{pIdPais int}>, <{pIdCanton int}>, <{pIdProvincia int}>, <{pIdBarrio int}>, <{pSeñal varchar(85)}>, <{pIdPersonaJurid int}>, <{pIdDistrito int}>);
    
    }


