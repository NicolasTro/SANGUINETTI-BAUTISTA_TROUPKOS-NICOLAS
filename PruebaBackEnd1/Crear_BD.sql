DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NRO_MATRICULA INTEGER UNIQUE NOT NULL,
    NOMBRE VARCHAR(50) NOT NULL,
    APELLIDO VARCHAR(50) NOT NULL
);