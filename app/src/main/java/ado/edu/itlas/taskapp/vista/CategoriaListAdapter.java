package ado.edu.itlas.taskapp.vista;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;

/**
 * Created by MESCyT on 23/6/2018.
 */

public class CategoriaListAdapter extends BaseAdapter {
    private Context contexto;
    List<Categoria> categorias;

    public CategoriaListAdapter(Context contexto, List<Categoria> categorias) {
        this.contexto = contexto;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return categorias.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // TODO: validar si view no es nulo

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(contexto);
            view = inflater.inflate(R.layout.categoria_listaview_row, null, true);

        }
        TextView lblCategoriaId = view.findViewById(R.id.lblCategoriaId);
        TextView lblNombreCategoria = view.findViewById(R.id.lblNombreCategoria);

        Categoria cat = categorias.get(i);

        lblCategoriaId.setText(cat.getId().toString());
        lblNombreCategoria.setText(cat.getNombre());
        return view;

    }
}
