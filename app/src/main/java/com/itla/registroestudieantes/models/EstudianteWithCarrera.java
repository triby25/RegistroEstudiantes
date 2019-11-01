package com.itla.registroestudieantes.models;

import androidx.room.Embedded;
import androidx.room.Relation;

public class EstudianteWithCarrera {

    @Embedded
    public Estudiante estudiante;

    @Relation(parentColumn = "idcarrera", entityColumn = "id", entity = Carrera.class)
    public Carrera carrera;
}
