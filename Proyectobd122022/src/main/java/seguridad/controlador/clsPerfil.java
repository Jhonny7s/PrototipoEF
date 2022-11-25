package seguridad.controlador;
/*
actualización 0209 Juan Miguel Sandoval Chile ESTA ES LA ************************
*/
public class clsPerfil {
    private int perid; //iper_id;
    private String pernombre;//sper_nombre;
    private String perestatus; //sper_estado;

    public clsPerfil() {
    }

    public clsPerfil(int iid) {
        this.perid = iid;
    }
    
    public clsPerfil(String snombre, String sestado) {
        this.pernombre = snombre;
        this.perestatus = sestado;
    }
    
    public clsPerfil(int iid, String snombre, String sestado) {
        this.perid = iid;
        this.pernombre = snombre;
        this.perestatus = sestado;
    }
    

    public int getId_perfil() {
        return perid;
    }

    public void setId_perfil(int iid) {
        this.perid = iid;
    }

    public String getNombrePerfil() {
        return pernombre;
    }

    public void setNombrePerfil(String snombre) {
        this.pernombre = snombre;
    }

    public String getEstadoPerfil() {
        return perestatus;
    }

    public void setEstadoPerfil(String sestado) {
        this.perestatus = sestado;
    }
    

    @Override
    public String toString() {
        return "tbl_perfil{" + "perid=" + perid + ", pernombre=" + pernombre + ", perestatus=" + perestatus + '}';
    }
    
    
}
