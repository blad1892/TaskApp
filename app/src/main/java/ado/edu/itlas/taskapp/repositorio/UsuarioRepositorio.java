package ado.edu.itlas.taskapp.repositorio;

import java.util.List;


import ado.edu.itlas.taskapp.entidad.Usuario;

public interface UsuarioRepositorio {
    public boolean guardar(Usuario usuarios);

    public Usuario buscar(int id);

    public Usuario buscarUser(String username);

    public List<Usuario> buscar(String tecnico);
}
