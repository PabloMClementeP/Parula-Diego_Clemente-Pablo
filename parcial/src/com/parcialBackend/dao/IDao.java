package com.parcialBackend.dao;

public interface IDao<T> {
    // guardar - buscar - eliminar - listar

    T guardar(T t);

    T buscar(int id);

    void eliminar(int id);

    T buscarPorId(int id);
}
