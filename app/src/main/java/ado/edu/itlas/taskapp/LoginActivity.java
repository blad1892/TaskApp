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

import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;
import ado.edu.itlas.taskapp.vista.AppConfig;
import ado.edu.itlas.taskapp.vista.LoginRegistroActivity;
import ado.edu.itlas.taskapp.vista.MainActivity;
import ado.edu.itlas.taskapp.vista.TareaUsuarioNormal;
import ado.edu.itlas.taskapp.vista.TareaUsuarioTecnico;

public class LoginActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Loging Activity";
    private UsuarioRepositorio usuarioRepositorio;
    private Usuario usuario;

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

                                              usuario = usuarioRepositorio.buscarUser(txtUsuario.getText().toString());
                                              if (txtNombre.getText().toString().equals("admin") && txtContraceña.getText().toString().equals("admin")) {
                                                  Intent intento = new Intent(LoginActivity.this, MainActivity.class);
                                                  startActivity(intento);
                                                  return;
                                              }


                                              if (usuario == null) {
                                                  Toast miToas = Toast.makeText(LoginActivity.this, "Usuario no registrado", Toast.LENGTH_LONG);
                                                  miToas.setGravity(Gravity.CENTER, 20, 40);
                                                  miToas.show();
                                                  return;
                                              }

                                              if (usuario.getNombre().equals(txtNombre.getText().toString()) && usuario.getContracena().equals(txtContraceña.getText().toString())) {

                                                  AppConfig.getConfig().setUsuario(usuario);

                                                  if (usuario.getTipoUsuario() == Usuario.TipoUsuario.TECNICO) {
                                                      Intent intento = new Intent(LoginActivity.this, TareaUsuarioTecnico.class);
                                                      startActivity(intento);
                                                  } else if (usuario.getTipoUsuario().equals(Usuario.TipoUsuario.NORMAL)) {
                                                      Intent intento = new Intent(LoginActivity.this, TareaUsuarioNormal.class);
                                                      startActivity(intento);
                                                  }

                                              } else if (usuario.getNombre().equals(txtUsuario.getText().toString()) && usuario.getContracena() != txtContraceña.getText().toString()) {
                                                  Toast miToas = Toast.makeText(LoginActivity.this, "La Contraceña es incorecta", Toast.LENGTH_LONG);
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
