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
public class clsUsuarioConectado {
    private static int usuid;
    private static String usunombre;    

    public static int getUsuid() {
        return usuid;
    }

    public static void setUsuid(int usuid) {
        clsUsuarioConectado.usuid = usuid;
    }

    public static String getUsunombre() {
        return usunombre;
    }

    public static void setUsunombre(String usunombre) {
        clsUsuarioConectado.usunombre = usunombre;
    }
}
