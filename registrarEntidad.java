package GUI;

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

public class registrarEntidad {

	private JFrame frame;
	private JTextField textFieldmbreNo;
	private JTextField textFieldCedula;
	
	@SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelPais() throws Exception {  
        @SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();  
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
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
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
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
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
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
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
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
        
        @SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelCategoria() throws Exception {  
        @SuppressWarnings("unchecked")
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel();  
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Categoria ORDER BY Nombre");  
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
		frame.setBounds(100, 100, 302, 474);
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
		
		JComboBox<String> cmBxPais = new JComboBox();
		cmBxPais.setModel(comboBoxModelPais());
		cmBxPais.setBounds(116, 172, 144, 24);
		frame.getContentPane().add(cmBxPais);
		
		JComboBox<String> cmBxDistrito = new JComboBox();
		cmBxDistrito.setModel(comboBoxModelDistrito());
		cmBxDistrito.setBounds(116, 280, 144, 24);
		frame.getContentPane().add(cmBxDistrito);
		
		JComboBox<String> cmBxProvincia = new JComboBox();
		cmBxProvincia.setModel(comboBoxModelProvincia());
		cmBxProvincia.setBounds(117, 208, 143, 24);
		frame.getContentPane().add(cmBxProvincia);
		
		JComboBox<String> cmBxCantón = new JComboBox();
		cmBxCantón.setModel(comboBoxModelCanton());
		cmBxCantón.setBounds(116, 244, 144, 24);
		frame.getContentPane().add(cmBxCantón);
		
		JLabel lblCategora = new JLabel("Categoría:");
		lblCategora.setBounds(26, 344, 91, 15);
		frame.getContentPane().add(lblCategora);
		
		JComboBox<String> cmBxCategoria = new JComboBox();
                cmBxCategoria.setModel(comboBoxModelCategoria());
		cmBxCategoria.setBounds(114, 335, 146, 24);
		frame.getContentPane().add(cmBxCategoria);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(89, 409, 117, 25);
		frame.getContentPane().add(btnRegistrar);
		
		textFieldmbreNo = new JTextField();
		textFieldmbreNo.setBounds(153, 51, 114, 19);
		frame.getContentPane().add(textFieldmbreNo);
		textFieldmbreNo.setColumns(10);
		
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
	}
}
