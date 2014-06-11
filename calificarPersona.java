package GUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;

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

public class calificarPersona {

	private JFrame frame;
        private JButton btnBuscar;
        public static JLabel lblPersona;
        private JLabel lblTitulo, lblCalif, lblReview;
        private JComboBox<String> comboBoxCedula;
        private JComboBox comboBoxCalificacion;
        final private static String[] calif = {"1","2","3","4","5","6","7","8","9","10"};
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
        
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calificarPersona window = new calificarPersona();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calificarPersona() throws Exception {
		initialize();
	}

	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Calificar persona");
                frame.setResizable(false);

		lblTitulo = new JLabel("Seleccione la persona");
		lblTitulo.setBounds(105, 12, 190, 15);
		frame.getContentPane().add(lblTitulo);
                
                comboBoxCedula = new JComboBox();
		comboBoxCedula.setModel(comboBoxModelCedula());
		comboBoxCedula.setBounds(35, 54, 125, 19);
		frame.getContentPane().add(comboBoxCedula);
                
                comboBoxCalificacion = new JComboBox();
                comboBoxCalificacion.setModel(new DefaultComboBoxModel(calif));
                comboBoxCalificacion.setBounds(200,150,50,20);
                frame.getContentPane().add(comboBoxCalificacion);
                
                lblCalif = new JLabel("Calificación");
                lblCalif.setBounds(comboBoxCalificacion.getX()+60, comboBoxCalificacion.getY(), 160, 25);
                frame.getContentPane().add(lblCalif);
                
                lblReview = new JLabel("Review");
		lblReview.setBounds(60, 85, 160, 25);
		frame.getContentPane().add(lblReview);
                
                lblPersona = new JLabel(" ");
		lblPersona.setBounds(180, 50, 160, 25);
		frame.getContentPane().add(lblPersona);
                
                textArea = new JTextArea();
		textArea.setBounds(31, 74, 181, 200);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setLocation(12, 105);
		sp.setSize(170, 150);
		frame.getContentPane().add(sp);
                
                JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(comboBoxCalificacion.getX()+25, comboBoxCalificacion.getY()+60, 100, 20);
		frame.getContentPane().add(btnCalificar);
                                
                comboBoxCedula.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            try {
                                logica.logicaCalificarPersona.obtenerNombre((String)comboBoxCedula.getSelectedItem());
                            } catch (Exception ex) {
                                Logger.getLogger(calificarPersona.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }            
                );
                
                btnCalificar.addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            try {
                                logica.logicaCalificarPersona.calificar((String)comboBoxCedula.getSelectedItem(),(String)comboBoxCalificacion.getSelectedItem(),textArea.getText());
                                JOptionPane.showMessageDialog(null, "Calificación registrada","Correcto",JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception ex) {
                                Logger.getLogger(calificarPersona.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }            
                );
	}
}
