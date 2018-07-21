package ado.edu.itlas.taskapp.repositorio;

import java.awt.font.TextAttribute;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;

public interface TareasRepositorio{
    public boolean guardar(Usuarios usuarios);

    public Tareas buscar(int id);

    public Tareas buscarTareas(String username);

    public List<Tareas> buscar(String buscar);
}
