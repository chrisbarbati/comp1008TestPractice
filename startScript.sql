CREATE DATABASE customerList;

USE customerList;

CREATE TABLE customers(
	customerNum int PRIMARY KEY NOT NULL,
    customerName varchar(30) NOT NULL
);

INSERT INTO customers (customerNum, customerName) VALUES (1, "John"), (2, "Sally");