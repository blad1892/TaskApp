package ado.edu.itlas.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Tarea;

public class MostrarTareaCreadaTecnico extends AppCompatActivity {
    Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tarea_creada_tecnico);


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
            lblUsuarioAsignado.setText("By: " + tarea.getUsuarioAsignado().getNombre());
            lblDescripcion.setText(tarea.getDescripcion());
        }
    }
}
