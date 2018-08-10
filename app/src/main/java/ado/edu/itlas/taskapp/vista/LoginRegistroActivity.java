package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import ado.edu.itlas.taskapp.LoginActivity;
import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Usuario;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class LoginRegistroActivity extends AppCompatActivity {

    final static String LOC_TAG = "Login Registro Activity";
    private Usuario usuarios;
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registro);

        usuarioRepositorio = new UsuarioRepositorioImp(this);

        TextView lblRegistrarse = (TextView) findViewById(R.id.lblRegistrarse);
        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        final EditText txtNombre = (EditText) findViewById(R.id.txtnombre);
        final EditText txtContraceña = (EditText) findViewById(R.id.txtContraceña);
        final EditText txtConfirmarContraceña = (EditText) findViewById(R.id.txtConfirmarContracena);
        final RadioButton rdTecnico = (RadioButton) findViewById(R.id.rdTecnico);
        final RadioButton rdNormal = (RadioButton) findViewById(R.id.rdNormal);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuarios == null) {
                    usuarios = new Usuario(null, null, null, null, null,null);
                }
                usuarios.setEmail(txtEmail.getText().toString());
                usuarios.setNombre(txtNombre.getText().toString());
                usuarios.setContracena(txtContraceña.getText().toString());

                if (rdTecnico.isChecked()) {
                    usuarios.setTipoUsuario(Usuario.TipoUsuario.TECNICO);
                } else if (rdNormal.isChecked()) {
                    usuarios.setTipoUsuario(Usuario.TipoUsuario.NORMAL);
                }
                String cont1 = txtContraceña.getText().toString();
                String cont2 = txtConfirmarContraceña.getText().toString();
                if (cont1.equals(cont2)) {

                    Log.i(LOC_TAG, usuarios.toString());
                    usuarioRepositorio.guardar(usuarios);
                    Log.i(LOC_TAG, usuarios.toString());

                    Intent intent = new Intent(LoginRegistroActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast miToas = Toast.makeText(LoginRegistroActivity.this, "La contraceña no coiside", Toast.LENGTH_LONG);
                    miToas.setGravity(Gravity.CENTER, 20, 40);
                    miToas.show();
                }
            }
        });
    }
}
