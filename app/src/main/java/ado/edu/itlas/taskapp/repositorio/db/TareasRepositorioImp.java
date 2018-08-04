package ado.edu.itlas.taskapp.repositorio.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;

import ado.edu.itlas.taskapp.entidad.Tarea;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;

public class TareasRepositorioImp implements TareasRepositorio {
    ConexionDb conexionDb;
    Tarea tarea;
    Categoria categoria = new Categoria();
    Usuario usuario;

    private final static String TABLE_TAREAS = "tareas";
    private final static String CAMPO_NOMBRE = "nombre";
    private final static String CAMPO_DESCRIPCION = "descripcion";
    private final static String CAMPO_FECHA = "fecha";
    private final static String CAMPO_FECHA_TERMINADO = "fechaTerminado";
    private final static String CAMPO_ESTADO = "estado";
    private final static String CAMPO_CATEGORIA = "categoria";
    private final static String CAMPO_USUARIO_CREADOR = "usuarioCreador";
    private final static String CAMPO_USUARIO_ASIGNADO = "usuarioAsignado";

    public TareasRepositorioImp(Context context) {
        conexionDb = new ConexionDb(context);
    }

    @Override
    public boolean guardar(Tarea tarea) {
        ContentValues cv = new ContentValues();

        cv.put(CAMPO_NOMBRE, tarea.getNombre());
        cv.put(CAMPO_DESCRIPCION, tarea.getDescripcion());
        cv.put(CAMPO_FECHA, tarea.getFecha().toString());
        if (tarea.getFechaTerminado() != null) {
            cv.put(CAMPO_FECHA_TERMINADO, tarea.getFechaTerminado().toString());
        }
        if (tarea.getEstado() == null) {
            cv.put(CAMPO_ESTADO, Tarea.TareaEstado.PENDIENTE.toString());
        } else {
            cv.put(CAMPO_ESTADO, tarea.getEstado().toString());
        }
        cv.put(CAMPO_CATEGORIA, tarea.getCategoria().getNombre());
        cv.put(CAMPO_USUARIO_CREADOR, tarea.getUsuarioCreador().getNombre());
        cv.put(CAMPO_USUARIO_ASIGNADO, tarea.getUsuarioAsignado().getNombre());

        SQLiteDatabase db = conexionDb.getWritableDatabase();

        cv.put(CAMPO_NOMBRE, tarea.getNombre());
        cv.put(CAMPO_DESCRIPCION, tarea.getDescripcion());
        cv.put(CAMPO_FECHA, tarea.getFecha().toString());
//        cv.put(CAMPO_FECHA_TERMINADO, );
        cv.put(CAMPO_ESTADO, tarea.getEstado().toString());
        cv.put(CAMPO_CATEGORIA, categoria.getNombre());
//        cv.put(CAMPO_USUARIO_CREADOR, tareas.getUsuarioCreador());
//        cv.put(CAMPO_USUARIO_ASIGNADO, tareas.getUsuarioAsignado());


        db = conexionDb.getWritableDatabase();


        Long i = db.insert(TABLE_TAREAS, null, cv);
        if (i.intValue() > 0) {
            tarea.setId(i.intValue());
            db.close();
            return true;
        }
        db.close();
        return false;
    }


