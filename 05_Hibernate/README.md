# Hibernate

These examples use Hibernate to perform CRUD operations on a MySQL DB containing Automobile Manufacturer Vehicles.

## MySQL CMD Line
Note: This example uses the MySQL installation in MAMP for macOS. The default path for installation is /Applications/MAMP/Library/bin/mysql.

### SQL Create / Seed Script
src/main/resources/META-INF/sql/db-create-seed.sql 

### DB User Credentials
user: e57

password: password

### To Create DB
```
$ /Applications/MAMP/Library/bin/mysql --host=localhost -ue57 -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.6.33 MySQL Community Server (GPL)

Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> source src/main/resources/META-INF/sql/db-create-seed.sql 
Query OK, 4 rows affected (0.23 sec)

Query OK, 1 row affected (0.00 sec)

Database changed
Query OK, 0 rows affected (0.31 sec)

Query OK, 0 rows affected (0.15 sec)

Query OK, 0 rows affected (0.19 sec)

Query OK, 0 rows affected (0.14 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.01 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)
```

### To Use / Query DB
```
$ mysql> use HibernateAutosDB;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------------------+
| Tables_in_hibernateautosdb |
+----------------------------+
| AUTO                       |
| DRIVETRAIN                 |
| DRIVETRAIN_AUTO            |
| MANUFACTURER               |
+----------------------------+
4 rows in set (0.00 sec)

mysql> SELECT * FROM manufacturer;
+----+-----------+---------+
| ID | NAME      | VERSION |
+----+-----------+---------+
|  1 | Chevrolet |       0 |
|  2 | Dodge     |       0 |
|  3 | Ford      |       0 |
+----+-----------+---------+
3 rows in set (0.00 sec)

mysql> SELECT * FROM auto;
+----+-----------------+------------+------+--------+---------+
| ID | MANUFACTURER_ID | MODEL      | YEAR | MSRP   | VERSION |
+----+-----------------+------------+------+--------+---------+
|  1 |               1 | Camaro     | 2018 | 25,000 |       0 |
|  2 |               2 | Challenger | 2017 | 26,000 |       0 |
|  3 |               2 | Charger    | 2018 | 27,000 |       0 |
|  4 |               3 | Fusion     | 2017 | 23,000 |       0 |
|  5 |               3 | Fiesta     | 2018 | 20,000 |       0 |
|  6 |               3 | Mustang    | 2018 | 25,000 |       0 |
+----+-----------------+------------+------+--------+---------+

6 rows in set (0.00 sec)

mysql> SELECT * FROM drivetrain;
+----+--------------+---------------------+
| ID | TRANSMISSION | ENGINE_DISPLACEMENT |
+----+--------------+---------------------+
|  1 | Automatic    | 2.0L                |
|  3 | Automatic    | 2.5L                |
|  5 | Automatic    | 5.0L                |
|  2 | Manual       | 2.0L                |
|  4 | Manual       | 2.5L                |
|  6 | Manual       | 5.0L                |
+----+--------------+---------------------+
6 rows in set (0.00 sec)

mysql> SELECT * FROM drivetrain_auto;
+---------------+---------+
| DRIVETRAIN_ID | AUTO_ID |
+---------------+---------+
|             5 |       1 |
|             5 |       2 |
|             4 |       3 |
|             3 |       4 |
|             2 |       5 |
|             4 |       6 |
+---------------+---------+
6 rows in set (0.00 sec)

mysql> exit;
Bye
```

## App Execution
See README.md in Demo dir.
