/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsCliente;
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
public class daoCliente {

    private static final String SQL_SELECT = "SELECT clicodigo, clinombre, clidireccion, clinit, clitelefono, cliestatus FROM tbl_clientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_clientes(clinombre, clidireccion, clinit, clitelefono, cliestatus) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_clientes SET clinombre=?, clidireccion=?, clinit=?, clitelefono=?, cliestatus=? WHERE clicodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_clientes WHERE clicodigo=?";
    private static final String SQL_QUERY = "SELECT clicodigo, clinombre, clidireccion, clinit, clitelefono, cliestatus FROM tbl_clientes WHERE clicodigo = ?";


    public List<clsCliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCliente cliente = null;
        List<clsCliente> clientes = new ArrayList<clsCliente>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("clicodigo");
                String nombre = rs.getString("clinombre");
                String direccion = rs.getString("clidireccion");
                String nit = rs.getString("clinit");
                String telefono = rs.getString("clitelefono");
                String estatus = rs.getString("cliestatus");

                cliente = new clsCliente();
                cliente.setClicodigo(codigo);
                cliente.setClinombre(nombre);
                cliente.setClidireccion(direccion);
                cliente.setClinit(nit);
                cliente.setClitelefono(telefono);
                cliente.setCliestatus(estatus);
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return clientes;
    }

    public int insert(clsCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getClinombre());
            stmt.setString(2, cliente.getClidireccion());
            stmt.setString(3, cliente.getClinit());
            stmt.setString(4, cliente.getClitelefono());
            stmt.setString(5, cliente.getCliestatus());      

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

    public int update(clsCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getClinombre());
            stmt.setString(2, cliente.getClidireccion());
            stmt.setString(3, cliente.getClinit());
            stmt.setString(4, cliente.getClitelefono());
            stmt.setString(5, cliente.getCliestatus());
            stmt.setInt(6, cliente.getClicodigo());

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

    public int delete(clsCliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getClicodigo());
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
    public clsCliente query(clsCliente cliente) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCliente> clientes = new ArrayList<clsCliente>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cliente.getClicodigo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("clicodigo");
                String nombre = rs.getString("clinombre");
                String direccion = rs.getString("clidireccion");
                String nit = rs.getString("clinit");
                String telefono = rs.getString("clitelefono");
                String estatus = rs.getString("cliestatus");
                
                cliente = new clsCliente();
                cliente.setClicodigo(codigo);
                cliente.setClinombre(nombre);
                cliente.setClidireccion(direccion);
                cliente.setClinit(nit);
                cliente.setClitelefono(telefono);
                cliente.setCliestatus(estatus);
                
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
        return cliente;
    }
   
}