    @Override
    public Tarea buscar(int Id) {

        String sql = "SELECT  FROM tareas WHERE id=" + Id + "";
        SQLiteDatabase db = conexionDb.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.moveToFirst()) {
            tarea = new Tarea();

            tarea.setId(cursor.getInt(cursor.getColumnIndex("id")));
            tarea.setNombre(cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE)));
            tarea.setDescripcion(cursor.getString(cursor.getColumnIndex(CAMPO_DESCRIPCION)));
            Date fechaCreado = new Date(cursor.getLong(cursor.getColumnIndex(CAMPO_FECHA)));
            Date fechaTerminado = new Date(cursor.getLong(cursor.getColumnIndex(CAMPO_FECHA_TERMINADO)));
            tarea.setFecha(fechaCreado);
            tarea.setFechaTerminado(fechaTerminado);
            String cat = cursor.getString(cursor.getColumnIndex(CAMPO_CATEGORIA));
            Categoria categoria = new Categoria(cat);
            tarea.setCategoria(categoria);
            String estado = cursor.getString(cursor.getColumnIndex(CAMPO_ESTADO));
            String usuarioCreador = cursor.getString(cursor.getColumnIndex(CAMPO_USUARIO_CREADOR));
            String usuarioAsignado = cursor.getString(cursor.getColumnIndex(CAMPO_USUARIO_ASIGNADO));
            Usuario usario = new Usuario();
            usario.setNombre(usuarioCreador);
            tarea.setUsuarioCreador(usario);
            usario.setNombre(usuarioAsignado);
            tarea.setUsuarioAsignado(usario);

            switch (estado) {
                case "PENDIENTE":
                    tarea.setEstado(Tarea.TareaEstado.PENDIENTE);
                    break;
                case "EN_PROCESO":
                    tarea.setEstado(Tarea.TareaEstado.EN_PROCESO);
                    break;
                case "TERMINADO":
                    tarea.setEstado(Tarea.TareaEstado.TERMINADO);
                    break;
            }
        }
        db.close();
        cursor.close();
        return tarea;
    }

    @Override
    public List<Tarea> buscarAsignadoA(Usuario user) {
        List<Tarea> tareas = new ArrayList<Tarea>();

        String sql = "SELECT tareas.* FROM tareas WHERE tareas.usuarioAsignado='" + user + "'";

        SQLiteDatabase db = conexionDb.getReadableDatabase();
        String[] columna = {"id", CAMPO_NOMBRE, CAMPO_DESCRIPCION, CAMPO_FECHA, CAMPO_FECHA_TERMINADO, CAMPO_ESTADO, CAMPO_CATEGORIA, CAMPO_USUARIO_CREADOR, CAMPO_USUARIO_ASIGNADO};

        Cursor cs = db.rawQuery(sql, null, null);

        while (cs.moveToFirst()) {
            int id = cs.getInt(cs.getColumnIndex("id"));
            String nombre = cs.getString(cs.getColumnIndex(CAMPO_NOMBRE));
            String descripcion = cs.getString(cs.getColumnIndex(CAMPO_DESCRIPCION));
            Date fechaCreado = new Date(cs.getLong(cs.getColumnIndex(CAMPO_FECHA)));
            Date fechaTerminado = new Date(cs.getLong(cs.getColumnIndex(CAMPO_FECHA_TERMINADO)));
            String cat = cs.getString(cs.getColumnIndex(CAMPO_CATEGORIA));

            Categoria categoria = new Categoria(cat);

            String estado = cs.getString(cs.getColumnIndex(CAMPO_ESTADO));
            Usuario usario = new Usuario();
            String usuarioCreador = cs.getString(cs.getColumnIndex(CAMPO_USUARIO_CREADOR));
            String usuarioAsignado = cs.getString(cs.getColumnIndex(CAMPO_USUARIO_ASIGNADO));
            usario.setNombre(usuarioCreador);
            switch (estado) {
                case "PENDIENTE":
                    tareas.add(new Tarea(id, nombre, descripcion, fechaCreado, Tarea.TareaEstado.PENDIENTE, categoria, usario));
//                    tarea.setEstado(Tarea.TareaEstado.PENDIENTE);
                    break;
                case "EN_PROCESO":
                    tareas.add(new Tarea(id, nombre, descripcion, fechaCreado, Tarea.TareaEstado.PENDIENTE, categoria, usario));
//                    tarea.setEstado(Tarea.TareaEstado.EN_PROCESO);
                    break;
                case "TERMINADO":
                    tareas.add(new Tarea(id, nombre, descripcion, fechaCreado, Tarea.TareaEstado.PENDIENTE, categoria, usario));
//                    tarea.setEstado(Tarea.TareaEstado.TERMINADO);
                    break;
            }
            cs.moveToNext();
        }
        db.close();
        cs.close();

        return tareas;
    }

    @Override
    public List<Tarea> buscarCreadoPor(Usuario usuario) {
        List<Tarea> tareas = new ArrayList<Tarea>();
        String sql = "SELECT tareas.* FROM tareas WHERE tareas.usuarioCreador='" + usuario.toString() + "'";
        SQLiteDatabase db = conexionDb.getReadableDatabase();
        String[] columna = {"id", CAMPO_NOMBRE, CAMPO_DESCRIPCION, CAMPO_FECHA, CAMPO_FECHA_TERMINADO, CAMPO_ESTADO, CAMPO_CATEGORIA, CAMPO_USUARIO_CREADOR, CAMPO_USUARIO_ASIGNADO};

        Cursor cs = db.rawQuery(sql, null);
//        Cursor cs= db.query(TABLE_TAREAS,columna,null,null,null,null,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
//            if(cs.getString(cs.getColumnIndex(CAMPO_USUARIO_CREADOR)).equals(usuario.toString())) {
            int id = cs.getInt(cs.getColumnIndex("id"));
            String nombre = cs.getString(cs.getColumnIndex(CAMPO_NOMBRE));
            String descripcion = cs.getString(cs.getColumnIndex(CAMPO_DESCRIPCION));
            Date fechaCreado = new Date(cs.getLong(cs.getColumnIndex(CAMPO_FECHA)));
            Date fechaTerminado = new Date(cs.getLong(cs.getColumnIndex(CAMPO_FECHA_TERMINADO)));
            String cat = cs.getString(cs.getColumnIndex(CAMPO_CATEGORIA));
            Categoria categoria = new Categoria(cat);

            String estado = cs.getString(cs.getColumnIndex(CAMPO_ESTADO));
            Usuario usario = new Usuario();
            String usuarioCreador = cs.getString(cs.getColumnIndex(CAMPO_USUARIO_CREADOR));
            String usuarioAsignado = cs.getString(cs.getColumnIndex(CAMPO_USUARIO_ASIGNADO));

            usario.setNombre(usuarioAsignado);

            switch (estado) {
                case "PENDIENTE":
                    tareas.add(new Tarea(id, nombre, descripcion, fechaCreado, Tarea.TareaEstado.PENDIENTE, categoria, usario));
//                    tarea.setEstado(Tarea.TareaEstado.PENDIENTE);
                    break;
                case "EN_PROCESO":
                    tareas.add(new Tarea(id, nombre, descripcion, fechaCreado, Tarea.TareaEstado.PENDIENTE, categoria, usario));
//                    tarea.setEstado(Tarea.TareaEstado.EN_PROCESO);
                    break;
                case "TERMINADO":
                    tareas.add(new Tarea(id, nombre, descripcion, fechaCreado, Tarea.TareaEstado.PENDIENTE, categoria, usario));
//                    tarea.setEstado(Tarea.TareaEstado.TERMINADO);
                    break;
            }
//            }
            cs.moveToNext();
        }
        db.close();
        cs.close();
        return tareas;

    }
}



