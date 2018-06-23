package ado.edu.itlas.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;
import ado.edu.itlas.taskapp.vista.CategoriaListAdapter;

public class CategoriaListActivity extends AppCompatActivity {

    private static final String log_Tac = "MainActivity";
    private CategoriaRepositorio categoriaRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista);

        categoriaRepositorio = new CategoriaRepositorioImp(this);
        List<Categoria>categorias=categoriaRepositorio.buscar(null);

        Log.i(log_Tac,"Total de categoria");
        ListView catListView = (ListView) findViewById(R.id.categoria_listview);
        catListView.setAdapter(new CategoriaListAdapter(this,categorias));


    }
}