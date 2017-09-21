DROP   DATABASE JdbcAutosDB;
CREATE DATABASE JdbcAutosDB;
USE JdbcAutosDB;

CREATE TABLE MANUFACTURER (
       ID INT (11) NOT NULL AUTO_INCREMENT
     , NAME VARCHAR(100) NOT NULL
     , UNIQUE UQ_MANUFACTURER_1 (NAME)
     , PRIMARY KEY (ID)
);

CREATE TABLE AUTO (
       ID INT (11) NOT NULL AUTO_INCREMENT
     , MANUFACTURER_ID INT (11) NOT NULL
     , MODEL VARCHAR(25) NOT NULL
     , YEAR VARCHAR(4) NOT NULL
     , MSRP VARCHAR(6) NOT NULL
     , UNIQUE UQ_AUTO_1 (MODEL, YEAR)
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_AUTO_1 FOREIGN KEY (MANUFACTURER_ID)
                            REFERENCES MANUFACTURER (ID)
);

insert into manufacturer (name) values ('Chevrolet');
insert into manufacturer (name) values ('Dodge');
insert into manufacturer (name) values ('Ford');

insert into auto (manufacturer_id, model, year, msrp) values (1, 'Camaro', '2018', '25,000');

insert into auto (manufacturer_id, model, year, msrp) values (2, 'Challenger', '2017', '26,000');
insert into auto (manufacturer_id, model, year, msrp) values (2, 'Charger', '2018', '27,000');

insert into auto (manufacturer_id, model, year, msrp) values (3, 'Fusion', '2017', '23,000');
insert into auto (manufacturer_id, model, year, msrp) values (3, 'Fiesta', '2018', '20,000');
insert into auto (manufacturer_id, model, year, msrp) values (3, 'Mustang', '2018', '25,000');
