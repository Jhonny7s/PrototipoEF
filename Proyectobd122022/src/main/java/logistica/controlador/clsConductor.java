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
public class clsConductor {
    int condid;
    String condnombre;
    String condestatus;

    public clsConductor() {
    }

    public clsConductor(int id_aplicacion) {
        this.condid= id_aplicacion;
    }

    public clsConductor(String nombreAplicacion, String estadoAplicacion) {
        this.condnombre = nombreAplicacion;
        this.condestatus = estadoAplicacion;
    }

    public int getId_Conductor() {
        return condid;
    }

    public void setId_Conductor(int id_aplicacion) {
        this.condid = id_aplicacion;
    }

    public String getNombreConductor() {
        return condnombre;
    }

    public void setNombreConductor(String nombreAplicacion) {
        this.condnombre = nombreAplicacion;
    }

    public String getestadoConductor() {
        return condestatus;
    }

    public void setestadoConductor(String estadoAplicacion) {
        this.condestatus = estadoAplicacion;
    }

    @Override
    public String toString() {
        return "tbl_conductor{" + "condid=" + condid + ", condnombre=" + condnombre + ", condestatus=" + condestatus + '}';
    }
    
}
