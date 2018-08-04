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

import ado.edu.itlas.taskapp.entidad.Tarea;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;

import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class TareaUsuarioNormal extends AppCompatActivity {

    Usuario usuario;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp(this);


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

        lblUsuario.setText(AppConfig.getConfig().getUsuario().toString());


        Button btnCrearTarea = (Button) findViewById(R.id.btnCrearTarea);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(TareaUsuarioNormal.this, CrearTareas.class);

                intento.putExtra("usuario", lblUsuario.getText());

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
