package seguridad.controlador;

public class clsPerfilAplicaciones {

    private String perid;
    private String aplid;
    private String aplnombre;

    public clsPerfilAplicaciones() {
    }

    public clsPerfilAplicaciones(String perid, String aplid, String aplnombre) {
        this.perid = perid;
        this.aplid = aplid;
        this.aplnombre = aplnombre;
    }

   
    
    
    

    public String getPerid() {
        return perid;
    }

    public void setPerid(String perid) {
        this.perid = perid;
    }

    public String getAplid() {
        return aplid;
    }

    public void setAplid(String aplid) {
        this.aplid = aplid;
    }

    public String getAplnombre() {
        return aplnombre;
    }

    public void setAplnombre(String aplnombre) {
        this.aplnombre = aplnombre;
    }

    @Override
    public String toString() {
        return "clsPerfilAplicaciones{" + "perid=" + perid + ", aplid=" + aplid + ", aplnombre=" + aplnombre + '}';
    }
    
}