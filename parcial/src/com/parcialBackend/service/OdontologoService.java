package com.parcialBackend.service;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> IDao;

    public OdontologoService(IDao<Odontologo> IDao){
        this.IDao = IDao;
    }

    public Odontologo guardar(Odontologo odontologo){
        return IDao.registrarOdontologo(odontologo);
    }


    public List<Odontologo> listar() {
        return IDao.listarOdontologos();
    }


}
