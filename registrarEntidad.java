package GUI;

import static GUI.calificarPersona.textArea;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class registrarEntidad {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldCedula;
        private JTextArea textSeñal;
        private JComboBox<String> cmBxPais;
        JComboBox<String> cmBxDistrito;
        JComboBox<String> cmBxProvincia;
        JComboBox<String> cmBxCantón;
        JComboBox<?> cmBxCategoria;
	
	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelPais() throws Exception {  
        @SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();  
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Pais ORDER BY Nombre");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                comboBoxModel.addElement((rs.getString("Nombre")));  
            }  
            rs.close();  
            ps.close();  
        } catch (Exception e) {  
            throw e;  
        } 
        return comboBoxModel;  
    }  
	
	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelCanton() throws Exception {  
        @SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();  
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Canton ORDER BY Nombre");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                comboBoxModel.addElement((rs.getString("Nombre")));  
            }  
            rs.close();  
            ps.close();  
        } catch (Exception e) {  
            throw e;  
        } 
        return comboBoxModel;  
    }  

	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelProvincia() throws Exception {  
        @SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();  
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Provincia ORDER BY Nombre");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                comboBoxModel.addElement((rs.getString("Nombre")));  
            }  
            rs.close();  
            ps.close();  
        } catch (Exception e) {  
            throw e;  
        } 
        return comboBoxModel;  
    }  
	
	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelDistrito() throws Exception {  
        @SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();  
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=root&password=sqlbases");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Distrito ORDER BY Nombre");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                comboBoxModel.addElement((rs.getString("Nombre")));  
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
					registrarEntidad window = new registrarEntidad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public registrarEntidad() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 302, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistroDeEntidad = new JLabel("Registro de Entidad");
		lblRegistroDeEntidad.setBounds(70, 12, 151, 15);
		frame.getContentPane().add(lblRegistroDeEntidad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 53, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblCdulaJurdica = new JLabel("Cédula Jurídica:");
		lblCdulaJurdica.setBounds(26, 93, 113, 15);
		frame.getContentPane().add(lblCdulaJurdica);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(26, 139, 70, 15);
		frame.getContentPane().add(lblDireccin);
		
		cmBxPais = new JComboBox<String>();
		cmBxPais.setModel(comboBoxModelPais());
		cmBxPais.setBounds(116, 172, 144, 24);
		frame.getContentPane().add(cmBxPais);
		
		cmBxDistrito = new JComboBox<String>();
		cmBxDistrito.setModel(comboBoxModelDistrito());
		cmBxDistrito.setBounds(116, 280, 144, 24);
		frame.getContentPane().add(cmBxDistrito);
		
		cmBxProvincia = new JComboBox<String>();
		cmBxProvincia.setModel(comboBoxModelProvincia());
		cmBxProvincia.setBounds(117, 208, 143, 24);
		frame.getContentPane().add(cmBxProvincia);
		
		cmBxCantón = new JComboBox<String>();
		cmBxCantón.setModel(comboBoxModelCanton());
		cmBxCantón.setBounds(116, 244, 144, 24);
		frame.getContentPane().add(cmBxCantón);
		
		JLabel lblCategora = new JLabel("Categoría:");
		lblCategora.setBounds(26, 344, 91, 15);
		frame.getContentPane().add(lblCategora);
		
		cmBxCategoria = new JComboBox<Object>();
		cmBxCategoria.setBounds(114, 335, 146, 24);
		frame.getContentPane().add(cmBxCategoria);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(89, 470, 117, 25);
		frame.getContentPane().add(btnRegistrar);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(153, 51, 114, 19);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(153, 91, 114, 19);
		frame.getContentPane().add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		JLabel lblPas = new JLabel("País");
		lblPas.setBounds(26, 177, 70, 15);
		frame.getContentPane().add(lblPas);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(26, 213, 70, 15);
		frame.getContentPane().add(lblProvincia);
		
		JLabel lblCantn = new JLabel("Cantón");
		lblCantn.setBounds(26, 249, 70, 15);
		frame.getContentPane().add(lblCantn);
		
		JLabel lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(26, 285, 70, 15);
		frame.getContentPane().add(lblDistrito);
                
                JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(89, 505, 117, 25);
		frame.getContentPane().add(btnVolver);
                
                textSeñal = new JTextArea("Inserte aqui la direccion exacta");
                textSeñal.setBounds(29, 375, 217, 85);
                JScrollPane sp = new JScrollPane(textSeñal);
		sp.setLocation(39, 375);
		sp.setSize(220, 90);
		frame.getContentPane().add(sp);
                
                btnVolver.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				lobbyUsuario.main(null);
				frame.dispose();
			}
		});
                btnRegistrar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
                            try {
                                logica.logicaRegistrarEntidad.registrarEntidad(textFieldNombre.getText()
                                        ,textFieldCedula.getText(),(String)cmBxPais.getSelectedItem(),(String)cmBxProvincia.getSelectedItem()
                                        ,(String) cmBxCantón.getSelectedItem(),(String)cmBxDistrito.getSelectedItem(),
                                        (String)cmBxCategoria.getSelectedItem(), textSeñal.getText());
                            } catch (ClassNotFoundException ex) {
                                
                                JOptionPane.showMessageDialog(null, "Error: "+ ex.toString(), "ERROR", 3);
                            }
			}
		});
                
                textSeñal.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    textSeñalMouseClicked(evt);
                    }
                });
                
        }
        private void textSeñalMouseClicked(java.awt.event.MouseEvent evt) {                                           
            textSeñal.setText("");
    }
}
