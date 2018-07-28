package ado.edu.itlas.taskapp.repositorio.db;



public class ExtructuraDb {
    public static final  String TABLA_CATEGORIA = "CREATE TABLE categoria(id INTEGER NOT NULL  PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    public static final String TABLA_TAREAS = "CREATE TABLE tareas(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, fecha DATE,"
            + " fechaTerminado DATE, estado TEXT, categoria TEXT, usuarioCreador TEXT, usuarioAsignado TEXT)";
    public static final String TABLA_USUARIO="CREATE TABLE usuarios(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nombre TEXT, email TEXT, contracena TEXT, tipoUsuario TEXT, loguiado TEXT)";
}
