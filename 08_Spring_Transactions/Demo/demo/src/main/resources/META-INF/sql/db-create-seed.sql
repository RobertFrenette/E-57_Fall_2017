DROP DATABASE SpringTransactionsAutosDB;
CREATE DATABASE SpringTransactionsAutosDB;
USE SpringTransactionsAutosDB;

CREATE TABLE AUTO (
       ID INT (11) NOT NULL AUTO_INCREMENT
     , MODEL VARCHAR(25) NOT NULL
     , YEAR VARCHAR(4) NOT NULL
     , MSRP VARCHAR(6) NOT NULL
     , VERSION INT NOT NULL DEFAULT 0
     , UNIQUE UQ_AUTO_1 (MODEL, YEAR)
     , PRIMARY KEY (ID)
);


# Populate AUTO Table
insert into auto (model, year, msrp) values ('Camaro', '2018', '25,000');

insert into auto (model, year, msrp) values ('Challenger', '2017', '26,000');
insert into auto (model, year, msrp) values ('Charger', '2018', '27,000');

insert into auto (model, year, msrp) values ('Fusion', '2017', '23,000');
insert into auto (model, year, msrp) values ('Fiesta', '2018', '20,000');
insert into auto (model, year, msrp) values ('Mustang', '2018', '25,000');
