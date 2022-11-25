package logistica.controlador;

import seguridad.controlador.*;

/*
actualización 0209 Juan Miguel Sandoval Chile ESTA ES LA ************************
*/
public class clsExistencias {
    private int bodcodigo; //iper_id;
     private int prodcodigo;
    private float exisaldo;//sper_nombre;
    private String bodnombre;
    private String prodnombre;

    public clsExistencias() {
    }

    public clsExistencias(int iid, int sid) {
        this.bodcodigo = iid;
         this.prodcodigo = sid;
    }
    
  
    
    public clsExistencias(int iid, int sid,  Float fid) {
        this.bodcodigo = iid;
         this.prodcodigo = sid;
        this.exisaldo = fid;
      
    }
    

    public int getBodcodigo() {
        return bodcodigo;
    }

    public void setBodcodigo(int iid) {
        this.bodcodigo = iid;
    }
      public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int sid) {
        this.prodcodigo = sid;
    }
    
     public float getExisaldo() {
        return exisaldo;
    }

    public void setExisaldo(float fid) {
        this.exisaldo = fid;
    }


    public String getBodnombre() {
        return bodnombre;
    }

    public void setBodnombre(String Bodnombre) {
        this.bodnombre = Bodnombre;
    }
       public String getProdnombre() {
        return prodnombre;
    }

    public void setProdnombre(String Prodnombre) {
        this.prodnombre = Prodnombre;
    }
    
    
}
