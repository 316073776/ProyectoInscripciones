package Vista;

import Modelo.Inscripciones;
import Modelo.SqlAlumnos;
import Modelo.SqlGrupos;
import Modelo.Sqllnscripciones;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaInscripciones extends javax.swing.JFrame implements MouseListener{
    
    Sqllnscripciones sqlInscripcion;
    Inscripciones modInscripcion;
    
    public VentanaInscripciones() {
        initComponents();
        establecerModeloTabla();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        this.sqlInscripcion = new Sqllnscripciones();
        tbInscripciones.addMouseListener(this);
    }
    
    private void limpiarCajas(){
        cajaNoCuenta.setText(null);
        cajaClaveGrupo.setText(null);
    }
    
    private void llenarCajas(Inscripciones modInscripcion){
        cajaNoCuenta.setText(modInscripcion.getCuentaAlumno());
        cajaClaveGrupo.setText(modInscripcion.getClaveGrupo());
    }
    
    private void establecerModeloTabla() {

        Sqllnscripciones sqlInscripciones = new Sqllnscripciones();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbInscripciones.setModel(modeloTabla);

        Vector<Inscripciones> arregloInscripcion = sqlInscripciones.insertarDatosTabla();
        modeloTabla.addColumn("No. Cuenta");
        modeloTabla.addColumn("Clave Grupo");
        modeloTabla.addColumn("Hora");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Host");
        
        if (arregloInscripcion != null) {
            for (int i = 0; i < arregloInscripcion.size(); i++) {

                Object fila[] = new Object[5];
                fila[0] = arregloInscripcion.elementAt(i).getCuentaAlumno();
                fila[1] = arregloInscripcion.elementAt(i).getClaveGrupo();
                fila[2] = arregloInscripcion.elementAt(i).getHoraInscripcion();
                fila[3] = arregloInscripcion.elementAt(i).getFechaInscripcion();
                fila[4] = arregloInscripcion.elementAt(i).getIpHost();

                modeloTabla.addRow(fila);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInscripciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cajaNoCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cajaClaveGrupo = new javax.swing.JTextField();
        btLimpiar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRegresar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/formulario-de-registro.png"))); // NOI18N

        tbInscripciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbInscripciones);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("No. de Cuenta:");

        cajaNoCuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Clave del grupo:");

        cajaClaveGrupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btLimpiar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escoba.png"))); // NOI18N
        btLimpiar.setText("LIMPIAR");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btBorrar.setBackground(new java.awt.Color(255, 0, 0));
        btBorrar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btBorrar.setText("BORRAR");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        btGuardar.setBackground(new java.awt.Color(165, 220, 150));
        btGuardar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        btGuardar.setText("GUARDAR");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btLimpiar)
                                .addGap(126, 126, 126)
                                .addComponent(jButton1)
                                .addGap(32, 32, 32)
                                .addComponent(btBorrar)
                                .addGap(30, 30, 30)
                                .addComponent(btGuardar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cajaNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cajaClaveGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cajaClaveGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpiar)
                    .addComponent(btBorrar)
                    .addComponent(btGuardar)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        jMenu1.setText("OPCIONES");

        itemRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.png"))); // NOI18N
        itemRegresar.setText("Regresar");
        itemRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegresarActionPerformed(evt);
            }
        });
        jMenu1.add(itemRegresar);

        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegresarActionPerformed
        this.dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_itemRegresarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        limpiarCajas();
        establecerModeloTabla();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        sqlInscripcion = new Sqllnscripciones();
        modInscripcion = new Inscripciones();
        SqlAlumnos sqlAlumn = new SqlAlumnos();
        SqlGrupos sqlGrup = new SqlGrupos();
        
        if (cajaNoCuenta.getText().equals("") || cajaClaveGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los campos deben estar llenos.");//validar que los campos no estén vacíos
        } else if (cajaNoCuenta.getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "El número de cuenta debe tener 9 dígitos.");
        } else if (cajaClaveGrupo.getText().length() != 4) {
            JOptionPane.showMessageDialog(null, "La clave del grupo debe tener 4 dígitos.");
        } else if (sqlAlumn.buscarAlumno(cajaNoCuenta.getText()) == null){
            JOptionPane.showMessageDialog(null, "El número de cuenta del alumno no existe.");
        } else if (sqlGrup.buscarGrupo(cajaClaveGrupo.getText()) == null) {
            JOptionPane.showMessageDialog(null, "La clave del grupo no existe.");
        } else {
            modInscripcion.setCuentaAlumno(cajaNoCuenta.getText());
            modInscripcion.setClaveGrupo(cajaClaveGrupo.getText());

            if (sqlInscripcion.guardarInscripcion(modInscripcion)) {
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente.");
                limpiarCajas();
                establecerModeloTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar, el alumno con numero de cuenta " + cajaNoCuenta.getText() + "\nya está inscrito en el grupo " + cajaClaveGrupo.getText());
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        sqlInscripcion = new Sqllnscripciones();

        if (cajaNoCuenta.getText().equals("") || cajaClaveGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Busque un registro para borrar.");//validar que los campos no estén vacíos
        } else {

            if (sqlInscripcion.borrarInscripcion(cajaNoCuenta.getText(), cajaClaveGrupo.getText())) {
                limpiarCajas();
                establecerModeloTabla();
                JOptionPane.showMessageDialog(null, "Registro borrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar.");
            }
        }
    }//GEN-LAST:event_btBorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sqlInscripcion = new Sqllnscripciones();
        modInscripcion = new Inscripciones();
        SqlAlumnos sqlAlumn = new SqlAlumnos();
        SqlGrupos sqlGrup = new SqlGrupos();
        
        if (cajaNoCuenta.getText().equals("") || cajaClaveGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los campos deben estar llenos.");//validar que los campos no estén vacíos
        } else if (cajaNoCuenta.getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "El número de cuenta debe tener 9 dígitos.");
        } else if (cajaClaveGrupo.getText().length() != 4) {
            JOptionPane.showMessageDialog(null, "La clave del grupo debe tener 4 dígitos.");
        } else if (sqlAlumn.buscarAlumno(cajaNoCuenta.getText()) == null){
            JOptionPane.showMessageDialog(null, "El número de cuenta del alumno no existe.");
        } else if (sqlGrup.buscarGrupo(cajaClaveGrupo.getText()) == null) {
            JOptionPane.showMessageDialog(null, "La clave del grupo no existe.");
        } else {
            modInscripcion.setCuentaAlumno(cajaNoCuenta.getText());
            modInscripcion.setClaveGrupo(cajaClaveGrupo.getText());

            if (sqlInscripcion.actualizarInscripcion(modInscripcion)) {
                JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente.");
                limpiarCajas();
                establecerModeloTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar, el alumno con numero de cuenta " + cajaNoCuenta.getText() + "\nya está inscrito en el grupo " + cajaClaveGrupo.getText());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInscripciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JTextField cajaClaveGrupo;
    private javax.swing.JTextField cajaNoCuenta;
    private javax.swing.JMenuItem itemRegresar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbInscripciones;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tbInscripciones) {
            int fila = tbInscripciones.getSelectedRow();
            Inscripciones a = new Inscripciones();
            String cuenta = (String) tbInscripciones.getValueAt(fila, 0);
            String clave = (String) tbInscripciones.getValueAt(fila, 1);
            a = sqlInscripcion.buscarInscripcion(cuenta, clave);           
            llenarCajas(a);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
