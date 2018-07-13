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
    private TipoUsuario tipoUsuario;

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

    public void setContracena(String contracena) {
        this.contraceña = contracena;
    }

    public String getTipoUsuario() {
        return String.valueOf(tipoUsuario);
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuarios{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", contraceña='").append(contraceña).append('\'');
        sb.append(", tipoUsuario=").append(tipoUsuario);
        sb.append('}');
        return sb.toString();
    }
}