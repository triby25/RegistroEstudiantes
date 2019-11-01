package com.itla.registroestudieantes.repositories;

import android.content.Context;

import com.itla.registroestudieantes.daointerfaces.MateriaDao;
import com.itla.registroestudieantes.models.Materia;

import java.util.List;

public class MateriaRepository {
    private MateriaDao materiaDao;

    public MateriaRepository(Context context) {
        DbConexion db = DbConexion.getDatabase(context);
        materiaDao = db.materiaDao();
    }

    public Long insert (Materia materia) {
        return materiaDao.insert(materia);
    }

    public int update (Materia materia) {
        return materiaDao.update(materia);
    }

    public int delete (Materia materia) {
        return materiaDao.delete(materia);
    }

    public int deleteAll(){return  materiaDao.deleteAll();}

    public List<Materia> getAll()  {
        return materiaDao.getAll();
    }

    public Materia getById(final int id){
        return materiaDao.getById(id);
    }

    public List<Materia> getByIdCarrera(int idCarrera)  {
        return materiaDao.getByIdCarrera(idCarrera);
    }
}
