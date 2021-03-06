package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class lobbyUsuario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lobbyUsuario window = new lobbyUsuario();
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
	public lobbyUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Sesión de "+logica.logicaLobbyUsuario.usuarioActual);
                frame.setResizable(false);

		JLabel lblTitulo = new JLabel("Seleccione una opción");
		lblTitulo.setBounds(112, 12, 176, 15);
		frame.getContentPane().add(lblTitulo);

		JButton btnRegCat = new JButton("Categoría");
		btnRegCat.setBounds(35, 84, 120, 25);
		frame.getContentPane().add(btnRegCat);

		JButton btnEntidad = new JButton("Entidad");
		btnEntidad.setBounds(35, 124, 117, 25);
		frame.getContentPane().add(btnEntidad);

		JButton btnPersona = new JButton("Persona");
		btnPersona.setBounds(35, 163, 117, 25);
		frame.getContentPane().add(btnPersona);
                
                JButton btnBorrado = new JButton("Borrar Nota");
		btnBorrado.setBounds(585, 124, 130, 25);
		frame.getContentPane().add(btnBorrado);

		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setBounds(65, 49, 70, 15);
		frame.getContentPane().add(lblRegistrar);
                
                JLabel lblEdicion = new JLabel("Edición");
		lblEdicion.setBounds(625, 49, 70, 15);
		frame.getContentPane().add(lblEdicion);

		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(257, 49, 70, 15);
		frame.getContentPane().add(lblConsultar);
                
                JLabel lblCalificar = new JLabel("Calificar");
		lblCalificar.setBounds(451, 49, 70, 15);
		frame.getContentPane().add(lblCalificar);

		JButton btnConCat = new JButton("Categoría");
		btnConCat.setBounds(236, 84, 117, 25);
		frame.getContentPane().add(btnConCat);

		JButton btnConPersona = new JButton("Persona");
		btnConPersona.setBounds(236, 124, 117, 25);
		frame.getContentPane().add(btnConPersona);
                
                JButton btnBusPorCat = new JButton("Por Categoria");
		btnBusPorCat.setBounds(228, 163, 135, 25);
		frame.getContentPane().add(btnBusPorCat);
                
                JButton btnCalifPer = new JButton("Persona");
		btnCalifPer.setBounds(415, 84, 135, 25);
		frame.getContentPane().add(btnCalifPer);
                
                JButton btEdicion = new JButton("Editar Datos");
		btEdicion.setBounds(585, 84, 130, 25);
		frame.getContentPane().add(btEdicion);
                
                
                btnBusPorCat.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				consultaPorCategoria.main(null);
				frame.setVisible(false);
			}
		});
                
		btnRegCat.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				registrarCategoria.main(null);
				frame.setVisible(false);
			}
		});

		btnPersona.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				registrarPersona.main(null);
				frame.setVisible(false);
			}
		});

		btnConCat.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				consultarCategoria.main(null);
				frame.setVisible(false);
			}
		});
                
                btEdicion.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                       edicionDeDatos.main(null);
                       frame.setVisible(false);
                    }
                });
                
                btnCalifPer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                       calificarPersona.main(null);
                       frame.setVisible(false);
                    }
                });
                
                btnBorrado.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                       borradoDeNotas.main(null);
                       frame.setVisible(false);
                    }
                });
                

	}
}
