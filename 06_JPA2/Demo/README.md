# JPA 2

These examples use JPA 2 to perform CRUD operations on a MySQL DB containing Automobile Manufacturer Vehicles.

Note: Some functionality / implementation in these examples has been intentionally excluded, as they are part of the solution to the Term Projects.

## DB Creation
See README.md in root dir.


## demo App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerJPAApp

### To Execute
```
$ cd demo
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp"
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
09:45:52,342  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
09:45:52,633  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@66001c1b: startup date [Fri Oct 20 09:45:52 EDT 2017]; root of context hierarchy
09:45:52,865  INFO a.LocalContainerEntityManagerFactoryBean: 332 - Building JPA container EntityManagerFactory for persistence unit 'default'
09:45:53,009  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
09:45:53,015  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
09:45:53,017  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
09:45:53,019  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
09:45:53,039  INFO      org.hibernate.ejb.Ejb3Configuration: 529 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
09:45:53,170  INFO ons.internal.ConnectionProviderInitiator: 188 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
09:45:53,579  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
09:45:53,589  INFO e.engine.jdbc.internal.LobCreatorBuilder:  94 - HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
09:45:53,738  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
09:45:53,743  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
Hibernate: select manufactur0_.ID as ID1_2_, manufactur0_.NAME as NAME2_2_, manufactur0_.VERSION as VERSION3_2_ from MANUFACTURER manufactur0_
09:45:54,254  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  55 - 

Start listAllManufacturers()
09:45:54,255  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  57 - Manufacturer - Id: 1, Name: Chevrolet
09:45:54,255  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  57 - Manufacturer - Id: 2, Name: Dodge
09:45:54,256  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  57 - Manufacturer - Id: 3, Name: Ford
09:45:54,256  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  59 - End listAllManufacturers()

Hibernate: select ID, TRANSMISSION, ENGINE_DISPLACEMENT from DRIVETRAIN
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  70 - Start listAllDrivetrains()
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  72 - Drivetrain - Id: 1, Transmission: Automatic, EngineDisplacement: 2.0L
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  72 - Drivetrain - Id: 3, Transmission: Automatic, EngineDisplacement: 2.5L
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  72 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  72 - Drivetrain - Id: 2, Transmission: Manual, EngineDisplacement: 2.0L
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  72 - Drivetrain - Id: 4, Transmission: Manual, EngineDisplacement: 2.5L
09:45:54,288  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  72 - Drivetrain - Id: 6, Transmission: Manual, EngineDisplacement: 5.0L
09:45:54,289  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  74 - End listAllDrivetrains()

Hibernate: select ID, MANUFACTURER_ID, MODEL, YEAR, MSRP, VERSION from AUTO
09:45:54,293  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  84 - Start listAllAutos()
09:45:54,293  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  86 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
09:45:54,293  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  86 - Auto - Id: 2, Model: Challenger, Year: 2017, MSRP: $26,000
09:45:54,294  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  86 - Auto - Id: 3, Model: Charger, Year: 2018, MSRP: $27,000
09:45:54,294  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  86 - Auto - Id: 4, Model: Fusion, Year: 2017, MSRP: $23,000
09:45:54,294  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  86 - Auto - Id: 5, Model: Fiesta, Year: 2018, MSRP: $20,000
09:45:54,294  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  86 - Auto - Id: 6, Model: Mustang, Year: 2018, MSRP: $25,000
09:45:54,294  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  88 - End listAllAutos()

09:45:54,294  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@66001c1b: startup date [Fri Oct 20 09:45:52 EDT 2017]; root of context hierarchy
09:45:54,295  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.979 s
[INFO] Finished at: 2017-10-20T09:45:54-04:00
[INFO] Final Memory: 18M/174M
[INFO] ------------------------------------------------------------------------
```

## demo_crud App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerJPAApp

