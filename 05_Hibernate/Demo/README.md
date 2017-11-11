# Hibernate

These examples use Hibernate to perform CRUD operations on a MySQL DB containing Automobile Manufacturer Vehicles.

Note: Some functionality / implementation in these examples has been intentionally excluded, as they are part of the solution to the Term Projects.

## DB Creation
See README.md in root dir.


## demo App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerHibernateApp

### To Execute
```
$ cd demo
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerHibernateApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerHibernateApp"
```

### Console Output
```
[[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ demo ---
09:21:43,249  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
09:21:43,585  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@5d1740fd: startup date [Sun Oct 08 09:21:43 EDT 2017]; root of context hierarchy
09:21:43,942  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
09:21:43,951  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
09:21:43,953  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
09:21:43,955  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
09:21:44,445  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
09:21:44,614  INFO ion.internal.TransactionFactoryInitiator:  68 - HHH000399: Using default transaction strategy (direct JDBC transactions)
09:21:44,619  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
09:21:44,844  INFO m.hibernate4.HibernateTransactionManager: 339 - Using DataSource [org.apache.commons.dbcp.BasicDataSource@5939d0bd] of Hibernate SessionFactory for HibernateTransactionManager


Hibernate: select manufactur0_.ID as ID1_2_, manufactur0_.NAME as NAME2_2_, manufactur0_.VERSION as VERSION3_2_ from MANUFACTURER manufactur0_
09:21:45,138  INFO 57.demo.app.AutoManufacturerHibernateApp:  54 - Start listAllAutos()
09:21:45,138  INFO 57.demo.app.AutoManufacturerHibernateApp:  56 - Manufacturer - Id: 1, Name: Chevrolet
09:21:45,138  INFO 57.demo.app.AutoManufacturerHibernateApp:  56 - Manufacturer - Id: 2, Name: Dodge
09:21:45,138  INFO 57.demo.app.AutoManufacturerHibernateApp:  56 - Manufacturer - Id: 3, Name: Ford
09:21:45,139  INFO 57.demo.app.AutoManufacturerHibernateApp:  58 - End listAllAutos()


Hibernate: select auto0_.ID as ID1_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
09:21:45,168  INFO 57.demo.app.AutoManufacturerHibernateApp:  68 - Start listAllAutos()
09:21:45,170  INFO 57.demo.app.AutoManufacturerHibernateApp:  70 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
09:21:45,170  INFO 57.demo.app.AutoManufacturerHibernateApp:  70 - Auto - Id: 2, Model: Challenger, Year: 2017, MSRP: $26,000
09:21:45,170  INFO 57.demo.app.AutoManufacturerHibernateApp:  70 - Auto - Id: 3, Model: Charger, Year: 2018, MSRP: $27,000
09:21:45,170  INFO 57.demo.app.AutoManufacturerHibernateApp:  70 - Auto - Id: 4, Model: Fusion, Year: 2017, MSRP: $23,000
09:21:45,170  INFO 57.demo.app.AutoManufacturerHibernateApp:  70 - Auto - Id: 5, Model: Fiesta, Year: 2018, MSRP: $20,000
09:21:45,170  INFO 57.demo.app.AutoManufacturerHibernateApp:  70 - Auto - Id: 6, Model: Mustang, Year: 2018, MSRP: $25,000
09:21:45,171  INFO 57.demo.app.AutoManufacturerHibernateApp:  72 - End listAllAutos()


Hibernate: select drivetrain0_.ID as ID1_1_, drivetrain0_.ENGINE_DISPLACEMENT as ENGINE2_1_, drivetrain0_.TRANSMISSION as TRANSMIS3_1_ from DRIVETRAIN drivetrain0_
09:21:45,178  INFO 57.demo.app.AutoManufacturerHibernateApp:  83 - Start listAllDrivetrains()
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - Drivetrain - Id: 1, Transmission: Automatic, EngineDisplacement: 2.0L
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - Drivetrain - Id: 3, Transmission: Automatic, EngineDisplacement: 2.5L
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - Drivetrain - Id: 2, Transmission: Manual, EngineDisplacement: 2.0L
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - Drivetrain - Id: 4, Transmission: Manual, EngineDisplacement: 2.5L
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - Drivetrain - Id: 6, Transmission: Manual, EngineDisplacement: 5.0L
09:21:45,179  INFO 57.demo.app.AutoManufacturerHibernateApp:  87 - End listAllDrivetrains()
09:21:45,180  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@5d1740fd: startup date [Sun Oct 08 09:21:43 EDT 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.042 s
[INFO] Finished at: 2017-10-08T09:21:45-04:00
[INFO] Final Memory: 17M/170M
[INFO] ------------------------------------------------------------------------
```

