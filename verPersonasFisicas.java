package GUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class verPersonasFisicas {

	private JFrame frame;
        private JButton btnBuscar;
        public static JLabel lblNombre, lblNombreInd, lblCategoria, lblCategoriaInd, 
                             lblCalifInd, lblCalif, lblHistorial, lblHistorialInd;
        private JLabel lblTitulo;
        private static JComboBox<String> comboBoxCedula, comboBoxCalificaciones;
        
        public static JTextArea textArea;

	public static DefaultComboBoxModel<String> comboBoxModelCedula() throws Exception {  
            @SuppressWarnings("unchecked")
                    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel();  
            try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Cedula FROM PersonaFisica ORDER BY Cedula");  
                    ResultSet rs = ps.executeQuery();  
                    while(rs.next()){  
                        comboBoxModel.addElement((rs.getString("Cedula")));  
                    }  
                    rs.close();  
                    ps.close();  
            } catch (Exception e) {  
                throw e;  
            } 
            return comboBoxModel;  
        }
        
        public static DefaultComboBoxModel<String> comboBoxModelHistorial() throws Exception {  
            @SuppressWarnings("unchecked")
                    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel();  
            try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT idCalifcacion FROM CalifPersFis WHERE idPersona = (SELECT idPersonaFisica FROM PersonaFisica WHERE Cedula=?)");  
                    ps.setString(1, (String)comboBoxCedula.getSelectedItem());
                    ResultSet rs = ps.executeQuery();  
                    while(rs.next()){  
                        comboBoxModel.addElement((rs.getString("idCalifcacion")));  
                    }  
                    rs.close();  
                    ps.close();  
            } catch (Exception e) {  
                throw e;  
            } 
            return comboBoxModel;  
        }
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verPersonasFisicas window = new verPersonasFisicas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public verPersonasFisicas() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Buscar Personas");
                frame.setResizable(false);

		lblTitulo = new JLabel("Seleccione la persona");
		lblTitulo.setBounds(105, 12, 190, 15);
		frame.getContentPane().add(lblTitulo);
                
                comboBoxCedula = new JComboBox();
		comboBoxCedula.setModel(comboBoxModelCedula());
		comboBoxCedula.setBounds(120, 54, 125, 19);
		frame.getContentPane().add(comboBoxCedula);
                
                lblNombreInd=new JLabel("Nombre:");
		lblNombreInd.setBounds(20, 90, 160, 25);
		frame.getContentPane().add(lblNombreInd);
                
                lblNombre = new JLabel(" ");
		lblNombre.setBounds(lblNombreInd.getX()+70, lblNombreInd.getY(), 300, 25);
		frame.getContentPane().add(lblNombre);
                
                lblCategoriaInd=new JLabel("Categoria:");
		lblCategoriaInd.setBounds(20, 120, 160, 25);
		frame.getContentPane().add(lblCategoriaInd);
                
                lblCalifInd=new JLabel("Calificación:");
		lblCalifInd.setBounds(20, 150, 160, 25);
		frame.getContentPane().add(lblCalifInd);
                
                lblCalif=new JLabel(" ");
		lblCalif.setBounds(lblCalifInd.getX()+90, lblCalifInd.getY(), 160, 25);
		frame.getContentPane().add(lblCalif);
                
                lblNombre = new JLabel(" ");
		lblNombre.setBounds(lblNombreInd.getX()+70, lblNombreInd.getY(), 300, 25);
		frame.getContentPane().add(lblNombre);
                
                lblCategoria = new JLabel(" ");
		lblCategoria.setBounds(lblCategoriaInd.getX()+80, lblCategoriaInd.getY(), 300, 25);
		frame.getContentPane().add(lblCategoria);
                
                lblHistorial = new JLabel("Historial calificaciones");
                lblHistorial.setBounds(20, 180, 300, 25);
		frame.getContentPane().add(lblHistorial);
                
                comboBoxCalificaciones = new JComboBox();
		comboBoxCalificaciones.setModel(comboBoxModelHistorial());
		comboBoxCalificaciones.setBounds(70, 220, 50, 19);
		frame.getContentPane().add(comboBoxCalificaciones);
                
                textArea = new JTextArea();
		JScrollPane sp = new JScrollPane(textArea);
		sp.setSize(180, 130);
		sp.setLocation(190, 125);
		textArea.setBounds(12, 177, 294, 138);
		frame.getContentPane().add(sp);
                
                comboBoxCedula.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            try {
                                logica.logicaVerPersonasFisicas.obtenerNombre((String)comboBoxCedula.getSelectedItem());
                                logica.logicaVerPersonasFisicas.obtenerCategoria((String)comboBoxCedula.getSelectedItem());
                                logica.logicaVerPersonasFisicas.obtenerPromedio((String)comboBoxCedula.getSelectedItem());
                                comboBoxCalificaciones.setModel(comboBoxModelHistorial());
                            } catch (Exception ex) {
                                Logger.getLogger(calificarPersona.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                );
                
                comboBoxCalificaciones.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            try {
                                logica.logicaVerPersonasFisicas.obtenerReviews((String)comboBoxCedula.getSelectedItem(),(String)comboBoxCalificaciones.getSelectedItem());
                            } catch (Exception ex) {
                                Logger.getLogger(calificarPersona.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                );
                
                
	}
}
