package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tarea;
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
    Tarea tarea;
    Usuario usuario;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tareas);

        final TextView lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        lblUsuario.setText(AppConfig.getConfig().getUsuario().getNombre());

        categoriaRepositorio = new CategoriaRepositorioImp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar(null);

        final Spinner spinerCategoria = (Spinner) findViewById(R.id.spinerCategoria);
        ArrayAdapter<Categoria> adapterCategoria = new ArrayAdapter<Categoria>(this, android.R.layout.simple_list_item_1, categorias);
        spinerCategoria.setAdapter(adapterCategoria);

        usuarioRepositorio = new UsuarioRepositorioImp(this);
        final List<Usuario> usuarios = usuarioRepositorio.buscar(null);

        final Spinner spinerUsuarioTecnico = (Spinner) findViewById(R.id.spinerUsuarioTecnico);
        ArrayAdapter<Usuario> adapterUsuario = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, usuarios);
        spinerUsuarioTecnico.setAdapter(adapterUsuario);

        final EditText txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);


        final Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        Usuario ut = (Usuario) spinerUsuarioTecnico.getSelectedItem();
                        if (ut == null) {
                            Toast.makeText(CrearTareas.this, "Debes seleccionar un usuario Tecnico", Toast.LENGTH_LONG).show();
                            return;
                        }
                        tarea = new Tarea();
                        tarea.setNombre(lblUsuario.getText().toString());
                        Categoria catg = (Categoria) spinerCategoria.getSelectedItem();
                        tarea.setCategoria(catg);
                        tarea.setDescripcion(txtDescripcion.getText().toString());
                        tarea.setEstado(Tarea.TareaEstado.PENDIENTE);
                        tarea.setUsuarioCreador(AppConfig.getConfig().getUsuario());
                        tarea.setUsuarioAsignado(ut);

                        tarea.setFecha(new Date());

                        if (tareasRepositorio.guardar(tarea)) {
                            Intent intent = new Intent(CrearTareas.this, TareaUsuarioNormal.class);
                            intent.putExtra("id", tarea.getId());
                            startActivity(intent);
                        }
                    }
                }
        );

    }
}