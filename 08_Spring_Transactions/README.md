# Spring Transactions
This Spring Transaction Repo code is based on the examples provided by Vitaly in Week 8 and Pro Spring 4: com.apress.prospring4.ch9.

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
Query OK, 1 row affected (0.04 sec)

Query OK, 1 row affected (0.00 sec)

Database changed
Query OK, 0 rows affected (0.09 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)
```

### To Use / Query DB
```
$ mysql> use SpringTransactionsAutosDB;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+-------------------------------------+
| Tables_in_springtransactionsautosdb |
+-------------------------------------+
| AUTO                                |
+-------------------------------------+
1 row in set (0.00 sec)


mysql> select * from auto;
+----+------------+------+--------+---------+
| ID | MODEL      | YEAR | MSRP   | VERSION |
+----+------------+------+--------+---------+
|  1 | Camaro     | 2018 | 25,000 |       0 |
|  2 | Challenger | 2017 | 26,000 |       0 |
|  3 | Charger    | 2018 | 27,000 |       0 |
|  4 | Fusion     | 2017 | 23,000 |       0 |
|  5 | Fiesta     | 2018 | 20,000 |       0 |
|  6 | Mustang    | 2018 | 25,000 |       0 |
+----+------------+------+--------+---------+
6 rows in set (0.00 sec)

mysql> exit;
Bye
```

## App Execution
See README.md in Demo dir.
