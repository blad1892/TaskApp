package ado.edu.itlas.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

        ContentValues cv=new ContentValues();
        cv.put(CAMPO_NOMBRE,categoria.getDescripcion());
        SQLiteDatabase db=conexiodb.getWritableDatabase();

        Long id = db.insert(TABLA_CATEGORIA,null,cv);

if (id.intValue()>0){
    categoria.setId(id.intValue());
    return true;
}

        return false;
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        return false;
    }

    @Override
    public Categoria busacar(int id) {
        return null;
    }

    @Override
    public List<Categoria> buscar(String nombre) {
        return null;
    }
}
