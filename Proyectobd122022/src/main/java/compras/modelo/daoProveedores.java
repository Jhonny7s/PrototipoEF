/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsProveedores;
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
public class daoProveedores {

    private static final String SQL_SELECT = "SELECT procodigo, pronombre, prodireccion, protelefono, pronit, proestatus FROM tbl_proveedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_proveedores(pronombre, prodireccion, protelefono, pronit, proestatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proveedores SET pronombre=?, prodireccion=?, protelefono=?, pronit=?, proestatus=? WHERE procodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proveedores WHERE procodigo=?";
    private static final String SQL_QUERY = "SELECT procodigo, pronombre, prodireccion, protelefono, pronit, proestatus FROM tbl_proveedores WHERE procodigo = ?";


    public List<clsProveedores> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProveedores vendedor = null;
        List<clsProveedores> vendedores = new ArrayList<clsProveedores>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int procodigo = rs.getInt("procodigo");
                String pronombre = rs.getString("pronombre");
                String prodireccion = rs.getString("prodireccion");
                String protelefono = rs.getString("protelefono");
                String pronit = rs.getString("pronit");
                String proestatus = rs.getString("proestatus");


                vendedor = new clsProveedores();
                vendedor.setprocodigo(procodigo);
                vendedor.setpronombre(pronombre);
                vendedor.setprodireccion(prodireccion);
                vendedor.setprotelefono(protelefono);
                vendedor.setpronit(pronit);
                vendedor.setproestatus(proestatus);

                
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

    public int insert(clsProveedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getpronombre());
            stmt.setString(2, vendedor.getprodireccion());
            stmt.setString(3, vendedor.getprotelefono());
            stmt.setString(4, vendedor.getpronit());
            stmt.setString(5, vendedor.getproestatus());



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

    public int update(clsProveedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getpronombre());
            stmt.setString(2, vendedor.getprodireccion());
            stmt.setString(3, vendedor.getprotelefono());
            stmt.setString(4, vendedor.getpronit());
            stmt.setString(5, vendedor.getproestatus());
            stmt.setInt(6, vendedor.getprocodigo());

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

    public int delete(clsProveedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getprocodigo());
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
    public clsProveedores query(clsProveedores vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsProveedores> vendedores = new ArrayList<clsProveedores>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.getprocodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int procodigo = rs.getInt("procodigo");
                String pronombre = rs.getString("pronombre");
                String prodireccion = rs.getString("prodireccion");
                String protelefono = rs.getString("protelefono");
                String pronit = rs.getString("pronit");
                String proestatus = rs.getString("proestatus");
                
                vendedor = new clsProveedores();
                vendedor.setprocodigo(procodigo);
                vendedor.setpronombre(pronombre);
                vendedor.setprodireccion(prodireccion);
                vendedor.setprotelefono(protelefono);
                vendedor.setpronit(pronit);
                vendedor.setproestatus(proestatus);
                
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
