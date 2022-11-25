/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.controlador;

import seguridad.controlador.*;

/**
 *
 * @author visitante
 */
public class clsSucursales {
    int succodigo;
    String sucnombre;
    String sucestatus;

    public clsSucursales() {
    }

    public clsSucursales(int codigo_aplicacion) {
        this.succodigo= codigo_aplicacion;
    }

    public clsSucursales(String nombreAplicacion, String estadoAplicacion) {
        this.sucnombre = nombreAplicacion;
        this.sucestatus = estadoAplicacion;
    }

    public int getId_Sucursal() {
        return succodigo;
    }

    public void setId_Sucursal(int codigo_aplicacion) {
        this.succodigo = codigo_aplicacion;
    }

    public String getNombreSucursal() {
        return sucnombre;
    }

    public void setNombreSucursal(String nombreAplicacion) {
        this.sucnombre = nombreAplicacion;
    }

    public String getestadoSucursal() {
        return sucestatus;
    }

    public void setestadoSucursal(String estadoAplicacion) {
        this.sucestatus = estadoAplicacion;
    }

    @Override
    public String toString() {
        return "tbl_sucuctor{" + "succodigo=" + succodigo + ", sucnombre=" + sucnombre + ", sucestatus=" + sucestatus + '}';
    }
    
}
