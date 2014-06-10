/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JFrame;

/**
 *
 * @author JoseGarita
 */
public class edicionDatos extends javax.swing.JFrame {
    JFrame ventanaPadre;
    /**
     * Creates new form edicionDatos
     */
    public edicionDatos() {
        initComponents();
        buttonGroup1.add(btnNota);
        buttonGroup1.add(btnFechaNacim);
        buttonGroup1.add(btnNota);
        buttonGroup1.add(btnGenero);
        buttonGroup1.add(btnNombre);
        buttonGroup1.add(btnPrimerApellido);
        buttonGroup1.add(btnSegundoApellido);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnFechaNacim = new javax.swing.JRadioButton();
        btnGenero = new javax.swing.JRadioButton();
        btnNombre = new javax.swing.JRadioButton();
        btnNota = new javax.swing.JRadioButton();
        btnPrimerApellido = new javax.swing.JRadioButton();
        btnSegundoApellido = new javax.swing.JRadioButton();
        DatosIngresotext = new javax.swing.JTextField();
        formatoFecha = new javax.swing.JLabel();
        formatoGenero = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        idPersonaText = new javax.swing.JTextField();
        indicadorNotas = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFechaNacim.setText("Fecha De Nacimiento");

        btnGenero.setText("Genero");

        btnNombre.setText("Nombre");

        btnNota.setText("Nota");

        btnPrimerApellido.setText("Primer Apellido");

        btnSegundoApellido.setText("Segundo Apellido");
        btnSegundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSegundoApellidoActionPerformed(evt);
            }
        });

        DatosIngresotext.setText("Digite el dato");
        DatosIngresotext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatosIngresotextMouseClicked(evt);
            }
        });

        formatoFecha.setText("aaaa/dd/mm");

        formatoGenero.setText("1-Hombre / 2-Mujer");

        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        idPersonaText.setText("idPersona a Editar");
        idPersonaText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                idPersonaTextMouseClicked(evt);
            }
        });

        indicadorNotas.setText("1-10");

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idPersonaText, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DatosIngresotext, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(indicadorNotas))
                    .addComponent(btnNombre)
                    .addComponent(btnFechaNacim)
                    .addComponent(btnSegundoApellido)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formatoGenero))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(formatoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrimerApellido, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(30, 30, 30)
                .addComponent(btnFechaNacim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoFecha)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idPersonaText, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btnGenero))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(formatoGenero))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNombre)
                    .addComponent(DatosIngresotext, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNota)
                    .addComponent(indicadorNotas))
                .addGap(18, 18, 18)
                .addComponent(btnPrimerApellido)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSegundoApellido)
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>                        

    private void btnSegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void DatosIngresotextMouseClicked(java.awt.event.MouseEvent evt) {                                              
        DatosIngresotext.setText("");        // TODO add your handling code here:
    }                                             

    private void idPersonaTextMouseClicked(java.awt.event.MouseEvent evt) {                                           
        idPersonaText.setText("");
    }                                          

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {                                       
      try{
          if(btnFechaNacim.isSelected()){// fecha,genero, nom, nota, proap, segap
           logica.logicaEdicion.editarDatos(1,idPersonaText.getText(), DatosIngresotext.getText(), null, null, null, null, null);
        }
        if(btnGenero.isSelected()){
            logica.logicaEdicion.editarDatos(2,idPersonaText.getText(), null, DatosIngresotext.getText(), null, null, null, null);
        }
        if(btnNombre.isSelected()){
            logica.logicaEdicion.editarDatos(3,idPersonaText.getText(), null, null, DatosIngresotext.getText(), null, null, null);
        }
        if(btnNota.isSelected()){
            logica.logicaEdicion.editarDatos(4,idPersonaText.getText(), null, null,DatosIngresotext.getText(), null, null, null);
        }
        if(btnPrimerApellido.isSelected()){
            logica.logicaEdicion.editarDatos(5,idPersonaText.getText(), null, null, null, DatosIngresotext.getText(), null, null);
        }
        if(btnSegundoApellido.isSelected()){
            logica.logicaEdicion.editarDatos(6,idPersonaText.getText(), null, null, null, null, DatosIngresotext.getText(), null);
        }}
       catch(ClassNotFoundException | NumberFormatException e){
               
               
               }
    }                                      

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {                                       
        this.dispose(); 
        lobbyUsuario.main(null);
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(edicionDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edicionDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edicionDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edicionDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edicionDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField DatosIngresotext;
    private javax.swing.JButton btnEditar;
    private javax.swing.JRadioButton btnFechaNacim;
    private javax.swing.JRadioButton btnGenero;
    private javax.swing.JRadioButton btnNombre;
    private javax.swing.JRadioButton btnNota;
    private javax.swing.JRadioButton btnPrimerApellido;
    private javax.swing.JRadioButton btnSegundoApellido;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel formatoFecha;
    private javax.swing.JLabel formatoGenero;
    private javax.swing.JTextField idPersonaText;
    private javax.swing.JLabel indicadorNotas;
    // End of variables declaration                   
}