### To Execute
```
$ cd demo_crud
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp"
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
09:58:51,437  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
09:58:51,857  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@2d07ed1e: startup date [Fri Oct 20 09:58:51 EDT 2017]; root of context hierarchy
09:58:52,141  INFO a.LocalContainerEntityManagerFactoryBean: 332 - Building JPA container EntityManagerFactory for persistence unit 'default'
09:58:52,278  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
09:58:52,284  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
09:58:52,286  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
09:58:52,287  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
09:58:52,311  INFO      org.hibernate.ejb.Ejb3Configuration: 529 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
09:58:52,411  INFO ons.internal.ConnectionProviderInitiator: 188 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
09:58:52,842  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
09:58:52,852  INFO e.engine.jdbc.internal.LobCreatorBuilder:  94 - HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
09:58:53,027  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
09:58:53,030  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
Hibernate: select distinct auto0_.ID as ID1_0_0_, manufactur1_.ID as ID1_3_1_, drivetrain3_.ID as ID1_1_2_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_, manufactur1_.NAME as NAME2_3_1_, manufactur1_.VERSION as VERSION3_3_1_, drivetrain3_.ENGINE_DISPLACEMENT as ENGINE2_1_2_, drivetrain3_.TRANSMISSION as TRANSMIS3_1_2_, drivetrain2_.AUTO_ID as AUTO2_0_0__, drivetrain2_.DRIVETRAIN_ID as DRIVETRA1_2_0__ from AUTO auto0_ left outer join MANUFACTURER manufactur1_ on auto0_.MANUFACTURER_ID=manufactur1_.ID left outer join DRIVETRAIN_AUTO drivetrain2_ on auto0_.ID=drivetrain2_.AUTO_ID left outer join DRIVETRAIN drivetrain3_ on drivetrain2_.DRIVETRAIN_ID=drivetrain3_.ID where auto0_.ID=?
09:58:53,781  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  79 - Start listAuto() for Auto ID: 1
09:58:53,782  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  81 - Auto Id: 1, Manufacturer ID: 1, Model: Camaro, Year: 2018, MSRP: $25,000.
09:58:53,782  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  83 - Manufacturer - Id: 1, Name: Chevrolet
09:58:53,784  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  87 - Drivetrain - Id: 5, Transmission: Automatic, EngineDisplacement: 5.0L
09:58:53,784  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  91 - End listAuto() for Auto ID: 1


09:58:53,784  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  36 - List all Autos BEFORE Insert...
Hibernate: select auto0_.ID as ID1_0_, auto0_.MANUFACTURER_ID as MANUFACT6_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
09:58:53,793  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 101 - Start listAllAutos()
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 1, Manufacturer ID: 1, Model: Camaro, Year: 2018, MSRP: $25,000.
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 2, Manufacturer ID: 2, Model: Challenger, Year: 2017, MSRP: $26,000.
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 3, Manufacturer ID: 2, Model: Charger, Year: 2018, MSRP: $27,000.
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 4, Manufacturer ID: 3, Model: Fusion, Year: 2017, MSRP: $23,000.
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 5, Manufacturer ID: 3, Model: Fiesta, Year: 2018, MSRP: $20,000.
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 6, Manufacturer ID: 3, Model: Mustang, Year: 2018, MSRP: $25,000.
09:58:53,794  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 105 - End listAllAutos()


Hibernate: insert into AUTO (MANUFACTURER_ID, MODEL, MSRP, VERSION, YEAR) values (?, ?, ?, ?, ?)
Hibernate: insert into DRIVETRAIN_AUTO (AUTO_ID, DRIVETRAIN_ID) values (?, ?)
Hibernate: select auto0_.ID as ID1_0_, auto0_.MANUFACTURER_ID as MANUFACT6_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  54 - List all Autos AFTER Insert...
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 101 - Start listAllAutos()
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 1, Manufacturer ID: 1, Model: Camaro, Year: 2018, MSRP: $25,000.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 2, Manufacturer ID: 2, Model: Challenger, Year: 2017, MSRP: $26,000.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 3, Manufacturer ID: 2, Model: Charger, Year: 2018, MSRP: $27,000.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 4, Manufacturer ID: 3, Model: Fusion, Year: 2017, MSRP: $23,000.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 5, Manufacturer ID: 3, Model: Fiesta, Year: 2018, MSRP: $20,000.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 6, Manufacturer ID: 3, Model: Mustang, Year: 2018, MSRP: $25,000.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 7, Manufacturer ID: 1, Model: Corvette, Year: 2017, MSRP: $65,495.
09:58:53,854  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 105 - End listAllAutos()


Hibernate: select distinct auto0_.ID as ID1_0_0_, manufactur1_.ID as ID1_3_1_, drivetrain3_.ID as ID1_1_2_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_, manufactur1_.NAME as NAME2_3_1_, manufactur1_.VERSION as VERSION3_3_1_, drivetrain3_.ENGINE_DISPLACEMENT as ENGINE2_1_2_, drivetrain3_.TRANSMISSION as TRANSMIS3_1_2_, drivetrain2_.AUTO_ID as AUTO2_0_0__, drivetrain2_.DRIVETRAIN_ID as DRIVETRA1_2_0__ from AUTO auto0_ left outer join MANUFACTURER manufactur1_ on auto0_.MANUFACTURER_ID=manufactur1_.ID left outer join DRIVETRAIN_AUTO drivetrain2_ on auto0_.ID=drivetrain2_.AUTO_ID left outer join DRIVETRAIN drivetrain3_ on drivetrain2_.DRIVETRAIN_ID=drivetrain3_.ID where auto0_.ID=?
09:58:53,862  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  79 - Start listAuto() for Auto ID: 7
09:58:53,862  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  81 - Auto Id: 7, Manufacturer ID: 1, Model: Corvette, Year: 2017, MSRP: $65,495.
09:58:53,862  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  83 - Manufacturer - Id: 1, Name: Chevrolet
09:58:53,862  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  87 - Drivetrain - Id: 6, Transmission: Manual, EngineDisplacement: 5.0L
09:58:53,862  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  91 - End listAuto() for Auto ID: 7


Hibernate: select auto0_.ID as ID1_0_0_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_ from AUTO auto0_ where auto0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select drivetrain0_.AUTO_ID as AUTO2_0_1_, drivetrain0_.DRIVETRAIN_ID as DRIVETRA1_2_1_, drivetrain1_.ID as ID1_1_0_, drivetrain1_.ENGINE_DISPLACEMENT as ENGINE2_1_0_, drivetrain1_.TRANSMISSION as TRANSMIS3_1_0_ from DRIVETRAIN_AUTO drivetrain0_ inner join DRIVETRAIN drivetrain1_ on drivetrain0_.DRIVETRAIN_ID=drivetrain1_.ID where drivetrain0_.AUTO_ID=?
Hibernate: delete from DRIVETRAIN_AUTO where AUTO_ID=?
Hibernate: delete from AUTO where ID=? and VERSION=?
Hibernate: select auto0_.ID as ID1_0_, auto0_.MANUFACTURER_ID as MANUFACT6_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
Hibernate: select manufactur0_.ID as ID1_3_0_, manufactur0_.NAME as NAME2_3_0_, manufactur0_.VERSION as VERSION3_3_0_ from MANUFACTURER manufactur0_ where manufactur0_.ID=?
09:58:53,907  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  64 - List all Autos AFTER Delete...
09:58:53,907  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 101 - Start listAllAutos()
09:58:53,907  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 1, Manufacturer ID: 1, Model: Camaro, Year: 2018, MSRP: $25,000.
09:58:53,907  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 2, Manufacturer ID: 2, Model: Challenger, Year: 2017, MSRP: $26,000.
09:58:53,907  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 3, Manufacturer ID: 2, Model: Charger, Year: 2018, MSRP: $27,000.
09:58:53,908  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 4, Manufacturer ID: 3, Model: Fusion, Year: 2017, MSRP: $23,000.
09:58:53,908  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 5, Manufacturer ID: 3, Model: Fiesta, Year: 2018, MSRP: $20,000.
09:58:53,908  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 103 - Auto Id: 6, Manufacturer ID: 3, Model: Mustang, Year: 2018, MSRP: $25,000.
09:58:53,908  INFO .hes.e57.demo.app.AutoManufacturerJPAApp: 105 - End listAllAutos()


09:58:53,908  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@2d07ed1e: startup date [Fri Oct 20 09:58:51 EDT 2017]; root of context hierarchy
09:58:53,909  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.789 s
[INFO] Finished at: 2017-10-20T09:58:53-04:00
[INFO] Final Memory: 15M/260M
[INFO] ------------------------------------------------------------------------
```

