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
public class clsVentas {
    //declaracion de variable para Vendedores 
    String veedocumento;
    int clicodigo;
    String veefecha;
    int veetotal;
    String veeestatus;
    int vedorden;
    int prodcodigo;
    int vedcantidad;
    int vedprecio;
    int bodcodigo;


    public clsVentas() {
    }

    public clsVentas(String veedocumento) {
    this.veedocumento = veedocumento;
    }

     public clsVentas(String veedocumento, int clicodigo, String veefecha, int veetotal, String veeestatus, String vedestatus,int vedorden, 
             int prodcodigo, int vedcantidad, int vedprecio, int bodcodigo) {
         
        this.veedocumento = veedocumento;
        this.clicodigo = clicodigo;
        this.veefecha = veefecha;
        this.veetotal = veetotal;
        this.veeestatus = veeestatus;
        this.vedorden = vedorden;
        this.prodcodigo = prodcodigo;
        this.vedcantidad = vedcantidad;
        this.vedprecio = vedprecio;
        this.bodcodigo = bodcodigo;


    }



public String Getveedocumento() {
        return veedocumento;
    }

    public void Setvedcodigo(String veedocumento) {
        this.veedocumento = veedocumento;
    }


    public int Getclicodigo() {
        return clicodigo;
    }

    public void Setclicodigo(int clicodigo) {
        this.clicodigo = clicodigo;
    }

    public String Getveefecha() {
        return veefecha;
    }

    public void Setveefecha(String veefecha) {
        this.veefecha = veefecha;
    }

    public int Getveetotal() {
        return veetotal;
    }

    public void Setveetotal(int veetotal) {
        this.veetotal = veetotal;
    }
    
    public String Getveeestatus() {
        return veeestatus;
    }

    public void Setveeestatus(String veeestatus) {
        this.veeestatus = veeestatus;
    }
    
    public int Getvedorden() {
        return vedorden;
    }

    public void Setvedorden(int vedorden) {
        this.vedorden = vedorden;
    }
    
    public int Getprodcodigo() {
        return prodcodigo;
    }

    public void Setprodcodigo(int prodcodigo) {
        this.prodcodigo = prodcodigo;
    }
    
        public int Getvedcantidad() {
        return vedcantidad;
    }

    public void Setvedcantidad(int vedcantidad) {
        this.vedcantidad = vedcantidad;
    }
    
    
    public int Getvedprecio() {
        return vedprecio;
    }

    public void Setvedprecio(int vedprecio) {
        this.vedprecio = vedprecio;
    }
    
    public int Getbodcodigo() {
        return bodcodigo;
    }

    public void Setbodcodigo(int bodcodigo) {
        this.bodcodigo = bodcodigo;
    }
    


 



    @Override
    public String toString() {
         return "tbl_vendedores{" + "veedocumento =" + veedocumento + ", clicodigo=" + clicodigo + ", veefecha=" + veefecha + ", veetotal=" + veetotal +", veeestatus=" + veeestatus +", vedorden=" + vedorden +", prodcodigo=" + prodcodigo +", vedcantidad=" + vedcantidad +", vedprecio=" + vedprecio +", bodcodigo=" + bodcodigo + '}';
    }
    
}
