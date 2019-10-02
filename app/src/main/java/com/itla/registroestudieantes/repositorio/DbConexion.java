package com.itla.registroestudieantes.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbConexion extends SQLiteOpenHelper {
    private final static int VERSION =1;
    private final static String NAME_DB= "escuela.db";

    private final static String estudiante = "CREATE TABLE estudiante (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, matricula TEXT )";

    public DbConexion(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(estudiante);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
