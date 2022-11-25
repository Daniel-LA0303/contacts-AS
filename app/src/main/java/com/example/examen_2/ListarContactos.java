package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

public class ListarContactos extends AppCompatActivity implements Response.Listener<JSONObject>,  Response.ErrorListener {

    Button backLogin;
    List<ListElement> elements;

    RequestQueue rq;
    String url;
    JsonObjectRequest jor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contactos);

        backLogin = (Button) findViewById(R.id.button13);


        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class); //pasamos de un activity a otro
                startActivity(i);
            }
        });


        rq = Volley.newRequestQueue(this);
        url = "https://serviciosdigitalesplus.com/servicio/servicio.php?tipo=1&clave=201834496";

        jor = new JsonObjectRequest(Request.Method.GET, url, null, this, this);

        rq.add(jor);

    }
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
        elements = new ArrayList<>();
        try {
            for (int i = 0; i<json.length(); i++){
                jo = json.getJSONObject(i);
                elements.add(new ListElement(jo.optString("nom"), jo.optString("app"), jo.optString("tel"), jo.optString("id")));
            }
            //jo = json.getJSONObject(0);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        Adapter listadapte = new Adapter(elements, this);
        RecyclerView rc = findViewById(R.id.listRecycler);
        rc.setHasFixedSize(true);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(listadapte);
    }
}