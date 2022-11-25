/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsPedidos;
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
public class daoPedidos {

    private static final String SQL_SELECT = "SELECT pve_documento, clicodigo, pve_fecha FROM pedidos_ventas_encabezado";
    private static final String SQL_SELECT2 = "SELECT pve_documento, prodcodigo, pve_cantidad_producto, pve_total_producto FROM pedidos_ventas_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO pedidos_ventas_encabezado(pve_documento, clicodigo, pve_fecha) VALUES(?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO pedidos_ventas_detalle(pve_documento, prodcodigo, pve_cantidad_producto, pve_total_producto) VALUES( ?, ?, ?, ?)";
    
    //private static final String SQL_UPDATE = "UPDATE tbl_ventas_encabezado SET clicodigo=?, veefecha=?, veetotal=?, veeestatus=?  WHERE veedocumento = ?";
    private static final String SQL_UPDATE = "UPDATE proyectobd122022.pedidos_ventas_encabezado SET clicodigo = ?, pve_fecha = ? WHERE (pve_documento = ?)";
    //private static final String SQL_UPDATE2 = "UPDATE tbl_ventas_detalle SET vedorden=?, prodcodigo=?, vedcantidad=?, vedprecio=?, bodcodigo=? WHERE veedocumento = ?";
    private static final String SQL_UPDATE2 = "UPDATE proyectobd122022.pedidos_ventas_detalle SET prodcodigo = ?, pve_cantidad_producto = ?, pve_total_producto = ? WHERE (pve_documento = ?)";

    private static final String SQL_DELETE = "DELETE FROM proyectobd122022.pedidos_ventas_encabezado WHERE (pve_documento = ?)";
    private static final String SQL_DELETE2 = "DELETE FROM proyectobd122022.pedidos_ventas_detalle WHERE (pve_documento = ?)";

    private static final String SQL_QUERY = "SELECT pve_documento, clicodigo, pve_fecha FROM pedidos_ventas_encabezado WHERE pve_documento = ?";
    private static final String SQL_QUERY2 = "SELECT pve_documento, prodcodigo, pve_cantidad_producto, pve_total_producto FROM pedidos_ventas_detalle WHERE pve_documento = ?";


    public List<clsPedidos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPedidos pedido = null;
        List<clsPedidos> pedidos = new ArrayList<clsPedidos>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pve_documento = rs.getString("pve_documento");
                int clicodigo = rs.getInt("clicodigo");
                String pve_fecha = rs.getString("pve_fecha");

                
                pedido = new clsPedidos();
                pedido.setPve_documento(pve_documento);
                pedido.setClicodigo(clicodigo);
                pedido.setPve_fecha(pve_fecha);

                
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
    
        public List<clsPedidos> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPedidos pedido = null;
        List<clsPedidos> pedidos = new ArrayList<clsPedidos>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pve_documento = rs.getString("pve_documento");
                int prodcodigo = rs.getInt("prodcodigo");
                int pve_cantidad_producto = rs.getInt("pve_cantidad_producto");
                int pve_total_producto = rs.getInt("pve_total_producto");


                pedido = new clsPedidos();
                pedido.setPve_documento(pve_documento);
                pedido.setProdcodigo(prodcodigo);
                pedido.setPve_cantidad_producto(pve_cantidad_producto);
                pedido.setPve_total_producto(pve_total_producto);

                
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

    public int insert(clsPedidos pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pedido.getPve_documento());
            stmt.setInt(2, pedido.getClicodigo());
            stmt.setString(3, pedido.getPve_fecha());
  

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
    
        public int insert2(clsPedidos pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setString(1, pedido.getPve_documento());
            stmt.setInt(2, pedido.getProdcodigo());
            stmt.setInt(3, pedido.getPve_cantidad_producto());
            stmt.setInt(4, pedido.getPve_total_producto());


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

    public int update(clsPedidos pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, pedido.getClicodigo());
            stmt.setString(2, pedido.getPve_fecha());
            stmt.setString(3, pedido.getPve_documento());

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
    
        public int update2(clsPedidos pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, pedido.getProdcodigo());
            stmt.setInt(2, pedido.getPve_cantidad_producto());
            stmt.setInt(3, pedido.getPve_total_producto());
            stmt.setString(4, pedido.getPve_documento());

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

    public int delete(clsPedidos pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, pedido.getPve_documento());
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
    
        public int delete2(clsPedidos pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setString(1, pedido.getPve_documento());
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
    public clsPedidos query(clsPedidos pedido) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPedidos> vendedores = new ArrayList<clsPedidos>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, pedido.getPve_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pve_documento = rs.getString("pve_documento");
                int clicodigo = rs.getInt("clicodigo");
                String pve_fecha = rs.getString("pve_fecha");
                
                pedido = new clsPedidos();
                pedido.setPve_documento(pve_documento);
                pedido.setClicodigo(clicodigo);
                pedido.setPve_fecha(pve_fecha);
                
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
        return pedido;
    }
    
        public clsPedidos query2(clsPedidos pedido) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsPedidos> vendedores = new ArrayList<clsPedidos>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, pedido.getPve_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pve_documento = rs.getString("pve_documento");
                int prodcodigo = rs.getInt("prodcodigo");
                int pve_cantidad_producto = rs.getInt("pve_cantidad_producto");
                int pve_total_producto = rs.getInt("pve_total_producto");
                
                pedido = new clsPedidos();
                pedido.setPve_documento(pve_documento);
                pedido.setProdcodigo(prodcodigo);
                pedido.setPve_cantidad_producto(pve_cantidad_producto);
                pedido.setPve_total_producto(pve_total_producto);
                
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
        return pedido;
    }
   
}

