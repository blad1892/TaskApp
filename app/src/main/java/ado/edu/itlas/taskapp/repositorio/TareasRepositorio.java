package ado.edu.itlas.taskapp.repositorio;

import java.util.List;

import ado.edu.itlas.taskapp.entidad.Tarea;


import ado.edu.itlas.taskapp.entidad.Usuario;

public interface TareasRepositorio{
    public boolean guardar(Tarea tarea);

    public Tarea buscar(int id);


    public List<Tarea> buscarAsignadoA(Usuario usuarios);

    public List<Tarea> buscarCreadoPor(Usuario usuarios);

}
