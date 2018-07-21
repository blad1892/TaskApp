package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;

public class CategoriaListActivity extends AppCompatActivity {

    private static final String log_Tac = "Categoria Lista View";
    private CategoriaRepositorio categoriaRepositorio;
//    Categoria categoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista);

        categoriaRepositorio = new CategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);

        Log.i(log_Tac, "Total de categoria");
        ListView catListView = (ListView) findViewById(R.id.categoria_listview);
        catListView.setAdapter(new CategoriaListAdapter(this, categorias));

        catListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adatarView, View view, int position, long id) {

                Categoria cat = (Categoria) adatarView.getItemAtPosition(position);

                Intent  regCatIntento = new Intent(CategoriaListActivity.this, CategoriaActivity.class);
                regCatIntento.putExtra("categoria",cat);
                startActivity(regCatIntento);
            }
        });
    }
}