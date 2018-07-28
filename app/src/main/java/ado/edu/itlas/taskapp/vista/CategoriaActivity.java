package ado.edu.itlas.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.cert.CertificateRevokedException;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;

public class CategoriaActivity extends AppCompatActivity {

    private static final String LOC_TAC = "CategoriaActivity";
    private CategoriaRepositorio categoriaRepositorio;
    private Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_);

        categoriaRepositorio = new CategoriaRepositorioImp(this);

        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        final Button btnGuardar = (Button) findViewById(R.id.btnGuardar);

        Bundle paraBludle = getIntent().getExtras();

        if (paraBludle != null && paraBludle.containsKey("categoria")) {
            categoria = (Categoria) paraBludle.getSerializable("categoria");
            txtNombre.setText(categoria.getNombre());
            btnGuardar.setText("Actualizar");
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Categoria categoria = new Categoria();
                if (categoria == null) {
                    categoria = new Categoria(null,null);
                }

                categoria.setNombre(txtNombre.getText().toString());

                Log.i(LOC_TAC, categoria.toString());
                categoriaRepositorio.guardar(categoria);
                Log.i(LOC_TAC, categoria.toString());

                if (btnGuardar.getText() == "ACTUALIZAR") {
                    Toast miToas = Toast.makeText(CategoriaActivity.this, "Categoria Actualizada", Toast.LENGTH_LONG);
                    miToas.setGravity(Gravity.CENTER, 20, 40);
                    miToas.show();
                }else if(btnGuardar.getText()=="GUARDAR"){
                    Toast miToas = Toast.makeText(CategoriaActivity.this, "Categoria Guardada", Toast.LENGTH_LONG);
                    miToas.setGravity(Gravity.CENTER, 20, 40);
                    miToas.show();
                }
            }
        });

    }
}
