package com.itla.registroestudieantes.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity(foreignKeys = @ForeignKey(entity = Carrera.class,
        parentColumns = "id",
        childColumns = "idcarrera",
        onDelete = ForeignKey.NO_ACTION), indices = @Index({"idcarrera"}))
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
