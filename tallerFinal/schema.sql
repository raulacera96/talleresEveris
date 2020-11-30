CREATE DATABASE IF NOT EXISTS tiendamysql;

ALTER DATABASE tiendamysql
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE tiendamysql;

CREATE TABLE IF NOT EXISTS clientes (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  estado_cliente VARCHAR(30) NOT NULL,
  INDEX(last_name)
) engine=InnoDB;


CREATE TABLE IF NOT EXISTS direcciones (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  linea_dir VARCHAR(80) NOT NULL,
  provincia VARCHAR(30) NOT NULL,
  cliente_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id),
  INDEX(linea_dir) 
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visitas (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  visit_date DATE NOT NULL,
  importe DOUBLE NOT NULL,
  estado_visita VARCHAR(30) NOT NULL,
  cliente_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id),
  INDEX(visit_date)
) engine=InnoDB;
