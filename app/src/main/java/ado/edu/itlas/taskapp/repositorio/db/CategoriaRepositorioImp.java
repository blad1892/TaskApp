package ado.edu.itlas.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;

/**
 * Created by MESCyT on 16/6/2018.
 */

public class CategoriaRepositorioImp implements CategoriaRepositorio {
   private ConexionDb conexiodb;

    private static final String CAMPO_NOMBRE="nombre";
    private  static  final  String  TABLA_CATEGORIA="categoria";
    public CategoriaRepositorioImp(Context context) {
        conexiodb = new ConexionDb(context);
    }

    @Override
    public boolean guardar(Categoria categoria) {

        if (categoria.getId()!=null && categoria.getId()>0){
            return actualizar(categoria);
        }

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());
        SQLiteDatabase db = conexiodb.getWritableDatabase();

        Long id = db.insert(TABLA_CATEGORIA, null, cv);
        db.close();
        if (id.intValue() > 0) {
            categoria.setId(id.intValue());
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizar(Categoria categoria) {

        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());
        SQLiteDatabase db = conexiodb.getWritableDatabase();

        int Cantidad = db.update(TABLA_CATEGORIA, cv, "id = ?", new String[]{categoria.getId().toString()});
        db.close();

        return Cantidad > 0;
    }

    @Override
    public Categoria buscar(int id) {
        return null;
    }

    @Override
    public List<Categoria> buscar(String buscar) {
//        TODO:busacar las
        List<Categoria> categorias = new ArrayList<>();

        SQLiteDatabase db = conexiodb.getReadableDatabase();
        String[] columnas = {"id", CAMPO_NOMBRE};

        Cursor cursor = db.query(TABLA_CATEGORIA, columnas, null, null, null, null, null);
//        El cursor sirve pra preguntar si existe datos en la base de datos buscando fila por fila
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nombre = cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE));


            categorias.add(new Categoria(id, nombre));
            cursor.moveToNext();
        }

        cursor.close();
        db.close();
        return categorias;
    }
}
