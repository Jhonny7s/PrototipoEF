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
public class clsCotizacion {
    String cve_documento;
    int clicodigo;
    String cve_fecha;
    int cve_total;
    String cve_estatus;
    
    int cvd_orden;
    int prodcodigo;
    int cvd_cantidad_producto;
    int cvd_costo_producto;



    public clsCotizacion() {
    }

    public clsCotizacion(String cve_documento) {
    this.cve_documento = cve_documento;
    }

     public clsCotizacion(String cve_documento, int clicodigo, String cve_fecha,int cve_total, String cve_estatus, int cvd_orden, int prodcodigo,int cvd_cantidad_producto, int cvd_costo_producto) {
         
        this.cve_documento = cve_documento;
        this.clicodigo = clicodigo;
        this.cve_fecha = cve_fecha;
        this.cve_total = cve_total;
        this.cve_estatus = cve_estatus;
        this.cvd_orden = cvd_orden;
        this.prodcodigo = prodcodigo;
        this.cvd_cantidad_producto = cvd_cantidad_producto;
        this.cvd_costo_producto = cvd_costo_producto;
    }



public String Getcve_documento() {
        return cve_documento;
    }

    public void Setcve_documento(String cve_documento) {
        this.cve_documento = cve_documento;
    }


    public int Getclicodigo() {
        return clicodigo;
    }

    public void Setclicodigo(int clicodigo) {
        this.clicodigo = clicodigo;
    }

    public String Getcve_fecha() {
        return cve_fecha;
    }

    public void Setcve_fecha(String cve_fecha) {
        this.cve_fecha = cve_fecha;
    }
    
        public int Getcve_total() {
        return cve_total;
    }

    public void Setcve_total(int cve_total) {
        this.cve_total = cve_total;
    }
    
        public String Getcve_estatus() {
        return cve_estatus;
    }

    public void Setcve_estatus(String cve_estatus) {
        this.cve_estatus = cve_estatus;
    }

    public int Getcvd_orden() {
        return cvd_orden;
    }

    public void Setcvd_orden(int cvd_orden) {
        this.cvd_orden = cvd_orden;
    }
    
    public int Getprodcodigo() {
        return prodcodigo;
    }

    public void Setprodcodigo(int prodcodigo) {
        this.prodcodigo = prodcodigo;
    }
    
    public int Getcvd_cantidad_producto() {
        return cvd_cantidad_producto;
    }

    public void Setcvd_cantidad_producto(int cvd_cantidad_producto) {
        this.cvd_cantidad_producto = cvd_cantidad_producto;
    }
    
    public int Getcvd_costo_producto() {
        return cvd_costo_producto;
    }

    public void Setcvd_costo_producto(int cvd_costo_producto) {
        this.cvd_costo_producto = cvd_costo_producto;
    }
   
    
}
