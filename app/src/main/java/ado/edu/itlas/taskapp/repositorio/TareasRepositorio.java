package ado.edu.itlas.taskapp.repositorio;

import java.util.List;

<<<<<<< HEAD
import ado.edu.itlas.taskapp.entidad.Tarea;
=======
import ado.edu.itlas.taskapp.entidad.Tareas;
>>>>>>> 811755a5a72f92656b002384c0858e29bb7be543
import ado.edu.itlas.taskapp.entidad.Usuario;

public interface TareasRepositorio{
    public boolean guardar(Tarea tarea);

    public Tarea buscar(int id);

<<<<<<< HEAD
    public List<Tarea> buscarAsignadoA(Usuario usuarios);

    public List<Tarea> buscarCreadoPor(Usuario usuarios);
=======
    public List<Tareas> buscarAsignadoA(Usuario usuarios);

    public List<Tareas> buscarCreadoPor(Usuario usuarios);
>>>>>>> 811755a5a72f92656b002384c0858e29bb7be543
}
