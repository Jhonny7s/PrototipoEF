/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;
import ventas.controlador.clsCotizacion;

/**
 *
 * @author visitante
 */
public class daoCotizacion {

    private static final String SQL_SELECT = "SELECT cve_documento, clicodigo, cve_fecha, cve_total, cve_estatus FROM cotizacion_ventas_encabezado";
    private static final String SQL_SELECT2 = "SELECT cve_documento, cvd_orden, prodcodigo, cvd_cantidad_producto, cvd_costo_producto FROM cotizacion_ventas_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO cotizacion_ventas_encabezado(cve_documento, clicodigo, cve_fecha, cve_total, cve_estatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO cotizacion_ventas_detalle(cve_documento, cvd_orden, prodcodigo, cvd_cantidad_producto, cvd_costo_producto) VALUES(?, ?, ?, ?, ?)";
    
    //private static final String SQL_UPDATE = "UPDATE cotizacion_ventas_encabezado SET clicodigo=?, cve_fecha=?, veetotal=?, veeestatus=?  WHERE cve_documento = ?";
    private static final String SQL_UPDATE = "UPDATE proyectobd122022.cotizacion_ventas_encabezado SET clicodigo = ?, cve_fecha = ?, cve_total = ?, cve_estatus = ? WHERE (cve_documento = ?)";
    //private static final String SQL_UPDATE2 = "UPDATE cotizacion_ventas_detalle SET prodcodigo=?, prodcodigo=?, vedcantidad=?, vedprecio=?, bodcodigo=? WHERE cve_documento = ?";
    private static final String SQL_UPDATE2 = "UPDATE proyectobd122022.cotizacion_ventas_detalle SET cvd_orden = ?, prodcodigo = ?, cvd_cantidad_producto = ?, cvd_costo_producto WHERE (cve_documento = ?)";

    private static final String SQL_DELETE = "DELETE FROM proyectobd122022.cotizacion_ventas_encabezado WHERE (cve_documento = ?)";
    private static final String SQL_DELETE2 = "DELETE FROM proyectobd122022.cotizacion_ventas_detalle WHERE (cve_documento = ?)";

    private static final String SQL_QUERY = "SELECT cve_documento, clicodigo, cve_fecha, cve_total, cve_estatus FROM cotizacion_ventas_encabezado WHERE cve_documento = ?";
    private static final String SQL_QUERY2 = "SELECT cve_documento, cvd_orden, prodcodigo, cvd_cantidad_producto, cvd_costo_producto FROM cotizacion_ventas_detalle WHERE cve_documento = ?";


    public List<clsCotizacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCotizacion venta = null;
        List<clsCotizacion> ventas = new ArrayList<clsCotizacion>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cve_documento = rs.getString("cve_documento");
                int clicodigo = rs.getInt("clicodigo");
                String cve_fecha = rs.getString("cve_fecha");
                int cve_total = rs.getInt("cve_total");
                String cve_estatus = rs.getString("cve_estatus");


                venta = new clsCotizacion();
                venta.Setcve_documento(cve_documento);
                venta.Setclicodigo(clicodigo);
                venta.Setcve_fecha(cve_fecha);
                venta.Setcve_total(cve_total);
                venta.Setcve_estatus(cve_estatus);

                
                ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return ventas;
    }
    
        public List<clsCotizacion> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCotizacion venta = null;
        List<clsCotizacion> ventas = new ArrayList<clsCotizacion>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cve_documento = rs.getString("cve_documento");
                int cvd_orden = rs.getInt("cvd_orden");
                int prodcodigo = rs.getInt("prodcodigo");
                int cvd_cantidad_producto = rs.getInt("cvd_cantidad_producto");
                int cvd_costo_producto = rs.getInt("cvd_costo_producto");



                venta = new clsCotizacion();
                venta.Setcve_documento(cve_documento);
                venta.Setcvd_orden(cvd_orden);
                venta.Setprodcodigo(prodcodigo);
                venta.Setcvd_cantidad_producto(cvd_cantidad_producto);
                venta.Setcvd_costo_producto(cvd_costo_producto);

                
                ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return ventas;
    }

    public int insert(clsCotizacion vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vanta.Getcve_documento());
            stmt.setInt(2, vanta.Getclicodigo());
            stmt.setString(3, vanta.Getcve_fecha());
            stmt.setFloat(4, vanta.Getcve_total());
            stmt.setString(5, vanta.Getcve_estatus());



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
    
        public int insert2(clsCotizacion vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setString(1, vanta.Getcve_documento());
            stmt.setInt(2, vanta.Getcvd_orden());
            stmt.setInt(3, vanta.Getprodcodigo());
            stmt.setInt(4, vanta.Getcvd_cantidad_producto());
            stmt.setInt(5, vanta.Getcvd_costo_producto());



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

    public int update(clsCotizacion vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, vanta.Getclicodigo());
            stmt.setString(2, vanta.Getcve_fecha());
            stmt.setInt(3, vanta.Getcve_total());
            stmt.setString(4, vanta.Getcve_estatus());
            stmt.setString(5, vanta.Getcve_documento());

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
    
        public int update2(clsCotizacion vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, vanta.Getcvd_orden());
            stmt.setInt(2, vanta.Getprodcodigo());
            stmt.setInt(3, vanta.Getcvd_cantidad_producto());
            stmt.setInt(4, vanta.Getcvd_costo_producto());
            stmt.setString(5, vanta.Getcve_documento());

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

    public int delete(clsCotizacion vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vanta.Getcve_documento());
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
    
        public int delete2(clsCotizacion vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setString(1, vanta.Getcve_documento());
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

    public clsCotizacion query(clsCotizacion vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCotizacion> vendedores = new ArrayList<clsCotizacion>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, vanta.Getcve_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cve_documento = rs.getString("cve_documento");
                int clicodigo = rs.getInt("clicodigo");
                String cve_fecha = rs.getString("cve_fecha");
                int cve_total = rs.getInt("cve_total");
                String cve_estatus = rs.getString("cve_estatus");
                
                vanta = new clsCotizacion();
                vanta.Setcve_documento(cve_documento);
                vanta.Setclicodigo(clicodigo);
                vanta.Setcve_fecha(cve_fecha);
                vanta.Setcve_total(cve_total);
                vanta.Setcve_estatus(cve_estatus);
                
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
    
        public clsCotizacion query2(clsCotizacion vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCotizacion> vendedores = new ArrayList<clsCotizacion>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, vanta.Getcve_documento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cve_documento = rs.getString("cve_documento");
                int cvd_orden = rs.getInt("cvd_orden");
                int prodcodigo = rs.getInt("prodcodigo");
                int cvd_cantidad_producto = rs.getInt("cvd_cantidad_producto");
                int cvd_costo_producto = rs.getInt("cvd_costo_producto");
                
                vanta = new clsCotizacion();
                vanta.Setcve_documento(cve_documento);
                vanta.Setcvd_orden(cvd_orden);
                vanta.Setprodcodigo(prodcodigo);
                vanta.Setcvd_cantidad_producto(cvd_cantidad_producto);
                vanta.Setcvd_costo_producto(cvd_costo_producto);
                
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

