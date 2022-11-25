/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.vista;


import compras.controlador.clsDeudasCompras;
import compras.controlador.clsProveedores;
import compras.modelo.daoDeudasCompras;
import compras.modelo.daoProveedores;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import logistica.controlador.clsProductos;
import logistica.modelo.daoProductos;
import ventas.controlador.clsCliente;
import ventas.modelo.daoCliente;



/**
 *
 * @author visitante
 */
public class frmDeudasCompras extends javax.swing.JInternalFrame {

    public void ComboCliente() {
        daoCliente VentasDAO = new daoCliente();
        List<clsCliente> ventas = VentasDAO.select();
        cbox_procodigo.addItem("Seleccione un cliente");
        //cbox_clicodigo.removeAllItems();
        for (int i = 0; i < ventas.size(); i++) {
            cbox_procodigo.addItem(String.valueOf(ventas.get(i).getClicodigo()));
        }                          //revisarr que sea p minuscula o mayuscula el geyProcodigo
    }
    
        public void ComboEstatus() {
        daoDeudasCompras deudasComprasDAO = new daoDeudasCompras();
        List<clsDeudasCompras> deudasCompras = deudasComprasDAO.select();
        cbox_DeudasEstatus.addItem("Seleccione un Estado");
    }
    
        public void estados() {    
        cbox_DeudasEstatus.addItem("1");
        cbox_DeudasEstatus.addItem("0");
    }
        //HACER CAMBIOS ACA, DE daoProductos a daoCompras
        public void ComboProducto() {
        daoProveedores VentasDAO = new daoProveedores();
        List<clsProveedores> ventas = VentasDAO.select();
        cbox_prodcodigo.addItem("Seleccione un Proveedor");
        //cbox_clicodigo.removeAllItems();
        for (int i = 0; i < ventas.size(); i++) {
            cbox_prodcodigo.addItem(String.valueOf(ventas.get(i).getprocodigo()));
        }
        
    }    
    
// de aca todo nice
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id documento Deudas Compras");//ENCABEZADO
        modelo.addColumn("Proveedor Codigo");
        modelo.addColumn("ID Documento Compras");
        modelo.addColumn("Estatus");
        modelo.addColumn("Codigo Proveedor");
        modelo.addColumn("Total Compras");//DETALLE
        modelo.addColumn("Saldo Documento Deudas Compras");
        modelo.addColumn("Deuda Compra");

