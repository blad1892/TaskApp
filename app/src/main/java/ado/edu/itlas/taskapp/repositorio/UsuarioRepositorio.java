package ado.edu.itlas.taskapp.repositorio;

import java.util.List;


import ado.edu.itlas.taskapp.entidad.Usuarios;

public interface UsuarioRepositorio {
    boolean guardar(Usuarios usuarios);

    int buscar(int id);

    Usuarios buscarUser(String username);

    List<Usuarios> buscar(String buscarTecnico);
}
