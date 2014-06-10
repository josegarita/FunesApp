package GUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class consultaPorCategoria {

	private JFrame frame;
        private JButton btnBuscar;
        private JLabel lblTitulo;
        private JComboBox<String> comboBoxCategoria;
        public static JTextArea textArea;        

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
					consultaPorCategoria window = new consultaPorCategoria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public consultaPorCategoria() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Sesión de "+logica.logicaLobbyUsuario.usuarioActual);
                frame.setResizable(false);

		lblTitulo = new JLabel("Seleccione la categoria");
		lblTitulo.setBounds(105, 12, 190, 15);
		frame.getContentPane().add(lblTitulo);
                
                comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(comboBoxModelCategoria());
		comboBoxCategoria.setBounds(65, 54, 125, 19);
		frame.getContentPane().add(comboBoxCategoria);
                
                btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(200, 50, 117, 25);
		frame.getContentPane().add(btnBuscar);
                
                textArea = new JTextArea();
		textArea.setBounds(31, 74, 181, 200);
		textArea.setEditable(false);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setLocation(12, 80);
		sp.setSize(355, 160);
		frame.getContentPane().add(sp);
                
                btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					logica.logicaConsultaPorCategoria.consultar((String)comboBoxCategoria.getSelectedItem());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
