package ado.edu.itlas.taskapp.repositorio.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;

public class TareasRepositorioImp implements TareasRepositorio {
    ConexionDb conexionDb;
    Tareas tareas;
    Categoria categoria;
    Usuarios usuarios;
    private final static String TABLE_TAREAS = "tareas";
    private final static String CAMPO_NOMBRE = "nombre";
    private final static String CAMPO_DESCRIPCION = "descripcion";
    private final static String CAMPO_FECHA = "fecha";
    private final static String CAMPO_FECHA_TERMINADO = "fechaTerminado";
    private final static String CAMPOR_ESTADO = "estado";
    private final static String CAMPO_CATEGORIA = "categoria";
    private final static String CAMPO_USUARIO_CREADOR = "usuarioCreador";
    private final static String CAMPO_USUARIO_ASIGNADO = "usuarioAsignado";

    @Override
    public boolean guardar(Tareas tareas) {
        ContentValues cv = new ContentValues();
        cv.put( CAMPO_NOMBRE,tareas.getNombre());
        cv.put( CAMPO_DESCRIPCION, tareas.getDescripcion());
        cv.put( CAMPO_FECHA, tareas.getFecha().toString());
        cv.put( CAMPO_FECHA_TERMINADO,tareas.getFechaTerminado().toString());
        cv.put( CAMPOR_ESTADO,tareas.getEstado().toString());
        cv.put( CAMPO_CATEGORIA, categoria.getNombre());
        cv.put( CAMPO_USUARIO_CREADOR,usuarios.getId());
        cv.put( CAMPO_USUARIO_ASIGNADO,usuarios.getId());


        SQLiteDatabase db = conexionDb.getWritableDatabase();
        db.insert(TABLE_TAREAS, null, cv);


        return false;
    }

    @Override
    public Tareas buscar(int id) {
        return null;
    }

    @Override
    public List<Tareas> buscarAsignadoA(Usuarios usuarios) {
        return null;
    }

    @Override
    public List<Tareas> buscarCreadoPor(Usuarios usuarios) {
        return null;
    }
}
