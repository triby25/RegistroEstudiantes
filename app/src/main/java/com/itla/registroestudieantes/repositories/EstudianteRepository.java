package com.itla.registroestudieantes.repositories;

import android.content.Context;

import com.itla.registroestudieantes.daointerfaces.EstudianteDao;
import com.itla.registroestudieantes.models.Estudiante;
import com.itla.registroestudieantes.models.EstudianteWithCarrera;

import java.util.List;

public class EstudianteRepository {
    private EstudianteDao estudianteDao;

    public EstudianteRepository(Context context) {
        DbConexion db = DbConexion.getDatabase(context);
        estudianteDao = db.estudianteDao();
    }

    public Long insert(Estudiante estudiante) {
        return estudianteDao.insert(estudiante);
    }

    public int update(Estudiante estudiante) {
        return estudianteDao.update(estudiante);
    }

    public int delete(Estudiante estudiante) {
        return estudianteDao.delete(estudiante);
    }

    public int deleteAll(){return estudianteDao.deleteAll();}

    public List<Estudiante> getAll() {
        return estudianteDao.getAll();
    }

    public Estudiante getById(final int id) {
        return estudianteDao.getById(id);
    }

    public List<EstudianteWithCarrera> getAllWithCarrera(){
        return  estudianteDao.getAllWithCarrera();
    }

    public List<EstudianteWithCarrera> getByIdWithCarrera(int id){
        return estudianteDao.getByIdWithCarrera(id);
    }
}

