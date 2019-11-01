package com.itla.registroestudieantes.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Estudiante {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String nombre;
    private String matricula;
    private Integer idcarrera;

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

}