## demo_crud App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerHibernateApp

### To Execute
```
$ cd demo_crud
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerHibernateApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerHibernateApp"
```

### Console Output
```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ demo ---
10:56:48,788  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
10:56:49,115  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@5d1740fd: startup date [Tue Oct 10 10:56:49 EDT 2017]; root of context hierarchy
10:56:49,437  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
10:56:49,442  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
10:56:49,444  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
10:56:49,445  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
10:56:49,938  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
10:56:50,094  INFO ion.internal.TransactionFactoryInitiator:  68 - HHH000399: Using default transaction strategy (direct JDBC transactions)
10:56:50,099  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
10:56:50,447  INFO m.hibernate4.HibernateTransactionManager: 339 - Using DataSource [org.apache.commons.dbcp.BasicDataSource@7f604df7] of Hibernate SessionFactory for HibernateTransactionManager
Hibernate: select distinct auto0_.ID as ID1_0_0_, manufactur1_.ID as ID1_3_1_, drivetrain3_.ID as ID1_1_2_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_, manufactur1_.NAME as NAME2_3_1_, manufactur1_.VERSION as VERSION3_3_1_, drivetrain3_.ENGINE_DISPLACEMENT as ENGINE2_1_2_, drivetrain3_.TRANSMISSION as TRANSMIS3_1_2_, drivetrain2_.AUTO_ID as AUTO2_0_0__, drivetrain2_.DRIVETRAIN_ID as DRIVETRA1_2_0__ from AUTO auto0_ left outer join MANUFACTURER manufactur1_ on auto0_.MANUFACTURER_ID=manufactur1_.ID left outer join DRIVETRAIN_AUTO drivetrain2_ on auto0_.ID=drivetrain2_.AUTO_ID left outer join DRIVETRAIN drivetrain3_ on drivetrain2_.DRIVETRAIN_ID=drivetrain3_.ID
10:56:50,631  INFO 57.demo.app.AutoManufacturerHibernateApp: 136 - Start listAllAutosWithDrivetrainsAndManufacturers()
10:56:50,631  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
10:56:50,631  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 1, Name: Chevrolet
10:56:50,632  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
10:56:50,632  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,632  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 2, Manufacturer: Dodge, Model: Challenger, Year: 2017, MSRP: $26,000.
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 2, Name: Dodge
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 3, Manufacturer: Dodge, Model: Charger, Year: 2018, MSRP: $27,000.
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 2, Name: Dodge
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 4, Transmission: Manual, EngineDisplacement: 2.5L
10:56:50,633  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 4, Manufacturer: Ford, Model: Fusion, Year: 2017, MSRP: $23,000.
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 3, Name: Ford
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 3, Transmission: Automatic, EngineDisplacement: 2.5L
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 5, Manufacturer: Ford, Model: Fiesta, Year: 2018, MSRP: $20,000.
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 3, Name: Ford
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 2, Transmission: Manual, EngineDisplacement: 2.0L
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 6, Manufacturer: Ford, Model: Mustang, Year: 2018, MSRP: $25,000.
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 3, Name: Ford
10:56:50,634  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 4, Transmission: Manual, EngineDisplacement: 2.5L
10:56:50,635  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,635  INFO 57.demo.app.AutoManufacturerHibernateApp: 150 - End listAllAutosWithDrivetrainsAndManufacturers()


Hibernate: select distinct auto0_.ID as ID1_0_0_, manufactur1_.ID as ID1_3_1_, drivetrain3_.ID as ID1_1_2_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_, manufactur1_.NAME as NAME2_3_1_, manufactur1_.VERSION as VERSION3_3_1_, drivetrain3_.ENGINE_DISPLACEMENT as ENGINE2_1_2_, drivetrain3_.TRANSMISSION as TRANSMIS3_1_2_, drivetrain2_.AUTO_ID as AUTO2_0_0__, drivetrain2_.DRIVETRAIN_ID as DRIVETRA1_2_0__ from AUTO auto0_ left outer join MANUFACTURER manufactur1_ on auto0_.MANUFACTURER_ID=manufactur1_.ID left outer join DRIVETRAIN_AUTO drivetrain2_ on auto0_.ID=drivetrain2_.AUTO_ID left outer join DRIVETRAIN drivetrain3_ on drivetrain2_.DRIVETRAIN_ID=drivetrain3_.ID where auto0_.ID=?
10:56:50,643  INFO 57.demo.app.AutoManufacturerHibernateApp: 100 - Start listAuto() for Auto ID: 1
10:56:50,644  INFO 57.demo.app.AutoManufacturerHibernateApp: 102 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
10:56:50,644  INFO 57.demo.app.AutoManufacturerHibernateApp: 104 - Manufacturer - Id: 1, Name: Chevrolet
10:56:50,644  INFO 57.demo.app.AutoManufacturerHibernateApp: 108 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
10:56:50,644  INFO 57.demo.app.AutoManufacturerHibernateApp: 112 - End listAuto() for Auto ID: 1


10:56:50,644  INFO 57.demo.app.AutoManufacturerHibernateApp:  41 - List all Autos BEFORE Insert...
Hibernate: select auto0_.ID as ID1_0_, auto0_.MANUFACTURER_ID as MANUFACT6_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 122 - Start listAllAutos()
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 2, Manufacturer: Dodge, Model: Challenger, Year: 2017, MSRP: $26,000.
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 3, Manufacturer: Dodge, Model: Charger, Year: 2018, MSRP: $27,000.
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 4, Manufacturer: Ford, Model: Fusion, Year: 2017, MSRP: $23,000.
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 5, Manufacturer: Ford, Model: Fiesta, Year: 2018, MSRP: $20,000.
10:56:50,661  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 6, Manufacturer: Ford, Model: Mustang, Year: 2018, MSRP: $25,000.
10:56:50,662  INFO 57.demo.app.AutoManufacturerHibernateApp: 126 - End listAllAutos()


Hibernate: insert into MANUFACTURER (NAME, VERSION) values (?, ?)
Hibernate: insert into AUTO (MANUFACTURER_ID, MODEL, MSRP, VERSION, YEAR) values (?, ?, ?, ?, ?)
Hibernate: insert into DRIVETRAIN (ENGINE_DISPLACEMENT, TRANSMISSION) values (?, ?)
Hibernate: insert into DRIVETRAIN (ENGINE_DISPLACEMENT, TRANSMISSION) values (?, ?)
Hibernate: insert into DRIVETRAIN_AUTO (AUTO_ID, DRIVETRAIN_ID) values (?, ?)
Hibernate: insert into DRIVETRAIN_AUTO (AUTO_ID, DRIVETRAIN_ID) values (?, ?)
Hibernate: select distinct auto0_.ID as ID1_0_0_, manufactur1_.ID as ID1_3_1_, drivetrain3_.ID as ID1_1_2_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_, manufactur1_.NAME as NAME2_3_1_, manufactur1_.VERSION as VERSION3_3_1_, drivetrain3_.ENGINE_DISPLACEMENT as ENGINE2_1_2_, drivetrain3_.TRANSMISSION as TRANSMIS3_1_2_, drivetrain2_.AUTO_ID as AUTO2_0_0__, drivetrain2_.DRIVETRAIN_ID as DRIVETRA1_2_0__ from AUTO auto0_ left outer join MANUFACTURER manufactur1_ on auto0_.MANUFACTURER_ID=manufactur1_.ID left outer join DRIVETRAIN_AUTO drivetrain2_ on auto0_.ID=drivetrain2_.AUTO_ID left outer join DRIVETRAIN drivetrain3_ on drivetrain2_.DRIVETRAIN_ID=drivetrain3_.ID
10:56:50,741  INFO 57.demo.app.AutoManufacturerHibernateApp:  79 - List all Autos AFTER Insert...
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 136 - Start listAllAutosWithDrivetrainsAndManufacturers()
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 1, Name: Chevrolet
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 2, Manufacturer: Dodge, Model: Challenger, Year: 2017, MSRP: $26,000.
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 2, Name: Dodge
10:56:50,742  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 3, Manufacturer: Dodge, Model: Charger, Year: 2018, MSRP: $27,000.
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 2, Name: Dodge
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 4, Transmission: Manual, EngineDisplacement: 2.5L
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 4, Manufacturer: Ford, Model: Fusion, Year: 2017, MSRP: $23,000.
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 3, Name: Ford
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 3, Transmission: Automatic, EngineDisplacement: 2.5L
10:56:50,743  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 5, Manufacturer: Ford, Model: Fiesta, Year: 2018, MSRP: $20,000.
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 3, Name: Ford
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 2, Transmission: Manual, EngineDisplacement: 2.0L
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 6, Manufacturer: Ford, Model: Mustang, Year: 2018, MSRP: $25,000.
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 3, Name: Ford
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 4, Transmission: Manual, EngineDisplacement: 2.5L
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 138 - Auto - Id: 7, Manufacturer: BMW, Model: 3 Series, Year: 2017, MSRP: $33,450.
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 141 - Manufacturer - Id: 4, Name: BMW
10:56:50,744  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 7, Transmission: Automatic, EngineDisplacement: 3.0
10:56:50,745  INFO 57.demo.app.AutoManufacturerHibernateApp: 145 - Drivetrain - Id: 8, Transmission: Manual, EngineDisplacement: 3.0
10:56:50,745  INFO 57.demo.app.AutoManufacturerHibernateApp: 148 - 
10:56:50,745  INFO 57.demo.app.AutoManufacturerHibernateApp: 150 - End listAllAutosWithDrivetrainsAndManufacturers()


Hibernate: delete from DRIVETRAIN_AUTO where AUTO_ID=?
Hibernate: delete from DRIVETRAIN where ID=?
Hibernate: delete from DRIVETRAIN where ID=?
Hibernate: delete from AUTO where ID=? and VERSION=?
Hibernate: select auto0_.ID as ID1_0_, auto0_.MANUFACTURER_ID as MANUFACT6_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
10:56:50,786  INFO 57.demo.app.AutoManufacturerHibernateApp:  85 - List all Autos AFTER Delete...
10:56:50,786  INFO 57.demo.app.AutoManufacturerHibernateApp: 122 - Start listAllAutos()
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 2, Manufacturer: Dodge, Model: Challenger, Year: 2017, MSRP: $26,000.
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 3, Manufacturer: Dodge, Model: Charger, Year: 2018, MSRP: $27,000.
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 4, Manufacturer: Ford, Model: Fusion, Year: 2017, MSRP: $23,000.
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 5, Manufacturer: Ford, Model: Fiesta, Year: 2018, MSRP: $20,000.
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 124 - Auto - Id: 6, Manufacturer: Ford, Model: Mustang, Year: 2018, MSRP: $25,000.
10:56:50,787  INFO 57.demo.app.AutoManufacturerHibernateApp: 126 - End listAllAutos()


10:56:50,787  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@5d1740fd: startup date [Tue Oct 10 10:56:49 EDT 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.029 s
[INFO] Finished at: 2017-10-10T10:56:50-04:00
[INFO] Final Memory: 18M/169M
[INFO] ------------------------------------------------------------------------
```
