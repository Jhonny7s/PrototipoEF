/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.clsConexion;
import logistica.controlador.clsConcepto;
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
public class daoConcepto {

    private static final String SQL_SELECT = "SELECT conid, connombre, conestatus FROM tbl_conceptos";
    private static final String SQL_INSERT = "INSERT INTO tbl_conceptos(connombre, conestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_conceptos SET connombre=?, conestatus=? WHERE conid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_conceptos WHERE conid=?";
    private static final String SQL_QUERY = "SELECT conid, connombre, conestatus FROM tbl_conceptos WHERE conid = ?";

    public List<clsConcepto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsConcepto concepto = null;
        List<clsConcepto> conceptos = new ArrayList<clsConcepto>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("conid");
                String nombre = rs.getString("connombre");
                String estado = rs.getString("conestatus");
                
                concepto = new clsConcepto();
                concepto.setcodigoc(codigo);
                concepto.setNombrec(nombre);
                concepto.setestadoc(estado);
                
                conceptos.add(concepto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return conceptos;
    }

    public int insert(clsConcepto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, concepto.getNombrec());
            stmt.setString(2, concepto.getestadoc());


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

    public int update(clsConcepto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getNombrec());
            stmt.setString(2, concepto.getestadoc());
            stmt.setInt(3, concepto.getcodigoc());

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

    public int delete(clsConcepto concepto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, concepto.getcodigoc());
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
    public clsConcepto query(clsConcepto concepto) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsConcepto> conceptos = new ArrayList<clsConcepto>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, concepto.getcodigoc());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("conid");
                String nombre = rs.getString("connombre");
                String estado = rs.getString("conestatus");
                
                concepto = new clsConcepto();
                concepto.setcodigoc(codigo);
                concepto.setNombrec(nombre);
                concepto.setestadoc(estado);
                
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
        return concepto;
    }
        
}
