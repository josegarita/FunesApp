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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseGarita
 */
public class logicaEdicion {
    
    public static void editarDatos(int pTipo,String pCedula, String pFechaNacimiento, String pGenero,String pNombre, String pNota, String pPrimerAp, String pSegundoAp) throws ClassNotFoundException{
    try {  

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement pstat= null;
            ResultSet rs;
            if(pTipo== 1){
                    pstat = (PreparedStatement) connection.prepareStatement("CALL actualizarFechaNacimiento(?, ?)");
                    pstat.setString(1,pCedula);
                    pstat.setString(2,pFechaNacimiento);
            }
            if(pTipo== 2){
                pstat = (PreparedStatement) connection.prepareStatement("CALL actualizarGenero(?,?)");
                pstat.setString(1,pCedula);
                pstat.setString(2,pGenero);
            }
              if(pTipo== 3){
                    pstat = (PreparedStatement) connection.prepareStatement("CALL actualizarNombre(?,?);");
                    pstat.setString(1,pCedula);
                    pstat.setString(2,pNombre);
              }
                if(pTipo== 4){
                    pstat = (PreparedStatement) connection.prepareStatement("CALL actualizarNota(?, ?);");
                    pstat.setString(1,pCedula);
                    pstat.setString(2,pNota);
                }
                if(pTipo== 5){
                    pstat = (PreparedStatement) connection.prepareStatement("CALL actualizarPrimerApellido(?,?);");
                    pstat.setString(1,pCedula);
                    pstat.setString(2, pPrimerAp);
                }
                if(pTipo== 6){
                    pstat = (PreparedStatement) connection.prepareStatement("CALL actualizarSegundoApellido(?,?);");
                    pstat.setString(1,pCedula);
                    pstat.setString(2,pSegundoAp);
                }
            
            rs = pstat.executeQuery();  
            
            rs.close();  
            pstat.close();  
            JOptionPane.showMessageDialog(null, "Correcto", "Editado Correctamente", 1);
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null,"Error acontecido por: "+ e.toString(),"Error", 3);
            
        } 
		
	}

}

