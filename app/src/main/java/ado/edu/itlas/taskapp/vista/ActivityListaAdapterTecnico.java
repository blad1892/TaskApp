package ado.edu.itlas.taskapp.vista;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Tarea;

public class ActivityListaAdapterTecnico extends BaseAdapter {
    private Context contexto;
    List<Tarea> tareas;

    public ActivityListaAdapterTecnico(Context contexto, List<Tarea> tareas) {
        this.contexto = contexto;
        this.tareas = tareas;
    }

    @Override
    public int getCount() {
        return tareas.size();
    }

    @Override
    public Object getItem(int i) {
        return tareas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tareas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // TODO: validar si view no es nulo

        if (view == null) {

            LayoutInflater inflater = LayoutInflater.from(contexto);
            view = inflater.inflate(R.layout.activity_activit_tarea_usuario_lista_row, null, true);

        }
        TextView lblFecha = (TextView) view.findViewById(R.id.lblfecha);
        TextView lblDescripcion = (TextView) view.findViewById(R.id.lblDescripcion);
        TextView lblNombreUsuarioAsignado = (TextView) view.findViewById(R.id.lblNombreUsuarioAsignado);
        TextView lblCategoria = (TextView) view.findViewById(R.id.lblCategoria);
        TextView lblProceso = (TextView) view.findViewById(R.id.lblProceso);

        Tarea ta = tareas.get(i);

        lblFecha.setText(ta.getFecha().toString());
        lblDescripcion.setText(ta.getDescripcion());
        lblNombreUsuarioAsignado.setText(ta.getUsuarioAsignado().toString());
        lblCategoria.setText(ta.getCategoria().toString());
        String est = ta.getEstado().toString();
        lblProceso.setText(est);

        return view;
    }

}
