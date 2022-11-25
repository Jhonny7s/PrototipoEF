package seguridad.controlador;


public class clsPerfilUsuario {

    private String perid;
    private String usuid;
    private String usunombre;
    private String pernombre;

    public clsPerfilUsuario() {
    }

    public clsPerfilUsuario(String perid, String usuid, String usunombre, String pernombre) {
        this.perid = perid;
        this.usuid = usuid;
        this.usunombre = usunombre;
        this.pernombre = pernombre;
        
    }

   
    
    
    

    public String getPerid() {
        return perid;
    }

    public void setPerid(String perid) {
        this.perid = perid;
    }

    public String getUsuid() {
        return usuid;
    }

    public void setUsuid(String usuid) {
        this.usuid = usuid;
    }

    public String getUsunombre() {
        return usunombre;
    }

    public void setUsunombre(String usunombre) {
        this.usunombre = usunombre;
    }
     public String getPernombre() {
        return pernombre;
    }

    public void setPernombre(String pernombre) {
        this.pernombre = pernombre;
    }


    @Override
    public String toString() {
        return "clsPerfilUsuario{" + "perid=" + perid + ", usuid=" + usuid + ", usunombre=" + usunombre + '}';
    }
    
}