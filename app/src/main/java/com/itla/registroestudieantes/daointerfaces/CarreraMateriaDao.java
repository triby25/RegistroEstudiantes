package com.itla.registroestudieantes.daointerfaces;

import com.itla.registroestudieantes.models.CarreraMateria;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CarreraMateriaDao {
    @Insert
    void insert(CarreraMateria... obj);

    @Query("DELETE FROM carreramateria where idcarrera = :idCarrera")
    int deleteAll(int idCarrera);

}
