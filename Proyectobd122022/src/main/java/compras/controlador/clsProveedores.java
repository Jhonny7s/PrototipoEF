/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.controlador;

import seguridad.controlador.*;

/**
 *
 * @author visitante
 */

/*
    private int perid;
    private String pernombre;
    private String perestatus; 
*/
public class clsProveedores {
    int procodigo;
    String pronombre;
    String prodireccion;
    String protelefono;
    String pronit;
    String proestatus;

    public clsProveedores() {
    }

    public clsProveedores(int procodigo, String pronombre, String prodireccion, String protelefono, String pronit, String proestatus) {
        this.procodigo = procodigo;
        this.pronombre = pronombre;
        this.prodireccion = prodireccion;
        this.protelefono = protelefono;
        this.pronit = pronit;
        this.proestatus = proestatus;
    }

    public int getprocodigo() {
        return procodigo;
    }

    public void setprocodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public String getpronombre() {
        return pronombre;
    }

    public void setpronombre(String pronombre) {
        this.pronombre = pronombre;
    }

    public String getprodireccion() {
        return prodireccion;
    }

    public void setprodireccion(String prodireccion) {
        this.prodireccion = prodireccion;
    }

    public String getprotelefono() {
        return protelefono;
    }

    public void setprotelefono(String protelefono) {
        this.protelefono = protelefono;
    }

    public String getpronit() {
        return pronit;
    }

    public void setpronit(String pronit) {
        this.pronit = pronit;
    }

    public String getproestatus() {
        return proestatus;
    }

    public void setproestatus(String proestatus) {
        this.proestatus = proestatus;
    }

    @Override
    public String toString() {
        return "clsProveedores{" + "procodigo=" + procodigo + ", pronombre=" + pronombre + ", prodireccion=" + prodireccion + ", protelefono=" + protelefono + ", pronit=" + pronit + ", proestatus=" + proestatus + '}';
    }

}

   