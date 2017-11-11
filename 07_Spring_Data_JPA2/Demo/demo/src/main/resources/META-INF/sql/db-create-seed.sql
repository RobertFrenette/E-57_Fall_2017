DROP DATABASE SpringDataAutosDB;
CREATE DATABASE SpringDataAutosDB;
USE SpringDataAutosDB;

CREATE TABLE MANUFACTURER (
       ID INT (11) NOT NULL AUTO_INCREMENT
     , NAME VARCHAR(100) NOT NULL
     , VERSION INT NOT NULL DEFAULT 0
     , UNIQUE UQ_MANUFACTURER_1 (NAME)
     , PRIMARY KEY (ID)
);

CREATE TABLE AUTO (
       ID INT (11) NOT NULL AUTO_INCREMENT
     , MANUFACTURER_ID INT (11) NOT NULL
     , MODEL VARCHAR(25) NOT NULL
     , YEAR VARCHAR(4) NOT NULL
     , MSRP VARCHAR(6) NOT NULL
     , VERSION INT NOT NULL DEFAULT 0
     , UNIQUE UQ_AUTO_1 (MODEL, YEAR)
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_AUTO_1 FOREIGN KEY (MANUFACTURER_ID)
                            REFERENCES MANUFACTURER (ID)
);

CREATE TABLE DRIVETRAIN (
	ID INT (11) NOT NULL AUTO_INCREMENT
	, TRANSMISSION VARCHAR(10) NOT NULL
	, ENGINE_DISPLACEMENT VARCHAR(10) NOT NULL
    , UNIQUE UQ_DRIVETRAIN_1 (TRANSMISSION, ENGINE_DISPLACEMENT)
	, PRIMARY KEY (ID)
);

CREATE TABLE DRIVETRAIN_AUTO (
	DRIVETRAIN_ID INT (11) NOT NULL
	, AUTO_ID INT (11) NOT NULL
	, CONSTRAINT FK_DRIVETRAIN_AUTO_1 FOREIGN KEY (DRIVETRAIN_ID)
       REFERENCES DRIVETRAIN (ID) ON DELETE CASCADE
	, CONSTRAINT FK_DRIVETRAIN_AUTO_2 FOREIGN KEY (AUTO_ID)
       REFERENCES AUTO (ID)
);

# Populate MANUFACTURER Table
insert into manufacturer (name) values ('Chevrolet');
insert into manufacturer (name) values ('Dodge');
insert into manufacturer (name) values ('Ford');

# Populate AUTO Table
insert into auto (manufacturer_id, model, year, msrp) values (1, 'Camaro', '2018', '25,000');

insert into auto (manufacturer_id, model, year, msrp) values (2, 'Challenger', '2017', '26,000');
insert into auto (manufacturer_id, model, year, msrp) values (2, 'Charger', '2018', '27,000');

insert into auto (manufacturer_id, model, year, msrp) values (3, 'Fusion', '2017', '23,000');
insert into auto (manufacturer_id, model, year, msrp) values (3, 'Fiesta', '2018', '20,000');
insert into auto (manufacturer_id, model, year, msrp) values (3, 'Mustang', '2018', '25,000');

# Populate DRIVETRAIN Table
insert into drivetrain(transmission, engine_displacement) values('Automatic', '2.0L');
insert into drivetrain(transmission, engine_displacement) values('Manual', '2.0L');
insert into drivetrain(transmission, engine_displacement) values('Automatic', '2.5L');
insert into drivetrain(transmission, engine_displacement) values('Manual', '2.5L');
insert into drivetrain(transmission, engine_displacement) values('Automatic', '5.0L');
insert into drivetrain(transmission, engine_displacement) values('Manual', '5.0L');

# Populate DRIVETRAIN_AUTO Table
insert into drivetrain_auto(drivetrain_id, auto_id) values(5, 1);
insert into drivetrain_auto(drivetrain_id, auto_id) values(5, 2);
insert into drivetrain_auto(drivetrain_id, auto_id) values(4, 3);
insert into drivetrain_auto(drivetrain_id, auto_id) values(3, 4);
insert into drivetrain_auto(drivetrain_id, auto_id) values(2, 5);
insert into drivetrain_auto(drivetrain_id, auto_id) values(4, 6);