        daoDeudasCompras deudorDAO = new daoDeudasCompras();
        List<clsDeudasCompras> deudaCompras = deudorDAO.select();
        daoDeudasCompras deudorDAO2 = new daoDeudasCompras();
        List<clsDeudasCompras> deudaCompras2 = deudorDAO.select2();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[10];
        for (int i = 0; i < deudaCompras.size(); i++) {
            dato[0] = deudaCompras.get(i).getDce_documento(); //ENCABEZADO
            dato[1] = Integer.toString(deudaCompras.get(i).getProcodigo());
            dato[2] = deudaCompras.get(i).getCoedocumento();
            dato[3] = deudaCompras.get(i).getDce_estatus();
            dato[4] = Integer.toString(deudaCompras2.get(i).getProdcodigo());
            dato[5] = Integer.toString(deudaCompras2.get(i).getTotal_compras());//DETALLE
            dato[6] = Integer.toString(deudaCompras2.get(i).getDce_saldo_documento());
            dato[7] = Integer.toString(deudaCompras2.get(i).getDeudacompra());
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {
        clsDeudasCompras DeudasAConsultar = new clsDeudasCompras();
        clsDeudasCompras DeudasAConsultar2 = new clsDeudasCompras();
        daoDeudasCompras deudorDAO = new daoDeudasCompras();   
        daoDeudasCompras deudorDAO2 = new daoDeudasCompras();
        
        //***************************ENCABEZADO*********************************
        DeudasAConsultar.setDce_documento(txtbuscado.getText());
        DeudasAConsultar = deudorDAO.query(DeudasAConsultar); 
        txtIDDocumento.setText(DeudasAConsultar.getDce_documento());
        cbox_procodigo.setSelectedItem(Integer.toString(DeudasAConsultar.getProcodigo()));
        txtIDdocumentoCompras.setText(DeudasAConsultar.getCoedocumento());
        cbox_DeudasEstatus.setSelectedItem(DeudasAConsultar.getDce_estatus());
        
        //***************************DETALLE***********************************
        DeudasAConsultar2.setDce_documento(txtbuscado.getText());
        DeudasAConsultar2 = deudorDAO2.query2(DeudasAConsultar2);
        txtIDDocumento.setText(DeudasAConsultar2.getDce_documento());
        cbox_prodcodigo.setSelectedItem(Integer.toString(DeudasAConsultar2.getProdcodigo()));
        txtTotalCompras.setText(Integer.toString(DeudasAConsultar2.getTotal_compras()));
        txtSaldoDocumento.setText(Integer.toString(DeudasAConsultar2.getDce_saldo_documento()));
        txtDeudaCompra.setText(Integer.toString(DeudasAConsultar2.getDeudacompra()));
        txtIDDocumento.setEnabled(false);
        
    }

    public frmDeudasCompras() {
        initComponents();
        llenadoDeTablas();
        ComboCliente();
        ComboEstatus();
        estados();
        ComboProducto();

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
        txtIDdocumentoCompras = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtSaldoDocumento = new javax.swing.JTextField();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        txtTotalCompras = new javax.swing.JTextField();
        txtDeudaCompra = new javax.swing.JTextField();
        cbox_procodigo = new javax.swing.JComboBox<>();
        cbox_prodcodigo = new javax.swing.JComboBox<>();
        label8 = new javax.swing.JLabel();
        txtIDDocumento = new javax.swing.JTextField();
        cbox_DeudasEstatus = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Ventas");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Ventas");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 95, -1));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Proveedor codigo");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 102, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 95, -1));

        txtIDdocumentoCompras.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIDdocumentoCompras.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtIDdocumentoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 220, -1));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("ID Documento Compras");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, -1, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 20, 13, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, -1, -1));

        txtSaldoDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSaldoDocumento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtSaldoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 260, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Código Proveedor");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 200, -1, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Estatus");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 165, -1, -1));

        tablaVendedores.setBackground(new java.awt.Color(153, 255, 153));
        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 20, 880, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 12)); // NOI18N
        jLabel1.setText("1 = Habilitado y 0 = Inhabilitado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 263, -1));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Total Compras");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 234, -1, -1));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Saldo Documento");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 272, -1, -1));

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Deuda Compra");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 309, -1, -1));

        txtTotalCompras.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTotalCompras.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtTotalCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 263, -1));

        txtDeudaCompra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDeudaCompra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtDeudaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeudaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(txtDeudaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 263, -1));

        cbox_procodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_procodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_procodigoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_procodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 260, -1));

        cbox_prodcodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_prodcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_prodcodigoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_prodcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 263, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("ID Documento");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 57, -1, -1));

        txtIDDocumento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIDDocumento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtIDDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 263, -1));

        getContentPane().add(cbox_DeudasEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 263, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //****************DETALLE****************
        daoDeudasCompras deudorDAO2 = new daoDeudasCompras();
        clsDeudasCompras deudorAEliminar2 = new clsDeudasCompras();
        deudorAEliminar2.setDce_documento(txtbuscado.getText());
        deudorDAO2.delete2(deudorAEliminar2);
        //****************ENCABEZADO****************
        daoDeudasCompras deudorDAO = new daoDeudasCompras();
        clsDeudasCompras deudorAEliminar = new clsDeudasCompras();
        deudorAEliminar.setDce_documento(txtbuscado.getText());
        deudorDAO.delete(deudorAEliminar);        
        llenadoDeTablas();
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoDeudasCompras deudorDAO = new daoDeudasCompras();
        daoDeudasCompras deudorDAO2 = new daoDeudasCompras();
        clsDeudasCompras deudorAInsertar = new clsDeudasCompras();
        clsDeudasCompras deudorAInsertar2 = new clsDeudasCompras();
        //******************ENCABEZADO**********************
        deudorAInsertar.setDce_documento(txtIDDocumento.getText());
        deudorAInsertar.setProcodigo(Integer.parseInt(cbox_procodigo.getSelectedItem().toString()));
        deudorAInsertar.setCoedocumento(txtIDdocumentoCompras.getText());
        deudorAInsertar.setDce_estatus(cbox_DeudasEstatus.getSelectedItem().toString());
        
        //******************DETALLE**************************
        deudorAInsertar2.setDce_documento(txtIDDocumento.getText());
        deudorAInsertar2.setProdcodigo(Integer.parseInt(cbox_prodcodigo.getSelectedItem().toString()));
        deudorAInsertar2.setTotal_compras(Integer.parseInt(txtTotalCompras.getText()));
        deudorAInsertar2.setDce_saldo_documento(Integer.parseInt(txtSaldoDocumento.getText()));
        deudorAInsertar2.setDeudacompra(Integer.parseInt(txtDeudaCompra.getText()));
        
        //deudorAInsertar2.Setbodcodigo(Integer.parseInt(cbox_bodcodigo.getSelectedItem().toString()));
        
        deudorDAO.insert(deudorAInsertar);
        deudorDAO2.insert2(deudorAInsertar2);
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarVendedor();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        daoDeudasCompras deudorDAO2 = new daoDeudasCompras();
        clsDeudasCompras deudorAActualizar2 = new clsDeudasCompras();
        daoDeudasCompras deudorDAO = new daoDeudasCompras();
        clsDeudasCompras deudorAActualizar = new clsDeudasCompras();
        //******************DETALLE**************************
        deudorAActualizar2.setDce_documento(txtIDDocumento.getText());
        deudorAActualizar2.setProdcodigo(Integer.parseInt(cbox_prodcodigo.getSelectedItem().toString()));
        deudorAActualizar2.setTotal_compras(Integer.parseInt(txtTotalCompras.getText()));
        deudorAActualizar2.setDce_saldo_documento(Integer.parseInt(txtSaldoDocumento.getText()));
        deudorAActualizar2.setDeudacompra(Integer.parseInt(txtDeudaCompra.getText()));
        
        deudorDAO2.update2(deudorAActualizar2);
        //******************ENCABEZADO**********************
        deudorAActualizar.setDce_documento(txtIDDocumento.getText());
        deudorAActualizar.setProcodigo(Integer.parseInt(cbox_procodigo.getSelectedItem().toString()));
        deudorAActualizar.setCoedocumento(txtIDdocumentoCompras.getText());
        deudorAActualizar.setDce_estatus(cbox_DeudasEstatus.getSelectedItem().toString());
        
        deudorDAO.update(deudorAActualizar);
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);
        llenadoDeTablas();     
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtIDDocumento.setText("");
        cbox_procodigo.setSelectedIndex(0);
        txtIDdocumentoCompras.setText("");
        cbox_DeudasEstatus.setSelectedIndex(0);
        cbox_prodcodigo.setSelectedIndex(0);
        txtTotalCompras.setText("");
        txtSaldoDocumento.setText("");
        txtDeudaCompra.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        //FUNCION PARA HABILITAR TEXTO DE ID DOCUMENTO
        txtIDDocumento.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

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

    private void txtDeudaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeudaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeudaCompraActionPerformed

    private void cbox_procodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_procodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_procodigoActionPerformed

    private void cbox_prodcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_prodcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_prodcodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_DeudasEstatus;
    private javax.swing.JComboBox<String> cbox_procodigo;
    private javax.swing.JComboBox<String> cbox_prodcodigo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtDeudaCompra;
    private javax.swing.JTextField txtIDDocumento;
    private javax.swing.JTextField txtIDdocumentoCompras;
    private javax.swing.JTextField txtSaldoDocumento;
    private javax.swing.JTextField txtTotalCompras;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
