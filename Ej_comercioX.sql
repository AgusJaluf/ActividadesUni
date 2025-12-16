CREATE DATABASE ComercioX;
USE ComercioX;

CREATE TABLE PROVINCIAS (
    cod_prov INT PRIMARY KEY,
    nombre_prov VARCHAR(100) NOT NULL
);

CREATE TABLE CIUDADES (
    cod_postal INT PRIMARY KEY,
    cod_prov INT NOT NULL,
    nombre_ciudad VARCHAR(100) NOT NULL,
    FOREIGN KEY (cod_prov) REFERENCES PROVINCIAS(cod_prov)
);

CREATE TABLE CLIENTES (
    cod_cliente INT PRIMARY KEY,
    dni_cliente VARCHAR(20) NOT NULL,
    nombre VARCHAR(100),
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    fecha_nac DATE NOT NULL,
    direccion VARCHAR(255),
    cod_postal INT,
    FOREIGN KEY (cod_postal) REFERENCES CIUDADES(cod_postal)
);

CREATE TABLE TELEFONOS (
    nro_telef VARCHAR(20) PRIMARY KEY,
    cod_ch INT,
    tipo_tel VARCHAR(50) NOT NULL,
    FOREIGN KEY (cod_ch) REFERENCES CLIENTES(cod_cliente)
);
