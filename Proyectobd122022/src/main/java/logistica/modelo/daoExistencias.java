/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package logistica.modelo;

import seguridad.modelo.*;
import logistica.controlador.clsExistencias;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoExistencias {

    private static final String SQL_SELECT = "SELECT tbl_existencias.bodcodigo, tbl_existencias.prodcodigo, exisaldo, tbl_bodegas.bodnombre, tbl_productos.prodnombre FROM tbl_existencias INNER JOIN tbl_bodegas  ON tbl_existencias.bodcodigo = tbl_bodegas.bodcodigo INNER JOIN tbl_productos  ON tbl_existencias.prodcodigo = tbl_productos.prodcodigo";
    private static final String SQL_INSERT = "INSERT INTO tbl_existencias(bodcodigo, prodcodigo, exisaldo) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_existencias SET bodcodigo=? prodcodigo=?, exisaldo=? WHERE bodcodigo = ? and ";
    private static final String SQL_DELETE = "DELETE FROM tbl_existencias WHERE bodcodigo=?";
    private static final String SQL_QUERY  = "SELECT tbl_existencias.bodcodigo, tbl_existencias.prodcodigo, exisaldo, tbl_bodegas.bodnombre, tbl_productos.prodnombre FROM tbl_existencias INNER JOIN tbl_bodegas  ON tbl_existencias.bodcodigo = tbl_bodegas.bodcodigo INNER JOIN tbl_productos  ON tbl_existencias.prodcodigo = tbl_productos.prodcodigo WHERE tbl_existencias.bodcodigo = ?";

    public List<clsExistencias> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsExistencias perfil = null;
        List<clsExistencias> perfiles = new ArrayList<clsExistencias>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("bodcodigo");
                int sPerfil_nombre =rs.getInt("prodcodigo");
                float sPerfil_estado = rs.getFloat("exisaldo");
                String Bodnombre = rs.getString("bodnombre");
                String Prodnombre = rs.getString("prodnombre");

                perfil = new clsExistencias();
                perfil.setBodcodigo(iPerfil_id);
                 perfil.setBodnombre(String.valueOf(Bodnombre));
                perfil.setProdcodigo(sPerfil_nombre);
                 perfil.setProdnombre(String.valueOf(Prodnombre));
                perfil.setExisaldo(sPerfil_estado);
                 

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

    public int insert(clsExistencias perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,  perfil.getBodcodigo());
            stmt.setInt(2, perfil.getProdcodigo());
            stmt.setFloat(3, perfil.getExisaldo());
         

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

    public int update(clsExistencias perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
         
            stmt.setInt(1, perfil.getProdcodigo()); 
            stmt.setFloat(2, perfil.getExisaldo());
            
           
            stmt.setInt(3,  perfil.getBodcodigo());
             
          
           
    

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

    public int delete(clsExistencias perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getBodcodigo());
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

    public clsExistencias query(clsExistencias perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfil.getBodcodigo()); //getId_perfil
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("bodcodigo");
                int sPerfil_nombre = rs.getInt("prodcodigo");
                Float sPerfil_estado = rs.getFloat("exisaldo");
             

                perfil = new clsExistencias();
                perfil.setBodcodigo(iPerfil_id);
                perfil.setProdcodigo(sPerfil_nombre);
                perfil.setExisaldo(sPerfil_estado);
         
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
