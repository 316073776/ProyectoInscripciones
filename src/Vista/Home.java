package Vista;

public class Home extends javax.swing.JFrame {

    public Home() {
        
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btAlumnos = new javax.swing.JButton();
        btProfesores = new javax.swing.JButton();
        btGrupos = new javax.swing.JButton();
        btInscripciones = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("¡BIENVENIDO!");

        btAlumnos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escritorios.png"))); // NOI18N
        btAlumnos.setText("ALUMNOS");
        btAlumnos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlumnos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlumnosActionPerformed(evt);
            }
        });

        btProfesores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profesor.png"))); // NOI18N
        btProfesores.setText("PREFESORES");
        btProfesores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btProfesores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProfesoresActionPerformed(evt);
            }
        });

        btGrupos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/instructor.png"))); // NOI18N
        btGrupos.setText("GRUPOS");
        btGrupos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGrupos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGruposActionPerformed(evt);
            }
        });

        btInscripciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btInscripciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/formulario-de-registro.png"))); // NOI18N
        btInscripciones.setText("INSCRIPCIONES");
        btInscripciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btInscripciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInscripcionesActionPerformed(evt);
            }
        });

        btSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btSalir.setText("SALIR");
        btSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAlumnos)
                                .addGap(18, 18, 18)
                                .addComponent(btProfesores))
                            .addComponent(btInscripciones))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSalir)
                            .addComponent(btGrupos))))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAlumnos)
                    .addComponent(btProfesores)
                    .addComponent(btGrupos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btInscripciones)
                    .addComponent(btSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

    private void btAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlumnosActionPerformed
        this.dispose();
        VentanaAlumnos ventanaAlumnos = new VentanaAlumnos();
        ventanaAlumnos.setVisible(true);
    }//GEN-LAST:event_btAlumnosActionPerformed

    private void btProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProfesoresActionPerformed
        this.dispose();
        VentanaProfesores ventanaProfesores = new VentanaProfesores();
        ventanaProfesores.setVisible(true);
    }//GEN-LAST:event_btProfesoresActionPerformed

    private void btGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGruposActionPerformed
        this.dispose();
        VentanaGrupos ventanaGrupos = new VentanaGrupos();
        ventanaGrupos.setVisible(true);
    }//GEN-LAST:event_btGruposActionPerformed

    private void btInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInscripcionesActionPerformed
        this.dispose();
        VentanaInscripciones ventanaInscripciones = new VentanaInscripciones();
        ventanaInscripciones.setVisible(true);
    }//GEN-LAST:event_btInscripcionesActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlumnos;
    private javax.swing.JButton btGrupos;
    private javax.swing.JButton btInscripciones;
    private javax.swing.JButton btProfesores;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
