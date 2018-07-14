package ado.edu.itlas.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ado.edu.itlas.taskapp.vista.CategoriaActivity;
import ado.edu.itlas.taskapp.vista.CategoriaListActivity;
import ado.edu.itlas.taskapp.vista.CategoriaListAdapter;
import ado.edu.itlas.taskapp.vista.LoginActivity;


public class MainActivity extends AppCompatActivity {
    private static final String log_Tac = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Button btnMostrarLista = (Button) findViewById(R.id.btnCategoriaLista);
        btnMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(MainActivity.this, CategoriaListActivity.class);
                startActivity(inten);
            }
        });

        Button btnCategoria = (Button) findViewById(R.id.btnCategoria);
        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(MainActivity.this, CategoriaActivity.class);
                startActivity(inten);
            }
        });

        Button btnRegistrarse = (Button)findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intento);
            }
        });
    }

}
