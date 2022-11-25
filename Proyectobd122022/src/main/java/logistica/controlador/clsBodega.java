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
public class clsBodega {
    int bodcodigo;
    String bodnombre;
    String bodestatus;

    public clsBodega() {
    }

    public clsBodega(int codigo) {
        this.bodcodigo= codigo;
    }

    public clsBodega(String nombre, String estado) {
        this.bodnombre = nombre;
        this.bodestatus = estado;
    }

    public int getcodigob() {
        return bodcodigo;
    }

    public void setcodigob(int codigo) {
        this.bodcodigo = codigo;
    }

    public String getNombreb() {
        return bodnombre;
    }

    public void setNombreb(String nombre) {
        this.bodnombre = nombre;
    }

    public String getestadob() {
        return bodestatus;
    }

    public void setestadob(String estado) {
        this.bodestatus = estado;
    }

    @Override
    public String toString() {
        return "tbl_bodegas{" + "bodcodigo=" + bodcodigo + ", bodnombre=" + bodnombre + ", bodestatus=" + bodestatus + '}';
    }
    
}
