package com.parcialBackend.dao;

import java.util.List;

public interface IDao<T> {
    // guardar - listar

    T registrarOdontologo(T var1);

    List<T> listarOdontologos();
}
