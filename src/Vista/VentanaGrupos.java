
package Vista;

import Modelo.Grupos;
import Modelo.Horarios;
import Modelo.Profesores;
import Modelo.SqlGrupos;
import Modelo.SqlHorarios;
import Modelo.SqlProfesores;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date; 
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaGrupos extends javax.swing.JFrame implements MouseListener{

    SqlHorarios sqlHorario;
    SqlGrupos sqlGrupo;
    Horarios modHorario;
    Grupos modGrupo;
    
    public VentanaGrupos() {
        initComponents();
        establecerModeloTablaHorarios();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        cajaVariableHorarios.setVisible(false);
        cajaVariableGrupos.setVisible(false);
        this.sqlHorario = new SqlHorarios();
        tbHorarios.addMouseListener(this);
        rbActivo.setSelected(true);
        establecerModeloTablaProfesores();
        tbProfes.addMouseListener(this);
        establecerModeloTablaGrupos();
        tbGrupos.addMouseListener(this);
        establecerModeloTablaPeriodos();
        tbPeriodos.addMouseListener(this);
        establecerModeloTablaAsignatura();
        tbAsignaturas.addMouseListener(this);
    }
    
    public void limpiarCajasHorarios(){
        cajaIdSalon.setText(null);
        cajaEdificio.setText(null);
        cajaPiso.setText(null);
        cajaClvGrupoHorarios.setText(null);
        cajaVariableHorarios.setText(null);
        cbDia.setSelectedIndex(0);
        cbHora.setSelectedIndex(0);
    }
    
    public void limpiarCajasAsignatura(){
        cajaClaveAsig.setText(null);
        cajaAsignatura.setText(null);
        cbPlanEstudios.setSelectedIndex(0);
    }
    
    public void limpiarCajasPeriodo(){
        cajaIdPeriodo.setText(null);
        cajaFechaInicio.setDate(null);
        cajaFechaFin.setDate(null);
        rbActivo.setSelected(true);
    }
    
    public void limpiarCajasGrupo(){
        cajaVariableGrupos.setText(null);
        cajaClaveGrupo.setText(null);
        cajaCupo.setText(null);
        cajaNumTrabajador.setText(null);
    }
    
    public void llenarTodasCajas(Grupos modGrupo){
        cajaVariableGrupos.setText(modGrupo.getGrupoClave());
        cajaClaveGrupo.setText(modGrupo.getGrupoClave());
        cajaCupo.setText(String.valueOf(modGrupo.getCupo()));
        cajaNumTrabajador.setText(modGrupo.getClaveProfesor());
        cajaIdPeriodo.setText(modGrupo.getIdPriodo());
        cajaFechaInicio.setDate(modGrupo.getFechaInicioPer());
        cajaFechaFin.setDate(modGrupo.getFechaFinPer());
        if(modGrupo.isEstadoPer() == true){
            rbActivo.setSelected(true);
        } else {
            rbInactivo.setSelected(true);
        }
        cajaClaveAsig.setText(modGrupo.getIdAsignatura());
        cajaAsignatura.setText(modGrupo.getNomAsignatura());
        switch(modGrupo.getPlanEstudios()){
            case "2016" :
                cbPlanEstudios.setSelectedIndex(0);
                break;
            case "2012" :
                cbPlanEstudios.setSelectedIndex(1);
                break;
            case "2006" :
                cbPlanEstudios.setSelectedIndex(2);
                break;  
            case "1998" :
                cbPlanEstudios.setSelectedIndex(3);
                break;
        }
    }

    public void establecerModeloTablaHorarios(){
        SqlHorarios sqlHorarios = new SqlHorarios();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbHorarios.setModel(modeloTabla);

        Vector<Horarios> arregloHorarios = sqlHorarios.establecerModeloTablaHorarios();
        modeloTabla.addColumn("Id Horario");
        modeloTabla.addColumn("Grupo");
        modeloTabla.addColumn("Salón");
        modeloTabla.addColumn("Día");
        modeloTabla.addColumn("Hora Inicio");
        modeloTabla.addColumn("Hora Fin");

        if (arregloHorarios != null) {
            for (int i = 0; i < arregloHorarios.size(); i++) {

                Object fila[] = new Object[6];
                fila[0] = arregloHorarios.elementAt(i).getIdHorario();
                fila[1] = arregloHorarios.elementAt(i).getGrupoClave();
                fila[2] = arregloHorarios.elementAt(i).getIdSalon();
                fila[3] = arregloHorarios.elementAt(i).getDia();
                fila[4] = arregloHorarios.elementAt(i).getHoraInicio();
                fila[5] = arregloHorarios.elementAt(i).getHoraFin();

                modeloTabla.addRow(fila);
            }
        }
    }
    
    public void establecerModeloTablaProfesores() {

        SqlProfesores sqlAlumno = new SqlProfesores();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbProfes.setModel(modeloTabla);

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
    
    public void establecerModeloTablaGrupos(){
        SqlGrupos sqlGrupo = new SqlGrupos();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbGrupos.setModel(modeloTabla);

        Vector<Grupos> arregloGrupos = sqlGrupo.establecerModeloTablaGrupos();
        modeloTabla.addColumn("Clave del grupo");
        modeloTabla.addColumn("Periodo");
        modeloTabla.addColumn("Asignatura");
        modeloTabla.addColumn("Profesor");
        modeloTabla.addColumn("Cupo");

        if (arregloGrupos != null) {
            for (int i = 0; i < arregloGrupos.size(); i++) {

                Object fila[] = new Object[5];
                fila[0] = arregloGrupos.elementAt(i).getGrupoClave();
                fila[1] = arregloGrupos.elementAt(i).getIdPriodo();
                fila[2] = arregloGrupos.elementAt(i).getNomAsignatura();
                fila[3] = arregloGrupos.elementAt(i).getClaveProfesor();
                fila[4] = arregloGrupos.elementAt(i).getCupo();

                modeloTabla.addRow(fila);
            }
        }
    }
    
    public void establecerModeloTablaPeriodos(){
        SqlGrupos sqlGrupo = new SqlGrupos();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbPeriodos.setModel(modeloTabla);

        Vector<Grupos> arregloGrupos = sqlGrupo.establecerModeloTablaPeriodos();
        modeloTabla.addColumn("Id Periodo");
        modeloTabla.addColumn("Fecha Inicio");
        modeloTabla.addColumn("Fecha Fin");
        modeloTabla.addColumn("Estado");

        if (arregloGrupos != null) {
            for (int i = 0; i < arregloGrupos.size(); i++) {

                Object fila[] = new Object[4];
                fila[0] = arregloGrupos.elementAt(i).getIdPriodo();
                fila[1] = arregloGrupos.elementAt(i).getFechaInicioPer();
                fila[2] = arregloGrupos.elementAt(i).getFechaFinPer();
                fila[3] = arregloGrupos.elementAt(i).isEstadoPer();

                modeloTabla.addRow(fila);
            }
        }
    }
    
    public void establecerModeloTablaAsignatura(){
        SqlGrupos sqlGrupo = new SqlGrupos();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        tbAsignaturas.setModel(modeloTabla);

        Vector<Grupos> arregloGrupos = sqlGrupo.establecerModeloTablaAsignatura();
        modeloTabla.addColumn("Clave asignatura");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Plan de estudios");

        if (arregloGrupos != null) {
            for (int i = 0; i < arregloGrupos.size(); i++) {

                Object fila[] = new Object[3];
                fila[0] = arregloGrupos.elementAt(i).getIdAsignatura();
                fila[1] = arregloGrupos.elementAt(i).getNomAsignatura();
                fila[2] = arregloGrupos.elementAt(i).getPlanEstudios();

                modeloTabla.addRow(fila);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpEstado = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cajaBuscar = new javax.swing.JTextField();
        btBuscarGrupo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGrupos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProfes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cajaAsignatura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cajaClaveAsig = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btBuscarAsignatura = new javax.swing.JButton();
        btCrearAsignatura = new javax.swing.JButton();
        cbPlanEstudios = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cajaClaveGrupo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cajaCupo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cajaNumTrabajador = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cajaFechaInicio = new com.toedter.calendar.JDateChooser();
        cajaFechaFin = new com.toedter.calendar.JDateChooser();
        rbActivo = new javax.swing.JRadioButton();
        rbInactivo = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        cajaIdPeriodo = new javax.swing.JTextField();
        btBuscarPeriodo = new javax.swing.JButton();
        btCrearPeriodo = new javax.swing.JButton();
        cajaVariableGrupos = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbPeriodos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbAsignaturas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btActualizar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        pnHorarios = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbHorarios = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cajaIdSalon = new javax.swing.JTextField();
        btBuscarSalon = new javax.swing.JButton();
        cajaEdificio = new javax.swing.JTextField();
        cajaPiso = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox<>();
        cbHora = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cajaClvGrupoHorarios = new javax.swing.JTextField();
        btLimpiarHorarios = new javax.swing.JButton();
        btActualizarHorarios = new javax.swing.JButton();
        btBorrarHorarios = new javax.swing.JButton();
        btGuardarHorarios = new javax.swing.JButton();
        btCrearSalon = new javax.swing.JButton();
        cajaVariableHorarios = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemRegresar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GRUPOS (CRUD)");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setPreferredSize(new java.awt.Dimension(625, 900));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/instructor.png"))); // NOI18N

        cajaBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btBuscarGrupo.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btBuscarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btBuscarGrupo.setText("BUSCAR GRUPO");
        btBuscarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarGrupoActionPerformed(evt);
            }
        });

        tbGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Periodo", "Asignatura", "Profesor", "Cupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbGrupos);

        tbProfes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No. TRABAJADOR", "NOMBRE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbProfes);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        cajaAsignatura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Clave: *");

        cajaClaveAsig.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Plan de Estudios:");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setText("ASIGNATURA");

        btBuscarAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btBuscarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarAsignaturaActionPerformed(evt);
            }
        });

        btCrearAsignatura.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btCrearAsignatura.setText("CREAR");
        btCrearAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearAsignaturaActionPerformed(evt);
            }
        });

        cbPlanEstudios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPlanEstudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2012", "2006", "1998" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPlanEstudios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cajaAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cajaClaveAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btBuscarAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btCrearAsignatura)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(92, 92, 92))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cajaClaveAsig, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(btBuscarAsignatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPlanEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btCrearAsignatura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Clave del Grupo: *");

        cajaClaveGrupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Cupo: *");

        cajaCupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("<html>Profesor No. de Trabajador: * </html>");
        jLabel1.setToolTipText("");

        cajaNumTrabajador.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cajaClaveGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaNumTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cajaClaveGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cajaCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaNumTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel7.setText("PERIODO");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Fecha de Inicio:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de Término:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Estado:");

        cajaFechaInicio.setDateFormatString("dd/MM/yyyy");

        cajaFechaFin.setDateFormatString("dd/MM/yyyy");

        rbActivo.setBackground(new java.awt.Color(102, 102, 102));
        gpEstado.add(rbActivo);
        rbActivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbActivo.setText("Activo");

        rbInactivo.setBackground(new java.awt.Color(102, 102, 102));
        gpEstado.add(rbInactivo);
        rbInactivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbInactivo.setText("Inactivo");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Id Periodo: *");

        cajaIdPeriodo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btBuscarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btBuscarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPeriodoActionPerformed(evt);
            }
        });

        btCrearPeriodo.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btCrearPeriodo.setText("CREAR");
        btCrearPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cajaIdPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btBuscarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(41, 41, 41)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(rbActivo)
                                            .addGap(45, 45, 45)
                                            .addComponent(rbInactivo))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(btCrearPeriodo)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cajaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cajaFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)))
                        .addGap(18, 18, 18))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cajaIdPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cajaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cajaFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbInactivo)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbActivo)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(btCrearPeriodo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cajaVariableGrupos.setEditable(false);

        tbPeriodos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbPeriodos);

        tbAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tbAsignaturas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cajaVariableGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btBuscarGrupo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(cajaVariableGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btBuscarGrupo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        btActualizar.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btActualizar)
                .addGap(54, 54, 54)
                .addComponent(btBorrar)
                .addGap(68, 68, 68)
                .addComponent(btGuardar)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btActualizar)
                    .addComponent(btBorrar)
                    .addComponent(btGuardar)
                    .addComponent(btLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("GRUPOS", jPanel2);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hora.png"))); // NOI18N

        tbHorarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbHorarios);

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel15.setText("SALÓN");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Id Salón: *");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Edificio:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Piso:");

        cajaIdSalon.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btBuscarSalon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btBuscarSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarSalonActionPerformed(evt);
            }
        });

        cajaEdificio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cajaPiso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Día:");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Hora:");

        cbDia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado" }));

        cbHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "13:00 - 15:00", "16:00 - 18:00", "18:00 - 20:00", "20:00 - 22:00" }));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Clave Grupo: *");

        cajaClvGrupoHorarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btLimpiarHorarios.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btLimpiarHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escoba.png"))); // NOI18N
        btLimpiarHorarios.setText("LIMPIAR");
        btLimpiarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarHorariosActionPerformed(evt);
            }
        });

        btActualizarHorarios.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btActualizarHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btActualizarHorarios.setText("ACTUALIZAR");
        btActualizarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarHorariosActionPerformed(evt);
            }
        });

        btBorrarHorarios.setBackground(new java.awt.Color(255, 0, 0));
        btBorrarHorarios.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btBorrarHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btBorrarHorarios.setText("BORRAR");
        btBorrarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarHorariosActionPerformed(evt);
            }
        });

        btGuardarHorarios.setBackground(new java.awt.Color(165, 220, 105));
        btGuardarHorarios.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btGuardarHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        btGuardarHorarios.setText("GUARDAR");
        btGuardarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarHorariosActionPerformed(evt);
            }
        });

        btCrearSalon.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btCrearSalon.setText("CREAR");
        btCrearSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearSalonActionPerformed(evt);
            }
        });

        cajaVariableHorarios.setEditable(false);

        javax.swing.GroupLayout pnHorariosLayout = new javax.swing.GroupLayout(pnHorarios);
        pnHorarios.setLayout(pnHorariosLayout);
        pnHorariosLayout.setHorizontalGroup(
            pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHorariosLayout.createSequentialGroup()
                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHorariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(pnHorariosLayout.createSequentialGroup()
                        .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnHorariosLayout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel14))
                            .addGroup(pnHorariosLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btActualizarHorarios)
                                    .addGroup(pnHorariosLayout.createSequentialGroup()
                                        .addComponent(cajaVariableHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(pnHorariosLayout.createSequentialGroup()
                                                    .addComponent(jLabel15)
                                                    .addGap(38, 38, 38))
                                                .addGroup(pnHorariosLayout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cajaIdSalon)
                                                    .addGap(5, 5, 5)))
                                            .addGroup(pnHorariosLayout.createSequentialGroup()
                                                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(24, 24, 24)
                                                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cajaPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cajaEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(5, 5, 5)))))
                                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnHorariosLayout.createSequentialGroup()
                                        .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnHorariosLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel21))
                                            .addGroup(pnHorariosLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel20))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cajaClvGrupoHorarios, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(pnHorariosLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(btBorrarHorarios)))))
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHorariosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btLimpiarHorarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btGuardarHorarios)
                .addGap(30, 30, 30))
            .addGroup(pnHorariosLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btCrearSalon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHorariosLayout.setVerticalGroup(
            pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHorariosLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnHorariosLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(cajaIdSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cajaVariableHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cajaPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cajaClvGrupoHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCrearSalon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(pnHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpiarHorarios)
                    .addComponent(btActualizarHorarios)
                    .addComponent(btBorrarHorarios)
                    .addComponent(btGuardarHorarios))
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("HORARIOS", pnHorarios);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btLimpiarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarHorariosActionPerformed
        limpiarCajasHorarios();
        establecerModeloTablaHorarios();
    }//GEN-LAST:event_btLimpiarHorariosActionPerformed

    private void btCrearSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearSalonActionPerformed
        sqlHorario = new SqlHorarios();
        String idSalon, piso;
        char edificio;

        if (cajaIdSalon.getText().equals("") || cajaEdificio.getText().equals("") || cajaPiso.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos está vacío.");//validar que los campos no estén vacíos
        } else {    
            if (cajaIdSalon.getText().length() == 6) {
                
                idSalon = cajaIdSalon.getText().toUpperCase();
                edificio = cajaEdificio.getText().toUpperCase().charAt(0);
                piso = cajaPiso.getText();
                
                if (sqlHorario.crearSalon(idSalon, edificio, piso)) {
                    JOptionPane.showMessageDialog(null, "El salón se creó correctamente");
                    cajaIdSalon.setText(null);
                    cajaEdificio.setText(null);
                    cajaPiso.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar, el Id del salón ya existe.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El Id del salón debe tener 6 caracteres.");
            }
        }
    }//GEN-LAST:event_btCrearSalonActionPerformed

    private void btBuscarSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarSalonActionPerformed
        sqlHorario = new SqlHorarios();
        String [] valores;

        valores = sqlHorario.buscarSalon(cajaIdSalon.getText().toUpperCase());

        if (cajaIdSalon.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de Id del salón está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaIdSalon.getText().length() != 6) {
                JOptionPane.showMessageDialog(null, "El Id debe ser de 6 dígitos.");
            } else {
                if (valores != null) {
                    cajaEdificio.setText(valores[0]);
                    cajaPiso.setText(valores[1]);
                } else {
                    JOptionPane.showMessageDialog(null, "El salón no existe, puede crearlo.");
                }
            }
        }
    }//GEN-LAST:event_btBuscarSalonActionPerformed

    private void btGuardarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarHorariosActionPerformed
        sqlHorario = new SqlHorarios();
        modHorario = new Horarios();

        if (cajaIdSalon.getText().equals("") || cajaClvGrupoHorarios.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaIdSalon.getText().length() == 6 && cajaClvGrupoHorarios.getText().length() == 4) {

                modHorario.setIdSalon(cajaIdSalon.getText().toUpperCase());
                modHorario.setGrupoClave(cajaClvGrupoHorarios.getText().toUpperCase());
                switch (cbDia.getSelectedIndex()){
                    case 0:
                        modHorario.setIdDia(1);
                        break;
                    case 1:
                        modHorario.setIdDia(2);
                        break;
                    case 2:
                        modHorario.setIdDia(3);
                        break;
                    case 3:
                        modHorario.setIdDia(4);
                        break;
                    case 4:
                        modHorario.setIdDia(5);
                        break;
                    case 5:
                        modHorario.setIdDia(6);
                        break; 
                }
                switch(cbHora.getSelectedIndex()){
                    case 1:
                        modHorario.setIdHora(1);
                        break;
                    case 2:
                        modHorario.setIdHora(2);
                        break;
                    case 3:
                        modHorario.setIdHora(3);
                        break;
                    case 4:
                        modHorario.setIdHora(4);
                        break;
                    case 5:
                        modHorario.setIdHora(5);
                        break;
                    case 6:
                        modHorario.setIdHora(6);
                        break; 
                    case 0:
                        modHorario.setIdHora(7);
                        break;
                }
                if (sqlHorario.guardarHorario(modHorario)) {
                        JOptionPane.showMessageDialog(null, "El registro se guardó correctamente.");
                        limpiarCajasHorarios();
                        establecerModeloTablaHorarios();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar.");
                    }
            } else {
               JOptionPane.showMessageDialog(null, "El Id del grupo debe ser de 6 caracteres y la clave del gupo debe de ser de 4 dígitos");
            }
        }
    }//GEN-LAST:event_btGuardarHorariosActionPerformed

    private void btActualizarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarHorariosActionPerformed
        sqlHorario = new SqlHorarios();
        modHorario = new Horarios();

        if (cajaIdSalon.getText().equals("") || cajaClvGrupoHorarios.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaIdSalon.getText().length() == 6 && cajaClvGrupoHorarios.getText().length() == 4){

                modHorario.setIdSalon(cajaIdSalon.getText().toUpperCase());
                modHorario.setGrupoClave(cajaClvGrupoHorarios.getText().toUpperCase());
                modHorario.setIdHorario(Integer.parseInt(cajaVariableHorarios.getText()));
                switch (cbDia.getSelectedIndex()){
                    case 0:
                        modHorario.setIdDia(1);
                        break;
                    case 1:
                        modHorario.setIdDia(2);
                        break;
                    case 2:
                        modHorario.setIdDia(3);
                        break;
                    case 3:
                        modHorario.setIdDia(4);
                        break;
                    case 4:
                        modHorario.setIdDia(5);
                        break;
                    case 5:
                        modHorario.setIdDia(6);
                        break; 
                }
                switch(cbHora.getSelectedIndex()){
                    case 1:
                        modHorario.setIdHora(1);
                        break;
                    case 2:
                        modHorario.setIdHora(2);
                        break;
                    case 3:
                        modHorario.setIdHora(3);
                        break;
                    case 4:
                        modHorario.setIdHora(4);
                        break;
                    case 5:
                        modHorario.setIdHora(5);
                        break;
                    case 6:
                        modHorario.setIdHora(6);
                        break; 
                    case 0:
                        modHorario.setIdHora(7);
                        break;
                }

                if (sqlHorario.actualizarHorario(modHorario)) {
                    JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente.");
                    limpiarCajasHorarios();
                    establecerModeloTablaHorarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar.");
                }

            } else {

                JOptionPane.showMessageDialog(null, "El Id del grupo debe ser de 6 caracteres y la clave del gupo debe de ser de 4 dígitos");
                
            }

        }
    }//GEN-LAST:event_btActualizarHorariosActionPerformed

    private void btBorrarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarHorariosActionPerformed
        sqlHorario = new SqlHorarios();

        if (cajaVariableHorarios.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro para borrar.");//validar que los campos no estén vacíos
        } else {

            if (sqlHorario.borrarHorario(Integer.parseInt(cajaVariableHorarios.getText())) == true) {
                limpiarCajasHorarios();
                establecerModeloTablaHorarios();
                JOptionPane.showMessageDialog(null, "Registro borrado Correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el registro.");
            }
        }
    }//GEN-LAST:event_btBorrarHorariosActionPerformed

    private void btBuscarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarAsignaturaActionPerformed
        sqlGrupo = new SqlGrupos();
        
        modGrupo = sqlGrupo.buscarAsignatura(cajaClaveAsig.getText().toUpperCase());

        if (cajaClaveAsig.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo clave de asignatura está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaClaveAsig.getText().length() != 4) {
                JOptionPane.showMessageDialog(null, "La clave de asignatura debe tener 4 dígitos");
            } else {
                if (modGrupo != null) {

                    cajaAsignatura.setText(modGrupo.getNomAsignatura());
                    switch(modGrupo.getPlanEstudios()){
                        case "2016" :
                            cbPlanEstudios.setSelectedIndex(0);
                            break;
                        case "2012" :
                            cbPlanEstudios.setSelectedIndex(1);
                            break;
                        case "2006" :
                            cbPlanEstudios.setSelectedIndex(2);
                            break;  
                        case "1998" :
                            cbPlanEstudios.setSelectedIndex(3);
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La asignatura con clave " + cajaClaveAsig.getText() + " no existe, puede crearla.");
                }
            }
        }
    }//GEN-LAST:event_btBuscarAsignaturaActionPerformed

    private void btCrearAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearAsignaturaActionPerformed
        sqlGrupo = new SqlGrupos();
        modGrupo = new Grupos();

        if (cajaClaveAsig.getText().equals("") || cajaAsignatura.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ningún campo de asignatura debe estar vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaClaveAsig.getText().length() != 4) {
                JOptionPane.showMessageDialog(null, "La clave debe tener 4 dígitos");
            } else {

                modGrupo.setIdAsignatura(cajaClaveAsig.getText());
                modGrupo.setNomAsignatura(cajaAsignatura.getText().toUpperCase());
                switch(cbPlanEstudios.getSelectedIndex()){
                    case 0 :
                        modGrupo.setPlanEstudios("2016");
                        break;
                    case 1 :
                        modGrupo.setPlanEstudios("2012");
                        break;
                    case 2 :
                        modGrupo.setPlanEstudios("2006");
                        break;  
                    case 3 :
                        modGrupo.setPlanEstudios("1998");
                        break;
                }
                if (sqlGrupo.crearAsignatura(modGrupo)){
                    JOptionPane.showMessageDialog(null, "La asignatura se creó correctamente");
                    limpiarCajasAsignatura();
                    establecerModeloTablaAsignatura();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar, ya existe la clave de la asignatura.");
                }
            }
        }
    }//GEN-LAST:event_btCrearAsignaturaActionPerformed

    private void btCrearPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearPeriodoActionPerformed
        sqlGrupo = new SqlGrupos();
        modGrupo = new Grupos();

        if (cajaIdPeriodo.getText().equals("") || cajaFechaInicio.getDate() == null || cajaFechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ningún campo debe estar vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaIdPeriodo.getText().length() == 6) {

                Date fecIni = cajaFechaInicio.getDate();
                Date fecFin = cajaFechaFin.getDate();

                long fI = fecIni.getTime();
                long fF = fecFin.getTime();

                java.sql.Date fechaInicio = new java.sql.Date(fI);
                java.sql.Date fechaFin = new java.sql.Date(fF);

                modGrupo.setIdPriodo(cajaIdPeriodo.getText());
                modGrupo.setFechaInicioPer(fechaInicio);
                modGrupo.setFechaFinPer(fechaFin);
                if(rbActivo.isSelected()){
                    modGrupo.setEstadoPer(true);
                }
                if(rbInactivo.isSelected()){
                    modGrupo.setEstadoPer(false);
                }

                if (sqlGrupo.crearPeriodo(modGrupo)) {
                    JOptionPane.showMessageDialog(null, "El periodo se creó correctamente");
                    establecerModeloTablaPeriodos();
                    limpiarCajasPeriodo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar, el Id del periodo ya existe.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Id del periodo debe tener 6 caracteres.");
            }
        }
    }//GEN-LAST:event_btCrearPeriodoActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
       limpiarCajasAsignatura();
       limpiarCajasPeriodo();
       limpiarCajasGrupo();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btBuscarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPeriodoActionPerformed
        sqlGrupo = new SqlGrupos();
        
        modGrupo = sqlGrupo.buscarPeriodo(cajaIdPeriodo.getText());

        if (cajaIdPeriodo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo Id Periodo está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaIdPeriodo.getText().length() != 6) {
                JOptionPane.showMessageDialog(null, "El ID debe tener 6 caracteres.");
            } else {
                if (modGrupo != null) {
                    
                    cajaFechaInicio.setDate(modGrupo.getFechaInicioPer());
                    cajaFechaFin.setDate(modGrupo.getFechaFinPer());
                    if(modGrupo.isEstadoPer() == true){
                        rbActivo.setSelected(true);
                    } else {
                        rbInactivo.setSelected(true);
                    }
                    

                } else {
                    JOptionPane.showMessageDialog(null, "El periodo con el Id " + cajaIdPeriodo.getText() + " no existe, puede crearlo.");
                }
            }
        }
    }//GEN-LAST:event_btBuscarPeriodoActionPerformed

    private void btBuscarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarGrupoActionPerformed
        sqlGrupo = new SqlGrupos();
        
        modGrupo = sqlGrupo.buscarGrupo(cajaBuscar.getText().toUpperCase());

        if (cajaBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de busqueda está vacío.");//validar que los campos no estén vacíos
        } else {
            if (cajaBuscar.getText().length() != 4) {
                JOptionPane.showMessageDialog(null, "La clave debe tener 4 dígitos");
            } else {
                if (modGrupo != null) {
                    
                    llenarTodasCajas(modGrupo);

                } else {
                    JOptionPane.showMessageDialog(null, "La clave del grupo no existe.");
                }
            }
        }
    }//GEN-LAST:event_btBuscarGrupoActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        sqlGrupo = new SqlGrupos();
        modGrupo = new Grupos();
        SqlProfesores sqlProfe = new SqlProfesores();
        
        if (cajaClaveGrupo.getText().equals("") || cajaIdPeriodo.getText().equals("") || cajaNumTrabajador.getText().equals("") || cajaClaveAsig.getText().equals("") || cajaIdPeriodo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else if (cajaClaveGrupo.getText().length() == 4) {

            modGrupo.setGrupoClave(cajaClaveGrupo.getText());
            modGrupo.setClaveProfesor(cajaNumTrabajador.getText());
            modGrupo.setIdPriodo(cajaIdPeriodo.getText());
            modGrupo.setIdAsignatura(cajaClaveAsig.getText());
            modGrupo.setCupo(Integer.parseInt(cajaCupo.getText()));

            if (sqlGrupo.buscarAsignatura(cajaClaveAsig.getText()) == null) {
                JOptionPane.showMessageDialog(null, "La clave de la asignatura no existe, debe crearla.");
            } else if (sqlGrupo.buscarPeriodo(cajaIdPeriodo.getText()) == null) {
                JOptionPane.showMessageDialog(null, "El Id del periodo no existe, debe crearlo.");
            } else if (sqlProfe.buscarProfesor(cajaNumTrabajador.getText()) == null) {
                JOptionPane.showMessageDialog(null, "El número de trabajador no existe, debe crearlo.");
            } else if (sqlGrupo.buscarGrupo(cajaClaveGrupo.getText()) != null) {
                JOptionPane.showMessageDialog(null, "La calve del grupo ya existe.");
            } else {
                if (sqlGrupo.guardarGrupo(modGrupo)) {

                    JOptionPane.showMessageDialog(null, "El registro se guardó correctamente.");
                    limpiarCajasAsignatura();
                    limpiarCajasPeriodo();
                    limpiarCajasGrupo();
                    establecerModeloTablaGrupos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar.");
                }  
            }
        } else {
            JOptionPane.showMessageDialog(null, "La clave del grupo debe ser de 4 dígitos.");
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        sqlGrupo = new SqlGrupos();
        modGrupo = new Grupos();
        SqlProfesores sqlProfe = new SqlProfesores();

        if (cajaClaveGrupo.getText().equals("") || cajaIdPeriodo.getText().equals("") || cajaNumTrabajador.getText().equals("") || cajaClaveAsig.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos obligatorios está vacío.");//validar que los campos no estén vacíos
        } else if (sqlGrupo.buscarAsignatura(cajaClaveAsig.getText()) == null) {
            JOptionPane.showMessageDialog(null, "La clave de la asignatura no existe, debe crearla.");
        } else if (sqlGrupo.buscarPeriodo(cajaIdPeriodo.getText()) == null) {
            JOptionPane.showMessageDialog(null, "El Id del periodo no existe, debe crearlo.");
        } else if (sqlProfe.buscarProfesor(cajaNumTrabajador.getText()) == null) {
            JOptionPane.showMessageDialog(null, "El número de trabajador no existe, debe crearlo.");
        } else if (cajaClaveGrupo.getText().equals(cajaVariableGrupos.getText())) {

            modGrupo.setGrupoClave(cajaClaveGrupo.getText());
            modGrupo.setClaveProfesor(cajaNumTrabajador.getText());
            modGrupo.setIdPriodo(cajaIdPeriodo.getText());
            modGrupo.setIdAsignatura(cajaClaveAsig.getText());
            modGrupo.setCupo(Integer.parseInt(cajaCupo.getText()));

            if (sqlGrupo.actualizarGrupo(modGrupo)) {
                JOptionPane.showMessageDialog(null, "El registro se actualizó correctamente.");
                limpiarCajasAsignatura();
                limpiarCajasPeriodo();
                limpiarCajasGrupo();
                establecerModeloTablaGrupos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }

        } else {

            JOptionPane.showMessageDialog(null, "La clave del grupo no se debe modificar, intentelo de nuevo.");
            cajaClaveGrupo.setText(cajaVariableGrupos.getText());
        }   
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        sqlGrupo = new SqlGrupos();

        if (cajaClaveGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Busque un registro para borrar.");//validar que los campos no estén vacíos
        } else {

            if (sqlGrupo.borrarGrupo(cajaClaveGrupo.getText())) {
                limpiarCajasAsignatura();
                limpiarCajasPeriodo();
                limpiarCajasGrupo();
                establecerModeloTablaGrupos();
                JOptionPane.showMessageDialog(null, "Registro borrado Correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar el registro porque está sujeto a una inscripción.");
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
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btActualizarHorarios;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btBorrarHorarios;
    private javax.swing.JButton btBuscarAsignatura;
    private javax.swing.JButton btBuscarGrupo;
    private javax.swing.JButton btBuscarPeriodo;
    private javax.swing.JButton btBuscarSalon;
    private javax.swing.JButton btCrearAsignatura;
    private javax.swing.JButton btCrearPeriodo;
    private javax.swing.JButton btCrearSalon;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuardarHorarios;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btLimpiarHorarios;
    private javax.swing.JTextField cajaAsignatura;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaClaveAsig;
    private javax.swing.JTextField cajaClaveGrupo;
    private javax.swing.JTextField cajaClvGrupoHorarios;
    private javax.swing.JTextField cajaCupo;
    private javax.swing.JTextField cajaEdificio;
    private com.toedter.calendar.JDateChooser cajaFechaFin;
    private com.toedter.calendar.JDateChooser cajaFechaInicio;
    private javax.swing.JTextField cajaIdPeriodo;
    private javax.swing.JTextField cajaIdSalon;
    private javax.swing.JTextField cajaNumTrabajador;
    private javax.swing.JTextField cajaPiso;
    private javax.swing.JTextField cajaVariableGrupos;
    private javax.swing.JTextField cajaVariableHorarios;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbPlanEstudios;
    private javax.swing.ButtonGroup gpEstado;
    private javax.swing.JMenuItem itemRegresar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnHorarios;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTable tbAsignaturas;
    private javax.swing.JTable tbGrupos;
    private javax.swing.JTable tbHorarios;
    private javax.swing.JTable tbPeriodos;
    private javax.swing.JTable tbProfes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        SqlProfesores sqlProf = new SqlProfesores();
        SqlGrupos sqlGrup = new SqlGrupos();
        
        if (e.getSource() == tbHorarios) {
            int fila = tbHorarios.getSelectedRow();
            Horarios a = new Horarios();
            int numero = (int) tbHorarios.getValueAt(fila, 0);
            a = sqlHorario.buscarHorario(numero);           
            cajaVariableHorarios.setText(String.valueOf(a.getIdHorario()));
            cajaIdSalon.setText(a.getIdSalon());
            cajaEdificio.setText(String.valueOf(a.getEdificio()));
            cajaPiso.setText(a.getPiso());
            cajaClvGrupoHorarios.setText(a.getGrupoClave());
            switch (a.getIdDia()){
                    case 1:
                        cbDia.setSelectedIndex(0);
                        break;
                    case 2:
                        cbDia.setSelectedIndex(1);
                        break;
                    case 3:
                        cbDia.setSelectedIndex(2);
                        break;
                    case 4:
                        cbDia.setSelectedIndex(3);
                        break;
                    case 5:
                        cbDia.setSelectedIndex(4);
                        break;
                    case 6:
                        cbDia.setSelectedIndex(5);
                        break; 
                }
            switch(a.getIdHora()){
                    case 1:
                        cbHora.setSelectedIndex(1);
                        break;
                    case 2:
                        cbHora.setSelectedIndex(2);
                        break;
                    case 3:
                        cbHora.setSelectedIndex(3);
                        break;
                    case 4:
                        cbHora.setSelectedIndex(4);
                        break;
                    case 5:
                        cbHora.setSelectedIndex(5);
                        break;
                    case 6:
                        cbHora.setSelectedIndex(6);
                        break; 
                    case 7:
                        cbHora.setSelectedIndex(0);
                        break;
                }
        }
        if (e.getSource() == tbProfes) {
            int fila = tbProfes.getSelectedRow();
            Profesores a = new Profesores();
            String numero = (String) tbProfes.getValueAt(fila, 0);
            a = sqlProf.buscarProfesor(numero);           
            cajaNumTrabajador.setText(a.getNumTrabajador());
        }
        
        if (e.getSource() == tbGrupos) {
            int fila = tbGrupos.getSelectedRow();
            Grupos a = new Grupos();
            String numero = (String) tbGrupos.getValueAt(fila, 0);
            a = sqlGrup.buscarGrupo(numero);
            llenarTodasCajas(a);
        }
        
        if (e.getSource() == tbPeriodos) {
            int fila = tbPeriodos.getSelectedRow();
            Grupos a = new Grupos();
            String numero = (String) tbPeriodos.getValueAt(fila, 0);
            a = sqlGrup.buscarPeriodo(numero);
            cajaIdPeriodo.setText(a.getIdPriodo());
            cajaFechaInicio.setDate(a.getFechaInicioPer());
            cajaFechaFin.setDate(a.getFechaFinPer());
            if(a.isEstadoPer() == true){
                rbActivo.setSelected(true);
            } else {
                rbInactivo.setSelected(true);
            }
        }
        
        if (e.getSource() == tbAsignaturas) {
            int fila = tbAsignaturas.getSelectedRow();
            Grupos a = new Grupos();
            String numero = (String) tbAsignaturas.getValueAt(fila, 0);
            a = sqlGrup.buscarAsignatura(numero);
            cajaClaveAsig.setText(a.getIdAsignatura());
            cajaAsignatura.setText(a.getNomAsignatura());
            switch(a.getPlanEstudios()){
                case "2016" :
                    cbPlanEstudios.setSelectedIndex(0);
                    break;
                case "2012" :
                    cbPlanEstudios.setSelectedIndex(1);
                    break;
                case "2006" :
                    cbPlanEstudios.setSelectedIndex(2);
                    break;  
                case "1998" :
                    cbPlanEstudios.setSelectedIndex(3);
                    break;
            }
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
