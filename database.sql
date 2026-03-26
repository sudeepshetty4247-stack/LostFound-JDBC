CREATE DATABASE lostfound_db;

USE lostfound_db;

CREATE TABLE items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100),
    description VARCHAR(200),
    location_found VARCHAR(100),
    status VARCHAR(50)
);
