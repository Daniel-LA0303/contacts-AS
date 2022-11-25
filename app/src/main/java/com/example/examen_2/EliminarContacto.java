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

public class EliminarContacto extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    Button delete, backLogin;
    EditText id;
    RequestQueue rq;
    String url;
    JsonObjectRequest jor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_contacto);
        delete = (Button) findViewById(R.id.button12);
        backLogin = (Button) findViewById(R.id.button11);
        id = (EditText) findViewById(R.id.editTextTextPersonName9);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class); //pasamos de un activity a otro
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDeleteClick(view);
                Intent i = new Intent(getApplicationContext(), Menu.class); //pasamos de un activity a otro
                startActivity(i);
            }
        });
    }

    public void btnDeleteClick(View v){
        String idDB = "";


        idDB = id.getText().toString();

        rq = Volley.newRequestQueue(this);
        url = "https://serviciosdigitalesplus.com/servicio/servicio.php?" +
                "tipo=4&id=" + idDB  + "&clave=201834496";

        jor = new JsonObjectRequest(Request.Method.GET, url, null, this, this);

        rq.add(jor);
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