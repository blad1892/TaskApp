package ado.edu.itlas.taskapp.vista;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class CrearTareas extends AppCompatActivity {

    CategoriaRepositorio categoriaRepositorio;
    UsuarioRepositorio usuarioRepositorio;
    Categoria categoria;
    Tareas tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tareas);

        categoriaRepositorio = new CategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);

        Spinner spinerCategoria = (Spinner) findViewById(R.id.spinerCategoria);
        spinerCategoria.setAdapter(new CategoriaListAdapter(this, categorias));

        usuarioRepositorio = new UsuarioRepositorioImp(this);
        List<Usuarios> usuarios = usuarioRepositorio.buscar(null);

        Spinner spinerUsuarioTecnico = (Spinner) findViewById(R.id.spinerUsuarioTecnico);
        spinerUsuarioTecnico.setAdapter(new UsuarioListaAdapter(this, usuarios));

        EditText txtDescripcion = (EditText)findViewById(R.id.txtDescripcion);


        Button btnGuardar=(Button)findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
    }

}

