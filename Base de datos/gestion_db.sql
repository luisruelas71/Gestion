CREATE DATABASE IF NOT EXISTS `gestion_db` 
  DEFAULT CHARACTER SET utf8mb4 
  COLLATE utf8mb4_unicode_ci;

USE `gestion_db`;

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `rol` VARCHAR(20) NOT NULL DEFAULT 'ADMIN',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `profesores` (
  `id_profesor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido_paterno` VARCHAR(50) NOT NULL,
  `apellido_materno` VARCHAR(50) NOT NULL,
  `rfc` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`id_profesor`),
  UNIQUE KEY `rfc` (`rfc`),
  CONSTRAINT `chk_rfc_formato` CHECK (REGEXP_LIKE(`rfc`, '^[A-Z&Ñ]{3,4}[0-9]{6}[A-Z0-9]{3}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `unidades_aprendizaje` (
  `id_unidad_aprendizaje` INT NOT NULL AUTO_INCREMENT,
  `nombre_unidad` VARCHAR(50) NOT NULL,
  `horas_clase` INT NOT NULL DEFAULT 0,
  `horas_taller` INT NOT NULL DEFAULT 0,
  `horas_laboratorio` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_unidad_aprendizaje`),
  CONSTRAINT `chk_horas_clase` CHECK (`horas_clase` BETWEEN 0 AND 4),
  CONSTRAINT `chk_horas_taller` CHECK (`horas_taller` BETWEEN 0 AND 4),
  CONSTRAINT `chk_horas_laboratorio` CHECK (`horas_laboratorio` BETWEEN 0 AND 4)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `asignaciones` (
  `id_asignacion` INT NOT NULL AUTO_INCREMENT,
  `id_profesor` INT NOT NULL,
  `id_unidad_aprendizaje` INT NOT NULL,
  `dia_semana` VARCHAR(15) NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  PRIMARY KEY (`id_asignacion`),
  KEY `fk_profesor_idx` (`id_profesor`),
  KEY `fk_unidad_idx` (`id_unidad_aprendizaje`),
  CONSTRAINT `asignaciones_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`) ON DELETE CASCADE,
  CONSTRAINT `asignaciones_ibfk_2` FOREIGN KEY (`id_unidad_aprendizaje`) REFERENCES `unidades_aprendizaje` (`id_unidad_aprendizaje`) ON DELETE CASCADE,
  CONSTRAINT `chk_horario_valido` CHECK (`hora_fin` > `hora_inicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;