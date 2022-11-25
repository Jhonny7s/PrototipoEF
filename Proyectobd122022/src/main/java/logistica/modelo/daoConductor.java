/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.*;
import logistica.controlador.clsConductor;
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
public class daoConductor {

    private static final String SQL_SELECT = "SELECT condid, condnombre, condestatus FROM tbl_conductor";
    private static final String SQL_INSERT = "INSERT INTO tbl_conductor(condnombre, condestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_conductor SET condnombre=?, condestatus=? WHERE condid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_conductor WHERE condid=?";
    private static final String SQL_QUERY = "SELECT condid, condnombre, condestatus FROM tbl_conductor WHERE condid = ?";

    public List<clsConductor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsConductor aplicacion = null;
        List<clsConductor> aplicaciones = new ArrayList<clsConductor>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("condid");
                String nombre = rs.getString("condnombre");
                String estado = rs.getString("condestatus");
                
                aplicacion = new clsConductor();
                aplicacion.setId_Conductor(id_aplicacion);
                aplicacion.setNombreConductor(nombre);
                aplicacion.setestadoConductor(estado);
                
                aplicaciones.add(aplicacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return aplicaciones;
    }

    public int insert(clsConductor aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getNombreConductor());
            stmt.setString(2, aplicacion.getestadoConductor());


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

    public int update(clsConductor aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombreConductor());
            stmt.setString(2, aplicacion.getestadoConductor());
            stmt.setInt(3, aplicacion.getId_Conductor());

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

    public int delete(clsConductor aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getId_Conductor());
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
    public clsConductor query(clsConductor aplicacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsConductor> aplicaciones = new ArrayList<clsConductor>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, aplicacion.getId_Conductor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("condid");
                String nombre = rs.getString("condnombre");
                String estado = rs.getString("condestatus");
                
                aplicacion = new clsConductor();
                aplicacion.setId_Conductor(id_aplicacion);
                aplicacion.setNombreConductor(nombre);
                aplicacion.setestadoConductor(estado);
                
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
        return aplicacion;
    }
        
}
