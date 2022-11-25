/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.clsConexion;
import logistica.controlador.clsMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarca {

    private static final String SQL_SELECT = "SELECT marcodigo, marnombre, marestatus FROM tbl_marcas";
    private static final String SQL_INSERT = "INSERT INTO tbl_marcas(marnombre, marestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marcas SET marnombre=?, marestatus=? WHERE marcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marcas WHERE marcodigo=?";
    private static final String SQL_QUERY = "SELECT marcodigo, marnombre, marestatus FROM tbl_marcas WHERE marcodigo = ?";

    public List<clsMarca> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMarca marca = null;
        List<clsMarca> marcas = new ArrayList<clsMarca>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("marcodigo");
                String nombre = rs.getString("marnombre");
                String estado = rs.getString("marestatus");
                
                marca = new clsMarca();
                marca.setcodigo(codigo);
                marca.setNombre(nombre);
                marca.setestado(estado);
                
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return marcas;
    }

    public int insert(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marca.getNombre());
            stmt.setString(2, marca.getestado());


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

    public int update(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marca.getNombre());
            stmt.setString(2, marca.getestado());
            stmt.setInt(3, marca.getcodigo());

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

    public int delete(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, marca.getcodigo());
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
    public clsMarca query(clsMarca marca) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsMarca> marcas = new ArrayList<clsMarca>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, marca.getcodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("marcodigo");
                String nombre = rs.getString("marnombre");
                String estado = rs.getString("marestatus");
                
                marca = new clsMarca();
                marca.setcodigo(codigo);
                marca.setNombre(nombre);
                marca.setestado(estado);
                
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
        return marca;
    }
        
}
