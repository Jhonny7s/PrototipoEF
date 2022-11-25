/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package logistica.modelo;

import seguridad.modelo.*;
import logistica.controlador.clsMovimientos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logistica.controlador.clsMovimientos;

/**
 *
 * @author visitante
 */
public class daoMovimientos {

    private static final String SQL_SELECT = "SELECT tbl_movimientoen.movestado, tbl_movimientoen.movid, tbl_movimientoen.movfecha, tbl_productos.prodnombre, tbl_productos.prodexistencia,  tbl_lineas.linnombre, tbl_marcas.marnombre, tbl_conceptos.connombre, tbl_clientes.clinombre, tbl_proveedores.pronombre, tbl_movimientode.movcantidad FROM tbl_movimientode INNER JOIN tbl_movimientoen ON tbl_movimientode.movid = tbl_movimientoen.movid INNER JOIN tbl_productos  ON tbl_productos.prodcodigo = tbl_movimientode.prodcodigo  INNER JOIN tbl_lineas ON tbl_movimientode.lincodigo = tbl_lineas.lincodigo INNER JOIN tbl_marcas  ON tbl_marcas.marcodigo = tbl_movimientode.marcodigo INNER JOIN tbl_conceptos  ON tbl_conceptos.conid = tbl_movimientode.conid INNER JOIN tbl_clientes  ON tbl_clientes.clicodigo = tbl_movimientode.clicodigo INNER JOIN tbl_proveedores  ON tbl_proveedores.procodigo = tbl_movimientode.procodigo";
    private static final String SQL_INSERT = "INSERT INTO tbl_movimientoen(movid, movfecha, movestado) VALUES(?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_movimientode(movid, prodcodigo, conid, clicodigo, procodigo, lincodigo, marcodigo, movcantidad) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movimientoen SET movid=?, movfecha=?, movestado=?";
    private static final String SQL_UPDATE2 = "UPDATE tbl_movimientoen SET movid=?, prodcodigo=?, conid=?, clicodigo=?, procodigo=?, lincodigo=?, marcodigo=?, movcantidad=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movimientoen en WHERE movid=?";
    private static final String SQL_DELETE2 = "DELETE FROM tbl_movimientode en WHERE movid=?";
    private static final String SQL_QUERY  = "SELECT tbl_movimientoen.movid, tbl_movimientoen.movfecha, tbl_movimientoen.movestado, tbl_productos.prodnombre, tbl_productos.prodexistencia, tbl_movimientode.movcantidad, tbl_lineas.linnombre, tbl_marcas.marnombre, tbl_conceptos.connombre, tbl_clientes.clinombre, tbl_proveedores.pronombre FROM tbl_movimientode INNER JOIN tbl_movimientoen ON tbl_movimientode.movid = tbl_movimientoen.movid INNER JOIN tbl_productos  ON tbl_productos.prodcodigo = tbl_movimientode.prodcodigo  INNER JOIN tbl_lineas ON tbl_movimientode.lincodigo = tbl_lineas.lincodigo INNER JOIN tbl_marcas  ON tbl_marcas.marcodigo = tbl_movimientode.marcodigo INNER JOIN tbl_conceptos  ON tbl_conceptos.conid = tbl_movimientode.conid INNER JOIN tbl_clientes  ON tbl_clientes.clicodigo = tbl_movimientode.clicodigo INNER JOIN tbl_proveedores  ON tbl_proveedores.procodigo = tbl_movimientode.procodigo";

    public List<clsMovimientos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMovimientos perfil = null;
        List<clsMovimientos> perfiles = new ArrayList<clsMovimientos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Movid = rs.getInt("tbl_movimientoen.movid");
                String Movfecha =rs.getString("movfecha");
                String Movestado =rs.getString("movestado");
                String Prodnombre =rs.getString("prodnombre");
                Float Prodexistencia = rs.getFloat("prodexistencia");
                int Movcantidad = rs.getInt("movcantidad");
                String Linnombre = rs.getString("linnombre");
                String Marnombre = rs.getString("marnombre");
                String Connombre = rs.getString("connombre");
                String Clinombre = rs.getString("clinombre");
                String Pronombre = rs.getString("pronombre");
               
                perfil = new clsMovimientos();
                perfil.setPronombre(Pronombre);
                perfil.setMovid(Movid);
                perfil.setMovfecha(Movfecha);
                perfil.setMovestado(Movestado);
                perfil.setProdnombre(Prodnombre);
                perfil.setProdexistencia(Prodexistencia);
                perfil.setMovcantidad(Movcantidad);
                perfil.setMarnombre(Marnombre);
                perfil.setLinnombre(Linnombre);
                perfil.setConnombre(Connombre);
                perfil.setClinombre(Clinombre);
                
                
                
               
          
                 

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

    public int insert(clsMovimientos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,  perfil.getMovid());
            stmt.setString(2, perfil.getMovfecha());
            stmt.setString(3, perfil.getMovestado());
                  
         

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
     public int insert2(clsMovimientos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setInt(1,  perfil.getMovid());
            stmt.setInt(2, perfil.getProdcodigo());
            stmt.setInt(3, perfil.getConid());
            stmt.setInt(4, perfil.getClicodigo());
            stmt.setInt(5, perfil.getProcodigo());
            stmt.setInt(6, perfil.getLincodigo());
            stmt.setInt(7, perfil.getMarcodigo());
            stmt.setInt(8, perfil.getMovcantidad());
                  
         

            System.out.println("ejecutando query:" + SQL_INSERT2);
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

    public int update(clsMovimientos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1,  perfil.getMovid());
            stmt.setString(2, perfil.getMovfecha());
            stmt.setString(3, perfil.getMovestado());
            
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

    public int update2(clsMovimientos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
        
            stmt.setInt(1,  perfil.getMovid());
            stmt.setInt(2, perfil.getProdcodigo());
            stmt.setInt(3, perfil.getConid());
            stmt.setInt(4, perfil.getClicodigo());
            stmt.setInt(5, perfil.getProcodigo());
            stmt.setInt(6, perfil.getLincodigo());
            stmt.setInt(7, perfil.getMarcodigo());
            stmt.setInt(8, perfil.getMovcantidad());

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
    public int delete(clsMovimientos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getMovid());
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
    
    
    public int delete2(clsMovimientos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setInt(1, perfil.getMovid());
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
    

    public clsMovimientos query(clsMovimientos perfil) {
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
                
                int Movid = rs.getInt("movid");
                String Movfecha =rs.getString("movfecha");
                String Movestado =rs.getString("movestado");
                         
                perfil = new clsMovimientos();
                perfil.setMovid(Movid);
                perfil.setMovfecha(Movfecha);
                perfil.setMovestado(Movestado);
           
            
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
