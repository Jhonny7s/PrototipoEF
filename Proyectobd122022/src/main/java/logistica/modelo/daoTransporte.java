/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package logistica.modelo;

import seguridad.modelo.*;
import logistica.controlador.clsTransporte;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTransporte {

    private static final String SQL_SELECT = "SELECT tranmatricula, tranmodelo, tranmarca, trantipo FROM tbl_transporte";
    private static final String SQL_INSERT = "INSERT INTO tbl_transporte(tranmatricula, tranmodelo, tranmarca, trantipo) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_transporte SET  tranmodelo=?, tranmarca=?, trantipo=? WHERE tranmatricula = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_transporte WHERE tranmatricula=?";
    private static final String SQL_QUERY  = "SELECT tranmatricula, tranmodelo, tranmarca, trantipo FROM tbl_transporte WHERE tranmatricula = ?";

    public List<clsTransporte> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsTransporte perfil = null;
        List<clsTransporte> perfiles = new ArrayList<clsTransporte>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("tranmatricula");
                String sPerfil_nombre = rs.getString("tranmodelo");
                String sPerfil_estado = rs.getString("tranmarca");
                String sTipo = rs.getString("trantipo");

                perfil = new clsTransporte();
                perfil.setTranmatricula(iPerfil_id);
                perfil.setTranmodelo(sPerfil_nombre);
                perfil.setTranmarca(sPerfil_estado);
                 perfil.setTrantipo(sTipo);

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

    public int insert(clsTransporte perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,  perfil.getTranmatricula());
            stmt.setString(2, perfil.getTranmodelo());
            stmt.setString(3, perfil.getTranmarca());
            stmt.setString(4, perfil.getTrantipo());

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

    public int update(clsTransporte aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getTranmodelo());
            stmt.setString(2, aplicacion.getTranmarca());
            stmt.setString(3, aplicacion.getTrantipo());
            stmt.setInt(4,  aplicacion.getTranmatricula());

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
    public int delete(clsTransporte perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getTranmatricula());
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

    public clsTransporte query(clsTransporte perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfil.getTranmatricula()); //getId_perfil
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("tranmatricula");
                String sPerfil_nombre = rs.getString("tranmodelo");
                String sPerfil_estado = rs.getString("tranmarca");
                String tipo = rs.getString("trantipo");

                perfil = new clsTransporte();
                perfil.setTranmatricula(iPerfil_id);
                perfil.setTranmodelo(sPerfil_nombre);
                perfil.setTranmarca(sPerfil_estado);
                perfil.setTrantipo(tipo);
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
