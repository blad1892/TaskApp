package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Tarea;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;

public class TareaUsuarioTecnico extends AppCompatActivity {
    Usuario usuario;
    Tarea tarea;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_usuario_tecnico);

        TextView lblUsuarioL = (TextView) findViewById(R.id.lblUsuarioL);
        lblUsuarioL.setText(AppConfig.getConfig().getUsuario().toString());

        Button btnPendiente = (Button) findViewById(R.id.btnPendiente);
        Button btnProceso = (Button) findViewById(R.id.btnProceso);
        Button btnBusqueda = (Button) findViewById(R.id.btnBusqueda);

        final ListView taLisViewTecnico = (ListView) findViewById(R.id.tareaListViewTecnico);

        usuario = new Usuario();
        usuario.setNombre(AppConfig.getConfig().getUsuario().toString());
        final List<Tarea> tareas = tareasRepositorio.buscarAsignadoA(usuario);

        taLisViewTecnico.setAdapter(new ActivityListaAdapterTecnico(this, tareas));

        taLisViewTecnico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Tarea taExtra = (Tarea) adapterView.getItemAtPosition(position);

                Intent intentRecuperar = new Intent(TareaUsuarioTecnico.this, MostrarTareaCreadaTecnico.class);
                intentRecuperar.putExtra("tarea", taExtra);
                startActivity(intentRecuperar);
            }
        });

        btnPendiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setNombre(AppConfig.getConfig().getUsuario().toString());
                final List<Tarea> tareas1 = tareasRepositorio.buscarAsignadoA(usuario);
                String[] posiciones = new String[tareas1.size()];
                int tama = 0;
                for (int i = 0; i < tareas1.size(); i++) {
                    if (tareas1.get(i).getEstado().toString().equals("PENDIENTE")) {
                        posiciones[i] = i + "";
                        tama++;
                    }
                }
                final List<Tarea> tareas2 = new ArrayList<Tarea>(tama);
                int k = 0;
                for (int i = 0; i < posiciones.length; i++) {
                    if (posiciones[i] != null) {
                        Integer j = Integer.parseInt(posiciones[i]);
                        tareas2.add(k, tareas1.get(j));
                        k++;
                    }
                }

                taLisViewTecnico.setAdapter(new ActivityListaAdapterTecnico(TareaUsuarioTecnico.this, tareas2));
            }
        });

        btnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setNombre(AppConfig.getConfig().getUsuario().toString());
                final List<Tarea> tareas1 = tareasRepositorio.buscarAsignadoA(usuario);
                String[] posiciones = new String[tareas1.size()];
                int tama = 0;
                for (int i = 0; i < tareas1.size(); i++) {
                    if (tareas1.get(i).getEstado().toString().equals("EN_PROCESO")) {
                        posiciones[i] = i + "";
                        tama++;
                    }
                }
                final List<Tarea> tareas2 = new ArrayList<Tarea>(tama);
                int k = 0;
                for (int i = 0; i < posiciones.length; i++) {
                    if (posiciones[i] != null) {
                        Integer j = Integer.parseInt(posiciones[i]);
                        tareas2.add(k, tareas1.get(j));
                        k++;
                    }
                }

                taLisViewTecnico.setAdapter(new ActivityListaAdapterTecnico(TareaUsuarioTecnico.this, tareas2));
            }
        });
    }
}
