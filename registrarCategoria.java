package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import logica.logicaRegistrarCategoria;

public class registrarCategoria {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCategoria window = new registrarCategoria();
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
	public registrarCategoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 259, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInstrucción = new JLabel("Registrar categoría");
		lblInstrucción.setBounds(60, 12, 148, 25);
		frame.getContentPane().add(lblInstrucción);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(23, 77, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(118, 75, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(12, 128, 114, 25);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(138, 128, 105, 25);
		frame.getContentPane().add(btnVolver);
		
		btnRegistrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				logicaRegistrarCategoria.Registrar(textField.getText());
				JOptionPane.showMessageDialog(null, "Se ha registrado la categoría "+textField.getText(),"Registrado",JOptionPane.INFORMATION_MESSAGE);
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