## demo_criteria_query App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerJPAApp

### To Execute
```
$ cd demo
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJPAApp"
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
09:10:46,514  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
09:10:46,856  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@65e5a158: startup date [Sun Oct 29 09:10:46 EDT 2017]; root of context hierarchy
09:10:47,074  INFO a.LocalContainerEntityManagerFactoryBean: 332 - Building JPA container EntityManagerFactory for persistence unit 'default'
09:10:47,222  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
09:10:47,229  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
09:10:47,231  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
09:10:47,233  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
09:10:47,250  INFO      org.hibernate.ejb.Ejb3Configuration: 529 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
09:10:47,353  INFO ons.internal.ConnectionProviderInitiator: 188 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
09:10:47,683  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
09:10:47,692  INFO e.engine.jdbc.internal.LobCreatorBuilder:  94 - HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
09:10:47,866  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
09:10:47,870  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
09:10:48,179  INFO demo.service.autoManufacturerServiceImpl:  40 - Finding Auto with model: Camaro
Hibernate: select distinct auto0_.ID as ID1_0_0_, manufactur1_.ID as ID1_3_1_, drivetrain3_.ID as ID1_1_2_, auto0_.MANUFACTURER_ID as MANUFACT6_0_0_, auto0_.MODEL as MODEL2_0_0_, auto0_.MSRP as MSRP3_0_0_, auto0_.VERSION as VERSION4_0_0_, auto0_.YEAR as YEAR5_0_0_, manufactur1_.NAME as NAME2_3_1_, manufactur1_.VERSION as VERSION3_3_1_, drivetrain3_.ENGINE_DISPLACEMENT as ENGINE2_1_2_, drivetrain3_.TRANSMISSION as TRANSMIS3_1_2_, drivetrain2_.AUTO_ID as AUTO2_0_0__, drivetrain2_.DRIVETRAIN_ID as DRIVETRA1_2_0__ from AUTO auto0_ left outer join MANUFACTURER manufactur1_ on auto0_.MANUFACTURER_ID=manufactur1_.ID left outer join DRIVETRAIN_AUTO drivetrain2_ on auto0_.ID=drivetrain2_.AUTO_ID left outer join DRIVETRAIN drivetrain3_ on drivetrain2_.DRIVETRAIN_ID=drivetrain3_.ID where 1=1 and auto0_.MODEL=?

09:10:48,446  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  44 - Start listAllAutos()
09:10:48,446  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  46 - Auto Id: 1, Manufacturer ID: 1, Model: Camaro, Year: 2018, MSRP: $25,000.
09:10:48,448  INFO .hes.e57.demo.app.AutoManufacturerJPAApp:  48 - End listAllAutos()


09:10:48,448  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@65e5a158: startup date [Sun Oct 29 09:10:46 EDT 2017]; root of context hierarchy
09:10:48,449  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.933 s
[INFO] Finished at: 2017-10-29T09:10:48-04:00
[INFO] Final Memory: 16M/297M
[INFO] ------------------------------------------------------------------------
```
