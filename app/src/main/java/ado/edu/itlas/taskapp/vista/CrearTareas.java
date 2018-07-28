package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class CrearTareas extends AppCompatActivity {

    CategoriaRepositorio categoriaRepositorio;
    UsuarioRepositorio usuarioRepositorio;
    Categoria categoria;
    Tareas tarea;
    Usuario usuario;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tareas);

        final TextView lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        categoriaRepositorio = new CategoriaRepositorioImp(this);
        final List<Categoria> categorias = categoriaRepositorio.buscar(null);

        final Spinner spinerCategoria = (Spinner) findViewById(R.id.spinerCategoria);
        spinerCategoria.setAdapter(new CategoriaListAdapter(this, categorias));

        usuarioRepositorio = new UsuarioRepositorioImp(this);
        final List<Usuario> usuarios = usuarioRepositorio.buscar(null);

        final Spinner spinerUsuarioTecnico = (Spinner) findViewById(R.id.spinerUsuarioTecnico);
        ArrayAdapter<Usuario> adapterUsuario = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, usuarios);
        spinerUsuarioTecnico.setAdapter(adapterUsuario);

        final EditText txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);


        final Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario ut = (Usuario) spinerUsuarioTecnico.getSelectedItem();

                if (ut == null) {
                    Toast.makeText(CrearTareas.this, "Debes seleccionar un usuario Tecnico", Toast.LENGTH_LONG).show();
                    return;
                }
                tarea = new Tareas();
                categoria = new Categoria();
                tarea.setNombre(AppConfig.getConfig().getUsuario().toString());
                categoria.setNombre(spinerCategoria.getSelectedItem().toString());
                tarea.setCategoria(categoria.setNombre(spinerCategoria.getSelectedItem().toString()));
                tarea.setDescripcion(txtDescripcion.getText().toString());
                tarea.setEstado(Tareas.TareaEstado.PENDIENTE);
                tarea.setUsuarioCreador(AppConfig.getConfig().getUsuario());
                tarea.setUsuarioAsignado(ut);
                tarea.setFecha(new Date());

                if (tareasRepositorio.guardar(tarea)) {
                    Intent intent = new Intent(CrearTareas.this, MostrarTareaCreada.class);
                    startActivity(intent);
                }
            }
        });
    }

}

