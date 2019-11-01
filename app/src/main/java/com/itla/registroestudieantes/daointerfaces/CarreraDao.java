package com.itla.registroestudieantes.daointerfaces;


import com.itla.registroestudieantes.models.Carrera;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CarreraDao {
    @Insert
    Long insert(Carrera obj);

    @Update
    Integer update(Carrera obj);

    @Delete
    int delete(Carrera obj);

    @Query("DELETE FROM carrera")
    int deleteAll();

    @Query("SELECT * FROM carrera")
    List<Carrera> getAll();

    @Query("SELECT * FROM carrera WHERE id = :id LIMIT 1")
    Carrera getById(int id);
}
