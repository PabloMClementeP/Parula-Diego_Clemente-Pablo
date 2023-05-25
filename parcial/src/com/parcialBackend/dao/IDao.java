package com.parcialBackend.dao;

import java.util.List;

public interface IDao<T> {
    // guardar - buscar - eliminar - listar

    T guardar(T t);

    T buscar(int id);

    void eliminar(int id);

    List<T> listarTodos();
}
