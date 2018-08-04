package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
<<<<<<< HEAD
import ado.edu.itlas.taskapp.entidad.Tarea;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;
=======
import ado.edu.itlas.taskapp.entidad.Usuario;
>>>>>>> 811755a5a72f92656b002384c0858e29bb7be543
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class TareaUsuarioNormal extends AppCompatActivity {
<<<<<<< HEAD
    Usuario usuario;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp(this);
=======
    Usuario usuarios;
    UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImp(this);
    int cont;
>>>>>>> 811755a5a72f92656b002384c0858e29bb7be543

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_usuario_normal);
        usuario = new Usuario();
        usuario.setNombre(AppConfig.getConfig().getUsuario().toString());
        final List<Tarea> tareas = tareasRepositorio.buscarCreadoPor(usuario);

        ListView tareasList = (ListView) findViewById(R.id.listViewTareas);
        tareasList.setAdapter(new ActivityListaAdapterTecnico(this, tareas));

        final TextView lblUsuario = (TextView) findViewById(R.id.lblUsuario);
<<<<<<< HEAD
        lblUsuario.setText(AppConfig.getConfig().getUsuario().toString());
=======
        cont += 1;
        if (cont == 1) {
            usuarios = usuarioRepositorio.usuarioLoguiado();
            lblUsuario.setText(usuarios.getNombre().toString());
        }
>>>>>>> 811755a5a72f92656b002384c0858e29bb7be543

        Button btnCrearTarea = (Button) findViewById(R.id.btnCrearTarea);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(TareaUsuarioNormal.this, CrearTareas.class);
<<<<<<< HEAD
                intento.putExtra("usuario", lblUsuario.getText());
=======
                intento.putExtra("usuario",lblUsuario.getText());
>>>>>>> 811755a5a72f92656b002384c0858e29bb7be543
                startActivity(intento);
            }
        });
        ListView tarListView = (ListView) findViewById(R.id.listViewTareas);
        tarListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Tarea ta = (Tarea) adapterView.getItemAtPosition(position);
                Intent intent = new Intent(TareaUsuarioNormal.this, MostrarTareaCreada.class);
                intent.putExtra("tarea", ta);
                startActivity(intent);
            }
        });

        Button btnTodo = (Button) findViewById(R.id.btnTodos);
        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setNombre(AppConfig.getConfig().getUsuario().toString());
                List<Tarea> tas = tareasRepositorio.buscarCreadoPor(usuario);

                ListView tareasList = (ListView) findViewById(R.id.listViewTareas);
                tareasList.setAdapter(new ActivityListaAdapterTecnico(TareaUsuarioNormal.this, tas));
            }
        });
    }
}
