/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.controlador;



/**
 *
 * @author carlos
 */

/*
    private int perid;
    private String pernombre;
    private String perestatus; 
*/
public class clsMarca {
    int marcodigo;
    String marnombre;
    String marestatus;

    public clsMarca() {
    }

    public clsMarca(int codigo) {
        this.marcodigo= codigo;
    }

    public clsMarca(String nombre, String estado) {
        this.marnombre = nombre;
        this.marestatus = estado;
    }

    public int getcodigo() {
        return marcodigo;
    }

    public void setcodigo(int codigo) {
        this.marcodigo = codigo;
    }

    public String getNombre() {
        return marnombre;
    }

    public void setNombre(String nombre) {
        this.marnombre = nombre;
    }

    public String getestado() {
        return marestatus;
    }

    public void setestado(String estado) {
        this.marestatus = estado;
    }

    @Override
    public String toString() {
        return "tbl_marcas{" + "marcodigo=" + marcodigo + ", marnombre=" + marnombre + ", marestatus=" + marestatus + '}';
    }
    
}
