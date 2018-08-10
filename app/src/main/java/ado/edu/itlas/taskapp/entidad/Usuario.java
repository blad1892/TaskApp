package ado.edu.itlas.taskapp.entidad;

import java.io.Serializable;

/**
 * Created by MESCyT on 7/7/2018.
 */

public class Usuario implements Serializable {

    public enum TipoUsuario {
        TECNICO, NORMAL
    }

    private Integer id;
    private String nombre;
    private String email;
    private String contracena;
    private TipoUsuario tipoUsuario;
    private String loguiado;

    public String getLoguiado() {
        return loguiado;
    }

    public void setLoguiado(String loguiado) {
        this.loguiado = loguiado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContracena() {
        return contracena;
    }

    public void setContracena(String contracena) {
        this.contracena = contracena;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String usuarioCreador) {

        this.nombre = nombre;
    }

    public Usuario() {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contracena = contracena;
        this.tipoUsuario = tipoUsuario;
        this.loguiado = loguiado;
    }

    public Usuario(Integer id, String nombre, String email, String contracena, TipoUsuario tipoUsuario, String loguiado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contracena = contracena;
        this.tipoUsuario = tipoUsuario;
        this.loguiado = loguiado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}