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
public class clsPedidosCompras {
    //declaracion de variable para Vendedores 
    String pce_documento;
    int procodigo;
    String pce_fecha;
    int pce_total;
    String pce_estatus;
    
    int pcd_orden;
    int prodcodigo;
    int pcd_cantidad_producto;
    int pcd_costo_producto;

    public clsPedidosCompras() {
    }

    public clsPedidosCompras(String pce_documento, int procodigo, String pce_fecha, int pce_total, String pce_estatus, int pcd_orden, int prodcodigo, int pcd_cantidad_producto, int pcd_costo_producto) {
        this.pce_documento = pce_documento;
        this.procodigo = procodigo;
        this.pce_fecha = pce_fecha;
        this.pce_total = pce_total;
        this.pce_estatus = pce_estatus;
        this.pcd_orden = pcd_orden;
        this.prodcodigo = prodcodigo;
        this.pcd_cantidad_producto = pcd_cantidad_producto;
        this.pcd_costo_producto = pcd_costo_producto;
    }

    public String getPce_documento() {
        return pce_documento;
    }

    public void setPce_documento(String pce_documento) {
        this.pce_documento = pce_documento;
    }

    public int getProcodigo() {
        return procodigo;
    }

    public void setProcodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public String getPce_fecha() {
        return pce_fecha;
    }

    public void setPce_fecha(String pce_fecha) {
        this.pce_fecha = pce_fecha;
    }

    public int getPce_total() {
        return pce_total;
    }

    public void setPce_total(int pce_total) {
        this.pce_total = pce_total;
    }

    public String getPce_estatus() {
        return pce_estatus;
    }

    public void setPce_estatus(String pce_estatus) {
        this.pce_estatus = pce_estatus;
    }

    public int getPcd_orden() {
        return pcd_orden;
    }

    public void setPcd_orden(int pcd_orden) {
        this.pcd_orden = pcd_orden;
    }

    public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int prodcodigo) {
        this.prodcodigo = prodcodigo;
    }

    public int getPcd_cantidad_producto() {
        return pcd_cantidad_producto;
    }

    public void setPcd_cantidad_producto(int pcd_cantidad_producto) {
        this.pcd_cantidad_producto = pcd_cantidad_producto;
    }

    public int getPcd_costo_producto() {
        return pcd_costo_producto;
    }

    public void setPcd_costo_producto(int pcd_costo_producto) {
        this.pcd_costo_producto = pcd_costo_producto;
    }

    @Override
    public String toString() {
        return "clsPedidosCompras{" + "pce_documento=" + pce_documento + ", procodigo=" + procodigo + ", pce_fecha=" + pce_fecha + ", pce_total=" + pce_total + ", pce_estatus=" + pce_estatus + ", pcd_orden=" + pcd_orden + ", prodcodigo=" + prodcodigo + ", pcd_cantidad_producto=" + pcd_cantidad_producto + ", pcd_costo_producto=" + pcd_costo_producto + '}';
    }
    
    }
