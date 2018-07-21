
package ado.edu.itlas.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class UsuarioLista extends AppCompatActivity {
UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        usuarioRepositorio = new UsuarioRepositorioImp(this);
        List<Usuarios> usuarios = usuarioRepositorio.buscar(null);

//        Log.i(log_Tac, "Total de categoria");
        ListView catListView = (ListView) findViewById(R.id.listUsuario);
        catListView.setAdapter(new UsuarioListaAdapter(this, usuarios));
    }
}
