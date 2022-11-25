package logistica.controlador;

import seguridad.controlador.*;

/*
actualización 0209 Juan Miguel Sandoval Chile ESTA ES LA ************************
*/
public class clsTransporte {
    private int tranmatricula; //iper_id;
    private String tranmodelo;//sper_nombre;
    private String tranmarca; //sper_estado;
      private String trantipo;

    public clsTransporte() {
    }

    public clsTransporte(int iid) {
        this.tranmatricula = iid;
    }
    
    public clsTransporte(String snombre, String sestado, String tipo) {
        this.tranmodelo = snombre;
        this.tranmarca = sestado;
         this.trantipo = tipo;
    }
    
    public clsTransporte(int iid, String snombre, String sestado, String tipo) {
        this.tranmatricula = iid;
        this.tranmodelo = snombre;
        this.tranmarca = sestado;
        this.trantipo = tipo;
    }
    

    public int getTranmatricula() {
        return tranmatricula;
    }

    public void setTranmatricula(int iid) {
        this.tranmatricula = iid;
    }

    public String getTranmodelo() {
        return tranmodelo;
    }

    public void setTranmodelo(String snombre) {
        this.tranmodelo = snombre;
    }

    public String getTranmarca() {
        return tranmarca;
    }

    public void setTranmarca(String sestado) {
        this.tranmarca = sestado;
    }
    
     public String getTrantipo() {
        return trantipo;
    }

    public void setTrantipo(String tipo) {
        this.trantipo = tipo;
    }
    

    @Override
    public String toString() {
        return "tbl_perfil{" + "tranmatricula=" + tranmatricula + ", tranmodelo=" + tranmodelo + ", tranmarca=" + tranmarca + '}';
    }
    
    
}
