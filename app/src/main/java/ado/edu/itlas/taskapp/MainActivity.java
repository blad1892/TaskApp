package ado.edu.itlas.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ado.edu.itlas.taskapp.vista.CategoriaActivity;


public class MainActivity extends AppCompatActivity {
    /*
    *https://github.com/blad1892/TaskApp
    *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCategoria=findViewById(R.id.btnCategoria);
        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this,ActivityCategoria.class);
                startActivities(new Intent[]{intento});

            }
        });



    }


}
