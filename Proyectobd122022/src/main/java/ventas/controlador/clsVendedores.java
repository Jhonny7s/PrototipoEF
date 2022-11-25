/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controlador;



/**
 *
 * @author visitante
 */
public class clsVendedores {
    //declaracion de variable para Vendedores 
    int vedcodigo;
    String vednombre;
    String veddireccion;
    String vedtelefono;
    String vednit;
    String vedestatus;

    public clsVendedores() {
    }

    public clsVendedores(int vedcodigo) {
    this.vedcodigo = vedcodigo;
    }

     public clsVendedores(String vednombre, String veddireccion, String vedtelefono, String vednit, String vedestatus, int vedcodigo) {
        this.vedcodigo = vedcodigo;
        this.vednombre = vednombre;
        this.veddireccion = veddireccion;
        this.vedtelefono = vedtelefono;
        this.vednit = vednit;
        this.vedestatus = vedestatus;
    }



public int Getvedcodigo() {
        return vedcodigo;
    }

    public void Setvedcodigo(int vedcodigo) {
        this.vedcodigo = vedcodigo;
    }


    public String Getvednombre() {
        return vednombre;
    }

    public void Setvednombre(String vednombre) {
        this.vednombre = vednombre;
    }

    public String Getveddireccion() {
        return veddireccion;
    }

    public void Setveddireccion(String veddireccion) {
        this.veddireccion = veddireccion;
    }

    public String Getvedtelefono() {
        return vedtelefono;
    }

    public void Setvedtelefono(String vedtelefono) {
        this.vedtelefono = vedtelefono;
    }

    public String Getvednit() {
        return vednit;
    }

    public void Setvednit(String vednit) {
        this.vednit = vednit;
    }

    public String Getvedestatus() {
        return vedestatus;
    }

    public void Setvedestatus(String vedestatus) {
        this.vedestatus = vedestatus;
    }

 



    @Override
    public String toString() {
         return "tbl_vendedores{" + "vedcodigo =" + vedcodigo + ", vednombre=" + vednombre + ", veddireccion=" + veddireccion + ", vedtelefono=" + vedtelefono +", vednit=" + vednit +", vedestatus=" + vedestatus + '}';
    }
    
}
