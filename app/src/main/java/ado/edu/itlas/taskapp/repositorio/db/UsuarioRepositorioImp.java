package ado.edu.itlas.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

// import javax.swing.text.AbstractDocument;

import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
//import sun.rmi.runtime.Log;

public class UsuarioRepositorioImp implements UsuarioRepositorio {

    private ConexionDb conexionDb;
    Usuario usuarios;
    private final String LOC_TAG = "Guardando un usuario";
    private final String LOC_TAG2 = "Loguiar usuario";

    private static final String TABLA_USUARIO = "usuarios";
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_EMAIL = "email";
    private static final String CAMPO_CONTRACENA = "contracena";
    private static final String CAMPO_TIPO_USUARIO = "tipoUsuario";

    public UsuarioRepositorioImp(Context context) {
        conexionDb = new ConexionDb(context);
    }


    @Override
    public boolean guardar(Usuario usuarios) {
        ContentValues cv = new ContentValues();
        cv.put(CAMPO_NOMBRE, usuarios.getNombre());
        cv.put(CAMPO_EMAIL, usuarios.getEmail());
        cv.put(CAMPO_CONTRACENA, usuarios.getContracena());
        cv.put(CAMPO_TIPO_USUARIO, usuarios.getTipoUsuario().toString());

        SQLiteDatabase db = conexionDb.getWritableDatabase();

        if (usuarios.getId() != null && usuarios.getId() > 0) {
            int cantidad = db.update(TABLA_USUARIO, cv, "id=1", new String[]{usuarios.getId().toString()});
            db.close();
            return cantidad > 0;
        } else {

            Long i = db.insert(TABLA_USUARIO, null, cv);
            db.close();

            if (i.intValue() > 0) {
                usuarios.setId(i.intValue());
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario buscar(int id) {
        String sql = "SELECT * FROM usuarios WHERE nombre = '" + usuarios.getNombre() + "'";
        SQLiteDatabase db = conexionDb.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        int i;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                String tipUsuario = cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE));

                if (tipUsuario.equals("TECNICO")) {
                    usuarios.setId(id);
                    return usuarios;
                } else {
                    cursor.moveToNext();
                }
            }
        }
        return null;
    }


    public Usuario buscarUser(String username) {//Este metodo estaba de la siguiente manera public Usuario buscarUser(String username)

        Usuario usuarios = null;
        String sql = "SELECT * FROM usuarios WHERE nombre ='" + username + "'";

//        String[] columnas = {"id", CAMPO_NOMBRE, CAMPO_EMAIL, CAMPO_CONTRACENA, CAMPO_TIPO_USUARIO};

        SQLiteDatabase db = conexionDb.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {

            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nombre = cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE));
            String email = cursor.getString(cursor.getColumnIndex(CAMPO_EMAIL));
            String contracena = cursor.getString(cursor.getColumnIndex(CAMPO_CONTRACENA));
            String tipoUsuario = cursor.getString(cursor.getColumnIndex(CAMPO_TIPO_USUARIO));

            if (tipoUsuario.equals("TECNICO")) {

                usuarios = new Usuario(id, nombre, email, contracena, Usuario.TipoUsuario.TECNICO);
                db.close();
                cursor.close();
            } else if (tipoUsuario.equals("NORMAL")) {
                usuarios = new Usuario(id, nombre, email, contracena, Usuario.TipoUsuario.NORMAL);

                db.close();
                cursor.close();
            }
        } else {
            db.close();
            cursor.close();
        }

        return usuarios;
    }

    @Override
    public List<Usuario> buscar(String tecnico) {

        List<Usuario> usuarios = new ArrayList<>();
//        String sql = "SELECT id, nombre, tipoUsuario FROM usuarios WHERE tipoUsuario = 'TECNICO'";
        SQLiteDatabase db = conexionDb.getReadableDatabase();
        String[] columna = {"id", CAMPO_NOMBRE, CAMPO_EMAIL, CAMPO_CONTRACENA, CAMPO_TIPO_USUARIO};

        Cursor cursor = db.query(TABLA_USUARIO, columna, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nombre = cursor.getString(cursor.getColumnIndex(CAMPO_NOMBRE));
            String email = cursor.getString(cursor.getColumnIndex(CAMPO_EMAIL));
            String contraceña = cursor.getString(cursor.getColumnIndex(CAMPO_CONTRACENA));
            String tipoUsuario = cursor.getString(cursor.getColumnIndex(CAMPO_TIPO_USUARIO));


            if (tipoUsuario.equals("TECNICO")) {
                usuarios.add(new Usuario(id, nombre, email, contraceña, Usuario.TipoUsuario.TECNICO));
            }
            cursor.moveToNext();
        }
        db.close();
        cursor.close();

        return usuarios;
    }

}
//    UPDATE tblCustomers
//    SET Email = 'None'
//    WHERE [Last Name] = 'Smith'