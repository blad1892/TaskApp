package ado.edu.itlas.taskapp.repositorio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MESCyT on 16/6/2018.
 */

public class ConexionDb extends SQLiteOpenHelper {

    private static final String LOG_TAB = "ConexionDb";
    private static final String NOMBRE_DB = "taskapp.db";
    private static final int VERSION_DB = 1;


    public ConexionDb(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAB, "Creando la base de datos");
        db.execSQL(ExtructuraDb.TABLA_CATEGORIA);
        db.execSQL(ExtructuraDb.TABLA_USUARIO);
        db.execSQL(ExtructuraDb.TABLA_TAREAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versiionAntigua, int versionNueva) {
        Log.i(LOG_TAB, "Actualizando la base de datos");
        db.execSQL(ExtructuraDb.TABLA_CATEGORIA);
        db.execSQL(ExtructuraDb.TABLA_USUARIO);
        db.execSQL(ExtructuraDb.TABLA_TAREAS);

    }
}
