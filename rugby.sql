-- Crear la base de datos
CREATE DATABASE rugby_top10;
USE rugby_top10;


CREATE TABLE equipos (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100),
    estadio VARCHAR(100),
    latitud DECIMAL(9,6), 
    longitud DECIMAL(9,6) 
);


CREATE TABLE jugadores (
    id_jugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    posicion VARCHAR(50),
    id_equipo INT,
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo) ON DELETE CASCADE
);


CREATE TABLE partidos (
    id_partido INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    id_equipo_local INT,
    id_equipo_visitante INT,
    puntos_local INT DEFAULT 0,
    puntos_visitante INT DEFAULT 0,
    tries_local INT DEFAULT 0,
    tries_visitante INT DEFAULT 0,
    ganador INT, 
    FOREIGN KEY (id_equipo_local) REFERENCES equipos(id_equipo),
    FOREIGN KEY (id_equipo_visitante) REFERENCES equipos(id_equipo),
    FOREIGN KEY (ganador) REFERENCES equipos(id_equipo)
);


CREATE TABLE estadisticas (
    id_estadistica INT AUTO_INCREMENT PRIMARY KEY,
    id_equipo INT,
    partidos_jugados INT DEFAULT 0,
    victorias INT DEFAULT 0,
    empates INT DEFAULT 0,
    derrotas INT DEFAULT 0,
    puntos INT DEFAULT 0,
    bonus_ofensivo INT DEFAULT 0,
    bonus_defensivo INT DEFAULT 0,
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo)
);

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    tipo ENUM('administrador', 'periodista') NOT NULL
);
