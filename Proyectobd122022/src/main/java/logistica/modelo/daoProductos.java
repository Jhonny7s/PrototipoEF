/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package logistica.modelo;

import seguridad.modelo.*;
import logistica.controlador.clsProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProductos {

    private static final String SQL_SELECT = "SELECT prodcodigo, prodnombre, prodexistencia, prodestatus,tbl_productos.marcodigo, tbl_lineas.lincodigo,tbl_marcas.marnombre, tbl_lineas.linnombre FROM tbl_productos INNER JOIN tbl_marcas  ON tbl_productos.marcodigo = tbl_marcas.marcodigo INNER JOIN tbl_lineas  ON tbl_productos.lincodigo = tbl_lineas.lincodigo;";
    private static final String SQL_INSERT = "INSERT INTO tbl_productos(prodcodigo, prodnombre, prodexistencia, prodestatus, marcodigo, lincodigo) VALUES(?, ?, ?, ?, ?, ? )";
    
     private static final String SQL_UPDATE = "UPDATE tbl_productos SET prodnombre=?, prodexistencia=?, prodestatus=?, marcodigo=?, lincodigo=? WHERE prodcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos WHERE prodcodigo=?";
    private static final String SQL_QUERY  = "SELECT prodcodigo, prodnombre, prodexistencia, prodestatus,tbl_productos.marcodigo, tbl_lineas.lincodigo,tbl_marcas.marnombre, tbl_lineas.linnombre FROM tbl_productos INNER JOIN tbl_marcas  ON tbl_productos.marcodigo = tbl_marcas.marcodigo INNER JOIN tbl_lineas  ON tbl_productos.lincodigo = tbl_lineas.lincodigo WHERE prodcodigo = ?";

    public List<clsProductos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProductos perfil = null;
        List<clsProductos> perfiles = new ArrayList<clsProductos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("prodcodigo");
                String Prodnombre =rs.getString("prodnombre");
                Float Prodexistencia = rs.getFloat("prodexistencia");
                 String Prodestatus = rs.getString("prodestatus");
                 int Marcodigo = rs.getInt("marcodigo");
                 int Lincodigo = rs.getInt("lincodigo");
                String Marnombre = rs.getString("marnombre");
                String Linnombre = rs.getString("linnombre");

                perfil = new clsProductos();
                perfil.setProdcodigo(iPerfil_id);
                 perfil.setProdnombre(Prodnombre);
                  perfil.setProdexistencia(Prodexistencia);
                   perfil.setProdestatus(Prodestatus);
                    perfil.setMarcodigo(Marcodigo);
                    perfil.setLincodigo(Lincodigo);
                    perfil.setMarnombre(Marnombre);
                    perfil.setLinnombre(Linnombre);
               
          
                 

                perfiles.add(perfil);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return perfiles;
    }

    public int insert(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,  perfil.getProdcodigo());
            stmt.setString(2, perfil.getProdnombre());
            stmt.setFloat(3, perfil.getProdexistencia());
             stmt.setString(4, perfil.getProdestatus());
             stmt.setInt(5,  perfil.getMarcodigo());
             stmt.setInt(6,  perfil.getLincodigo());
        
         

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

    public int update(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
        
            stmt.setString(1, perfil.getProdnombre());
            stmt.setFloat(2, perfil.getProdexistencia());
             stmt.setString(3, perfil.getProdestatus());
               stmt.setInt(4, perfil.getMarcodigo());
                stmt.setInt(5, perfil.getLincodigo());
               stmt.setInt(6, perfil.getProdcodigo());

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

    public int delete(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getProdcodigo());
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

    public clsProductos query(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfil.getProdcodigo()); //getId_perfil
            rs = stmt.executeQuery();
            while (rs.next()) {
               int iPerfil_id = rs.getInt("prodcodigo");
                String Prodnombre =rs.getString("prodnombre");
                Float Prodexistencia = rs.getFloat("prodexistencia");
                 String Prodestatus = rs.getString("prodestatus");
                 int Marcodigo = rs.getInt("marcodigo");
                 int Lincodigo = rs.getInt("lincodigo");
                String Marnombre = rs.getString("marnombre");
                String Linnombre = rs.getString("linnombre");

                perfil = new clsProductos();
                perfil.setProdcodigo(iPerfil_id);
                 perfil.setProdnombre(Prodnombre);
                  perfil.setProdexistencia(Prodexistencia);
                   perfil.setProdestatus(Prodestatus);
                    perfil.setMarcodigo(Marcodigo);
                    perfil.setLincodigo(Lincodigo);
                    perfil.setMarnombre(Marnombre);
                    perfil.setLinnombre(Linnombre);
         
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return perfil;
    }
}
