DROP DATABASE customerList;

CREATE DATABASE customerList;

USE customerList;

CREATE TABLE customers(
	customerNum int PRIMARY KEY NOT NULL,
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    pin int NOT NULL, #Not an acceptable way to store pin in real life. For demonstrative purposes only,
    address varchar(40) NOT NULL,
    dob varchar(30) NOT NULL, #Revise to use dateTime later.
    imagePath varchar(30) NOT NULL
);

CREATE TABLE accounts(
	accountNum int PRIMARY KEY NOT NULL,
    accountType varchar(30) NOT NULL,
    accountOwner int,
    accountBalance decimal(10,2),
    interestRate decimal(8,4),
    FOREIGN KEY (accountOwner) REFERENCES customers(customerNum)
);

#A few example customers

INSERT INTO customers (customerNum, firstName, lastName, pin, address, dob, imagePath) VALUES 
(1, "Christian", "Barbati", 1525, "742 Evergreen Terrace", "06-22-1998", "portrait1.jpg"),
(2, "Jenny", "Baker", 9486, "247 Evergreen Terrace", "12-12-1998", "portrait2.jpg"),
(3, "Michael", "Smith", 3854, "471 Evergreen Terrace", "07-15-1998", "portrait3.jpg");

#A few example accounts

INSERT INTO accounts (accountNum, accountType, accountOwner, accountBalance, interestRate) VALUES 
(1, "Chequing", 1, 0, 0.01),
(2, "Savings", 1, 0, 0.05),
(3, "Savings", 2, 0, 0.05),
(4, "TFSA", 1, 2, 0.03),
(5, "Savings", 3, 0, 0.05),
(6, "Chequing", 2, 0, 0.01),
(7, "Savings", 2, 0, 0.05),
(8, "Chequing", 1, 0, 0.01),
(9, "Savings", 3, 0, 0.05);