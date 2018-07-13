package ado.edu.itlas.taskapp.vista;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.repositorio.UsuarioRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.UsuarioRepositorioImp;

public class LoginActivity extends AppCompatActivity{

    UsuarioRepositorio usuarioRepositorio;
    UsuarioRepositorioImp usuarioRepositorioImp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
}
