package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Loging Activity";
    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioRepositorioImp usuarioRepositorioImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioRepositorio = new UsuarioRepositorioImp(this);

        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        EditText txtContraceña = (EditText) findViewById(R.id.txtContraceña);
        TextView lblRegistrarce = (TextView) findViewById(R.id.lblRegistrarse);


        btnIniciar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                          }
                                      }

        );
        lblRegistrarce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(LoginActivity.this, LoginRegistroActivity.class);
                startActivity(intento);
            }
        });


    }
}
