/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsVentas;
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
public class daoVentas {

    private static final String SQL_SELECT = "SELECT veedocumento, clicodigo, veefecha, veetotal, veeestatus FROM tbl_ventas_encabezado";
    private static final String SQL_SELECT2 = "SELECT veedocumento, vedorden, prodcodigo, vedcantidad, vedprecio, bodcodigo FROM tbl_ventas_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO tbl_ventas_encabezado(veedocumento, clicodigo, veefecha, veetotal, veeestatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_ventas_detalle(veedocumento, vedorden, prodcodigo, vedcantidad, vedprecio, bodcodigo) VALUES( ?, ?, ?, ?, ?, ?)";
    
    //private static final String SQL_UPDATE = "UPDATE tbl_ventas_encabezado SET clicodigo=?, veefecha=?, veetotal=?, veeestatus=?  WHERE veedocumento = ?";
    private static final String SQL_UPDATE = "UPDATE proyectobd122022.tbl_ventas_encabezado SET clicodigo = ?, veefecha = ?, veetotal = ?, veeestatus = ? WHERE (veedocumento = ?)";
    //private static final String SQL_UPDATE2 = "UPDATE tbl_ventas_detalle SET vedorden=?, prodcodigo=?, vedcantidad=?, vedprecio=?, bodcodigo=? WHERE veedocumento = ?";
    private static final String SQL_UPDATE2 = "UPDATE proyectobd122022.tbl_ventas_detalle SET vedorden = ?, prodcodigo = ?, vedcantidad = ?, vedprecio = ?, bodcodigo = ? WHERE (veedocumento = ?)";

    private static final String SQL_DELETE = "DELETE FROM proyectobd122022.tbl_ventas_encabezado WHERE (veedocumento = ?)";
    private static final String SQL_DELETE2 = "DELETE FROM proyectobd122022.tbl_ventas_detalle WHERE (veedocumento = ?)";

    private static final String SQL_QUERY = "SELECT veedocumento, clicodigo, veefecha, veetotal, veeestatus FROM tbl_ventas_encabezado WHERE veedocumento = ?";
    private static final String SQL_QUERY2 = "SELECT veedocumento, vedorden, prodcodigo, vedcantidad, vedprecio, bodcodigo FROM tbl_ventas_detalle WHERE veedocumento = ?";


    public List<clsVentas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVentas venta = null;
        List<clsVentas> ventas = new ArrayList<clsVentas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String veedocumento = rs.getString("veedocumento");
                int clicodigo = rs.getInt("clicodigo");
                String veefecha = rs.getString("veefecha");
                int veetotal = rs.getInt("veetotal");
                String veeestatus = rs.getString("veeestatus");


                venta = new clsVentas();
                venta.Setvedcodigo(veedocumento);
                venta.Setclicodigo(clicodigo);
                venta.Setveefecha(veefecha);
                venta.Setveetotal(veetotal);
                venta.Setveeestatus(veeestatus);

                
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
    
        public List<clsVentas> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVentas venta = null;
        List<clsVentas> ventas = new ArrayList<clsVentas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String veedocumento = rs.getString("veedocumento");
                int vedorden = rs.getInt("vedorden");
                int prodcodigo = rs.getInt("prodcodigo");
                int vedcantidad = rs.getInt("vedcantidad");
                int vedprecio = rs.getInt("vedprecio");
                int bodcodigo = rs.getInt("bodcodigo");



                venta = new clsVentas();
                venta.Setvedcodigo(veedocumento);
                venta.Setvedorden(vedorden);
                venta.Setprodcodigo(prodcodigo);
                venta.Setvedcantidad(vedcantidad);
                venta.Setvedprecio(vedprecio);
                venta.Setbodcodigo(bodcodigo);

                
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

    public int insert(clsVentas vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vanta.Getveedocumento());
            stmt.setInt(2, vanta.Getclicodigo());
            stmt.setString(3, vanta.Getveefecha());
            stmt.setFloat(4, vanta.Getveetotal());
            stmt.setString(5, vanta.Getveeestatus());



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
    
        public int insert2(clsVentas vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setString(1, vanta.Getveedocumento());
            stmt.setInt(2, vanta.Getvedorden());
            stmt.setInt(3, vanta.Getprodcodigo());
            stmt.setInt(4, vanta.Getvedcantidad());
            stmt.setInt(5, vanta.Getvedprecio());
            stmt.setInt(6, vanta.Getbodcodigo());



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

    public int update(clsVentas vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, vanta.Getclicodigo());
            stmt.setString(2, vanta.Getveefecha());
            stmt.setInt(3, vanta.Getveetotal());
            stmt.setString(4, vanta.Getveeestatus());
            stmt.setString(5, vanta.Getveedocumento());

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
    
        public int update2(clsVentas vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, vanta.Getvedorden());
            stmt.setInt(2, vanta.Getprodcodigo());
            stmt.setInt(3, vanta.Getvedcantidad());
            stmt.setInt(4, vanta.Getvedprecio());
            stmt.setInt(5, vanta.Getbodcodigo());
            stmt.setString(6, vanta.Getveedocumento());

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

    public int delete(clsVentas vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vanta.Getveedocumento());
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
    
        public int delete2(clsVentas vanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setString(1, vanta.Getveedocumento());
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
    public clsVentas query(clsVentas vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsVentas> vendedores = new ArrayList<clsVentas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, vanta.Getveedocumento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String veedocumento = rs.getString("veedocumento");
                int clicodigo = rs.getInt("clicodigo");
                String veefecha = rs.getString("veefecha");
                int veetotal = rs.getInt("veetotal");
                String veeestatus = rs.getString("veeestatus");
                
                vanta = new clsVentas();
                vanta.Setvedcodigo(veedocumento);
                vanta.Setclicodigo(clicodigo);
                vanta.Setveefecha(veefecha);
                vanta.Setveetotal(veetotal);
                
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
    
        public clsVentas query2(clsVentas vanta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsVentas> vendedores = new ArrayList<clsVentas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, vanta.Getveedocumento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String veedocumento = rs.getString("veedocumento");
                int vedorden = rs.getInt("vedorden");
                int prodcodigo = rs.getInt("prodcodigo");
                int vedcantidad = rs.getInt("vedcantidad");
                int vedprecio = rs.getInt("vedprecio");
                int bodcodigo = rs.getInt("bodcodigo");
                
                vanta = new clsVentas();
                vanta.Setvedcodigo(veedocumento);
                vanta.Setvedorden(vedorden);
                vanta.Setprodcodigo(prodcodigo);
                vanta.Setvedcantidad(vedcantidad);
                vanta.Setvedprecio(vedprecio);
                vanta.Setbodcodigo(bodcodigo);
                
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

