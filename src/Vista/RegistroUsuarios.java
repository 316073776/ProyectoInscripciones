
package Vista;

import Modelo.Hash;
import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import javax.swing.JOptionPane;


public class RegistroUsuarios extends javax.swing.JFrame {

    public RegistroUsuarios() {
       
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void limpiarCajas(){
        cajaRegNombre.setText("");
        cajaRegApPaterno.setText("");
        cajaRegApMaterno.setText("");
        cajaRegUsuario.setText("");
        cajaRegContasenia.setText("");
        cajaRegContraConfirm.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cajaRegNombre = new javax.swing.JTextField();
        cajaRegApPaterno = new javax.swing.JTextField();
        cajaRegApMaterno = new javax.swing.JTextField();
        cajaRegUsuario = new javax.swing.JTextField();
        cajaRegContasenia = new javax.swing.JPasswordField();
        cajaRegContraConfirm = new javax.swing.JPasswordField();
        btRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR USUARIO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        etqUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        etqUsuario.setText("Usuario: *");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Contraseña: *");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>Confirmar Contraseña: * </html>");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre: *");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Paterno: *");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Apellido Materno:");

        cajaRegNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaRegApPaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaRegApMaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaRegUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaRegContasenia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaRegContraConfirm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btRegistrar.setBackground(new java.awt.Color(165, 220, 105));
        btRegistrar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btRegistrar.setText("REGISTRAR");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel6.setText("REGISTRAR USUARIOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etqUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cajaRegNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cajaRegContraConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(cajaRegContasenia, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cajaRegUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cajaRegApPaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cajaRegApMaterno, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cajaRegNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRegApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRegApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRegUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRegContasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaRegContraConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btRegistrar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        
        SqlUsuarios sqlUsuario = new SqlUsuarios();
        Usuarios modUsuario = new Usuarios();
        String contrasenia = new String(cajaRegContasenia.getPassword());
        String contraseniaConf = new String(cajaRegContraConfirm.getPassword());
        
        
        if(cajaRegNombre.getText().equals("") || cajaRegApPaterno.getText().equals("") || cajaRegUsuario.getText().equals("") || cajaRegUsuario.getText().equals("") || contrasenia.equals("") || contraseniaConf.equals("")){
            JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío, favor de llenar los campos obligatorios.");//validar que los campos no estén vacíos
        } else {
            
            if (contrasenia.equals(contraseniaConf)){//Validar que las contraseñas coincidan
                
                if (sqlUsuario.existeUsuario(cajaRegUsuario.getText().toUpperCase()) == 0){//Verificar que no exista el usuario

                    String nuevaContra = Hash.sha1(contrasenia);

                    modUsuario.setPersNombre(cajaRegNombre.getText().toUpperCase());
                    modUsuario.setPersApPaterno(cajaRegApPaterno.getText().toUpperCase());
                    modUsuario.setPersApMaterno(cajaRegApMaterno.getText().toUpperCase());
                    modUsuario.setUsuario(cajaRegUsuario.getText().toUpperCase());
                    modUsuario.setContrasenia(nuevaContra);

                    if( sqlUsuario.registrar(modUsuario)){
                        JOptionPane.showMessageDialog(null, "El registro se guardó correctamente.");
                        limpiarCajas();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            } 
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        InicioSesion.ventanaRegistro = null;
    }//GEN-LAST:event_formWindowClosing

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JTextField cajaRegApMaterno;
    private javax.swing.JTextField cajaRegApPaterno;
    private javax.swing.JPasswordField cajaRegContasenia;
    private javax.swing.JPasswordField cajaRegContraConfirm;
    private javax.swing.JTextField cajaRegNombre;
    private javax.swing.JTextField cajaRegUsuario;
    private javax.swing.JLabel etqUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
