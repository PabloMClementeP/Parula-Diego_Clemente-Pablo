//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.parcialBackend.dao.impl;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologosRepository;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologosRepository) {
        this.odontologosRepository = odontologosRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        this.odontologosRepository.add(odontologo);
        LOGGER.info("Odontólogo guardado: " + odontologo);
        return odontologo;
    }

    public List<Odontologo> listarOdontologos() {
        LOGGER.info("Lista de todos los odontólogos registrados: " + (this.odontologosRepository));
        return this.odontologosRepository;
    }
}
