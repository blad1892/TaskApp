package ado.edu.itlas.taskapp.vista;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tarea;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;

public class MostrarTareaCreada extends AppCompatActivity {
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp(this);
    Categoria categoria;
    Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tarea_creada);

        TextView lblFecha = (TextView) findViewById(R.id.lblfecha);
        TextView lblCategoria = (TextView) findViewById(R.id.lblCategoria);
        TextView lblUsuarioAsignado = (TextView) findViewById(R.id.lblUsuarioAsignado);
        TextView lblEstado = (TextView) findViewById(R.id.lblEstado);
        TextView lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);

        Bundle bundle = getIntent().getExtras();
        tarea = new Tarea();
        if (bundle != null && bundle.containsKey("tarea")) {
            tarea = (Tarea) bundle.getSerializable("tarea");
            lblFecha.setText(tarea.getFecha().toString());
            lblCategoria.setText(tarea.getCategoria().toString());
            lblEstado.setText(tarea.getEstado().toString());
            if (lblEstado.getText().toString().equals("PENDIENTE")) {
                lblEstado.setTextColor(Color.parseColor("#FFFF8800"));
            } else if (lblEstado.getText().toString().equals("EN_PROCESO")) {
                lblEstado.setTextColor(Color.BLUE);
            } else if (lblEstado.getText().toString().equals("TERMINADO")) {
                lblEstado.setTextColor(Color.GREEN);
            }
            lblUsuarioAsignado.setText(tarea.getUsuarioAsignado().getNombre());
            lblDescripcion.setText(tarea.getDescripcion());
        }
//        tarea = tareasRepositorio.buscar(tarea.getId());

    }
}
