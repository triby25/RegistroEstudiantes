package com.itla.registroestudieantes.repositories;

import android.content.Context;

import com.itla.registroestudieantes.daointerfaces.CarreraDao;
import com.itla.registroestudieantes.models.Carrera;


import java.util.List;

public class CarreraRepository {
    private CarreraDao carreraDao;

    public CarreraRepository(Context context) {
        DbConexion db = DbConexion.getDatabase(context);
        carreraDao = db.carreraDao();
    }

    public Long insert (Carrera carrera) {
        return carreraDao.insert(carrera);
    }

    public int update (Carrera carrera) {
        return carreraDao.update(carrera);
    }

    public int delete (Carrera carrera) {
        return carreraDao.delete(carrera);
    }

    public int deleteAll(){return  carreraDao.deleteAll();}

    public List<Carrera> getAll()  {
        return carreraDao.getAll();
    }

    public Carrera getById(final int id){
        return carreraDao.getById(id);
    }
}
