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
public class clsConcepto {
    int conid;
    String connombre;
    String conestatus;

    public clsConcepto() {
    }

    public clsConcepto(int codigo) {
        this.conid= codigo;
    }

    public clsConcepto(String nombre, String estado) {
        this.connombre = nombre;
        this.conestatus = estado;
    }

    public int getcodigoc() {
        return conid;
    }

    public void setcodigoc(int codigo) {
        this.conid = codigo;
    }

    public String getNombrec() {
        return connombre;
    }

    public void setNombrec(String nombre) {
        this.connombre = nombre;
    }

    public String getestadoc() {
        return conestatus;
    }

    public void setestadoc(String estado) {
        this.conestatus = estado;
    }

    @Override
    public String toString() {
        return "tbl_conceptos{" + "conid=" + conid + ", connombre=" + connombre + ", conestatus=" + conestatus + '}';
    }
    
}
