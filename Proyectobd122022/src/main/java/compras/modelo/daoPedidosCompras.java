/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsPedidosCompras;
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
public class daoPedidosCompras {

    private static final String SQL_SELECT = "SELECT pce_documento, procodigo, pce_fecha, pce_total, pce_estatus FROM pedidos_compras_encabezado";
    private static final String SQL_SELECT2 = "SELECT pce_documento, pcd_orden, prodcodigo, pcd_cantidad_producto, pcd_costo_producto FROM pedidos_compras_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO pedidos_compras_encabezado(pce_documento, procodigo, pce_fecha, pce_total, pce_estatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO pedidos_compras_detalle(pce_documento, pcd_orden, prodcodigo, pcd_cantidad_producto, pcd_costo_producto) VALUES( ?, ?, ?, ?, ?)";
    
    //private static final String SQL_UPDATE = "UPDATE tbl_ventas_encabezado SET clicodigo=?, veefecha=?, veetotal=?, veeestatus=?  WHERE veedocumento = ?";
    private static final String SQL_UPDATE = "UPDATE proyectobd122022.pedidos_compras_encabezado SET procodigo = ?, pce_fecha = ?, pce_total = ?, pce_estatus = ? WHERE (pce_documento = ?)";
    //private static final String SQL_UPDATE2 = "UPDATE tbl_ventas_detalle SET vedorden=?, prodcodigo=?, vedcantidad=?, vedprecio=?, bodcodigo=? WHERE veedocumento = ?";
    private static final String SQL_UPDATE2 = "UPDATE proyectobd122022.pedidos_compras_detalle SET pcd_orden = ?, prodcodigo = ?, pcd_cantidad_producto = ?, pcd_costo_producto = ? WHERE (pce_documento = ?)";

    private static final String SQL_DELETE = "DELETE FROM proyectobd122022.pedidos_compras_encabezado WHERE (pce_documento = ?)";
    private static final String SQL_DELETE2 = "DELETE FROM proyectobd122022.pedidos_compras_detalle WHERE (pce_documento = ?)";

    private static final String SQL_QUERY = "SELECT pce_documento, procodigo, pce_fecha, pce_total, pce_estatus FROM pedidos_compras_encabezado WHERE pce_documento = ?";
    private static final String SQL_QUERY2 = "SELECT pce_documento, pcd_orden, prodcodigo, pcd_cantidad_producto, pcd_costo_producto FROM pedidos_compras_detalle WHERE pce_documento = ?";


    public List<clsPedidosCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPedidosCompras pedido = null;
        List<clsPedidosCompras> pedidos = new ArrayList<clsPedidosCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pce_documento = rs.getString("pce_documento");
                int procodigo = rs.getInt("procodigo");
                String pce_fecha = rs.getString("pce_fecha");
                int pce_total = rs.getInt("pce_total");
                String pce_estatus = rs.getString("pce_estatus");


                pedido = new clsPedidosCompras();
                pedido.setPce_documento(pce_documento);
                pedido.setProcodigo(procodigo);
                pedido.setPce_fecha(pce_fecha);
                pedido.setPce_total(pce_total);
                pedido.setPce_estatus(pce_estatus);

                
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return pedidos;
    }
    
        public List<clsPedidosCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPedidosCompras pedido = null;
        List<clsPedidosCompras> pedidos = new ArrayList<clsPedidosCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pce_documento = rs.getString("pce_documento");
                int pcd_orden = rs.getInt("pcd_orden");
                int prodcodigo = rs.getInt("prodcodigo");
                int pcd_cantidad_producto = rs.getInt("pcd_cantidad_producto");
                int pcd_costo_producto = rs.getInt("pcd_costo_producto");



                pedido = new clsPedidosCompras();
                pedido.setPce_documento(pce_documento);
                pedido.setPcd_orden(pcd_orden);
                pedido.setProdcodigo(prodcodigo);
                pedido.setPcd_cantidad_producto(pcd_cantidad_producto);
                pedido.setPcd_costo_producto(pcd_costo_producto);

                
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return pedidos;
    }

    public int insert(clsPedidosCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vanta.getPce_documento());
            stmt.setInt(2, vanta.getProcodigo());
            stmt.setString(3, vanta.getPce_fecha());
            stmt.setInt(4, vanta.getPce_total());             //ACA PUEDE QUE SEA INT JUANMI
            stmt.setString(5, vanta.getPce_estatus());



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
    
        public int insert2(clsPedidosCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setString(1, vanta.getPce_documento());
            stmt.setInt(2, vanta.getPcd_orden());
            stmt.setInt(3, vanta.getProdcodigo());
            stmt.setInt(4, vanta.getPcd_cantidad_producto());
            stmt.setInt(5, vanta.getPcd_costo_producto());



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

    public int update(clsPedidosCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, vanta.getProcodigo());
            stmt.setString(2, vanta.getPce_fecha());
            stmt.setInt(3, vanta.getPce_total());
            stmt.setString(4, vanta.getPce_estatus());
            stmt.setString(5, vanta.getPce_documento());

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
    
        public int update2(clsPedidosCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, vanta.getPcd_orden());
            stmt.setInt(2, vanta.getProdcodigo());
            stmt.setInt(3, vanta.getPcd_cantidad_producto());
            stmt.setInt(4, vanta.getPcd_costo_producto());
            stmt.setString(6, vanta.getPce_documento());

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

    public int delete(clsPedidosCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vanta.getPce_documento());
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
    
        public int delete2(clsPedidosCompras vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setString(1, vanta.getPce_documento());
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
    public clsPedidosCompras query(clsPedidosCompras vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPedidosCompras> comprador = new ArrayList<clsPedidosCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, vanta.getPce_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pce_documento = rs.getString("pce_documento");
                int procodigo = rs.getInt("procodigo");
                String pce_fecha = rs.getString("pce_fecha");
                int pce_total = rs.getInt("pce_total");
                String pce_estatus = rs.getString("pce_estatus");
                
                vanta = new clsPedidosCompras();
                vanta.setPce_documento(pce_documento);
                vanta.setProcodigo(procodigo);
                vanta.setPce_fecha(pce_fecha);
                vanta.setPce_total(pce_total);
                vanta.setPce_estatus(pce_estatus);
                
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
    
        public clsPedidosCompras query2(clsPedidosCompras vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPedidosCompras> comprador = new ArrayList<clsPedidosCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, vanta.getPce_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pce_documento = rs.getString("pce_documento");
                int pcd_orden = rs.getInt("pcd_orden");
                int prodcodigo = rs.getInt("prodcodigo");
                int pcd_cantidad_producto = rs.getInt("pcd_cantidad_producto");
                int pcd_costo_producto = rs.getInt("pcd_costo_producto");
                
                vanta = new clsPedidosCompras();
                vanta.setPce_documento(pce_documento);
                vanta.setPcd_orden(pcd_orden);
                vanta.setProdcodigo(prodcodigo);
                vanta.setPcd_cantidad_producto(pcd_cantidad_producto);
                vanta.setPcd_costo_producto(pcd_costo_producto);
                
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

