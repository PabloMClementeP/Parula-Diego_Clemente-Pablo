package com.parcialBackend.service;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> genericIDao;

    public OdontologoService(IDao<Odontologo> genericIDao){
        this.genericIDao = genericIDao;
    }

    public Odontologo guardarGeneric(Odontologo generic){
        return genericIDao.guardar(generic);
    }


    public List<Odontologo> listarGenerics() {
        return genericIDao.listarTodos();
    }


}
