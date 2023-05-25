package com.parcialBackend.dao.impl;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Odontologo;

import java.util.List;

public class GenericDaoEnMemoria implements IDao<Odontologo> {

    private List<Odontologo> genericRepositorio;

    public GenericDaoEnMemoria(List<Odontologo> estudianteRepositorio) {
        this.genericRepositorio = estudianteRepositorio;
    }

    @Override
    public Odontologo guardar(Odontologo generic) {
        genericRepositorio.add(generic);

        return generic;
    }


    @Override
    public Odontologo buscar(int id) {
        Odontologo genericBuscado = null;
        int i = 0;
        while(i < genericRepositorio.size() && genericBuscado == null){

            Odontologo generic = genericRepositorio.get(i);

            if(generic.getId() == id) {
                genericBuscado = generic;
            }
            i++;
        }
        return genericBuscado;
    }


    @Override
    public void eliminar(int id) {

        Odontologo generic = buscar(id);

        genericRepositorio.remove(generic);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return genericRepositorio;
    }

}


