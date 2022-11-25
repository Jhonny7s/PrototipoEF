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
public class clsCliente {
    //declaracion de variable para Vendedores 
    int clicodigo;
    String clinombre;
    String clidireccion;
    String clinit;
    String clitelefono;
    String cliestatus;

    public clsCliente() {
    }

    public clsCliente(int iId_cliente) {
    this.clicodigo = clicodigo;
    }

     public clsCliente(String clinombre, String clidireccion, String clinit, String clitelefono, String cliestatus, int clicodigo ) {
        this.clicodigo = clicodigo;
        this.clinombre = clinombre;
        this.clidireccion = clidireccion;
        this.clinit = clinit;
        this.clitelefono = clitelefono;
        this.cliestatus = cliestatus;
        
    }



public int getClicodigo() {
        return clicodigo;
    }

    public void setClicodigo(int clicodigo) {
        this.clicodigo = clicodigo;
    }


    public String getClinombre() {
        return clinombre;
    }

    public void setClinombre(String clinombre) {
        this.clinombre = clinombre;
    }

    public String getClidireccion() {
        return clidireccion;
    }

    public void setClidireccion(String clidireccion) {
        this.clidireccion = clidireccion;
    }

    public String getClinit() {
        return clinit;
    }

    public void setClinit(String clinit) {
        this.clinit = clinit;
    }

    public String getClitelefono() {
        return clitelefono;
    }

    public void setClitelefono(String clitelefono) {
        this.clitelefono = clitelefono;
    }

    public String getCliestatus() {
        return cliestatus;
    }

    public void setCliestatus(String cliestatus) {
        this.cliestatus = cliestatus;
    }
    
    @Override
    public String toString() {
         return "tbl_clientes{" + "clicodigo =" + clicodigo + ", clinombre=" + clinombre + ", clidireccion=" + clidireccion + ", clinit=" + clinit +", clitelefono=" + clitelefono +", cliestatus=" + cliestatus +'}';
    }
    
}
