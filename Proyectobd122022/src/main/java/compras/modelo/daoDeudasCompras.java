/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsDeudasCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;

/**
 *
 * @author visitante
 */
public class daoDeudasCompras {

    private static final String SQL_SELECT = "SELECT dce_documento, procodigo, coedocumento, dce_estatus FROM deudas_compras_encabezado";
    private static final String SQL_SELECT2 = "SELECT dce_documento, prodcodigo, total_compras, dce_saldo_documento, deudacompra FROM deudas_compras_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO deudas_compras_encabezado(dce_documento, procodigo, coedocumento, dce_estatus) VALUES(?, ?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO deudas_compras_detalle(dce_documento, prodcodigo, total_compras, dce_saldo_documento, deudacompra) VALUES( ?, ?, ?, ?, ?)";
    
    //private static final String SQL_UPDATE = "UPDATE tbl_ventas_encabezado SET clicodigo=?, veefecha=?, veetotal=?, veeestatus=?  WHERE dce_documento = ?";
    private static final String SQL_UPDATE = "UPDATE proyectobd122022.deudas_compras_encabezado SET procodigo = ?, coedocumento = ?, dce_estatus = ? WHERE (dce_documento = ?)";
    //private static final String SQL_UPDATE2 = "UPDATE tbl_ventas_detalle SET procodigo=?, prodcodigo=?, vedcantidad=?, vedprecio=?, bodcodigo=? WHERE dce_documento = ?";
    private static final String SQL_UPDATE2 = "UPDATE proyectobd122022.deudas_compras_detalle SET prodcodigo = ?, total_compras = ?, dce_saldo_documento = ?, deudacompra = ? WHERE (dce_documento = ?)";

    private static final String SQL_DELETE = "DELETE FROM proyectobd122022.deudas_compras_encabezado WHERE (dce_documento = ?)";
    private static final String SQL_DELETE2 = "DELETE FROM proyectobd122022.deudas_compras_detalle WHERE (dce_documento = ?)";

    private static final String SQL_QUERY = "SELECT dce_documento, procodigo, coedocumento, dce_estatus FROM deudas_compras_encabezado WHERE dce_documento = ?";
    private static final String SQL_QUERY2 = "SELECT dce_documento, prodcodigo, total_compras, dce_saldo_documento, deudacompra FROM deudas_compras_detalle WHERE dce_documento = ?";


    public List<clsDeudasCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsDeudasCompras DeudaCompra = null;
        List<clsDeudasCompras> DeudasCompras = new ArrayList<clsDeudasCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dce_documento = rs.getString("dce_documento");
                int procodigo = rs.getInt("procodigo");
                String coedocumento = rs.getString("coedocumento");
                String dce_estatus = rs.getString("dce_estatus");


                DeudaCompra = new clsDeudasCompras();
                DeudaCompra.setDce_documento(dce_documento);
                DeudaCompra.setProcodigo(procodigo);
                DeudaCompra.setCoedocumento(coedocumento);
                DeudaCompra.setDce_estatus(dce_estatus);

                
                DeudasCompras.add(DeudaCompra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return DeudasCompras;
    }
    
        public List<clsDeudasCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsDeudasCompras DeudaCompra = null;
        List<clsDeudasCompras> DeudasCompras = new ArrayList<clsDeudasCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dce_documento = rs.getString("dce_documento");
                int prodcodigo = rs.getInt("prodcodigo");
                int total_compras = rs.getInt("total_compras");
                int dce_saldo_documento = rs.getInt("dce_saldo_documento");
                int deudacompra = rs.getInt("deudacompra");



                DeudaCompra = new clsDeudasCompras();
                DeudaCompra.setDce_documento(dce_documento);
                DeudaCompra.setProdcodigo(prodcodigo);
                DeudaCompra.setTotal_compras(total_compras);
                DeudaCompra.setDce_saldo_documento(dce_saldo_documento);
                DeudaCompra.setDeudacompra(deudacompra);
                
                
                DeudasCompras.add(DeudaCompra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return DeudasCompras;
    }

    public int insert(clsDeudasCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vanta.getDce_documento());
            stmt.setInt(2, vanta.getProcodigo());
            stmt.setString(3, vanta.getCoedocumento());
            stmt.setString(4, vanta.getDce_estatus());



            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }
    
        public int insert2(clsDeudasCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setString(1, vanta.getDce_documento());
            stmt.setInt(2, vanta.getProdcodigo());
            stmt.setInt(3, vanta.getTotal_compras());
            stmt.setInt(4, vanta.getDce_saldo_documento());
            stmt.setInt(5, vanta.getDeudacompra());



            System.out.println("ejecutando query:" + SQL_INSERT2);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsDeudasCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, vanta.getProcodigo());
            stmt.setString(2, vanta.getCoedocumento());
            stmt.setString(3, vanta.getDce_estatus());
            stmt.setString(4, vanta.getDce_documento());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }
    
        public int update2(clsDeudasCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, vanta.getProdcodigo());
            stmt.setInt(2, vanta.getTotal_compras());
            stmt.setInt(3, vanta.getDce_saldo_documento());
            stmt.setInt(4, vanta.getDeudacompra());
            stmt.setString(5, vanta.getDce_documento());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsDeudasCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vanta.getDce_documento());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }
    
        public int delete2(clsDeudasCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setString(1, vanta.getDce_documento());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsDeudasCompras query(clsDeudasCompras vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsDeudasCompras> deudores = new ArrayList<clsDeudasCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, vanta.getDce_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dce_documento = rs.getString("dce_documento");
                int procodigo = rs.getInt("procodigo");
                String coedocumento = rs.getString("coedocumento");
                String dce_estatus = rs.getString("dce_estatus");
                
                vanta = new clsDeudasCompras();
                vanta.setDce_documento(dce_documento);
                vanta.setProcodigo(procodigo);
                vanta.setCoedocumento(coedocumento);
                vanta.setDce_estatus(dce_estatus);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return vanta;
    }
    
        public clsDeudasCompras query2(clsDeudasCompras vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsDeudasCompras> vendedores = new ArrayList<clsDeudasCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, vanta.getDce_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String dce_documento = rs.getString("dce_documento");
                int prodcodigo = rs.getInt("prodcodigo");
                int total_compras = rs.getInt("total_compras");
                int dce_saldo_documento = rs.getInt("dce_saldo_documento");
                int deudacompra = rs.getInt("deudacompra");
                
                vanta = new clsDeudasCompras();
                vanta.setDce_documento(dce_documento);
                vanta.setProdcodigo(prodcodigo);
                vanta.setTotal_compras(total_compras);
                vanta.setDce_saldo_documento(dce_saldo_documento);
                vanta.setDeudacompra(deudacompra);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return vanta;
    }
   
}

