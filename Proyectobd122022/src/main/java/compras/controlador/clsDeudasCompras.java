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
public class clsDeudasCompras {
    //declaracion de variable para Vendedores 
    String dce_documento;
    int procodigo;
    String coedocumento;
    String dce_estatus;
    
    int prodcodigo;
    int total_compras;
    int dce_saldo_documento;
    int deudacompra;

    public clsDeudasCompras() {
    }

    public clsDeudasCompras(String dce_documento, int procodigo, String coedocumento, String dce_estatus, int prodcodigo, int total_compras, int dce_saldo_documento, int deudacompra) {
        this.dce_documento = dce_documento;
        this.procodigo = procodigo;
        this.coedocumento = coedocumento;
        this.dce_estatus = dce_estatus;
        this.prodcodigo = prodcodigo;
        this.total_compras = total_compras;
        this.dce_saldo_documento = dce_saldo_documento;
        this.deudacompra = deudacompra;
    }

    public String getDce_documento() {
        return dce_documento;
    }

    public void setDce_documento(String dce_documento) {
        this.dce_documento = dce_documento;
    }

    public int getProcodigo() {
        return procodigo;
    }

    public void setProcodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public String getCoedocumento() {
        return coedocumento;
    }

    public void setCoedocumento(String coedocumento) {
        this.coedocumento = coedocumento;
    }

    public String getDce_estatus() {
        return dce_estatus;
    }

    public void setDce_estatus(String dce_estatus) {
        this.dce_estatus = dce_estatus;
    }

    public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int prodcodigo) {
        this.prodcodigo = prodcodigo;
    }

    public int getTotal_compras() {
        return total_compras;
    }

    public void setTotal_compras(int total_compras) {
        this.total_compras = total_compras;
    }

    public int getDce_saldo_documento() {
        return dce_saldo_documento;
    }

    public void setDce_saldo_documento(int dce_saldo_documento) {
        this.dce_saldo_documento = dce_saldo_documento;
    }

    public int getDeudacompra() {
        return deudacompra;
    }

    public void setDeudacompra(int deudacompra) {
        this.deudacompra = deudacompra;
    }

    @Override
    public String toString() {
        return "clsDeudasCompras{" + "dce_documento=" + dce_documento + ", procodigo=" + procodigo + ", coedocumento=" + coedocumento + ", dce_estatus=" + dce_estatus + ", prodcodigo=" + prodcodigo + ", total_compras=" + total_compras + ", dce_saldo_documento=" + dce_saldo_documento + ", deudacompra=" + deudacompra + '}';
    }

    }
