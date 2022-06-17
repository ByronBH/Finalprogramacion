/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio.vista;

import colegio.modelo.daoFacultad;
import colegio.controlador.clsFacultades;
import java.awt.Desktop;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.net.URI;
import javax.swing.JOptionPane;
/**
 *
 * @author visitante
 */
public class frmMantenimientofacultad extends javax.swing.JInternalFrame {

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
        modelo.addColumn("codigo_facultad");
        modelo.addColumn("nombre_facultad");
        modelo.addColumn("estatus_facultad");
        
        daoFacultad facultadDAO = new daoFacultad();
        List<clsFacultades> facultades = facultadDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[3];
        for (int i = 0; i < facultades.size(); i++) {
            dato[0] = Integer.toString(facultades.get(i).getcodigo_facultad());
            dato[1] = facultades.get(i).getnombre_facultad();
            dato[2] = facultades.get(i).getestatus_facultad();
            
            //System.out.println("facultad:" + facultades);
            modelo.addRow(dato);
        }
    }
    public void estado() {    
        cbox_estado.addItem("Seleccione una opción");
        cbox_estado.addItem("activo");
        cbox_estado.addItem("inactivo");
    }

    public void buscarVendedor() {
        clsFacultades facultadAConsultar = new clsFacultades();
        daoFacultad facultadDAO = new daoFacultad();
        facultadAConsultar.setcodigo_facultad(Integer.parseInt(txtbuscado.getText()));
        facultadAConsultar = facultadDAO.query(facultadAConsultar);
        txtNombre.setText(facultadAConsultar.getnombre_facultad());   
        cbox_estado.setSelectedItem(facultadAConsultar.getestatus_facultad());
        
    }

    public frmMantenimientofacultad() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        estado();
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
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        cbox_estado = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Facultad");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Facultades");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 95, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Nombre Facultad");
        label3.setToolTipText("En este apartado se agrega el nombre de los departamentos que tiene la empresa");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 240, 20));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 95, -1));

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "deparid", "deparnombre", "deparestado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 556, 303));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText(".");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 350, 20, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 20, 13, -1));

        jButton2.setText("?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 90, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Estado");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        cbox_estado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_estadoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 200, 20));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
        int i =JOptionPane.showConfirmDialog(this, "seguro que quieres borrar este dato ");
        if ( i == 0){
        daoFacultad facultadDAO = new daoFacultad();
        clsFacultades facultadAEliminar = new clsFacultades();
        facultadAEliminar.setcodigo_facultad(Integer.parseInt(txtbuscado.getText()));
        facultadDAO.delete(facultadAEliminar);
       
        }else if(1==1){
         JOptionPane.showMessageDialog(this, "no se a borrado los datos ");
        }
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoFacultad facultadDAO = new daoFacultad();
        clsFacultades facultadAInsertar = new clsFacultades();
        facultadAInsertar.setnombre_facultad(txtNombre.getText());
         facultadAInsertar.setestatus_facultad(cbox_estado.getSelectedItem().toString());
        facultadDAO.insert(facultadAInsertar);
        
        llenadoDeTablas();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
  int i =JOptionPane.showConfirmDialog(this, "seguro que quieres modificar este dato ");
        if ( i == 0){
        daoFacultad facultadDAO = new daoFacultad();
        clsFacultades facultadAActualizar = new clsFacultades();
        facultadAActualizar.setcodigo_facultad(Integer.parseInt(txtbuscado.getText()));
        facultadAActualizar.setnombre_facultad(txtNombre.getText());
        facultadAActualizar.setestatus_facultad(cbox_estado.getSelectedItem().toString());
        facultadDAO.update(facultadAActualizar);
        
        } else if(1==1){
         JOptionPane.showMessageDialog(this, "no se a modificado los datos ");
        }
         llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       
        txtNombre.setText("");
        cbox_estado.setSelectedIndex(0);
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            
            Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/16u3Iz38pFTR4hnO8JYcy_20Z1Mx9oDUJ/view?usp=sharing"));
        } catch (Exception e){
JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
 

        }
    }//GEN-LAST:event_jButton2ActionPerformed


    private void cbox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_estadoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_estado;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
