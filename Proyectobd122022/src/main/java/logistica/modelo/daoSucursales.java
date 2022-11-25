/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.modelo;

import seguridad.modelo.*;
import logistica.controlador.clsSucursales;
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
public class daoSucursales {

    private static final String SQL_SELECT = "SELECT succodigo, sucnombre, sucestatus FROM tbl_sucursales";
    private static final String SQL_INSERT = "INSERT INTO tbl_sucursales(sucnombre, sucestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_sucursales SET sucnombre=?, sucestatus=? WHERE succodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_sucursales WHERE succodigo=?";
    private static final String SQL_QUERY = "SELECT succodigo, sucnombre, sucestatus FROM tbl_sucursales WHERE succodigo = ?";

    public List<clsSucursales> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsSucursales aplicacion = null;
        List<clsSucursales> aplicaciones = new ArrayList<clsSucursales>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("succodigo");
                String nombre = rs.getString("sucnombre");
                String estado = rs.getString("sucestatus");
                
                aplicacion = new clsSucursales();
                aplicacion.setId_Sucursal(id_aplicacion);
                aplicacion.setNombreSucursal(nombre);
                aplicacion.setestadoSucursal(estado);
                
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

    public int insert(clsSucursales aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getNombreSucursal());
            stmt.setString(2, aplicacion.getestadoSucursal());


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

    public int update(clsSucursales aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombreSucursal());
            stmt.setString(2, aplicacion.getestadoSucursal());
            stmt.setInt(3, aplicacion.getId_Sucursal());

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

    public int delete(clsSucursales aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getId_Sucursal());
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
    public clsSucursales query(clsSucursales aplicacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsSucursales> aplicaciones = new ArrayList<clsSucursales>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, aplicacion.getId_Sucursal());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("succodigo");
                String nombre = rs.getString("sucnombre");
                String estado = rs.getString("sucestatus");
                
                aplicacion = new clsSucursales();
                aplicacion.setId_Sucursal(id_aplicacion);
                aplicacion.setNombreSucursal(nombre);
                aplicacion.setestadoSucursal(estado);
                
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
