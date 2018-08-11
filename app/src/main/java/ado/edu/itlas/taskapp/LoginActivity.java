package ado.edu.itlas.taskapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

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


        final TextView mTextView = (TextView) findViewById(R.id.text);
// ...

// Instantiate the RequestQueue.
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://www.google.com";

        // ////////////////////////////// implemetar gjon //////////////// //////
        //         Usuario usuario = nuevo Usuario ();
//         usuario.setEmail ("bladimir@hotmail.com");
//         usuario.setNombre ("bladimir rojas");
//         Gson g = new Gson ();
//         String json = g.toJson (usuario);
//
//         Log.i ("JSON", json);
//
//
//         String usuarioString = "{\" email \ ": \" bladimir@hotmail.com \ ", \" nombre \ ": \" bladimir rojas \ "}";
//
//         Usuario u = g.fromJson (usuarioString, Usuario.class);
//
//         Log.i ("JSON.nombre", u.getNombre ());
//         Log.i ("JSON.email", u.getEmail ());
//
//         try {
//             URL gitapi = nueva URL ("https://api.github.com/gists/public");
//             HttpURLConnection connecion = (HttpURLConnection) gitapi.openConnection ();
//
//             if (connecion.getResponseCode () == 200) {
//                 InputStream result = connecion.getInputStream ();
//
//                 ByteArrayOutputStream result1 = new ByteArrayOutputStream ();
//                 byte [] buffer = new byte [1024];
//                 int length;
//
//                 while ((length = result.read (buffer))! = -1) {
//                     result1.write (buffer, 0, length);
//                 }
//                 Log.i ("API", result1.toString ());
//             }
//         } catch (MalformedURLException e) {
//             e.printStackTrace ();
//         } catch (IOException e) {
//             e.printStackTrace ();
//         }
        // ////////////////////////////////// Gson API //////////// /////////////////////////////


        usuarioRepositorio = new UsuarioRepositorioImp(this);

        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);

        TextView lblRegistrarce = (TextView) findViewById(R.id.lblRegistrarse);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              usuario = new Usuario();
                                              EditText txtUsuario = (EditText) findViewById(R.id.txtNombre);
                                              EditText txtContracena = (EditText) findViewById(R.id.txtContraceña);
                                              usuario.setNombre(txtUsuario.getText().toString());

                                              // Request a string response from the provided URL.
                                              final Gson gson = new Gson();
                                              final StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                                      new Response.Listener<String>() {
                                                          @Override
                                                          public void onResponse(String response) {
                                                              // Display the first 500 characters of the response string.
//                                                              mTextView.setText("Response is: "+ response.substring(0,500));

                                                              Log.i("RESUMEN", response);

                                                              Usuario us = gson.fromJson(response, Usuario.class);
                                                          }
                                                      }, new Response.ErrorListener() {
                                                  @Override
                                                  public void onErrorResponse(VolleyError error) {
//                                                      mTextView.setText("That didn't work!");
                                                      Log.i("RESUMEN", error.toString());
                                                  }
                                              }) {
                                                  @Override
                                                  public byte[] getBody() throws AuthFailureError {

                                                      String stringson = gson.toJson(usuario);
                                                      return stringson.getBytes();
                                                  }
                                              };
                                              queue.add(stringRequest);

                                              //////////////////////////////////////////
//                                              usuario = usuarioRepositorio.buscarUser(usuario.toString());

                                              if (txtNombre.getText().toString().equals("admin") && txtContracena.getText().toString().equals("admin")) {
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

                                              if (usuario.getNombre().equals(txtNombre.getText().toString()) && usuario.getContracena().equals(txtContracena.getText().toString())) {

                                                  AppConfig.getConfig().setUsuario(usuario);

                                                  if (usuario.getTipoUsuario() == Usuario.TipoUsuario.TECNICO) {
                                                      Intent intento = new Intent(LoginActivity.this, TareaUsuarioTecnico.class);
                                                      startActivity(intento);
                                                  } else if (usuario.getTipoUsuario().equals(Usuario.TipoUsuario.NORMAL)) {
                                                      Intent intento = new Intent(LoginActivity.this, TareaUsuarioNormal.class);
                                                      startActivity(intento);
                                                  }

                                              } else if (usuario.getNombre().equals(txtUsuario.getText().toString()) && usuario.getContracena() != txtContracena.getText().toString()) {
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
