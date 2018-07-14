package ado.edu.itlas.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

// import javax.swing.text.AbstractDocument;

import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
//import sun.rmi.runtime.Log;

public class UsuarioRepositorioImp implements UsuarioRepositorio {

    private ConexionDb conexionDb;

    private static final String TABLA_USUARIO = "usuarios";
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_CONTRACENA = "contraceña";
    private static final String CAMPO_TIPO_USUARIO = "tipoUsuario";

    public UsuarioRepositorioImp(Context context) {
        conexionDb= new ConexionDb(context);
    }


    @Override
    public boolean guardar(Usuarios usuarios) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, usuarios.getNombre());
        cv.put(CAMPO_EMAIL, usuarios.getEmail());
        cv.put(CAMPO_CONTRACENA, usuarios.getContracena());
        cv.put(CAMPO_TIPO_USUARIO, usuarios.getTipoUsuario());

        SQLiteDatabase db = conexionDb.getWritableDatabase();

        Long i = db.insert(TABLA_USUARIO, null, cv);
        db.close();

        if (i.intValue() > 0) {
            usuarios.setId(i.intValue());
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizar(Usuarios usuarios) {
        return false;
    }

    @Override
    public Usuarios buscar(int id) {
        return null;
    }

    @Override
    public List<Usuarios> buscar(String buscar) {

        List<Usuarios> usuarios = new ArrayList<>();

        SQLiteDatabase db = conexionDb.getReadableDatabase();
        String[] colummas = {"id", CAMPO_NOMBRE, CAMPO_EMAIL, CAMPO_CONTRACENA, CAMPO_TIPO_USUARIO};

        Cursor cursor = db.query(TABLA_USUARIO,colummas,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            int id =cursor.getInt(cursor.getColumnIndex("id"));
            String nombre =cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE));
            String email =cursor.getString(cursor.getColumnIndex(CAMPO_EMAIL));
            String contraceña =cursor.getString(cursor.getColumnIndex(CAMPO_CONTRACENA));
            String tipoUsuario =cursor.getString(cursor.getColumnIndex(CAMPO_TIPO_USUARIO));

            usuarios.add(new Usuarios(id,nombre,email,contraceña,tipoUsuario));
            cursor.moveToNext();
        }
        db.close();
        cursor.close();

        return usuarios;
    }
}
