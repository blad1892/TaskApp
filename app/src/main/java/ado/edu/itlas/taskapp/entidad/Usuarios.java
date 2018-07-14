package ado.edu.itlas.taskapp.entidad;

/**
 * Created by MESCyT on 7/7/2018.
 */

public class Usuarios {
    public enum TipoUsuario {
        TECNICO, NORMAL
    }


    private Integer id;
    private String nombre;
    private String email;
    private String contraceña;
    private String confirmarContraceña;
    private String tipoUsuario;

    public String getConfirmarContraceña() {
        return confirmarContraceña;
    }

    public void setConfirmarContraceña(String confirmarContraceña) {
        this.confirmarContraceña = confirmarContraceña;
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
        return contraceña;
    }

    public void setContraceña(String contracena) {
        this.contraceña = contracena;
    }

    public String getTipoUsuario() {
        return String.valueOf(tipoUsuario);
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuarios(Integer id, String nombre, String email, String contraceña, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraceña = contraceña;
       this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contraceña='" + contraceña + '\'' +
                ", confirmarContraceña='" + confirmarContraceña + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}