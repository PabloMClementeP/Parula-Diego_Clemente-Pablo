DROP TABLE IF EXISTS ODONTOLOGOS;

CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL);



-- Creación de Odontologos inicial

INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES (123213, 'Juan', 'Lopez'), (345786345, 'Mario', 'Benedetti'), (34658, 'Alicia', 'Caronte');