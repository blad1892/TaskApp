package ado.edu.itlas.taskapp.repositorio;

import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;

/**
 * Created by MESCyT on 16/6/2018.
 */

public interface CategoriaRepositorio {

    boolean guardar(Categoria categoria);
    boolean actualizar(Categoria categoria);
    Categoria busacar(int id);
    List<Categoria>buscar(String nombre);
}
