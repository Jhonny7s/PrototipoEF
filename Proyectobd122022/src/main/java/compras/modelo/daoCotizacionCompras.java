/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsCotizacionCompras;
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
public class daoCotizacionCompras {

    private static final String SQL_SELECT = "SELECT cce_documento, procodigo, cce_fecha FROM cotizacion_compras_encabezado";
    private static final String SQL_SELECT2 = "SELECT cce_documento, prodcodigo, cce_cantidad_producto, cce_total_producto FROM cotizacion_compras_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO cotizacion_compras_encabezado(cce_documento, procodigo, cce_fecha) VALUES(?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO cotizacion_compras_detalle(cce_documento, prodcodigo, cce_cantidad_producto, cce_total_producto) VALUES(?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE proyectobd122022.cotizacion_compras_encabezado SET procodigo=?, cce_fecha=? WHERE (cce_documento = ?)";
    private static final String SQL_UPDATE2 = "UPDATE proyectobd122022.cotizacion_compras_detalle SET prodcodigo=?, cce_cantidad_producto=?, cce_total_producto=? WHERE (cce_documento = ?)";

    private static final String SQL_DELETE = "DELETE FROM cotizacion_compras_encabezado WHERE cce_documento=?";
    private static final String SQL_DELETE2 = "DELETE FROM cotizacion_compras_detalle WHERE cce_documento=?";

    private static final String SQL_QUERY = "SELECT cce_documento, procodigo, cce_fecha FROM cotizacion_compras_encabezado WHERE cce_documento = ?";
    private static final String SQL_QUERY2 = "SELECT cce_documento, prodcodigo, cce_cantidad_producto, cce_total_producto FROM cotizacion_compras_detalle WHERE cce_documento = ?";


    
    
    
    public List<clsCotizacionCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCotizacionCompras compra = null;
        List<clsCotizacionCompras> compras = new ArrayList<clsCotizacionCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cce_documento = rs.getString("cce_documento");
                int procodigo = rs.getInt("procodigo");
                String cce_fecha = rs.getString("cce_fecha");
           
                compra = new clsCotizacionCompras();
                compra.setCce_documento(cce_documento);
                compra.setProcodigo(procodigo);
                compra.setCce_fecha(cce_fecha);
                 
                compras.add(compra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compras;
    }
    
        public List<clsCotizacionCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCotizacionCompras compra = null;
        List<clsCotizacionCompras> compras = new ArrayList<clsCotizacionCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cce_documento = rs.getString("cce_documento");
                int prodcodigo = rs.getInt("prodcodigo");
                int cce_cantidad_producto = rs.getInt("cce_cantidad_producto");
                int cce_total_producto = rs.getInt("cce_total_producto");
          
                compra = new clsCotizacionCompras();
                compra.setCce_documento(cce_documento);
                compra.setProdcodigo(prodcodigo);
                compra.setCce_cantidad_producto(cce_cantidad_producto);
                compra.setCce_total_producto(cce_total_producto);
            
                compras.add(compra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compras;
    }

    public int insert(clsCotizacionCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, comprador.getCce_documento());
            stmt.setInt(2, comprador.getProcodigo());
            stmt.setString(3, comprador.getCce_fecha());
   

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
    
        public int insert2(clsCotizacionCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setString(1, comprador.getCce_documento());
            stmt.setInt(2, comprador.getProdcodigo());
            stmt.setInt(3, comprador.getCce_cantidad_producto());
            stmt.setInt(4, comprador.getCce_total_producto());
              



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

    public int update(clsCotizacionCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, comprador.getCce_documento());
            stmt.setInt(2, comprador.getProcodigo());
            stmt.setString(3, comprador.getCce_fecha());
                     

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
    
        public int update2(clsCotizacionCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setString(1, comprador.getCce_documento());
            stmt.setInt(2, comprador.getProdcodigo());
            stmt.setInt(3, comprador.getCce_cantidad_producto());
            stmt.setInt(4, comprador.getCce_total_producto());
     
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

    public int delete(clsCotizacionCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, comprador.getCce_documento());
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
    
        public int delete2(clsCotizacionCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setString(1, comprador.getCce_documento());
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
    public clsCotizacionCompras query(clsCotizacionCompras comprador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCotizacionCompras> compras = new ArrayList<clsCotizacionCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, comprador.getCce_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cce_documento = rs.getString("cce_documento");
                int procodigo = rs.getInt("procodigo");
                String cce_fecha = rs.getString("cce_fecha");
   
                
                comprador = new clsCotizacionCompras();
                comprador.setCce_documento(cce_documento);
                comprador.setProcodigo(procodigo);
                comprador.setCce_fecha(cce_fecha);
            
                
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
        return comprador;
    }
    
        public clsCotizacionCompras query2(clsCotizacionCompras comprador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCotizacionCompras> compras = new ArrayList<clsCotizacionCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, comprador.getCce_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cce_documento = rs.getString("cce_documento");
                int prodcodigo = rs.getInt("prodcodigo");
                int cce_cantidad_producto = rs.getInt("cce_cantidad_producto");
                int cce_total_producto = rs.getInt("cce_total_producto");
          
       
                
                comprador = new clsCotizacionCompras();
                comprador.setCce_documento(cce_documento);
                comprador.setProdcodigo(prodcodigo);
                comprador.setCce_cantidad_producto(cce_cantidad_producto);
                comprador.setCce_total_producto(cce_total_producto);
        
                
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
        return comprador;
    }
   
}

