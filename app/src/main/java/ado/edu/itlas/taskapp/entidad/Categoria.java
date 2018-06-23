package ado.edu.itlas.taskapp.entidad;


import java.security.PrivateKey;

public class Categoria {
   private Integer id;
    private String nombre;

    public Categoria(){

    }
    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Categoria setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Categoria{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
