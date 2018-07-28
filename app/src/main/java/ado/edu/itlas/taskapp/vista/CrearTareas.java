package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.entidad.Usuarios;
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
    Tareas tareas;
    Usuarios usuario;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tareas);

        final TextView lblUsuario = (TextView) findViewById(R.id.lblUsuario);
       usuario= usuarioRepositorio.usuarioLoguiado();
        lblUsuario.setText(usuario.getNombre());

        categoriaRepositorio = new CategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);

        final Spinner spinerCategoria = (Spinner) findViewById(R.id.spinerCategoria);
        spinerCategoria.setAdapter(new CategoriaListAdapter(this, categorias));

        usuarioRepositorio = new UsuarioRepositorioImp(this);
        final List<Usuarios> usuarios = usuarioRepositorio.buscar(null);

        final Spinner spinerUsuarioTecnico = (Spinner) findViewById(R.id.spinerUsuarioTecnico);
        spinerUsuarioTecnico.setAdapter(new UsuarioListaAdapter(this, usuarios));

        final EditText txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);


        final Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                btnGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        tareas.setNombre(lblUsuario.getText().toString());
                        tareas.setCategoria(categoria.setNombre(spinerCategoria.getSelectedItem().toString()));
                        tareas.setDescripcion(txtDescripcion.getText().toString());
                        tareas.setEstado(Tareas.TareaEstado.PENDIENTE);
                        tareas.setUsuarioAsignado(spinerUsuarioTecnico.getSelectedItem().toString());
                        tareas.setUsuarioCreador(lblUsuario.getText().toString());
                        Calendar c = Calendar.getInstance();
                        tareas.setFecha(c.getTime());

                        if (tareasRepositorio.guardar(tareas)) {
                            Intent intent = new Intent(CrearTareas.this, MostrarTareaCreada.class);
                            startActivity(intent);
                        }

                    }
                });


            }
        });
    }

}

