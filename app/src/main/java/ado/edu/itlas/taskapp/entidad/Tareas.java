package ado.edu.itlas.taskapp.entidad;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MESCyT on 7/7/2018.
 */

public class Tareas implements Serializable{

    public enum TareaEstado{
        PENDIENTE,
        EN_PROCESO,
        TERMINADO
    }

    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Date fechaTerminado;
    private TareaEstado estado;
    private Categoria categoria;
    private Usuario usuarioCreador;
    private Usuario usuarioAsignado;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaTerminado() {
        return fechaTerminado;
    }

    public void setFechaTerminado(Date fechaTerminado) {
        this.fechaTerminado = fechaTerminado;
    }

    public TareaEstado getEstado() {
        return estado;
    }

    public void setEstado(TareaEstado estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tareas() {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.fechaTerminado = fechaTerminado;
        this.estado = estado;
        this.categoria = categoria;
        this.usuarioCreador = usuarioCreador;
        this.usuarioAsignado = usuarioAsignado;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tareas{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append(", fechaTerminado=").append(fechaTerminado);
        sb.append(", estado=").append(estado);
        sb.append(", categoria=").append(categoria);
        sb.append(", usuarioCreador=").append(usuarioCreador);
        sb.append(", usuarioAsignado=").append(usuarioAsignado);
        sb.append('}');
        return sb.toString();
    }
}
