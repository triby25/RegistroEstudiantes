package com.itla.registroestudieantes.repositorio;

import com.itla.registroestudieantes.entidades.Estudiante;

public interface EstudianteRepositorio {
    void crear(Estudiante estudiante);
    void actulizar (Estudiante estudiante);
    void borrar ( Estudiante estudiante);
    Estudiante buscar(int id);

}
