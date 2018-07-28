package ado.edu.itlas.taskapp.repositorio;

import java.util.List;

import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuario;

public interface TareasRepositorio{
    public boolean guardar(Tareas tareas);

    public Tareas buscar(int id);

    public List<Tareas> buscarAsignadoA(Usuario usuarios);

    public List<Tareas> buscarCreadoPor(Usuario usuarios);
}
