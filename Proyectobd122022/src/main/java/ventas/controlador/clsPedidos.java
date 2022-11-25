/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controlador;



/**
 *
 * @author visitante
 */
public class clsPedidos {
    //declaracion de variable para Vendedores 
    String pve_documento;
    int clicodigo;
    String pve_fecha;
    int prodcodigo;
    int pve_cantidad_producto;
    int pve_total_producto;

    public clsPedidos() {
    }

    public clsPedidos(String pve_documento) {
    this.pve_documento = pve_documento;
    }

     public clsPedidos(String pve_documento, String pve_fecha, int clicodigo, int prodcodigo, int pve_cantidad_producto, int pve_total_producto) {
        this.pve_documento = pve_documento;
        this.clicodigo = clicodigo;
        this.pve_fecha = pve_fecha;
        this.prodcodigo = prodcodigo;
        this.pve_cantidad_producto = pve_cantidad_producto;
        this.pve_total_producto = pve_total_producto;
        
    }


public String getPve_documento() {
        return pve_documento;
    }

    public void setPve_documento(String pve_documento) {
        this.pve_documento = pve_documento;
    }


    public int getClicodigo() {
        return clicodigo;
    }

    public void setClicodigo(int clicodigo) {
        this.clicodigo = clicodigo;
    }

    public String getPve_fecha() {
        return pve_fecha;
    }

    public void setPve_fecha(String pve_fecha) {
        this.pve_fecha = pve_fecha;
    }

    public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int prodcodigo) {
        this.prodcodigo = prodcodigo;
    }

    public int getPve_cantidad_producto() {
        return pve_cantidad_producto;
    }

    public void setPve_cantidad_producto(int pve_cantidad_producto) {
        this.pve_cantidad_producto = pve_cantidad_producto;
    }

    public int getPve_total_producto() {
        return pve_total_producto;
    }

    public void setPve_total_producto(int pve_total_producto) {
        this.pve_total_producto = pve_total_producto;
    }
    
    @Override
    public String toString() {
         return "tbl_clientes{" + "pve_documento =" + pve_documento + ", clicodigo=" + clicodigo + ", pve_fecha=" + pve_fecha + ", prodcodigo=" + prodcodigo +", pve_cantidad_producto=" + pve_cantidad_producto +", pve_total_producto=" + pve_total_producto +'}';
    }
    
}
