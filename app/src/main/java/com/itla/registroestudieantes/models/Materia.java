package com.itla.registroestudieantes.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Materia {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String nombre;
    private Integer creditos;

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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
