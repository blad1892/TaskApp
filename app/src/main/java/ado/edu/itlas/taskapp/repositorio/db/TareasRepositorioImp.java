package ado.edu.itlas.taskapp.repositorio.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;

public class TareasRepositorioImp implements TareasRepositorio {
    ConexionDb conexionDb;

    @Override
    public boolean guardar(Usuarios usuarios) {


        return false;
    }

    @Override
    public Tareas buscar(int id) {
        return null;
    }

    @Override
    public Tareas buscarTareas(String username) {
        return null;
    }


    @Override
    public List<Tareas> buscar(String buscarTecnico) {

        List<Usuarios>usuarios=new ArrayList<>();

        String sql = "SELECT nombre FROM usuarios WHERE tipoUsuario = 'TECNICO'";
        SQLiteDatabase db = conexionDb.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql ,null);
        cursor.moveToNext();
        if (!cursor.isAfterLast()){
usuarios.get(cursor.getInt(cursor.getColumnIndex("id")));


        }
        return null;
    }
}
