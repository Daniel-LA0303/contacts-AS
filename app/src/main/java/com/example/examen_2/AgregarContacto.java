package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class AgregarContacto extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    Button add, backLogin;
    EditText nombre, apellido, tel;

    RequestQueue rq;
    String url;
    JsonObjectRequest jor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        add = (Button) findViewById(R.id.button7);
        backLogin = (Button) findViewById(R.id.button8);

        nombre = (EditText) findViewById(R.id.editTextTextPersonName2);
        apellido = (EditText) findViewById(R.id.editTextTextPersonName3);
        tel = (EditText) findViewById(R.id.editTextTextPersonName4);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class); //pasamos de un activity a otro
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddClick(view);
            }
        });
    }
    public void btnAddClick(View v){
        String id = "";
        String nom = "";
        String app = "";
        String tele = "";

        nom = nombre.getText().toString();
        app = apellido.getText().toString();
        tele = tel.getText().toString();
        rq = Volley.newRequestQueue(this);
        url = "https://serviciosdigitalesplus.com/servicio/servicio.php?" +
                "tipo=2&" + "&nom=" + nom + "&tel=" + tele + "&app=" + app + "&clave=201834496";

        jor = new JsonObjectRequest(Request.Method.GET, url, null, this, this);

        rq.add(jor);
        Intent i = new Intent(getApplicationContext(), Menu.class); //pasamos de un activity a otro
        startActivity(i);
    }


    //add
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println("error");
    }
    //add
    @Override
    public void onResponse(JSONObject response) {
        //validar objeto
        JSONArray json = response.optJSONArray("dato");

        JSONObject jo = null;
        //tare los daots (consulta)

    }
}