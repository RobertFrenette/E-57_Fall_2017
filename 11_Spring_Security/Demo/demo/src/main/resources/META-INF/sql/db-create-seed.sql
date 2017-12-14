DROP DATABASE SpringMVCAutosDB;
CREATE DATABASE SpringMVCAutosDB;
USE SpringMVCAutosDB;

CREATE TABLE AUTO (
       ID INT (11) NOT NULL AUTO_INCREMENT
     , MODEL VARCHAR(25) NOT NULL
     , YEAR VARCHAR(4) NOT NULL
     , MSRP VARCHAR(7) NOT NULL
     , PHOTO BLOB
     , VERSION INT NOT NULL DEFAULT 0
     , UNIQUE UQ_AUTO_1 (MODEL, YEAR)
     , PRIMARY KEY (ID)
);

# Populate AUTO Table
insert into auto (model, year, msrp) values ('Spark', '2018', '13,000');
insert into auto (model, year, msrp) values ('Sonic', '2018', '15,295');
insert into auto (model, year, msrp) values ('Cruze', '2018', '16,975');
insert into auto (model, year, msrp) values ('Malibu', '2018', '21,680');
insert into auto (model, year, msrp) values ('Impala', '2018', '27,895');
insert into auto (model, year, msrp) values ('Volt', '2018', '33,220');
insert into auto (model, year, msrp) values ('Bolt EV', '2018', '36,620');
insert into auto (model, year, msrp) values ('Camaro', '2018', '25,905');
insert into auto (model, year, msrp) values ('SS Sedan', '2018', '46,625');
insert into auto (model, year, msrp) values ('Corvette', '2018', '55,495');
insert into auto (model, year, msrp) values ('Trax', '2018', '21,000');
insert into auto (model, year, msrp) values ('Equinox', '2018', '23,580');
insert into auto (model, year, msrp) values ('Traverse', '2018', '29,930');
insert into auto (model, year, msrp) values ('Tahoe', '2018', '47,125');
insert into auto (model, year, msrp) values ('Suburban', '2018', '49,915');
insert into auto (model, year, msrp) values ('Colorado', '2018', '20,200');
insert into auto (model, year, msrp) values ('Silverado', '2018', '28,285');
