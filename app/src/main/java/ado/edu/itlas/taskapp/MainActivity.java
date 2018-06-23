package ado.edu.itlas.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ado.edu.itlas.taskapp.vista.CategoriaActivity;


public class MainActivity extends AppCompatActivity {
    private static final String log_Tac = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       Button btnCategoria = (Button) findViewById(R.id.btnCategoria);
       Button btnMostrarLista = (Button) findViewById(R.id.btnMostrarLista);

        btnMostrarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(MainActivity.this, CategoriaListActivity.class);
                startActivity(inten);

            }
        });
        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(MainActivity.this, CategoriaActivity.class);
                startActivity(inten);

            }
        });
//


    }

}
