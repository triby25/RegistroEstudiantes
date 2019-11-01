package com.itla.registroestudieantes.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Carrera {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
