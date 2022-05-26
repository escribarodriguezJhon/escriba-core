DROP DATABASE IF EXISTS bdjescriba;
CREATE DATABASE IF NOT EXISTS bdjescriba;

use bdjescriba;

CREATE TABLE direcciones(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  calle VARCHAR(50) NOT NULL,
  ciudad VARCHAR(50) NOT NULL,
  estado VARCHAR(50) NOT NULL,
  codigo_postal VARCHAR(10) NOT NULL,
  pais VARCHAR(50) NOT NULL
);
CREATE TABLE estudiantes (
  codigo CHAR(6) NOT NULL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  telefono VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  serie VARCHAR(50) NOT NULL,
  direccion_id INT NOT NULL,
  FOREIGN KEY (direccion_id) REFERENCES direcciones(id)
);
CREATE TABLE profesor(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  telefono VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  salario FLOAT NOT NULL,
  direccion_id INT NOT NULL,
  FOREIGN KEY (direccion_id) REFERENCES direcciones(id)
);