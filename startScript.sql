DROP DATABASE customerList;

CREATE DATABASE customerList;

USE customerList;

CREATE TABLE customers(
	customerNum int PRIMARY KEY NOT NULL,
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    pin int NOT NULL, #Not an acceptable way to store pin in real life. For demonstrative purposes only,
    address varchar(40) NOT NULL,
    dob varchar(30) NOT NULL #Revise to use dateTime later.
);

CREATE TABLE accounts(
	accountNum int PRIMARY KEY NOT NULL,
    accountType varchar(30) NOT NULL,
    accountOwner int,
    FOREIGN KEY (accountOwner) REFERENCES customers(customerNum)
);