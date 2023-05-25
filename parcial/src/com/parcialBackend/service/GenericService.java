package com.parcialBackend.service;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Generic;

import java.util.List;

public class GenericService {
    private IDao<Generic> genericIDao;

    public GenericService(IDao<Generic> genericIDao){
        this.genericIDao = genericIDao;
    }

    public Generic guardarGeneric(Generic generic){
        return genericIDao.guardar(generic);
    }

    public Generic buscarGenericPorId(int id) {
        return genericIDao.buscar(id);
    }

    public List<Generic> listarGenerics() {
        return genericIDao.listarTodos();
    }

    public void eliminarGeneric(int id) {
        genericIDao.eliminar(id);
    }
}
