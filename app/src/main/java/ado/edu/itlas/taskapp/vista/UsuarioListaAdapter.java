package ado.edu.itlas.taskapp.vista;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itlas.taskapp.LoginActivity;
import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;

public class UsuarioListaAdapter extends BaseAdapter {
    private Context context;
    List<Usuarios> usuarios;

    public UsuarioListaAdapter(Context context, List<Usuarios> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(context.equals(CrearTareas.class)){
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.activity_usuario_lista_adapter,null,true);

            TextView lblNombre = convertView.findViewById(R.id.lblNombreUsuario);
            Usuarios user=usuarios.get(position);
            lblNombre.setText(user.getNombre());
            return convertView;
        }



        return convertView;
    }
}
