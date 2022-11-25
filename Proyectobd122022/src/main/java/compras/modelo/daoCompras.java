/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;

/**
 *
 * @author visitante
 */
public class daoCompras {

    private static final String SQL_SELECT = "SELECT coedocumento, procodigo, coefecha, coetotal, coeestatus FROM tbl_compras_encabezado";
    private static final String SQL_SELECT2 = "SELECT coedocumento, codorden, prodcodigo, codcantidad, codcosto, bodcodigo FROM tbl_compras_detalle";
    
    private static final String SQL_INSERT = "INSERT INTO tbl_compras_encabezado(coedocumento, procodigo, coefecha, coetotal, coeestatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_compras_detalle(coedocumento, codorden, prodcodigo, codcantidad, codcosto, bodcodigo) VALUES(?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE tbl_compras_encabezado SET procodigo=?, coefecha=?, coetotal=?, coeestatus=?  WHERE coedocumento = ?";
    private static final String SQL_UPDATE2 = "UPDATE tbl_compras_detalle SET codorden=?, prodcodigo=?, codcantidad=?, codcosto=?, bodcodigo=? WHERE coedocumento = ?";

    private static final String SQL_DELETE = "DELETE FROM tbl_compras_encabezado WHERE coedocumento=?";
    private static final String SQL_DELETE2 = "DELETE FROM tbl_compras_detalle WHERE coedocumento=?";

    private static final String SQL_QUERY = "SELECT coedocumento, procodigo, coefecha, coetotal, coeestatus FROM tbl_compras_encabezado WHERE coedocumento = ?";
    private static final String SQL_QUERY2 = "SELECT coedocumento, codorden, prodcodigo, codcantidad, codcosto, bodcodigo FROM tbl_compras_detalle WHERE coedocumento = ?";


    public List<clsCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCompras compra = null;
        List<clsCompras> compras = new ArrayList<clsCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int coedocumento = rs.getInt("coedocumento");
                int procodigo = rs.getInt("procodigo");
                String coefecha = rs.getString("coefecha");
                int coetotal = rs.getInt("coetotal");
                String coeestatus = rs.getString("coeestatus");


                compra = new clsCompras();
                compra.setCoedocumento(coedocumento);
                compra.setProcodigo(procodigo);
                compra.setCoefecha(coefecha);
                compra.setCoetotal(coetotal);
                compra.setCoeestatus(coeestatus);

                
                compras.add(compra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compras;
    }
    
        public List<clsCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCompras compra = null;
        List<clsCompras> compras = new ArrayList<clsCompras>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int coedocumento = rs.getInt("coedocumento");
                int codorden = rs.getInt("codorden");
                int prodcodigo = rs.getInt("prodcodigo");
                int codcantidad = rs.getInt("codcantidad");
                int codcosto = rs.getInt("codcosto");
                int bodcodigo = rs.getInt("bodcodigo");


                compra = new clsCompras();
                compra.setCoedocumento(coedocumento);
                compra.setCodorden(codorden);
                compra.setProdcodigo(prodcodigo);
                compra.setCodcantidad(codcantidad);
                compra.setCodcosto(codcosto);
                compra.setBodcodigo(bodcodigo);

                
                compras.add(compra);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compras;
    }

    public int insert(clsCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, comprador.getCoedocumento());
            stmt.setInt(2, comprador.getProcodigo());
            stmt.setString(3, comprador.getCoefecha());
            stmt.setInt(4, comprador.getCoetotal());
            stmt.setString(5, comprador.getCoeestatus());



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
    
        public int insert2(clsCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setInt(1, comprador.getCoedocumento());
            stmt.setInt(2, comprador.getCodorden());
            stmt.setInt(3, comprador.getProdcodigo());
            stmt.setInt(4, comprador.getCodcantidad());
            stmt.setInt(5, comprador.getCodcosto());
            stmt.setInt(6, comprador.getBodcodigo());
            



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

    public int update(clsCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, comprador.getCoedocumento());
            stmt.setInt(2, comprador.getProcodigo());
            stmt.setString(3, comprador.getCoefecha());
            stmt.setInt(4, comprador.getCoetotal());
            stmt.setString(5, comprador.getCoeestatus());
            

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
    
        public int update2(clsCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, comprador.getCodorden());
            stmt.setInt(2, comprador.getProdcodigo());
            stmt.setInt(3, comprador.getCodcantidad());
            stmt.setInt(4, comprador.getCodcosto());
            stmt.setInt(5, comprador.getCoedocumento());
            stmt.setInt(6, comprador.getBodcodigo());

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

    public int delete(clsCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, comprador.getCoedocumento());
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
    
        public int delete2(clsCompras comprador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setInt(1, comprador.getCoedocumento());
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
    public clsCompras query(clsCompras comprador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCompras> compras = new ArrayList<clsCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, comprador.getCoedocumento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int coedocumento = rs.getInt("coedocumento");
                int procodigo = rs.getInt("procodigo");
                String coefecha = rs.getString("coefecha");
                int coetotal = rs.getInt("coetotal");
                String coeestatus = rs.getString("coeestatus");
    
                
                comprador = new clsCompras();
                comprador.setCoedocumento(coedocumento);
                comprador.setProcodigo(procodigo);
                comprador.setCoefecha(coefecha);
                comprador.setCoetotal(coetotal);
                comprador.setCoeestatus(coeestatus);
                
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
        return comprador;
    }
    
        public clsCompras query2(clsCompras comprador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCompras> compras = new ArrayList<clsCompras>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setInt(1, comprador.getCoedocumento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int coedocumento = rs.getInt("coedocumento");
                int codorden = rs.getInt("codorden");
                int prodcodigo = rs.getInt("prodcodigo");
                int codcantidad = rs.getInt("codcantidad");
                int codcosto = rs.getInt("codcosto");
                int bodcodigo = rs.getInt("bodcodigo");
       
                
                comprador = new clsCompras();
                comprador.setCoedocumento(coedocumento);
                comprador.setCodorden(codorden);
                comprador.setProdcodigo(prodcodigo);
                comprador.setCodcantidad(codcantidad);
                comprador.setCodcosto(codcosto);
                comprador.setBodcodigo(bodcodigo);
                
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
        return comprador;
    }
   
}

