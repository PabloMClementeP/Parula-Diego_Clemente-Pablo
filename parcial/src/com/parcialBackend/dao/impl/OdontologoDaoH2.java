//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.parcialBackend.dao.impl;

import com.parcialBackend.dao.H2Connection;
import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Odontologo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    public OdontologoDaoH2() {
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS(NOMBRE,APELLIDO,MATRICULA) VALUES (?, ?, ?)", 1);

            ps.setString(1, odontologo.getNombre());
            ps.setString(2, odontologo.getApellido());
            ps.setInt(3, odontologo.getMatricula());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()) {
                odontologo.setId(rs.getInt(1));
            }

            connection.commit();
            LOGGER.info("Se registro el odontólogo: " + odontologo);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            ex.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Ups ocurrio un problema!");
                } catch (SQLException exept) {
                    LOGGER.error(exept.getMessage());
                    exept.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.error("Ocurrió un problema al intentar cerrar la base de datos. " + e.getMessage());
                e.printStackTrace();
            }

        }

        return odontologo;
    }

    public List<Odontologo> listarOdontologos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                odontologos.add(odontologo);
            }

            LOGGER.info("Listado de los odontólogos registrados: " + odontologos);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ocurrió un problema al intentar cerrar la base de datos. " + ex.getMessage());
                ex.printStackTrace();
            }

        }

        return odontologos;
    }
}
