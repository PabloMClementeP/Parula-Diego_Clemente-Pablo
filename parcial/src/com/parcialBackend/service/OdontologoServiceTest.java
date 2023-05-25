package com.parcialBackend.service;

import com.parcialBackend.dao.impl.OdontologoDaoH2;
import com.parcialBackend.entity.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

class OdontologoServiceTest {

    private static Connection connection = null;

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void deberiaAgregarseUnOdontologo() {
        Odontologo odontologoTest = new Odontologo("Pedro", "Sanchez", 234);
        Odontologo odontologoResultado = odontologoService.guardar(odontologoTest);
        Assertions.assertEquals("Pedro", odontologoResultado.getNombre());
    }

    @Test
    public void deberiaListarTodosLosOdontologos() {
        List<Odontologo> odontologoListTest = odontologoService.listar();
        Assertions.assertFalse(odontologoListTest.isEmpty());
    }

}