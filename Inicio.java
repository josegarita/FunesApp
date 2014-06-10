package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Inicio {

	private JFrame frame;
	private JTextField pss;
	private JTextField usr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 284, 261);
		frame.setResizable(false);
		frame.setTitle("Inicio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pss = new JPasswordField();
		pss.setBounds(128, 61, 114, 19);
		frame.getContentPane().add(pss);
		pss.setColumns(10);
		
		usr = new JTextField();
		usr.setBounds(128, 22, 114, 19);
		frame.getContentPane().add(usr);
		usr.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(88, 99, 117, 25);
		frame.getContentPane().add(btnIngresar);
		
		btnIngresar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(logica.main.comprobar(usr.getText(),pss.getText())){
					JOptionPane.showMessageDialog(null, "Sesión iniciada como "+usr.getText(),"Bienvenido",JOptionPane.PLAIN_MESSAGE);
					logica.logicaLobbyUsuario.usuarioActual=usr.getText();
					lobbyUsuario.main(null);
					frame.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuario y/o contraseña erronea","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JLabel lblCdula = new JLabel("Usuario");
		lblCdula.setBounds(33, 24, 70, 15);
		frame.getContentPane().add(lblCdula);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(24, 63, 114, 15);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblnoTieneUna = new JLabel("¿No tiene una cuenta?");
		lblnoTieneUna.setBounds(59, 159, 191, 15);
		frame.getContentPane().add(lblnoTieneUna);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(88, 186, 117, 25);
		frame.getContentPane().add(btnRegistrarse);
		
		btnRegistrarse.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				Registro.main(null);
				frame.setVisible(false);
			}
		});
	}
}
