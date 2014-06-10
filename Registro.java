package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Registro {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldNick;
	private JTextField txtFieldApellido;
	private JPasswordField textFieldContraseña;
	private JPasswordField textFieldConfirmar;
	private JCheckBox chckbxUsuarioPrivado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
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
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 344, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Registro");
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 27, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 54, 70, 15);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(28, 81, 70, 15);
		frame.getContentPane().add(lblNick);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(130, 25, 114, 19);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(130, 79, 114, 19);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		txtFieldApellido = new JTextField();
		txtFieldApellido.setBounds(130, 52, 114, 19);
		frame.getContentPane().add(txtFieldApellido);
		txtFieldApellido.setColumns(10);
				
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(28, 108, 88, 15);
		frame.getContentPane().add(lblContrasea);
		
		textFieldContraseña = new JPasswordField();
		textFieldContraseña.setBounds(130, 108, 114, 19);
		frame.getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblConfirmar = new JLabel("Confirmar:");
		lblConfirmar.setBounds(28, 138, 88, 15);
		frame.getContentPane().add(lblConfirmar);
		
		textFieldConfirmar = new JPasswordField();
		textFieldConfirmar.setBounds(130, 139, 114, 19);
		frame.getContentPane().add(textFieldConfirmar);
		textFieldConfirmar.setColumns(10);
		
		chckbxUsuarioPrivado = new JCheckBox("Hacer mi usuario privado");
		chckbxUsuarioPrivado.setBounds(30, 155, 259, 50);
		frame.getContentPane().add(chckbxUsuarioPrivado);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(127, 213, 117, 25);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(256, 76, 76, 25);
		frame.getContentPane().add(btnCheck);
		
		btnRegistrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				while(true){	
					if(!(logica.logicaRegistro.comprobarContraseñas(textFieldContraseña.getText(),textFieldConfirmar.getText()))){
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden","Error",JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					if(!(logica.logicaRegistro.comprobarNick(textFieldNick.getText()))){
						JOptionPane.showMessageDialog(null, "El nick ingresado no está disponible, por favor elija otro","Error",JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					logica.logicaRegistro.Registrar(textFieldNombre.getText(),txtFieldApellido.getText(),textFieldNick.getText(),textFieldContraseña.getText(),chckbxUsuarioPrivado.isSelected());
					JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Registrado",JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		
		btnCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(logica.logicaRegistro.comprobarNick(textFieldNick.getText()))
					JOptionPane.showMessageDialog(null, "Nick Disponible","Disponible",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "El nick no está disponible","No disponible",JOptionPane.ERROR_MESSAGE);
			}		
		});
	}
}
