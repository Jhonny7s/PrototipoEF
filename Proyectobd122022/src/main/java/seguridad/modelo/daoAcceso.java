/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad.modelo;

import seguridad.vista.mdiGeneral;

/**
 *
 * @author Miguel Sandoval
 */
public class daoAcceso {
    public daoAcceso(String usuario){
      String tipo_usuario=usuario.toUpperCase();
      if(tipo_usuario.equals("") || tipo_usuario.equals("INVITADO") ){
          Invitado();
      }else if( tipo_usuario.equals("ADMINISTRADOR")){
          Administrador();
      }else if( tipo_usuario.equals("USUARIO")){
          Usuario();
      }
    }
    
    private void Administrador(){
        mdiGeneral mdi= new mdiGeneral();    
        mdi.setVisible(true);
    }
    
    private void Usuario(){
        mdiGeneral mdi= new mdiGeneral();
        mdi.jMenuItem3.setVisible(false);
        mdi.jMenuItem6.setVisible(false);
        mdi.setVisible(true);
    }
    
     private void Invitado(){
        mdiGeneral mdi= new mdiGeneral();
        mdi.jMenu4.enable(false);
        mdi.jM_MantenimientopApps.enable(false);
        mdi.setVisible(true);
    }
    
}
