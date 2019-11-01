package com.itla.registroestudieantes.daointerfaces;

import com.itla.registroestudieantes.models.Estudiante;
import com.itla.registroestudieantes.models.EstudianteWithCarrera;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface EstudianteDao  {
    @Insert
    Long insert(Estudiante obj);

    @Update
    Integer update(Estudiante obj);

    @Delete
    int delete(Estudiante obj);

    @Query("DELETE FROM estudiante")
    int deleteAll();

    @Query("SELECT * FROM estudiante")
    List<Estudiante> getAll();

    @Query("SELECT * FROM estudiante WHERE id = :id LIMIT 1")
    Estudiante getById(int id);

    @Query("SELECT * FROM estudiante")
    List<EstudianteWithCarrera> getAllWithCarrera();

    @Query("SELECT * FROM estudiante WHERE id = :id LIMIT 1")
    List<EstudianteWithCarrera> getByIdWithCarrera(int id);

}
