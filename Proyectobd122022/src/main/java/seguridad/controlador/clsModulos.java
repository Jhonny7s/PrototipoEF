/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.controlador;

/**
 *
 * @author visitante
 */
public class clsModulos {
    int modid;
    String modnombre;
    String modestatus;

    public clsModulos() {
    }

    public clsModulos(int id_aplicacion) {
        this.modid= id_aplicacion;
    }

    public clsModulos(String nombreAplicacion, String estadoAplicacion) {
        this.modnombre = nombreAplicacion;
        this.modestatus = estadoAplicacion;
    }

    public int getId_aplicacion() {
        return modid;
    }

    public void setId_aplicacion(int id_aplicacion) {
        this.modid = id_aplicacion;
    }

    public String getNombreAplicacion() {
        return modnombre;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.modnombre = nombreAplicacion;
    }

    public String getestadoAplicacion() {
        return modestatus;
    }

    public void setestadoAplicacion(String estadoAplicacion) {
        this.modestatus = estadoAplicacion;
    }

    @Override
    public String toString() {
        return "tbl_modulos{" + "modid=" + modid + ", modnombre=" + modnombre + ", modestatus=" + modestatus + '}';
    }
    
}
