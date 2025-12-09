package com.tap.gestiontorneo.Model.DAO;

import java.util.List;

public interface Repositorio<T> {
    void agregar(T elemento);
    void actualizar(T elemento);
    void eliminar(int id);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
}
