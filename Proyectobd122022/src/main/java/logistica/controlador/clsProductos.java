package logistica.controlador;

import seguridad.controlador.*;

/*
actualización 0209 Juan Miguel Sandoval Chile ESTA ES LA ************************
*/
public class clsProductos {
    private int prodcodigo;
    private String prodnombre;
    private float prodexistencia;//sper_nombre;
    private String prodestatus;
    private int marcodigo;
    private int lincodigo;
     private String marnombre;
    private String linnombre;
  

    public clsProductos() {
    }

    public clsProductos(int sid) {
   
         this.prodcodigo = sid;
    }
     
      public int getProdcodigo() {
        return prodcodigo;
    }

    public void setProdcodigo(int sid) {
        this.prodcodigo = sid;
    }
    
      public String getProdnombre() {
        return prodnombre;
    }

    public void setProdnombre(String Prodnombre) {
        this.prodnombre = Prodnombre;
    }
        public Float getProdexistencia() {
        return prodexistencia;
    }

    public void setProdexistencia(Float Prodexistencia) {
        this.prodexistencia = Prodexistencia;
    }
    
    
      public String getProdestatus() {
        return prodestatus;
    }

    public void setProdestatus(String Prodestatus) {
        this.prodestatus = Prodestatus;
    }
     public int getMarcodigo() {
        return marcodigo;
    }

    public void setMarcodigo(int Marcodigo) {
        this.marcodigo = Marcodigo;
    }
       public int getLincodigo() {
        return lincodigo;
    }

    public void setLincodigo(int Lincodigo) {
        this.lincodigo = Lincodigo;
    }

    public String getMarnombre() {
        return marnombre;
    }

    public void setMarnombre(String Marnombre) {
        this.marnombre = Marnombre;
    }
       public String getLinnombre() {
        return linnombre;
    }

    public void setLinnombre(String Linnombre) {
        this.linnombre = Linnombre;
    }
    
    
}