package ado.edu.itlas.taskapp.repositorio;

import java.util.List;


import ado.edu.itlas.taskapp.entidad.Usuarios;

public interface UsuarioRepositorio {
    public boolean guardar(Usuarios usuarios);

    public Usuarios buscar(int id);

    public Usuarios buscarUser(String username);

    public List<Usuarios> buscar(String buscarTecnico);
}
