package ado.edu.itlas.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.entidad.Tareas;
import ado.edu.itlas.taskapp.repositorio.TareasRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.TareasRepositorioImp;

public class MostrarTareaCreada extends AppCompatActivity {
TareasRepositorio tareasRepositorio=new TareasRepositorioImp();
Categoria categoria;
Tareas tareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tarea_creada);

        TextView lblFecha=(TextView)findViewById(R.id.lblfecha);
        TextView lblCategoria=(TextView)findViewById(R.id.lblCategoria);
        TextView lblUsuarioAsignado=(TextView)findViewById(R.id.lblUsuarioAsignado);
        TextView lblEstado=(TextView)findViewById(R.id.lblEstado);
        TextView lblDescripcion=(TextView)findViewById(R.id.lblDescripcion);

        tareasRepositorio.buscar(tareas.getId());

        lblFecha.setText(tareas.getFecha().toString());
        lblCategoria.setText(tareas.getCategoria().toString());
        lblEstado.setText(tareas.getEstado().toString());
//        lblUsuarioAsignado.setText(tareas.getUsuarioAsignado());
        lblDescripcion.setText(tareas.getDescripcion());

    }
}
