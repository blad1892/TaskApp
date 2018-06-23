package ado.edu.itlas.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.cert.CertificateRevokedException;

import ado.edu.itlas.taskapp.R;
import ado.edu.itlas.taskapp.entidad.Categoria;
import ado.edu.itlas.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itlas.taskapp.repositorio.db.CategoriaRepositorioImp;

public class CategoriaActivity extends AppCompatActivity {

    private static final String LOC_TAC = "CategoriaActivity";
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_);

        categoriaRepositorio=new CategoriaRepositorioImp(this);

        Button btnGuardar;
        final EditText txtNombre=(EditText) findViewById(R.id.txtNombre);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categoria categoria = new Categoria();
                categoria.setDescripcion(txtNombre.getText().toString());


                Log.i(LOC_TAC, categoria.toString());
                categoriaRepositorio.guardar(categoria);
                Log.i(LOC_TAC, categoria.toString());

            }
        });

    }
}
