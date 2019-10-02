package com.itla.registroestudieantes.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.registroestudieantes.entidades.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositorioDbImpl implements EstudianteRepositorio {
    private DbConexion dbConexion;

    public EstudianteRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void crear(Estudiante estudiante) {
        ContentValues cv= new ContentValues();
        cv.put("nombre", estudiante.getNombre());
        cv.put("matricula", estudiante.getMatricula());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.insert( "estudiante", null, cv);

        if(id<= 0){
            Log.i("EstudianteRepositorio", "Error guardando estudiante");
        } else {
            Log.i("EstudianteRepositorio", "Estudiante creado id="+id);
        }
    }

    @Override
    public void actulizar(Estudiante estudiante) {
        ContentValues cv= new ContentValues();
        cv.put("nombre", estudiante.getNombre());
        cv.put("matricula", estudiante.getMatricula());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.update( "estudiante",cv,"id=?",new String[]{String.valueOf(estudiante.getId())});

        if(id<= 0){
            Log.i("EstudianteRepositorio", "Error actualizando estudiante");
        } else {
            Log.i("EstudianteRepositorio", "Estudiante "+id+" acatualizado");
        }
    }

    @Override
    public void borrar(Estudiante estudiante) {
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        int res = db.delete("estudiante", "id=?", new String[]{String.valueOf(estudiante.getId())});
    }

    @Override
    public Estudiante buscar(int id) {
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.query("estudiante", null, "id=?", new String[]{String.valueOf(id)}, null, null, null, null);
        List<Estudiante> usuariosAreasList = new ArrayList<>();
        Estudiante estudiante=null;

        while (cursor.moveToNext()) {
            estudiante = new Estudiante();
            estudiante.setId(cursor.getInt(cursor.getColumnIndex("id")));
            estudiante.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            estudiante.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
        }
        cursor.close();
        db.close();
        return estudiante;

    }


}

