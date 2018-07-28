package ado.edu.itlas.taskapp.vista;

import ado.edu.itlas.taskapp.entidad.Usuario;

/**
 * Created by MESCyT on 28/7/2018.
 */

public class AppConfig {

    private static  AppConfig APP_CONFIG;
    private Usuario usuario;


    private AppConfig() {
    }


    public static AppConfig getConfig(){
        if (APP_CONFIG == null){
            APP_CONFIG = new AppConfig();
        }

        return APP_CONFIG;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
