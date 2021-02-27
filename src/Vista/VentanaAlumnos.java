package Vista;

import Modelo.Alumnos;
import Modelo.SqlAlumnos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaAlumnos extends javax.swing.JFrame implements MouseListener {

    private Alumnos modAlumno;
    private SqlAlumnos sqlAlumno;

    public VentanaAlumnos() {
        initComponents();
        establecerModeloTabla();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        cajaVariable.setVisible(false);
        this.sqlAlumno = new SqlAlumnos();
        tbAlumnos.addMouseListener(this);
    }

    public void limpiarCajas() {
        cajaBuscar.setText(null);
        cajaNombre.setText(null);
        cajaApPaterno.setText(null);
        cajaApMaterno.setText(null);
        cajaGeneracion.setText(null);
        cajaNumCuenta.setText(null);
        cajaVariable.setText(null);
    }

    public void llenarCajas(Alumnos modAlumno) {
        cajaNombre.setText(modAlumno.getPersNombre());
        cajaApPaterno.setText(modAlumno.getPersApPaterno());
        cajaApMaterno.setText(modAlumno.getPersApMaterno());
        cajaNumCuenta.setText(modAlumno.getNumCuenta());
        cajaGeneracion.setText(Integer.toString(modAlumno.getGeneracion()));
        cajaVariable.setText(modAlumno.getNumCuenta());
    }

    private void establecerModeloTabla() {

        SqlAlumnos sqlAlumno = new SqlAlumnos();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbAlumnos.setModel(modeloTabla);

        Vector<Alumnos> arregloAlumno = sqlAlumno.insertarDatosTabla();
        modeloTabla.addColumn("No. Cuenta");
        modeloTabla.addColumn("Nombre");

        if (arregloAlumno != null) {
            for (int i = 0; i < arregloAlumno.size(); i++) {

                Object fila[] = new Object[2];
                fila[0] = arregloAlumno.elementAt(i).getNumCuenta();
                fila[1] = arregloAlumno.elementAt(i).getPersNombre() + " " + arregloAlumno.elementAt(i).getPersApPaterno() + " " + arregloAlumno.elementAt(i).getPersApMaterno();

                modeloTabla.addRow(fila);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cajaBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        cajaApPaterno = new javax.swing.JTextField();
        cajaApMaterno = new javax.swing.JTextField();
        cajaNumCuenta = new javax.swing.JTextField();
        cajaGeneracion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlumnos = new javax.swing.JTable();
        cajaVariable = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRegresar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALUMNOS (CRUD)");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escritorios.png"))); // NOI18N

        cajaBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cajaBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btBuscar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btBuscar.setText("BUSCAR No. CUENTA");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
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

        btActualizar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
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

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre: *");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno: *");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Número de Cuenta: *");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Generación: * ");

        cajaNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaApPaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaApMaterno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaNumCuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaGeneracion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tbAlumnos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Cuenta", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbAlumnos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cajaApPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(cajaApMaterno)
                    .addComponent(jLabel6)
                    .addComponent(cajaNombre)
                    .addComponent(cajaGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaNumCuenta))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(cajaNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaGeneracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        cajaVariable.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71))
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cajaVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpiar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btActualizar)
                        .addGap(117, 117, 117)
                        .addComponent(btBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGuardar)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpiar)
                    .addComponent(cajaVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btActualizar)
                    .addComponent(btBorrar)
                    .addComponent(btGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        limpiarCajas();
        establecerModeloTabla();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        sqlAlumno = new SqlAlumnos();
        modAlumno = new Alumnos();

        if (cajaNombre.getText().equals("") || cajaApPaterno.getText().equals("") || cajaNumCuenta.getText().equals("") || cajaGeneracion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaNumCuenta.getText().length() == 9) {

                modAlumno.setPersNombre(cajaNombre.getText().toUpperCase());
                modAlumno.setPersApPaterno(cajaApPaterno.getText().toUpperCase());
                modAlumno.setPersApMaterno(cajaApMaterno.getText().toUpperCase());
                modAlumno.setNumCuenta(cajaNumCuenta.getText());
                modAlumno.setGeneracion(Integer.parseInt(cajaGeneracion.getText()));
                
                if (sqlAlumno.existeAlumno(modAlumno)) {//Verificar que no exista el alumno

                    if (sqlAlumno.guardarAlumno(modAlumno)) {
                        JOptionPane.showMessageDialog(null, "El registro se guardó correctamente.");
                        limpiarCajas();
                        establecerModeloTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El alumno " + cajaNombre.getText().toUpperCase() + " " + cajaApPaterno.getText().toUpperCase() + " " + cajaApMaterno.getText().toUpperCase() + "\no el No. de Cuenta " + cajaNumCuenta.getText() + " ya existe.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El número de cuenta debe tener 9 dígitos.");
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void itemRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegresarActionPerformed
        this.dispose();
        Home ventanaHome = new Home();
        ventanaHome.setVisible(true);
    }//GEN-LAST:event_itemRegresarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        sqlAlumno = new SqlAlumnos();
        modAlumno = null;

        modAlumno = sqlAlumno.buscarAlumno(cajaBuscar.getText().toUpperCase());

        if (cajaBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay nada en el campo de busqueda.");//validar que los campos no estén vacíos
        } else {
            if (cajaBuscar.getText().length() != 9) {
                JOptionPane.showMessageDialog(null, "El No. de Cuenta debe tener 9 dígitos.");
            } else {
                if (modAlumno != null) {

                    llenarCajas(modAlumno);
                    cajaBuscar.setText(null);

                } else {
                    JOptionPane.showMessageDialog(null, "El alumno no existe.");
                }
            }
        }

    }//GEN-LAST:event_btBuscarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        sqlAlumno = new SqlAlumnos();

        if (cajaNumCuenta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Busque un registro para borrar.");//validar que los campos no estén vacíos
        } else {

            if (sqlAlumno.borrarAlumno(cajaNumCuenta.getText())) {
                limpiarCajas();
                establecerModeloTabla();
                JOptionPane.showMessageDialog(null, "Registro borrado Correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el registro porque está sujeto a una inscripción.");
            }
        }
    }//GEN-LAST:event_btBorrarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        sqlAlumno = new SqlAlumnos();
        modAlumno = new Alumnos();

        if (cajaNombre.getText().equals("") || cajaApPaterno.getText().equals("") || cajaNumCuenta.getText().equals("") || cajaGeneracion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaNumCuenta.getText().equals(cajaVariable.getText())) {

                modAlumno.setPersNombre(cajaNombre.getText().toUpperCase());
                modAlumno.setPersApPaterno(cajaApPaterno.getText().toUpperCase());
                modAlumno.setPersApMaterno(cajaApMaterno.getText().toUpperCase());
                modAlumno.setNumCuenta(cajaVariable.getText());
                modAlumno.setGeneracion(Integer.parseInt(cajaGeneracion.getText()));

                if (sqlAlumno.actualizarAlumno(modAlumno)) {
                    JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente.");
                    limpiarCajas();
                    establecerModeloTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar.");
                }

            } else {

                JOptionPane.showMessageDialog(null, "El número de cuenta no se debe modificar, intentelo de nuevo.");
                cajaNumCuenta.setText(cajaVariable.getText());
            }

        }
    }//GEN-LAST:event_btActualizarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAlumnos().setVisible(true);
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
    private javax.swing.JTextField cajaGeneracion;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaNumCuenta;
    private javax.swing.JTextField cajaVariable;
    private javax.swing.JMenuItem itemRegresar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAlumnos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tbAlumnos) {
            int fila = tbAlumnos.getSelectedRow();
            Alumnos a = new Alumnos();
            String numero = (String) tbAlumnos.getValueAt(fila, 0);
            a = sqlAlumno.buscarAlumno(numero);           
            cajaVariable.setText(a.getNumCuenta());
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
