-- Crear la base de datos
CREATE DATABASE rugby;
USE rugby;

-- Tabla de campeonatos
CREATE TABLE campeonatos (
    id_campeonato INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Nombre del campeonato
    activo BOOLEAN DEFAULT TRUE -- Indica si el torneo está en curso
);

-- Tabla de equipos
CREATE TABLE equipos (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Esencial
    ciudad VARCHAR(100) DEFAULT NULL, -- Opcional
    estadio VARCHAR(100) DEFAULT NULL, -- Opcional
    latitud DECIMAL(9,6) DEFAULT NULL, -- Opcional
    longitud DECIMAL(9,6) DEFAULT NULL, -- Opcional
    id_dt INT DEFAULT NULL, -- Relación con DT
    FOREIGN KEY (id_dt) REFERENCES directores_tecnicos(id_dt)
);

-- Tabla de jugadores
CREATE TABLE jugadores (
    id_jugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Esencial
    apellido VARCHAR(100) NOT NULL, -- Esencial
    posicion VARCHAR(50) DEFAULT NULL, -- Opcional
    id_equipo INT DEFAULT NULL, -- Opcional (Si no tiene equipo al inicio)
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo) ON DELETE CASCADE
);

-- Tabla de directores técnicos
CREATE TABLE directores_tecnicos (
    id_dt INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Esencial
    apellido VARCHAR(100) NOT NULL, -- Esencial
    edad INT DEFAULT NULL, -- Opcional
    nacionalidad VARCHAR(100) DEFAULT NULL -- Opcional
);

-- Tabla de partidos con la columna estado
CREATE TABLE partidos (
    id_partido INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL, -- Fecha del partido
    id_equipo_local INT NOT NULL, -- Equipo que juega de local
    id_equipo_visitante INT NOT NULL, -- Equipo visitante
    puntos_local INT DEFAULT 0, -- Puntos anotados por el equipo local
    puntos_visitante INT DEFAULT 0, -- Puntos anotados por el equipo visitante
    tries_local INT DEFAULT 0, -- Cantidad de tries del equipo local
    tries_visitante INT DEFAULT 0, -- Cantidad de tries del equipo visitante
    ganador INT DEFAULT NULL, -- Equipo que ganó el partido
    id_campeonato INT NOT NULL, -- Relación con el campeonato
    estado ENUM('programado', 'jugado') DEFAULT 'programado', -- Estado del partido
    FOREIGN KEY (id_equipo_local) REFERENCES equipos(id_equipo),
    FOREIGN KEY (id_equipo_visitante) REFERENCES equipos(id_equipo),
    FOREIGN KEY (ganador) REFERENCES equipos(id_equipo),
    FOREIGN KEY (id_campeonato) REFERENCES campeonatos(id_campeonato)
);

-- Tabla de estadísticas de equipos
CREATE TABLE estadisticas (
    id_estadistica INT AUTO_INCREMENT PRIMARY KEY,
    id_equipo INT NOT NULL, -- Esencial
    partidos_jugados INT DEFAULT 0, -- Opcional
    victorias INT DEFAULT 0, -- Opcional
    empates INT DEFAULT 0, -- Opcional
    derrotas INT DEFAULT 0, -- Opcional
    puntos INT DEFAULT 0, -- Opcional
    bonus_ofensivo INT DEFAULT 0, -- Opcional
    bonus_defensivo INT DEFAULT 0, -- Opcional
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo)
);

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- Esencial
    email VARCHAR(100) UNIQUE NOT NULL, -- Esencial
    password VARCHAR(255) NOT NULL, -- Esencial
    tipo ENUM('administrador', 'periodista') DEFAULT 'periodista' -- Opcional (Por defecto 'periodista')
);

-- Tabla intermedia para jugadores en partidos
CREATE TABLE jugadores_partidos (
    id_jugador INT NOT NULL, -- Esencial
    id_partido INT NOT NULL, -- Esencial
    PRIMARY KEY (id_jugador, id_partido),
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador) ON DELETE CASCADE,
    FOREIGN KEY (id_partido) REFERENCES partidos(id_partido) ON DELETE CASCADE
);

-- Tabla de estadísticas individuales de jugadores
CREATE TABLE estadisticas_jugadores (
    id_estadistica INT AUTO_INCREMENT PRIMARY KEY,
    id_jugador INT NOT NULL, -- Esencial
    partidos_jugados INT DEFAULT 0, -- Opcional
    tries INT DEFAULT 0, -- Opcional
    puntos INT DEFAULT 0, -- Opcional
    FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador)
);
