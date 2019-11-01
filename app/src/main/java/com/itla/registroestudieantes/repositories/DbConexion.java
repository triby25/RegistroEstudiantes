package com.itla.registroestudieantes.repositories;

import android.content.Context;

import com.itla.registroestudieantes.daointerfaces.CarreraDao;
import com.itla.registroestudieantes.daointerfaces.CarreraMateriaDao;
import com.itla.registroestudieantes.daointerfaces.EstudianteDao;
import com.itla.registroestudieantes.daointerfaces.MateriaDao;
import com.itla.registroestudieantes.models.*;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Estudiante.class,Carrera.class,Materia.class,CarreraMateria.class}, version = 1,exportSchema = false)

public abstract class DbConexion extends RoomDatabase {
    public abstract EstudianteDao estudianteDao();
    public abstract CarreraDao carreraDao();
    public abstract MateriaDao materiaDao();
    public abstract CarreraMateriaDao carreraMateriaDao();

    private static DbConexion INSTANCE;

    public static DbConexion getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DbConexion.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            DbConexion.class, "dbschool.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
