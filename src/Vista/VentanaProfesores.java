
package Vista;

import Modelo.Profesores;
import Modelo.SqlProfesores;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaProfesores extends javax.swing.JFrame implements MouseListener {
    
    private Profesores modProfesor;
    private SqlProfesores sqlProfesor;
    
    public VentanaProfesores() {
        initComponents();
        establecerModeloTabla();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        cajaVariable.setVisible(false);
        this.sqlProfesor = new SqlProfesores();
        tbProfesores.addMouseListener(this);
    }
    
    public void limpiarCajas() {
        cajaBuscar.setText(null);
        cajaNombre.setText(null);
        cajaApPaterno.setText(null);
        cajaApMaterno.setText(null);
        cajaCedula.setText(null);
        cajaNumTrabajador.setText(null);
        cajaVariable.setText(null);
        cbGrado.setSelectedIndex(0);
    }
    
    public void llenarCajas(Profesores modProfesor) {
        cajaNombre.setText(modProfesor.getPersNombre());
        cajaApPaterno.setText(modProfesor.getPersApPaterno());
        cajaApMaterno.setText(modProfesor.getPersApMaterno());
        cajaCedula.setText(modProfesor.getCedula());
        cajaVariable.setText(modProfesor.getNumTrabajador());
        cajaNumTrabajador.setText(modProfesor.getNumTrabajador());
        switch (modProfesor.getGrado()){
            case 'L':
                cbGrado.setSelectedIndex(0);
                break;
            case 'M':
                cbGrado.setSelectedIndex(1);
                break;
            case 'P':
                cbGrado.setSelectedIndex(2);
                break;
        }
    }
    
    public void establecerModeloTabla() {

        SqlProfesores sqlAlumno = new SqlProfesores();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbProfesores.setModel(modeloTabla);

        Vector<Profesores> arregloAlumno = sqlAlumno.insertarDatosTabla();
        modeloTabla.addColumn("No. Trabajador");
        modeloTabla.addColumn("Nombre");

        if (arregloAlumno != null) {
            for (int i = 0; i < arregloAlumno.size(); i++) {

                Object fila[] = new Object[2];
                fila[0] = arregloAlumno.elementAt(i).getNumTrabajador();
                fila[1] = arregloAlumno.elementAt(i).getPersNombre() + " " + arregloAlumno.elementAt(i).getPersApPaterno() + " " + arregloAlumno.elementAt(i).getPersApMaterno();

                modeloTabla.addRow(fila);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cajaBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProfesores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        cajaApPaterno = new javax.swing.JTextField();
        cajaApMaterno = new javax.swing.JTextField();
        cajaNumTrabajador = new javax.swing.JTextField();
        cajaCedula = new javax.swing.JTextField();
        cbGrado = new javax.swing.JComboBox<>();
        cajaVariable = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRegresar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROFESORES (CRUD)");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profesor.png"))); // NOI18N

        cajaBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cajaBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btBuscar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btBuscar.setText("BUSCAR No. TRABAJADOR");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btActualizar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        btGuardar.setBackground(new java.awt.Color(165, 220, 105));
        btGuardar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        btGuardar.setText("GUARDAR");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
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

        btLimpiar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escoba.png"))); // NOI18N
        btLimpiar.setText("LIMPIAR");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        tbProfesores.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProfesores);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre: *");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno: *");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Número de Trabajador: *");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Cédula: *");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Grado:");

        cajaNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaApPaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaApMaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaNumTrabajador.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaCedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbGrado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licenciatura", "Maestría", "Postgrado" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(cajaNombre)
                        .addComponent(cajaApPaterno)
                        .addComponent(jLabel4)
                        .addComponent(cajaApMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cajaNumTrabajador)
                        .addComponent(cajaCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaNumTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        cajaVariable.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btActualizar)
                        .addGap(119, 119, 119)
                        .addComponent(btBorrar)
                        .addGap(134, 134, 134)
                        .addComponent(btGuardar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btBuscar)
                .addGap(207, 207, 207))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1))
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 173, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cajaVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLimpiar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btBuscar)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpiar)
                    .addComponent(cajaVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btActualizar)
                    .addComponent(btGuardar)
                    .addComponent(btBorrar))
                .addContainerGap())
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

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        sqlProfesor = new SqlProfesores();
        modProfesor = null;

        modProfesor = sqlProfesor.buscarProfesor(cajaBuscar.getText());

        if (cajaBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de busqueda está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaBuscar.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "El No. de trabajador debe tener 10 dígitos.");
            } else {
                if (modProfesor != null) {

                    llenarCajas(modProfesor);
                    cajaBuscar.setText(null);

                } else {
                    JOptionPane.showMessageDialog(null, "El No. de trabajador no existe.");
                }
            }
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        sqlProfesor = new SqlProfesores();
        modProfesor = new Profesores();

        if (cajaNombre.getText().equals("") || cajaApPaterno.getText().equals("") || cajaNumTrabajador.getText().equals("") || cajaCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaNumTrabajador.getText().length() == 10) {

                modProfesor.setPersNombre(cajaNombre.getText().toUpperCase());
                modProfesor.setPersApPaterno(cajaApPaterno.getText().toUpperCase());
                modProfesor.setPersApMaterno(cajaApMaterno.getText().toUpperCase());
                modProfesor.setNumTrabajador(cajaNumTrabajador.getText());
                modProfesor.setCedula(cajaCedula.getText());
                switch (cbGrado.getSelectedIndex()){
                    case 0 :
                        modProfesor.setGrado('L');
                        break;
                    case 1 :
                        modProfesor.setGrado('M');
                        break;
                    case 2 :
                        modProfesor.setGrado('P');
                        break;
                }
                
                if (sqlProfesor.existeProfesor(modProfesor)) {//Verificar que no exista el profesor

                    if (sqlProfesor.guardarProfesor(modProfesor)) {
                        JOptionPane.showMessageDialog(null, "El registro se guardó correctamente.");
                        limpiarCajas();
                        establecerModeloTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El profesor " + cajaNombre.getText().toUpperCase() + " " + cajaApPaterno.getText().toUpperCase() + " " + cajaApMaterno.getText().toUpperCase() +"\no el No. de trabajador " + cajaNumTrabajador.getText() + " ya existe.");
                }
            } else {
               JOptionPane.showMessageDialog(null, "El número de trabajador debe tener 10 dígitos.");
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        sqlProfesor = new SqlProfesores();
        modProfesor = new Profesores();

        if (cajaNombre.getText().equals("") || cajaApPaterno.getText().equals("") || cajaNumTrabajador.getText().equals("") || cajaCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaNumTrabajador.getText().equals(cajaVariable.getText())) {

                modProfesor.setPersNombre(cajaNombre.getText().toUpperCase());
                modProfesor.setPersApPaterno(cajaApPaterno.getText().toUpperCase());
                modProfesor.setPersApMaterno(cajaApMaterno.getText().toUpperCase());
                modProfesor.setNumTrabajador(cajaVariable.getText());
                modProfesor.setCedula(cajaCedula.getText());
                switch (cbGrado.getSelectedIndex()){
                    case 0 :
                        modProfesor.setGrado('L');
                        break;
                    case 1 :
                        modProfesor.setGrado('M');
                        break;
                    case 2 :
                        modProfesor.setGrado('P');
                        break;
                }

                if (sqlProfesor.actualizarProfesor(modProfesor)) {
                    JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente.");
                    limpiarCajas();
                    establecerModeloTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar.");
                }

            } else {

                JOptionPane.showMessageDialog(null, "El número de trabajador no se debe modificar, intentelo de nuevo.");
                cajaNumTrabajador.setText(cajaVariable.getText());
            }

        }
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        sqlProfesor = new SqlProfesores();

        if (cajaNumTrabajador.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Busque un registro para borrar.");//validar que los campos no estén vacíos
        } else {

            if (sqlProfesor.borrarProfesor(cajaNumTrabajador.getText())) {
                limpiarCajas();
                establecerModeloTabla();
                JOptionPane.showMessageDialog(null, "Registro borrado Correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el registro porque está sujeto a un grupo.");
            }
        }
    }//GEN-LAST:event_btBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JTextField cajaApMaterno;
    private javax.swing.JTextField cajaApPaterno;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaCedula;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaNumTrabajador;
    private javax.swing.JTextField cajaVariable;
    private javax.swing.JComboBox<String> cbGrado;
    private javax.swing.JMenuItem itemRegresar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbProfesores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tbProfesores) {
            int fila = tbProfesores.getSelectedRow();
            Profesores a = new Profesores();
            String numero = (String) tbProfesores.getValueAt(fila, 0);
            a = sqlProfesor.buscarProfesor(numero);           
            cajaVariable.setText(a.getNumTrabajador());
            llenarCajas(a);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
