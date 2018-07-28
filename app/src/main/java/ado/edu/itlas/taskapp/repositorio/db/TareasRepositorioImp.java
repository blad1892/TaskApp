package ado.edu.itlas.taskapp.repositorio.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;

public class TareasRepositorioImp implements TareasRepositorio {
    ConexionDb conexionDb;
    Tareas tareas;
    Categoria categoria = new Categoria();
    Usuario usuarios;
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
        cv.put(CAMPO_NOMBRE, tareas.getNombre());
        cv.put(CAMPO_DESCRIPCION, tareas.getDescripcion());
        cv.put(CAMPO_FECHA, tareas.getFecha().toString());
//        cv.put(CAMPO_FECHA_TERMINADO, );
        cv.put(CAMPOR_ESTADO, tareas.getEstado().toString());
        cv.put(CAMPO_CATEGORIA, categoria.getNombre());
//        cv.put(CAMPO_USUARIO_CREADOR, tareas.getUsuarioCreador());
//        cv.put(CAMPO_USUARIO_ASIGNADO, tareas.getUsuarioAsignado());


        SQLiteDatabase db =  conexionDb.getWritableDatabase();

        Long i = db.insert(TABLE_TAREAS, null, cv);
        if (i.intValue() > 0) {
            tareas.setId(i.intValue());
            db.close();
            return true;
        }
        db.close();
        return false;
    }


    @Override
    public Tareas buscar(int idTarea) {

        String sql = "SELECT id FROM tareas WHERE id=" + tareas.getId() + "";
        SQLiteDatabase db = conexionDb.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String nombre = cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE));
            String descripcion = cursor.getString(cursor.getColumnIndex(CAMPO_DESCRIPCION));
            String fechaCreado = cursor.getString(cursor.getColumnIndex(CAMPO_FECHA));
            String fechaTerminado = cursor.getString(cursor.getColumnIndex(CAMPO_FECHA_TERMINADO));
            String estado = cursor.getString(cursor.getColumnIndex(CAMPOR_ESTADO));
            categoria.setNombre(cursor.getString(cursor.getColumnIndex(CAMPO_CATEGORIA)));
            String usuarioCreador = cursor.getString(cursor.getColumnIndex(CAMPO_USUARIO_CREADOR));
            String usuarioAsignado = cursor.getString(cursor.getColumnIndex(CAMPO_USUARIO_ASIGNADO));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {

                date = simpleDateFormat.parse(fechaCreado);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            switch (estado) {
                case "PENDIENTE": {
//                    tareas = new Tareas(id, nombre, descripcion, date, null, Tareas.TareaEstado.PENDIENTE, categoria, usuarioCreador, usuarioAsignado);
                    break;
                }
                case "EN_PROCESO": {
//                    tareas = new Tareas(id, nombre, descripcion, date, null, Tareas.TareaEstado.EN_PROCESO, categoria, usuarioCreador, usuarioAsignado);
                    break;
                }
                case "TERMINADO": {
//                    tareas = new Tareas(id, nombre, descripcion, date, null, Tareas.TareaEstado.TERMINADO, categoria, usuarioCreador, usuarioAsignado);
                    break;
                }
            }
        }

        return tareas;
    }

    @Override
    public List<Tareas> buscarAsignadoA(Usuario usuarios) {
        return null;
    }

    @Override
    public List<Tareas> buscarCreadoPor(Usuario usuarios) {
        return null;
    }
}
