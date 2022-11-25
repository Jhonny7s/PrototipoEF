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
public class clsLinea {
    int lincodigo;
    String linnombre;
    String linestatus;

    public clsLinea() {
    }

    public clsLinea(int codigo) {
        this.lincodigo= codigo;
    }

    public clsLinea(String nombre, String estado) {
        this.linnombre = nombre;
        this.linestatus = estado;
    }

    public int getcodigol() {
        return lincodigo;
    }

    public void setcodigol(int codigo) {
        this.lincodigo = codigo;
    }

    public String getNombrel() {
        return linnombre;
    }

    public void setNombrel(String nombre) {
        this.linnombre = nombre;
    }

    public String getestadol() {
        return linestatus;
    }

    public void setestadol(String estado) {
        this.linestatus = estado;
    }

    @Override
    public String toString() {
        return "tbl_lineas{" + "lincodigo=" + lincodigo + ", linnombre=" + linnombre + ", linestatus=" + linestatus + '}';
    }
    
}
