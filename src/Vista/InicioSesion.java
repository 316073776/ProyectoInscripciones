
package Vista;

import Modelo.Hash;
import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class InicioSesion extends javax.swing.JFrame {

    public static RegistroUsuarios ventanaRegistro;
    
    public InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cajaUsuario = new javax.swing.JTextField();
        cajaContrasenia = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btIngresar = new javax.swing.JButton();
        btRegistrarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO DE SESIÓN");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel1.setText("INICIO DE SESIÓN");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Contraseña:");

        cajaUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaContrasenia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grupo.png"))); // NOI18N

        btIngresar.setBackground(new java.awt.Color(165, 220, 105));
        btIngresar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btIngresar.setText("INGRESAR");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        btRegistrarUsuario.setBackground(new java.awt.Color(120, 210, 250));
        btRegistrarUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btRegistrarUsuario.setText("Registrar Usuario");
        btRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cajaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(cajaContrasenia)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel3)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btIngresar)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btRegistrarUsuario)
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btRegistrarUsuario)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarUsuarioActionPerformed
                 
        if(ventanaRegistro == null){
            ventanaRegistro = new RegistroUsuarios();
            ventanaRegistro.setVisible(true);
        }
    }//GEN-LAST:event_btRegistrarUsuarioActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        
        SqlUsuarios sqlUsuario = new SqlUsuarios();
        Usuarios modeloUsuario = new Usuarios();
        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String contrasenia = new String(cajaContrasenia.getPassword());
        
        if( ! cajaUsuario.getText().equals("") && !contrasenia.equals("")){
            
            String nuevaContra = Hash.sha1(contrasenia);
            
            modeloUsuario.setUsuario(cajaUsuario.getText().toUpperCase());
            modeloUsuario.setContrasenia(nuevaContra);
            modeloUsuario.setInicioActual(fechaHora.format(date));
            
            if(sqlUsuario.inicioSesion(modeloUsuario)){
                
                ventanaRegistro = null;
                this.dispose();
                JOptionPane.showMessageDialog(null, "Bienvenido " + modeloUsuario.getPersNombre() + " " + modeloUsuario.getPersApPaterno() + 
                                               "\ntu último inicio de sesión fue " + modeloUsuario.getUltimoInicio());
                Home ventanaHome = new Home();
                ventanaHome.setVisible(true);
                        
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los datos están vacíos.\nFavor de llenar los campos.");
        }
    }//GEN-LAST:event_btIngresarActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JButton btRegistrarUsuario;
    private javax.swing.JPasswordField cajaContrasenia;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
