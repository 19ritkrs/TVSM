CREATE DATABASE crudapi;

USE crudapi;

CREATE TABLE tbl_employee
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    gender VARCHAR(255),
    department VARCHAR(255),
    dob DATE
);

CREATE TABLE locations (
  id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  latitude DOUBLE NOT NULL,
  longitude DOUBLE NOT NULL
);

  INSERT INTO locations (name, latitude, longitude)
  VALUES ('New York City', 40.7128, -74.0059);

  INSERT INTO locations (name, latitude, longitude)
  VALUES ('Tokyo', 35.6895, 139.6917);

  INSERT INTO locations (name, latitude, longitude)
  VALUES ('Paris', 48.8566, 2.3522);