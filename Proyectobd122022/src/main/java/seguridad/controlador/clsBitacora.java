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
public class clsBitacora {
    private int iId_bitacora;
    private String sFecha;
    private String sAccion;
    private String sIp;
    private String sNombrepc;
    private int iId_usuario;
    private int iId_aplicacion;
//ip
//usuario en compu
//scriptgeneral_g3

    public clsBitacora() {
    }

    public clsBitacora(int iId_bitacora) {
        this.iId_bitacora = iId_bitacora;
    }

    public clsBitacora(String sFecha, String sAccion, String sIp, String sNombrepc, int iId_usuario,int iId_aplicacion) {
        this.sFecha = sFecha;
        this.sAccion = sAccion;
        this.sIp = sIp;
        this.sNombrepc = sNombrepc;
        this.iId_usuario = iId_usuario;
        this.iId_aplicacion = iId_aplicacion;
    }

    public int fGetId_bitacora() {
        return iId_bitacora;
    }

    public void fSetId_Bitacora(int iId_bitacora) {
        this.iId_bitacora = iId_bitacora;
    }

    public String fGetfecha_Bitacora() {
        return sFecha;
    }

    public void fSetfecha_Bitacora(String sFecha) {
        this.sFecha = sFecha;
    }

    public String fGetaccion_Bitacora() {
        return sAccion;
    }

    public void fSetaccion_Bitacora(String sAccion) {
        this.sAccion = sAccion;
    }

    public String fGetip_Bitacora() {
        return sIp;
    }

    //public void fSetip_Bitacora(String sIp) {
     //   this.sIp = sIp;
    //}
    
    
    public void fSetip_Bitacora(String sIp) {
        this.sIp = sIp;
    }    

    public String fGetnombrepc_Bitacora() {
        return sNombrepc;
    }

    //public void fSetnombrepc_Bitacora(String sNombrepc) {
    //    this.sNombrepc = sNombrepc;
    //}
    public void fSetnombrepc_Bitacora(String sNombrepc) {
        this.sNombrepc = sNombrepc;
    }    
    
    public int fGetId_Usuario() {
        return iId_usuario;
    }

    public void fSetId_Usuario(int iId_usuario) {
        this.iId_usuario = iId_usuario;
    }

  public int fGetId_Aplicacion() {
        return iId_aplicacion;
    }

    public void fSetId_Aplicacion(int iId_aplicacion) {
        this.iId_aplicacion = iId_aplicacion;
    }
    

    @Override
    public String toString() {
        return "Bitacora{" + "id_bitacora=" + iId_bitacora + ", fecha=" + sFecha + ", accion=" + sAccion + ", id_usuario=" + iId_usuario +", id_aplicacion=" + iId_aplicacion +", ip=" + sIp +", nombrepc=" + sNombrepc + '}';
    }
}

