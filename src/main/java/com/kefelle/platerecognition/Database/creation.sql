use crs;

CREATE TABLE admin (
    login varchar(30),
    password varchar(30)
);

CREATE TABLE users (
    id int PRIMARY KEY unique auto_increment,
    fname varchar(30),
    lname varchar(30),
    username varchar(30) unique,
    password varchar(30),
    email varchar(50),
    inscription_date date,
    avatar blob
);
drop table users;
CREATE TABLE usersinrequests (
    fname varchar(30),
    lname varchar(30),
    username varchar(30),
    password varchar(30),
    email varchar(50),
    userconfirm blob
);

CREATE TABLE plate (
    licence_number varchar(15) PRIMARY KEY,
    plate_owner int,
    FOREIGN KEY (plate_owner) REFERENCES users(id)
);
drop table plate;
CREATE TABLE UserEntry (
    Day INT,
    Month INT,
    Year INT,
    Full_date DATE,
    user_id INT,
    licence_number VARCHAR(15),
    status BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (licence_number) REFERENCES plate(licence_number)
);
drop table UserEntry;

