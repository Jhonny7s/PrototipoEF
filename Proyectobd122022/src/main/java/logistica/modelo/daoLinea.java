/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.clsConexion;
import logistica.controlador.clsLinea;
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
public class daoLinea {

    private static final String SQL_SELECT = "SELECT lincodigo, linnombre, linestatus FROM tbl_lineas";
    private static final String SQL_INSERT = "INSERT INTO tbl_lineas(linnombre, linestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_lineas SET linnombre=?, linestatus=? WHERE lincodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_lineas WHERE lincodigo=?";
    private static final String SQL_QUERY = "SELECT lincodigo, linnombre, linestatus FROM tbl_lineas WHERE lincodigo = ?";

    public List<clsLinea> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsLinea linea = null;
        List<clsLinea> lineas = new ArrayList<clsLinea>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("lincodigo");
                String nombre = rs.getString("linnombre");
                String estado = rs.getString("linestatus");
                
                linea = new clsLinea();
                linea.setcodigol(codigo);
                linea.setNombrel(nombre);
                linea.setestadol(estado);
                
                lineas.add(linea);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return lineas;
    }

    public int insert(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, linea.getNombrel());
            stmt.setString(2, linea.getestadol());


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

    public int update(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, linea.getNombrel());
            stmt.setString(2, linea.getestadol());
            stmt.setInt(3, linea.getcodigol());

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

    public int delete(clsLinea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, linea.getcodigol());
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
    public clsLinea query(clsLinea linea) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsLinea> lineas = new ArrayList<clsLinea>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, linea.getcodigol());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("lincodigo");
                String nombre = rs.getString("linnombre");
                String estado = rs.getString("linestatus");
                
                linea = new clsLinea();
                linea.setcodigol(codigo);
                linea.setNombrel(nombre);
                linea.setestadol(estado);
                
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
        return linea;
    }
        
}
