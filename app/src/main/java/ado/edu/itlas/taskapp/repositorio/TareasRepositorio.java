package ado.edu.itlas.taskapp.repositorio;

import java.awt.font.TextAttribute;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;

public interface TareasRepositorio{
    public boolean guardar(Tareas tareas);

    public Tareas buscar(int id);

    public List<Tareas> buscarAsignadoA(Usuarios usuarios);

    public List<Tareas> buscarCreadoPor(Usuarios usuarios);
}
