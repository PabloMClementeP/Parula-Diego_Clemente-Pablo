package com.parcialBackend.dao.impl;

import com.parcialBackend.dao.H2Connection;
import com.parcialBackend.dao.IDao;
import com.parcialBackend.entity.Generic;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class GenericDaoH2 implements IDao<Generic> {

    private static final Logger LOGGER = Logger.getLogger(GenericDaoH2.class);

    @Override
    public Generic guardar(Generic generic) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, generic.getNombre());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                generic.setId(rs.getInt(1));
            }

            connection.commit();
            LOGGER.info("Se ha registrado el paciente: " + generic);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return generic;
    }

    @Override
    public Generic buscar(int id) {
        Connection connection = null;
        Generic generic = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                generic = crearObjetoGeneric(rs);
            }
            LOGGER.info("Se ha encontrado el generico con id " + id + ": " + generic);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return generic;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Generic> listarTodos() {
        return null;
    }


    // Metodo para guardar en el objeto el contenido del resulSet
    private Generic crearObjetoGeneric(ResultSet resultSet) throws SQLException {
        int idPaciente = resultSet.getInt("id");
        String nombrePaciente = resultSet.getString("nombre");
        return new Generic(idPaciente, nombrePaciente);
    }
}
