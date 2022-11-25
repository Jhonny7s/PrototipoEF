/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsPerfilUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPerfilUsuario {

    private static final String SQL_SELECT = "SELECT  perid,usuid FROM tbl_perfilusuario";
   
    private static final String SQL_INSERT = "INSERT INTO tbl_perfilusuario(perid, usuid) VALUES(?, ?)";
        private static final String SQL_INSERT1 = "INSERT INTO tbl_perfilusuario(perid, usuid) VALUES(?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE tbl_perfilusuario SET perid=?, usuid=? WHERE perid = ?";
        private static final String SQL_UPDATE1 = "UPDATE tbl_perfilusuario SET perid=?, usuid=? WHERE usuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfilusuario WHERE perid=?";
    private static final String SQL_DELETE1 = "DELETE FROM tbl_perfilusuario WHERE usuid=?";
    private static final String SQL_QUERY = "SELECT  perid, usuid FROM tbl_perfilusuario WHERE perid = ?";
     private static final String SQL_QUERY2 = "SELECT tbl_perfilusuario.usuid, tbl_perfilusuario.perid , tbl_usuario.usunombre FROM tbl_perfilusuario INNER JOIN tbl_usuario ON tbl_perfilusuario.usuid=tbl_usuario.usuid  WHERE tbl_perfilusuario.perid=?";
 private static final String SQL_QUERY3 = "SELECT tbl_perfilusuario.usuid, tbl_perfilusuario.perid , tbl_perfil.pernombre FROM tbl_perfilusuario INNER JOIN tbl_perfil ON tbl_perfilusuario.perid=tbl_perfil.perid  WHERE tbl_perfilusuario.perid=?";
    public List<clsPerfilUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilUsuario usuario = null;
        List<clsPerfilUsuario> usuarios = new ArrayList<clsPerfilUsuario>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int perfil = rs.getInt("perid");
                int aplicacion = rs.getInt("usuid");

                usuario = new clsPerfilUsuario();
               
                usuario.setPerid(String.valueOf(perfil));
                usuario.setUsuid(String.valueOf(aplicacion));

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

    public int insert(clsPerfilUsuario perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil_app.getPerid());
            stmt.setString(2, perfil_app.getUsuid());

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
     public int insert1(clsPerfilUsuario perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
      
        try {
          
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil_app.getPerid());
            stmt.setString(2, perfil_app.getUsuid());

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


    public int update(clsPerfilUsuario perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfil_app.getPerid());
            stmt.setString(2, perfil_app.getUsuid());
            

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
    
    public int delete1(clsPerfilUsuario perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, perfil_app.getUsuid());
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
    
 public int delete2(clsPerfilUsuario perfil_app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE1);
            stmt = conn.prepareStatement(SQL_DELETE1);
            stmt.setString(1, perfil_app.getPerid());
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
    
    
    
    /*public clsPerfilUsuario query(clsPerfilUsuario perfil_app) {
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
                int password = rs.getInt("usuid");

                perfil_app = new clsPerfilUsuario();
                perfil_app.setPerid(String.valueOf(username));
                perfil_app.setUsuid(String.valueOf(password));
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
        public clsPerfilUsuario query2(clsPerfilUsuario perfil) {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query2:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            //stmt.setString(1, perfil.getUsunombre());
            
            stmt.setString(1, perfil.getPerid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int perfilid = rs.getInt("perid");
                String nombreusu= rs.getString("usunombre");
                
                perfil = new clsPerfilUsuario();
                perfil.setPerid(String.valueOf(perfilid));
                perfil.setUsunombre(nombreusu);                
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
        
 public List<clsPerfilUsuario> select2(clsPerfilUsuario perUsu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilUsuario usuario = null;
        List<clsPerfilUsuario> usuarios = new ArrayList<clsPerfilUsuario>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setString(1, perUsu.getPerid());            
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int aplicacion = rs.getInt("usuid");
                int perfil = rs.getInt("perid");
                String nombreAplicacion = rs.getString("usunombre");

                usuario = new clsPerfilUsuario();
               
                usuario.setPerid(String.valueOf(perfil));
                usuario.setUsuid(String.valueOf(aplicacion));
                usuario.setUsunombre(String.valueOf(nombreAplicacion));
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
         public clsPerfilUsuario query3(clsPerfilUsuario perfil) {
         Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query3:" + SQL_QUERY3);
            stmt = conn.prepareStatement(SQL_QUERY3);
            //stmt.setString(1, perfil.getUsunombre());
            
            stmt.setString(1, perfil.getPerid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String perfilid = rs.getString("perid");
                String nombreusu= rs.getString("pernombre");
                
                perfil = new clsPerfilUsuario();
                perfil.setPerid(perfilid);
                perfil.setPernombre(nombreusu);                
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
 
 public List<clsPerfilUsuario> select3(clsPerfilUsuario perUsu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilUsuario usuario = null;
        List<clsPerfilUsuario> usuarios = new ArrayList<clsPerfilUsuario>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY3);
            stmt.setString(1, perUsu.getPerid());            
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String aplicacion = rs.getString("usuid");
                String perfil = rs.getString("perid");
                String nombreAplicacion = rs.getString("pernombre");

                usuario = new clsPerfilUsuario();
               
                usuario.setPerid(perfil);
                usuario.setUsuid(aplicacion);
                usuario.setPernombre(String.valueOf(nombreAplicacion));
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