/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.vista;

import colegio.modelo.daoAlumno;
import colegio.controlador.clsAlumnos;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;


/**
 *
 * @author visitante
 */
public class frmMantenimientoAlumnos extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
        /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        }*/
    }

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Carne");
        modelo.addColumn("nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Mail");
        modelo.addColumn("Estatus");
      
        daoAlumno alumnosDAO = new daoAlumno();
        List<clsAlumnos> alumnos = alumnosDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < alumnos.size(); i++) {
            dato[0] = Integer.toString(alumnos.get(i).getcarnet_alumno());
            dato[1] = alumnos.get(i).getnombre_alumno();
            dato[2] = alumnos.get(i).gettelefono_alumno();
            dato[3] = alumnos.get(i).getemail_alumno();
            dato[4] = alumnos.get(i).getestatus_alumno();
           
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {
        clsAlumnos alumnosAConsultar = new clsAlumnos();
        daoAlumno alumnosDAO = new daoAlumno();
        alumnosAConsultar.setcarnet_alumno(Integer.parseInt(txtbuscado.getText()));
        alumnosAConsultar = alumnosDAO.query(alumnosAConsultar);
        txtNombre.setText(alumnosAConsultar.getnombre_alumno());        
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        cbox_empleado = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtUltimaSesion = new javax.swing.JTextField();
        txtEstatus = new javax.swing.JTextField();
        txtNombreReal = new javax.swing.JTextField();
        txtCorreoE = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblUsuarioRegistrado = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Usuarios");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Vendedor");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID usuario", "nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        cbox_empleado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_empleadoActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Empleado:");

        txtContrasena.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtContrasena.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtContrasena.setOpaque(false);

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Contraseña");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtUltimaSesion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUltimaSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtUltimaSesion.setOpaque(false);

        txtEstatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEstatus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtEstatus.setOpaque(false);

        txtNombreReal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombreReal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombreReal.setOpaque(false);

        txtCorreoE.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCorreoE.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCorreoE.setOpaque(false);

        txtTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtTelefono.setOpaque(false);

        txtDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtDireccion.setOpaque(false);

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("FecUltimaSesion");

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Estatus");

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Nombre Real");

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Correo E");

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Telefono");

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Direccion");

        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblUsuarioRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label11)
                                            .addComponent(label10)
                                            .addComponent(label9)
                                            .addComponent(label8)
                                            .addComponent(label7)
                                            .addComponent(label6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombreReal, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCorreoE, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUltimaSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(294, 294, 294))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(135, 135, 135)
                .addComponent(label4)
                .addGap(46, 46, 46)
                .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblUsuarioRegistrado)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3)))
                            .addComponent(lb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUltimaSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label11)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(cbox_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoAlumno alumnosDAO = new daoAlumno();
        clsAlumnos alumnosAEliminar = new clsAlumnos();
        alumnosAEliminar.setcarnet_alumno(Integer.parseInt(txtbuscado.getText()));
        alumnosDAO.delete(alumnosAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoAlumno alumnosDAO = new daoAlumno();
        clsAlumnos alumnosAInsertar = new clsAlumnos();
        alumnosAInsertar.setcarnet_alumno(Integer.valueOf(txtNombre.getText()));
        alumnosAInsertar.setnombre_alumno(txtNombre.getText());
        alumnosAInsertar.setdireccion_alumno(txtContrasena.getText());
        alumnosAInsertar.settelefono_alumno(txtUltimaSesion.getText());        
        alumnosAInsertar.setemail_alumno(txtEstatus.getText());
        alumnosAInsertar.setestatus_alumno(txtNombreReal.getText());        
       
        
        alumnosDAO.insert(alumnosAInsertar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoAlumno alumnosDAO = new daoAlumno();
        clsAlumnos alumnosAActualizar = new clsAlumnos();
        alumnosAActualizar.setcarnet_alumno(Integer.parseInt(txtbuscado.getText()));
        alumnosAActualizar.setnombre_alumno(txtNombre.getText());
        alumnosAActualizar.setdireccion_alumno(txtContrasena.getText());        
        alumnosAActualizar.settelefono_alumno(txtUltimaSesion.getText());
        alumnosAActualizar.setemail_alumno(txtEstatus.getText());
        alumnosAActualizar.setestatus_alumno(txtNombreReal.getText());
        
        alumnosDAO.update(alumnosAActualizar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbox_empleado.setSelectedIndex(0);
        txtNombre.setText("");
        txtContrasena.setText("");
        txtUltimaSesion.setText("");
        txtEstatus.setText("");
        txtNombreReal.setText("");        
        txtCorreoE.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbox_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_empleadoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_empleadoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_empleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lblUsuarioRegistrado;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreoE;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreReal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUltimaSesion;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
