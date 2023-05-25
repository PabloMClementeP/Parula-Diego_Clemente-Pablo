package com.parcialBackend.dao.impl;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Generic;

import java.util.List;

public class GenericDaoEnMemoria implements IDao<Generic> {

    private List<Generic> genericRepositorio;

    public GenericDaoEnMemoria(List<Generic> estudianteRepositorio) {
        this.genericRepositorio = estudianteRepositorio;
    }

    @Override
    public Generic guardar(Generic generic) {
        genericRepositorio.add(generic);

        return generic;
    }


    @Override
    public Generic buscar(int id) {
        Generic genericBuscado = null;
        int i = 0;
        while(i < genericRepositorio.size() && genericBuscado == null){

            Generic generic = genericRepositorio.get(i);

            if(generic.getId() == id) {
                genericBuscado = generic;
            }
            i++;
        }
        return genericBuscado;
    }


    @Override
    public void eliminar(int id) {

        Generic generic = buscar(id);

        genericRepositorio.remove(generic);
    }

    @Override
    public List<Generic> listarTodos() {
        return genericRepositorio;
    }

}


