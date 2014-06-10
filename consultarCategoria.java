package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class consultarCategoria {

	private JFrame frame;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarCategoria window = new consultarCategoria();
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
	public consultarCategoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 245, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConCat = new JLabel("Presione buscar");
		lblConCat.setBounds(65, 12, 133, 15);
		frame.getContentPane().add(lblConCat);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 74, 181, 200);
		textArea.setEditable(false);
		JScrollPane sp = new JScrollPane(textArea);
		sp.setLocation(12, 76);
		sp.setSize(221, 200);
		frame.getContentPane().add(sp);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(65, 293, 117, 25);
		frame.getContentPane().add(btnVolver);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(65, 39, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					logica.logicaConsultarCategoria.consultar();
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
