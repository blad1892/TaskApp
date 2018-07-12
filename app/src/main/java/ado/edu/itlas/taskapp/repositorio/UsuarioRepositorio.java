package ado.edu.itlas.taskapp.repositorio;

import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Usuarios;

public interface UsuarioRepositorio {
    boolean guardar(Usuarios usuarios);
    boolean actualizar(Usuarios usuarios);
    Usuarios buscar(int id);
    List<Usuarios> buscar(String nombre);
}
