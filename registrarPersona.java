package GUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

public class registrarPersona {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldSegApellido;
	private JTextField txtFieldApellido;
	private JTextField textFieldCedula;
	private JTextField textFieldIntitucion;
	final private static String[] dias = new String[31];
	final private static String[] anios = new String[100];
	final private static String[] meses = new String[12];
        private JComboBox<String> comboBoxCargo = null;
        private JComboBox<String> comboBoxInstitucion = null;
        
        @SuppressWarnings("rawtypes")
	public static DefaultComboBoxModel<String> comboBoxModelCargo() throws Exception {  
            @SuppressWarnings("unchecked")
                    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel();  
            try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Cargo FROM Cargo ORDER BY Cargo");  
                    ResultSet rs = ps.executeQuery();  
                    while(rs.next()){  
                        comboBoxModel.addElement((rs.getString("Cargo")));  
                    }  
                    rs.close();  
                    ps.close();  
            } catch (Exception e) {  
                throw e;  
            } 
            return comboBoxModel;  
        } 
	
        public static DefaultComboBoxModel<String> comboBoxModelInstitucion() throws Exception {  
            @SuppressWarnings("unchecked")
                    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel();  
            try {  
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Funes?"+"user=usuario&password=pass");
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT Nombre FROM Institucion ORDER BY Nombre");  
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
		
		int i=0;
		while(i<31){
			dias[i]=String.valueOf(i+1);
			i++;
		}
		
		i=0;
		
		while(i<12){
			meses[i]=String.valueOf(i+1);
			i++;
		}
		
		i=0;
		int a=1915;
		while(i<100){
			anios[i]=String.valueOf(a);
			a++;
			i++;
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarPersona window = new registrarPersona();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public registrarPersona() throws Exception {
		initialize();
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Registro de personas");
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 27, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Primer Apellido:");
		lblApellido.setBounds(28, 54, 117, 15);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblSegApellido = new JLabel("Segundo Apellido:");
		lblSegApellido.setBounds(28, 81, 139, 15);
		frame.getContentPane().add(lblSegApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(185, 27, 114, 19);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldSegApellido = new JTextField();
		textFieldSegApellido.setBounds(185, 81, 114, 19);
		frame.getContentPane().add(textFieldSegApellido);
		textFieldSegApellido.setColumns(10);
		
		txtFieldApellido = new JTextField();
		txtFieldApellido.setBounds(185, 54, 114, 19);
		frame.getContentPane().add(txtFieldApellido);
		txtFieldApellido.setColumns(10);
				
		JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setBounds(28, 108, 88, 15);
		frame.getContentPane().add(lblCedula);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(185, 110, 114, 19);
		frame.getContentPane().add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		JLabel lblGenero = new JLabel("Sexo:");
		lblGenero.setBounds(28, 138, 88, 15);
		frame.getContentPane().add(lblGenero);
		
                comboBoxInstitucion = new JComboBox();
		comboBoxInstitucion.setModel(comboBoxModelInstitucion());
		comboBoxInstitucion.setBounds(185, 241, 114, 19);
		frame.getContentPane().add(comboBoxInstitucion);
                
                JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(271, 320, 117, 25);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(311, 108, 76, 20);
		frame.getContentPane().add(btnCheck);
		
		final JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(185, 137, 96, 23);
		frame.getContentPane().add(rdbtnMasculino);
		
		final JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(289, 137, 98, 23);
		frame.getContentPane().add(rdbtnFemenino);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnMasculino);
		bgroup.add(rdbtnFemenino);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(28, 165, 161, 15);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		
		@SuppressWarnings("rawtypes")
		final JComboBox comboBoxDias = new JComboBox();
		comboBoxDias.setModel(new DefaultComboBoxModel(dias));
		comboBoxDias.setBounds(195, 192, 46, 24);
		frame.getContentPane().add(comboBoxDias);
		
		final JComboBox comboBoxMeses = new JComboBox();
		comboBoxMeses.setModel(new DefaultComboBoxModel(meses));
		comboBoxMeses.setBounds(253, 192, 46, 24);
		frame.getContentPane().add(comboBoxMeses);
		
		final JComboBox comboBoxAnios = new JComboBox();
		comboBoxAnios.setModel(new DefaultComboBoxModel(anios));
		comboBoxAnios.setBounds(311, 192, 58, 24);
		frame.getContentPane().add(comboBoxAnios);
		
		JLabel lblLugarDeTrabajo = new JLabel("Lugar de trabajo:");
		lblLugarDeTrabajo.setBounds(28, 243, 139, 15);
		frame.getContentPane().add(lblLugarDeTrabajo);
		
		JLabel lblDiamesao = new JLabel("dia/mes/año");
		lblDiamesao.setBounds(58, 197, 87, 15);
		frame.getContentPane().add(lblDiamesao);
		
                
		comboBoxCargo = new JComboBox();
		comboBoxCargo.setModel(comboBoxModelCargo());
		comboBoxCargo.setBounds(185, 281, 114, 19);
		frame.getContentPane().add(comboBoxCargo);
                
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(28, 283, 70, 15);
		frame.getContentPane().add(lblCargo);
				
		
		btnRegistrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				while(true){
					if(textFieldCedula.getText().equals("") || textFieldNombre.getText().equals("") || txtFieldApellido.getText().equals("") || textFieldSegApellido.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					if(!rdbtnMasculino.isSelected() && !rdbtnFemenino.isSelected()){
						JOptionPane.showMessageDialog(null, "Debe seleccionar un genero para la persona","ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					if(logica.logicaRegistrarPersona.comprobarCedula(textFieldCedula.getText())){
						JOptionPane.showMessageDialog(null, "Ya hay una persona registrada con ese número de cédula","ERROR",JOptionPane.ERROR_MESSAGE);
						break;
					}
					
					String fecha=(String)comboBoxAnios.getSelectedItem()+"-"+(String)comboBoxMeses.getSelectedItem()+"-"+(String)comboBoxDias.getSelectedItem();
					int genero=0;
					
					if(rdbtnMasculino.isSelected())
						genero=1;
					
					if(rdbtnFemenino.isSelected())
						genero=2;
					
					if(logica.logicaRegistrarPersona.registrar(textFieldCedula.getText(), textFieldNombre.getText(), txtFieldApellido.getText(), textFieldSegApellido.getText(), genero, fecha,(String)comboBoxCargo.getSelectedItem(),(String)comboBoxInstitucion.getSelectedItem()))
						JOptionPane.showMessageDialog(null, "Persona registrada en la base de datos","Correcto",JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		
		btnCheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(logica.logicaRegistrarPersona.comprobarCedula(textFieldCedula.getText()))
					JOptionPane.showMessageDialog(null, "Ya hay una persona registrada con ese número de cédula","ERROR",JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "No hay ningúna persona registrada con ese número de cédula","Correcto",JOptionPane.INFORMATION_MESSAGE);
			}		
		});
	}
}
