package com.itla.registroestudieantes.daointerfaces;

import com.itla.registroestudieantes.models.Materia;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MateriaDao {
    @Insert
    Long insert(Materia obj);

    @Update
    Integer update(Materia obj);

    @Delete
    int delete(Materia obj);

    @Query("DELETE FROM materia")
    int deleteAll();

    @Query("SELECT * FROM materia")
    List<Materia> getAll();

    @Query("SELECT * FROM materia WHERE id = :id LIMIT 1")
    Materia getById(int id);

    @Query("SELECT m.* FROM materia m INNER JOIN carreramateria cm on m.id = cm.idmateria WHERE cm.idcarrera = :idCarrera")
    List<Materia> getByIdCarrera(int idCarrera);
}
