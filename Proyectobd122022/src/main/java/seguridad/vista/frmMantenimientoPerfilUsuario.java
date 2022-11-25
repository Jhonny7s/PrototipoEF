/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;


import seguridad.modelo.daoPerfilUsuario;
import seguridad.modelo.daoUsuario;
import seguridad.controlador.clsPerfilUsuario;
import seguridad.controlador.clsUsuario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.controlador.clsPerfil;
import seguridad.modelo.daoPerfil;


/**
 *
 * @author visitante
 */
public class frmMantenimientoPerfilUsuario extends javax.swing.JInternalFrame {
    

public void llenadoDeCodigos() {
        daoPerfil cargoDAO = new daoPerfil();
        List<clsPerfil> cargos = cargoDAO.select();
        
        cbox_codigo.addItem("Cargos disponibles");
        for (int i = 0; i < cargos.size(); i++) {
          String nuevo1= cargos.get(i).getNombrePerfil();
            int nuevo2= cargos.get(i).getId_perfil();
            cbox_codigo.addItem(nuevo2+"-"+nuevo1);
        }
        
    }
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Aplicacion");
        
        daoUsuario aplicacionDAO = new daoUsuario();
        List<clsUsuario> aplicaciones = aplicacionDAO.select();
        tablaVendedores.setModel(modelo);
        
        String[] dato = new String[3];
        for (int i = 0; i < aplicaciones.size(); i++) {
            
             dato[0] = Integer.toString(aplicaciones.get(i).getUsuid());
            dato[1] = aplicaciones.get(i).getUsunombre();
        
           
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
        
    }      
   
