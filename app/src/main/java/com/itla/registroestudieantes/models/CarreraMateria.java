package com.itla.registroestudieantes.models;

import android.content.Intent;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CarreraMateria {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Integer idcarrera;
    private Integer idmateria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }
}
