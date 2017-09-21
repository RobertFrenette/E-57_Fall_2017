# Spring JDBC

These examples uses Spring JDBC to perform CRUD operations on a MySQL DB containing Automboile Manufacturer Vehicles.

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
Your MySQL connection id is 17
Server version: 5.6.33 MySQL Community Server (GPL)

Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> source src/main/resources/META-INF/sql/db-create-seed.sql 
Query OK, 1 row affected (0.00 sec)

Database changed
Query OK, 0 rows affected (0.32 sec)

Query OK, 0 rows affected (0.22 sec)

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
$ mysql> use JdbcAutosDB;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+-----------------------+
| Tables_in_jdbcautosdb |
+-----------------------+
| AUTO                  |
| MANUFACTURER          |
+-----------------------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM manufacturer;
+----+-----------+
| ID | NAME      |
+----+-----------+
|  1 | Chevrolet |
|  2 | Dodge     |
|  3 | Ford      |
+----+-----------+
3 rows in set (0.00 sec)

mysql> SELECT * FROM auto;
+----+-----------------+------------+------+--------+
| ID | MANUFACTURER_ID | MODEL      | YEAR | MSRP   |
+----+-----------------+------------+------+--------+
|  1 |               1 | Camaro     | 2018 | 25,000 |
|  2 |               2 | Challenger | 2017 | 26,000 |
|  3 |               2 | Charger    | 2018 | 27,000 |
|  4 |               3 | Fusion     | 2017 | 23,000 |
|  5 |               3 | Fiesta     | 2018 | 20,000 |
|  6 |               3 | Mustang    | 2018 | 25,000 |
+----+-----------------+------------+------+--------+
6 rows in set (0.00 sec)

mysql> exit;
Bye
```

## App Execution
See README.md in Demo dir.