    public void buscarVendedor()
    {
        clsPerfilUsuario AConsultar = new clsPerfilUsuario();
        daoPerfilUsuario perDAO = new daoPerfilUsuario();
        AConsultar.setPerid(txtperid.getText());
        DefaultTableModel modelo = new DefaultTableModel();
            
        modelo.addColumn("ID Usuario");
        modelo.addColumn("ID Perfil");
        modelo.addColumn("Nombre del Usuario");
        
        //daoPerfilUsuario aplicacion = new daoPerfilUsuario();
        List<clsPerfilUsuario> aplicaciones = perDAO.select2(AConsultar);
        tablaAsignacion.setModel(modelo);
        int c=0;     
        
        String[] dato = new String[3];
        for (int i = 0; i < aplicaciones.size(); i++) {
            c=i+1;
            dato[0] = aplicaciones.get(i).getUsuid();
            dato[1] = aplicaciones.get(i).getPerid();
            dato[2] = aplicaciones.get(i).getUsunombre();
           System.out.println(dato[2]);
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        
        }
         //busqueda de perfil
         List<clsPerfilUsuario> aplicacione = perDAO.select3(AConsultar);
        tablaAsignacion.setModel(modelo);
                
        String[] datos = new String[3];
        for (int i = 0; i < aplicacione.size(); i++) {
           
            datos[2] = aplicacione.get(i).getPernombre();
          
            }
      String buscar = txtperid.getText();
                  
          //Usuario1
          String activo= aplicacione.get(0).getPernombre();
            txtactivo.setText(activo);
            System.out.println(activo);
                ;
 
       /*
       String activo= aplicacione.get(Integer.parseInt(buscar)).getPernombre();
         String pure= datos[2];
        System.out.println(activo); */
    
    }
     public void buscarVendedores()
    {
        clsPerfilUsuario AConsultar = new clsPerfilUsuario();
        daoPerfilUsuario perDAO = new daoPerfilUsuario();
        AConsultar.setPerid(txtperid.getText());
        DefaultTableModel modelo = new DefaultTableModel();
            
        modelo.addColumn("ID Usuario");
        modelo.addColumn("ID Perfil");
        modelo.addColumn("Nombre del Usuario");
        
        //daoPerfilUsuario aplicacion = new daoPerfilUsuario();
        List<clsPerfilUsuario> aplicaciones = perDAO.select2(AConsultar);
        tablaAsignacion.setModel(modelo);
                
        String[] dato = new String[9];
        
        for (int i = 0; i < aplicaciones.size(); i++) {
           for (int j=0; j<aplicaciones.size(); j++){
             dato[0] = aplicaciones.get(j).getUsuid();
            dato[1] = aplicaciones.get(j).getPerid();
            dato[2] = aplicaciones.get(j).getUsunombre();
    }        
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
         //busqueda de perfil
         List<clsPerfilUsuario> aplicacione = perDAO.select3(AConsultar);
        tablaAsignacion.setModel(modelo);
                
        String[] datos = new String[3];
        for (int i = 0; i < aplicacione.size(); i++) {
           
            datos[2] = aplicacione.get(i).getPernombre();
          
            }
      String buscar = txtperid.getText();
                  
          //Usuario1
          String activo= aplicacione.get(0).getPernombre();
            txtactivo.setText(activo);
            System.out.println(activo);
                ;
 
       /*
       String activo= aplicacione.get(Integer.parseInt(buscar)).getPernombre();
         String pure= datos[2];
        System.out.println(activo); */
    
    }
           
           

    

   

    public frmMantenimientoPerfilUsuario() {
        initComponents();
        llenadoDeTablas(); 
        llenadoDeCodigos();
     
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsignacion = new javax.swing.JTable();
        lbl_Aaplicacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_code = new javax.swing.JLabel();
        txtapid = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtperid = new javax.swing.JTextField();
        lbl_code1 = new javax.swing.JLabel();
        cbox_codigo = new javax.swing.JComboBox<>();
        txtactivo = new javax.swing.JTextField();
        lbl_code2 = new javax.swing.JLabel();
        lbl_code3 = new javax.swing.JLabel();
        lbl_code4 = new javax.swing.JLabel();
        lbl_code5 = new javax.swing.JLabel();
        lbl_code6 = new javax.swing.JLabel();
        lbl_code7 = new javax.swing.JLabel();
        lbl_code8 = new javax.swing.JLabel();
        lbl_code9 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Perfil aplicaciones");
        setPreferredSize(new java.awt.Dimension(900, 400));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAsignacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id usuario", "Id perfil", "Nombre Usuario"
            }
        ));
        jScrollPane2.setViewportView(tablaAsignacion);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 430, 210));

        lbl_Aaplicacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Aaplicacion.setText("Asignacion de perfil");
        getContentPane().add(lbl_Aaplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Usuarios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        lbl_code.setText("que quiere");
        getContentPane().add(lbl_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 10));

        txtapid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapidActionPerformed(evt);
            }
        });
        getContentPane().add(txtapid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 100, -1));

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 290, 210));

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 140, 80, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 180, 80, -1));

        jButton4.setText("Agregar todos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 220, 120, -1));

        jButton5.setText("Eliminar todos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 130, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        txtperid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtperidActionPerformed(evt);
            }
        });
        getContentPane().add(txtperid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 100, -1));

        lbl_code1.setText("Perfiles ");
        getContentPane().add(lbl_code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 100, -1));

        getContentPane().add(cbox_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 160, -1));

        txtactivo.setEditable(false);
        txtactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtactivoActionPerformed(evt);
            }
        });
        getContentPane().add(txtactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 120, -1));

        lbl_code2.setText("Ingrese el");
        getContentPane().add(lbl_code2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 10));

        lbl_code3.setText(" modificar:");
        getContentPane().add(lbl_code3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, 10));

        lbl_code4.setText(" Id del codigo");
        getContentPane().add(lbl_code4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, 10));

        lbl_code5.setText("disponibles");
        getContentPane().add(lbl_code5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 100, -1));

        lbl_code6.setText("del perfil que");
        getContentPane().add(lbl_code6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 100, -1));

        lbl_code7.setText("Perfil actual");
        getContentPane().add(lbl_code7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, -1));

        lbl_code8.setText("Ingrese el codigo ");
        getContentPane().add(lbl_code8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 100, -1));

        lbl_code9.setText("desea buscar:");
        getContentPane().add(lbl_code9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtapidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        daoPerfilUsuario vendedorDAO = new daoPerfilUsuario();
        clsPerfilUsuario vendedorAInsertar = new clsPerfilUsuario();
        vendedorAInsertar.setPerid(txtperid.getText());
        vendedorAInsertar.setUsuid(txtapid.getText());
        vendedorDAO.insert(vendedorAInsertar);
        llenadoDeTablas();
        buscarVendedor();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        daoPerfilUsuario vendedorDAO = new daoPerfilUsuario();
        clsPerfilUsuario vendedorAInsertar = new clsPerfilUsuario();
        vendedorAInsertar.setPerid(txtperid.getText());
        vendedorAInsertar.setUsuid(txtapid.getText());
        vendedorDAO.insert(vendedorAInsertar);
        llenadoDeTablas();
        buscarVendedor();
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        daoPerfilUsuario aplicacionDAO = new daoPerfilUsuario();
        clsPerfilUsuario aplicacionAEliminar = new clsPerfilUsuario();
        aplicacionAEliminar.setPerid(txtapid.getText());
        aplicacionDAO.delete2(aplicacionAEliminar);
        llenadoDeTablas();
        buscarVendedor();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        daoPerfilUsuario aplicacionDAO = new daoPerfilUsuario();
        clsPerfilUsuario aplicacionAEliminar = new clsPerfilUsuario();
        aplicacionAEliminar.setPerid(txtapid.getText());
        aplicacionDAO.delete2(aplicacionAEliminar);
        llenadoDeTablas();
        buscarVendedor();
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        daoPerfilUsuario vendedorDAO = new daoPerfilUsuario();
        clsPerfilUsuario vendedorAInsertar = new clsPerfilUsuario();

        vendedorAInsertar.setPerid(txtperid.getText());
        vendedorAInsertar.setUsuid(txtapid.getText());
        vendedorDAO.insert1(vendedorAInsertar);
        llenadoDeTablas();
        buscarVendedores();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        daoPerfilUsuario vendedorDAO = new daoPerfilUsuario();
        clsPerfilUsuario vendedorAInsertar = new clsPerfilUsuario();

        vendedorAInsertar.setPerid(txtperid.getText());
        vendedorAInsertar.setUsuid(txtapid.getText());
        vendedorDAO.insert(vendedorAInsertar);
        llenadoDeTablas();
        buscarVendedores();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        daoPerfilUsuario aplicacionDAO = new daoPerfilUsuario();
        clsPerfilUsuario aplicacionAEliminar = new clsPerfilUsuario();
        aplicacionAEliminar.setUsuid(txtperid.getText());
        aplicacionDAO.delete1(aplicacionAEliminar);
        llenadoDeTablas();
        buscarVendedor();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
        daoPerfilUsuario aplicacionDAO = new daoPerfilUsuario();
        clsPerfilUsuario aplicacionAEliminar = new clsPerfilUsuario();
        aplicacionAEliminar.setUsuid(txtperid.getText());
        aplicacionDAO.delete1(aplicacionAEliminar);
        llenadoDeTablas();
        buscarVendedor();
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_jButton1KeyPressed

    private void txtperidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtperidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtperidActionPerformed

    private void txtactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtactivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbox_codigo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbl_Aaplicacion;
    private javax.swing.JLabel lbl_code;
    private javax.swing.JLabel lbl_code1;
    private javax.swing.JLabel lbl_code2;
    private javax.swing.JLabel lbl_code3;
    private javax.swing.JLabel lbl_code4;
    private javax.swing.JLabel lbl_code5;
    private javax.swing.JLabel lbl_code6;
    private javax.swing.JLabel lbl_code7;
    private javax.swing.JLabel lbl_code8;
    private javax.swing.JLabel lbl_code9;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaAsignacion;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtactivo;
    private javax.swing.JTextField txtapid;
    private javax.swing.JTextField txtperid;
    // End of variables declaration//GEN-END:variables
}
