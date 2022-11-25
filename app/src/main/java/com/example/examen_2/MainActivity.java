package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        user = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);

        user.setText("admin");
        pass.setText("admin");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1Clcik(view);
            }
        });
    }
    public void btn1Clcik(View v){
        ConnexionSQLite conn = new ConnexionSQLite(getApplicationContext(), "dbUsuario", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        String sql = "select * from usuarioExa2 where user = '"+ user.getText().toString() + "'";
        //String line ="";
        try {
            Cursor c = db.rawQuery(sql, null);
            while (c.moveToNext()){
                if(c.getString(1).equals(pass.getText().toString())){

                    Intent i = new Intent(this, Menu.class);
                    i.putExtra("user", user.getText().toString());
                    //rootclear();
                    startActivity(i);
                }
            }
            db.close();
        }catch (Exception ex){
            db.close();
        }

    }


    public void clear(){
        user.setText("");
        pass.setText("");
    }
}