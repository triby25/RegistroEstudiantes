package com.itla.registroestudieantes.repositories;

import android.content.Context;

import com.itla.registroestudieantes.daointerfaces.CarreraMateriaDao;
import com.itla.registroestudieantes.models.CarreraMateria;

public class CarreraMateriaRepository {
    private CarreraMateriaDao carreraMateriaDao;

    public CarreraMateriaRepository(Context context) {
        DbConexion db = DbConexion.getDatabase(context);
        carreraMateriaDao = db.carreraMateriaDao();
    }

    public void insert(CarreraMateria carreraMateria){ carreraMateriaDao.insert(carreraMateria);}

    public int deleteAll(int idCarrera){return carreraMateriaDao.deleteAll(idCarrera);}
}
