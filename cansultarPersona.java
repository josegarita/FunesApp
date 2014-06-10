package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class consultarPersona {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldPriApe;
	private JTextField textFieldSegApe;
	private JTextField textFieldCedula;
	public static JTextArea textArea;
	public static String nom=null,pA=null,sA=null,ced=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarPersona window = new consultarPersona();
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
	public consultarPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 318, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Buscar Persona");
		frame.setResizable(false);
		
		JLabel lblinstruccion = new JLabel("Formulario de busqueda");
		lblinstruccion.setBounds(65, 12, 218, 15);
		frame.getContentPane().add(lblinstruccion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 65, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("1° Apellido:");
		lblApellido.setBounds(22, 96, 85, 15);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblApellido_1 = new JLabel("2° Apellido:");
		lblApellido_1.setBounds(22, 123, 90, 15);
		frame.getContentPane().add(lblApellido_1);
		
		JLabel lblCdula = new JLabel("Cédula:");
		lblCdula.setBounds(22, 150, 70, 15);
		frame.getContentPane().add(lblCdula);
		
		textArea = new JTextArea();
		JScrollPane sp = new JScrollPane(textArea);
		sp.setSize(294, 153);
		sp.setLocation(12, 193);
		textArea.setBounds(12, 177, 294, 138);
		frame.getContentPane().add(sp);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(36, 362, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(166, 362, 117, 25);
		frame.getContentPane().add(btnVolver);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(134, 63, 114, 19);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldPriApe = new JTextField();
		textFieldPriApe.setBounds(134, 94, 114, 19);
		frame.getContentPane().add(textFieldPriApe);
		textFieldPriApe.setColumns(10);
		
		textFieldSegApe = new JTextField();
		textFieldSegApe.setBounds(134, 121, 114, 19);
		frame.getContentPane().add(textFieldSegApe);
		textFieldSegApe.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(134, 148, 114, 19);
		frame.getContentPane().add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					if(!textFieldNombre.getText().equals(""))
						nom=textFieldNombre.getText();
					
					if(!textFieldPriApe.getText().equals(""))
						pA=textFieldPriApe.getText();
					
					if(!textFieldSegApe.getText().equals(""))
						sA=textFieldSegApe.getText();
					
					if(!textFieldCedula.getText().equals(""))
						ced=textFieldCedula.getText();
					
					logica.logicaConsultarPersonas.consultar(nom,pA,sA,ced);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lobbyUsuario.main(null);
				frame.setVisible(false);
			}
			
		});
	}
}
