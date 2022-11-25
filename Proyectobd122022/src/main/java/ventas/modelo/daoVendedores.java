/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsVendedores;
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
public class daoVendedores {

    private static final String SQL_SELECT = "SELECT vedcodigo, vednombre, veddireccion, vedtelefono, vednit, vedestatus FROM tbl_vendedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_vendedores(vednombre, veddireccion, vedtelefono, vednit, vedestatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_vendedores SET vednombre=?, veddireccion=?, vedtelefono=?, vednit=?, vedestatus=? WHERE vedcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_vendedores WHERE vedcodigo=?";
    private static final String SQL_QUERY = "SELECT vedcodigo, vednombre, veddireccion, vedtelefono, vednit, vedestatus FROM tbl_vendedores WHERE vedcodigo = ?";


    public List<clsVendedores> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVendedores vendedor = null;
        List<clsVendedores> vendedores = new ArrayList<clsVendedores>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int vedcodigo = rs.getInt("vedcodigo");
                String vednombre = rs.getString("vednombre");
                String veddireccion = rs.getString("veddireccion");
                String vedtelefono = rs.getString("vedtelefono");
                String vednit = rs.getString("vednit");
                String vedestatus = rs.getString("vedestatus");


                vendedor = new clsVendedores();
                vendedor.Setvedcodigo(vedcodigo);
                vendedor.Setvednombre(vednombre);
                vendedor.Setveddireccion(veddireccion);
                vendedor.Setvedtelefono(vedtelefono);
                vendedor.Setvednit(vednit);
                vendedor.Setvedestatus(vedestatus);

                
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return vendedores;
    }

    public int insert(clsVendedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.Getvednombre());
            stmt.setString(2, vendedor.Getveddireccion());
            stmt.setString(3, vendedor.Getvedtelefono());
            stmt.setString(4, vendedor.Getvednit());
            stmt.setString(5, vendedor.Getvedestatus());



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

    public int update(clsVendedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.Getvednombre());
            stmt.setString(2, vendedor.Getveddireccion());
            stmt.setString(3, vendedor.Getvedtelefono());
            stmt.setString(4, vendedor.Getvednit());
            stmt.setString(5, vendedor.Getvedestatus());
            stmt.setInt(6, vendedor.Getvedcodigo());

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

    public int delete(clsVendedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.Getvedcodigo());
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
    public clsVendedores query(clsVendedores vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsVendedores> vendedores = new ArrayList<clsVendedores>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.Getvedcodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int vedcodigo = rs.getInt("vedcodigo");
                String vednombre = rs.getString("vednombre");
                String veddireccion = rs.getString("veddireccion");
                String vedtelefono = rs.getString("vedtelefono");
                String vednit = rs.getString("vednit");
                String vedestatus = rs.getString("vedestatus");
                
                vendedor = new clsVendedores();
                vendedor.Setvedcodigo(vedcodigo);
                vendedor.Setvednombre(vednombre);
                vendedor.Setveddireccion(veddireccion);
                vendedor.Setvedtelefono(vedtelefono);
                vendedor.Setvednit(vednit);
                vendedor.Setvedestatus(vedestatus);
                
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
        return vendedor;
    }
   
}
