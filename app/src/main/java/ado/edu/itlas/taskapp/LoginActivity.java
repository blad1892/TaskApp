package ado.edu.itlas.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ado.edu.itlas.taskapp.entidad.Usuarios;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;
import ado.edu.itlas.taskapp.vista.LoginRegistroActivity;
import ado.edu.itlas.taskapp.vista.MainActivity;
import ado.edu.itlas.taskapp.vista.TareaUsuarioNormal;
import ado.edu.itlas.taskapp.vista.TareaUsuarioTecnico;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Loging Activity";
    private UsuarioRepositorio usuarioRepositorio;
    private Usuarios usuarios;

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


                                              EditText txtUsuario = (EditText) findViewById(R.id.txtNombre);
                                              EditText txtContraceña = (EditText) findViewById(R.id.txtContraceña);

                                              usuarios = usuarioRepositorio.buscarUser(txtUsuario.getText().toString());

                                              if (usuarios.getId() > 0) {

                                                  if (usuarios.getNombre().equals(txtNombre.getText().toString()) && usuarios.getContracena().equals(txtContraceña.getText().toString())) {
                                                      if (usuarios.getTipoUsuario()==Usuarios.TipoUsuario.TECNICO) {
                                                          Intent intento = new Intent(LoginActivity.this, TareaUsuarioTecnico.class);
                                                          startActivity(intento);
                                                      } else if (usuarios.getTipoUsuario().equals(Usuarios.TipoUsuario.NORMAL)) {
                                                          Intent intento = new Intent(LoginActivity.this, TareaUsuarioNormal.class);
                                                          startActivity(intento);
                                                      }

                                                  } else if (usuarios.getNombre().equals(txtUsuario.getText().toString()) && usuarios.getContracena() != txtContraceña.getText().toString()) {
                                                      Toast miToas = Toast.makeText(LoginActivity.this, "La Contraceña es incorecta", Toast.LENGTH_LONG);
                                                      miToas.setGravity(Gravity.CENTER, 20, 40);
                                                      miToas.show();

                                                  }

                                              } else if (usuarios == null) {
                                                  Toast miToas = Toast.makeText(LoginActivity.this, "Usuario no registrado", Toast.LENGTH_LONG);
                                                  miToas.setGravity(Gravity.CENTER, 20, 40);
                                                  miToas.show();
                                              }
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
