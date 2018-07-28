package ado.edu.itlas.taskapp.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Usuario;

public class UsuarioListaAdapter extends BaseAdapter {
    private Context context;
    List<Usuario> usuarios;

    public UsuarioListaAdapter(Context context, List<Usuario> usuarios) {
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
    public long getItemId(int i) {
        return usuarios.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_usuario_lista_adapter, null, true);

            TextView lblNombre = convertView.findViewById(R.id.lblNombreUsuario);

            Usuario user = usuarios.get(i);
            lblNombre.setText(user.getNombre());

        return lblNombre;
    }
}
