package ado.edu.itlas.taskapp.repositorio;

import android.icu.lang.UScript;

import java.util.List;


import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;

public interface UsuarioRepositorio {
    public boolean guardar(Usuarios usuarios);

    public Usuarios buscar(int id);

    public Usuarios buscarUser(String username);

    public List<Usuarios> buscar(String tecnico);
    public boolean loguiarUsuario(String loguiarDesloguiar, String nombreUsuario);
    public Usuarios usuarioLoguiado();
}
