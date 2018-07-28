package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class TareaUsuarioNormal extends AppCompatActivity {
    Usuarios usuarios;
    UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImp(this);
int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_usuario_normal);

        TextView lblUsuario = (TextView) findViewById(R.id.lblUsuario);
        cont+=1;
        if(cont==1) {
            usuarios = usuarioRepositorio.usuarioLoguiado();
            lblUsuario.setText(usuarios.getNombre().toString());
        }

        Button btnCrearTarea = (Button) findViewById(R.id.btnCrearTarea);
        btnCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(TareaUsuarioNormal.this, CrearTareas.class);
                startActivity(intento);
            }
        });

    }
}
