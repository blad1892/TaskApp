package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Tarea;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;

public class MostrarTareaCreadaTecnico extends AppCompatActivity {
    Tarea tarea;
    TareasRepositorio tareasRepositorio = new TareasRepositorioImp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tarea_creada_tecnico);


        TextView lblFecha = (TextView) findViewById(R.id.lblfecha);
        TextView lblCategoria = (TextView) findViewById(R.id.lblCategoria);
        TextView lblUsuarioAsignado = (TextView) findViewById(R.id.lblUsuarioAsignado);
        TextView lblEstado = (TextView) findViewById(R.id.lblEstado);
        TextView lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        TextView lblId = (TextView) findViewById(R.id.lblId);
        final Button btnListo = (Button) findViewById(R.id.btnListo);

        Bundle bundle = getIntent().getExtras();
        tarea = new Tarea();

        if (bundle != null && bundle.containsKey("tarea")) {
            tarea = (Tarea) bundle.getSerializable("tarea");
            tarea = tareasRepositorio.buscar(tarea.getId());

            lblId.setText(tarea.getId().toString());
//            lblFecha.setText(tarea.getFecha().toString());
            lblFecha.setText(tarea.getFecha().toString());
//            lblCategoria.setText(tarea.getCategoria().toString());
            lblCategoria.setText(tarea.getCategoria().toString());
//            lblEstado.setText(tarea.getEstado().toString());
            lblEstado.setText(tarea.getEstado().toString());
            if (lblEstado.getText().toString().equals("PENDIENTE")) {
                btnListo.setBackgroundColor(Color.BLUE);
                lblEstado.setTextColor(Color.parseColor("#FFFF8800"));
                btnListo.setText("En Proceso");
            } else if (lblEstado.getText().toString().equals("EN_PROCESO")) {
                btnListo.setText("Terminado");
                btnListo.setBackgroundColor(Color.GREEN);
                lblEstado.setTextColor(Color.BLUE);
            } else if (lblEstado.getText().toString().equals("TERMINADO")) {
                btnListo.setEnabled(false);
                btnListo.setBackgroundColor(Color.GRAY);
                lblEstado.setTextColor(Color.GREEN);
            }

            lblUsuarioAsignado.setText("By: " + tarea.getUsuarioAsignado().getNombre());
            lblDescripcion.setText(tarea.getDescripcion());

            btnListo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btnListo.getText().toString().equals("En Proceso")) {
                        tarea.setEstado(Tarea.TareaEstado.EN_PROCESO);
                    }else  if(btnListo.getText().toString().equals("Terminado")){
                        tarea.setEstado(Tarea.TareaEstado.TERMINADO);
                    }

                    tareasRepositorio.actualizar(tarea);
                    Intent intent = new Intent(MostrarTareaCreadaTecnico.this, TareaUsuarioTecnico.class);
                    startActivity(intent);
                }
            });
        }
    }
}
