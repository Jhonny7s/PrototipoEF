/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsPerfilAplicaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPerfilApps {

    private static final String SQL_SELECT = "SELECT  perid,aplid FROM tbl_aplicacionperfil";
   
    private static final String SQL_INSERT = "INSERT INTO tbl_aplicacionperfil(perid, aplid) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_aplicacionesperfil SET perid=?, aplid=? WHERE perid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_aplicacionesperfil WHERE perid=?";
    private static final String SQL_QUERY = "SELECT  perid, aplid FROM tbl_aplicacionperfil WHERE perid = ?";
     private static final String SQL_QUERY2 = "SELECT tbl_aplicacionperfil.aplid, tbl_aplicacionperfil.perid , tbl_aplicacion.aplnombre FROM tbl_aplicacionperfil INNER JOIN tbl_aplicacion ON tbl_aplicacionperfil.aplid=tbl_aplicacion.aplid  WHERE tbl_aplicacionperfil.perid=?";

    public List<clsPerfilAplicaciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilAplicaciones usuario = null;
        List<clsPerfilAplicaciones> usuarios = new ArrayList<clsPerfilAplicaciones>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int perfil = rs.getInt("perid");
                int aplicacion = rs.getInt("aplid");

                usuario = new clsPerfilAplicaciones();
               
                usuario.setPerid(String.valueOf(perfil));
                usuario.setAplid(String.valueOf(aplicacion));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil_app.getPerid());
            stmt.setString(2, perfil_app.getAplid());

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

    public int update(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfil_app.getPerid());
            stmt.setString(2, perfil_app.getAplid());
            

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

    public int delete(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
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

    /*public clsPerfilAplicaciones query(clsPerfilAplicaciones perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, perfil_app.getPerid());
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int username = rs.getInt("perid");
                int password = rs.getInt("aplid");

                perfil_app = new clsPerfilAplicaciones();
                perfil_app.setPerid(String.valueOf(username));
                perfil_app.setAplid(String.valueOf(password));
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
        return perfil_app;
    }*/
        public clsPerfilAplicaciones query2(clsPerfilAplicaciones perfil) {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query2:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            //stmt.setString(1, perfil.getAplnombre());
            
            stmt.setString(1, perfil.getPerid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int perfilid = rs.getInt("perid");
                String nombreapl= rs.getString("aplnombre");
                
                perfil = new clsPerfilAplicaciones();
                perfil.setPerid(String.valueOf(perfilid));
                perfil.setAplnombre(nombreapl);
                
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
 public List<clsPerfilAplicaciones> select2(clsPerfilAplicaciones perApl) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilAplicaciones usuario = null;
        List<clsPerfilAplicaciones> usuarios = new ArrayList<clsPerfilAplicaciones>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, perApl.getPerid());            
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int aplicacion = rs.getInt("aplid");
                int perfil = rs.getInt("perid");
                String nombreAplicacion = rs.getString("aplnombre");

                usuario = new clsPerfilAplicaciones();
               
                usuario.setPerid(String.valueOf(perfil));
                usuario.setAplid(String.valueOf(aplicacion));
                usuario.setAplnombre(String.valueOf(nombreAplicacion));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }
}

