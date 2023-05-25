//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.parcialBackend.dao.impl;

import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Odontologo;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologosRepository;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologosRepository) {
        this.odontologosRepository = odontologosRepository;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        this.odontologosRepository.add(odontologo);
        LOGGER.info("Odontólogo guardado: " + String.valueOf(odontologo));
        return odontologo;
    }

    public List<Odontologo> listarOdontologos() {
        LOGGER.info("Lista de todos los odontólogos registrados: " + String.valueOf(this.odontologosRepository));
        return this.odontologosRepository;
    }
}
