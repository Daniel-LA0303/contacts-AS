package com.example.examen_2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ConnexionSQLite extends SQLiteOpenHelper {

    String tabla = "create table usuarioExa2 (user text, pass text)";

    public ConnexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla);
        sqLiteDatabase.execSQL("insert into usuarioExa2 values ('admin', 'admin')"); //tabla usuario
        //sqLiteDatabase.execSQL("create table nota (id int, titulo text, comentario text)"); //tabla notas
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if  exists usuarioExa2");
        onCreate(sqLiteDatabase);
    }
}
