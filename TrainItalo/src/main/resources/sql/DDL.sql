DROP SCHEMA IF EXISTS trainItalo;
CREATE SCHEMA trainItalo;
USE trainItalo;

DROP TABLE IF EXISTS train_factory;
CREATE TABLE train_factory (
  factory_name VARCHAR(30) PRIMARY KEY,
  passenger_seats INT NOT NULL,
  disabled_passenger_seats INT NOT NULL,
  towable_w DOUBLE NOT NULL,
  head_w DOUBLE NOT NULL,
  passenger_w DOUBLE NOT NULL,
  cargo_w DOUBLE NOT NULL,
  restaurant_w DOUBLE NOT NULL
);

DROP TABLE IF EXISTS country;
CREATE TABLE country (
  country_name VARCHAR(50) PRIMARY KEY,
  alpha2_code VARCHAR(2) NOT NULL
);

DROP TABLE IF EXISTS alias;
CREATE TABLE alias (
  country_alias VARCHAR(50) PRIMARY KEY,
  country_name VARCHAR(50) NOT NULL,
  approved BOOLEAN DEFAULT FALSE NOT NULL,
  algorithm VARCHAR(20) NOT NULL,
  threshold_value DOUBLE(3,2),
  is_found BOOLEAN DEFAULT FALSE NOT NULL,
  FOREIGN KEY (country_name) REFERENCES country(country_name)
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);
	
DROP TABLE IF EXISTS train;
CREATE TABLE train (
  id_train INT PRIMARY KEY AUTO_INCREMENT,
  mat_train VARCHAR(20) NOT NULL,
  factory VARCHAR(30) NOT NULL,
  departure VARCHAR(50) NOT NULL,
  arrival VARCHAR(50) NOT NULL,
  departure_hour DATETIME NOT NULL,
  arrival_hour DATETIME NOT NULL,
  FOREIGN KEY (factory) REFERENCES train_factory(factory_name) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE,
  FOREIGN KEY (departure) REFERENCES country(country_name) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE,
  	FOREIGN KEY (arrival) REFERENCES country(country_name) 
  		ON UPDATE CASCADE
  		ON DELETE CASCADE
);

DROP TABLE IF EXISTS userr;
CREATE TABLE userr (
  user_mail VARCHAR(50) NOT NULL PRIMARY KEY,
  user_password VARCHAR(20) NOT NULL,
  user_name VARCHAR(30) NOT NULL,
  user_surname VARCHAR(30) NOT NULL,
  user_birthdate DATE DEFAULT NULL,
  is_admin BOOLEAN DEFAULT FALSE NOT NULL,
  train_game_score INT DEFAULT 0 NOT NULL
);