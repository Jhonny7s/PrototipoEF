/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.controlador;



/**
 *
 * @author visitante
 */
public class clsCotizacionCompras {
    //declaracion de variable para Compras 
    //encabezado
    String cce_documento;
    int procodigo;
    String cce_fecha;
    //detalle
    int prodcodigo;
    int cce_cantidad_producto;
    int cce_total_producto;
    
    public clsCotizacionCompras() {
    }

    public clsCotizacionCompras(String cce_documento) {
    this.cce_documento = cce_documento;
    }

    public clsCotizacionCompras(String cce_documento, int procodigo, String cce_fecha, int prodcodigo, int cce_cantidad_producto, int cce_total_producto) {
        this.cce_documento = cce_documento;
        this.procodigo = procodigo;
        this.cce_fecha = cce_fecha;
        this.prodcodigo = prodcodigo;
        this.cce_cantidad_producto = cce_cantidad_producto;
        this.cce_total_producto = cce_total_producto;
    }


    public String getCce_documento() {
        return cce_documento;
    }

    public void setCce_documento(String cce_documento) {
        this.cce_documento = cce_documento;
    }

    public int getProcodigo() {
        return procodigo;
    }

    public void setProcodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public String getCce_fecha() {
        return cce_fecha;
    }

    public void setCce_fecha(String cce_fecha) {
        this.cce_fecha = cce_fecha;
    }

    public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int prodcodigo) {
        this.prodcodigo = prodcodigo;
    }

    public int getCce_cantidad_producto() {
        return cce_cantidad_producto;
    }

    public void setCce_cantidad_producto(int cce_cantidad_producto) {
        this.cce_cantidad_producto = cce_cantidad_producto;
    }

    public int getCce_total_producto() {
        return cce_total_producto;
    }

    public void setCce_total_producto(int cce_total_producto) {
        this.cce_total_producto = cce_total_producto;
    }

    
 
    
    
    
    @Override
    public String toString() {
         return "cotizacion_compras_encabezado {" + "cce_documento =" + cce_documento + ", procodigo=" + procodigo + ", cce_fecha=" + cce_fecha + ", prodcodigo=" + prodcodigo + ", prodcodigo=" + prodcodigo +", cce_cantidad_producto=" + cce_cantidad_producto +", cce_total_producto=" + cce_total_producto + '}';
         
    }
    
}
