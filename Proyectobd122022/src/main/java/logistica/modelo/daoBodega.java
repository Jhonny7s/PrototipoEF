/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.clsConexion;
import logistica.controlador.clsBodega;
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
public class daoBodega {

    private static final String SQL_SELECT = "SELECT bodcodigo, bodnombre, bodestatus FROM tbl_bodegas";
    private static final String SQL_INSERT = "INSERT INTO tbl_bodegas(bodnombre, bodestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodegas SET bodnombre=?, bodestatus=? WHERE bodcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bodegas WHERE bodcodigo=?";
    private static final String SQL_QUERY = "SELECT bodcodigo, bodnombre, bodestatus FROM tbl_bodegas WHERE bodcodigo = ?";

    public List<clsBodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBodega bodega = null;
        List<clsBodega> bodegas = new ArrayList<clsBodega>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("bodcodigo");
                String nombre = rs.getString("bodnombre");
                String estado = rs.getString("bodestatus");
                
                bodega = new clsBodega();
                bodega.setcodigob(codigo);
                bodega.setNombreb(nombre);
                bodega.setestadob(estado);
                
                bodegas.add(bodega);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return bodegas;
    }

    public int insert(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bodega.getNombreb());
            stmt.setString(2, bodega.getestadob());


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

    public int update(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bodega.getNombreb());
            stmt.setString(2, bodega.getestadob());
            stmt.setInt(3, bodega.getcodigob());

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

    public int delete(clsBodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodega.getcodigob());
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
    public clsBodega query(clsBodega bodega) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsBodega> bodegas = new ArrayList<clsBodega>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bodega.getcodigob());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("bodcodigo");
                String nombre = rs.getString("bodnombre");
                String estado = rs.getString("bodestatus");
                
                bodega = new clsBodega();
                bodega.setcodigob(codigo);
                bodega.setNombreb(nombre);
                bodega.setestadob(estado);
                
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
        return bodega;
    }
        
}
