# Spring Data JPA 2

These examples use Spring Data JPA 2 to perform CRUD operations on a MySQL DB containing Automobile Manufacturer Vehicles.

Note: Some functionality / implementation in these examples has been intentionally excluded, as they are part of the solution to the Term Projects.

## DB Creation
See README.md in root dir.


## demo App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerSpringDataApp

### To Execute
```
$ cd demo
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringDataApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringDataApp"
```

### Console Output
```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building springjpa2 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ springjpa2 ---
11:05:34,704  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
11:05:35,075  INFO ctory.support.DefaultListableBeanFactory: 746 - Overriding bean definition for bean 'autoRepository': replacing [Root bean: class [org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null] with [Root bean: class [org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null]
11:05:35,080  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@2776410d: startup date [Fri Oct 20 11:05:35 EDT 2017]; root of context hierarchy
11:05:35,327  INFO a.LocalContainerEntityManagerFactoryBean: 332 - Building JPA container EntityManagerFactory for persistence unit 'default'
11:05:35,470  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
11:05:35,477  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
11:05:35,479  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
11:05:35,481  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
11:05:35,502  INFO      org.hibernate.ejb.Ejb3Configuration: 529 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
11:05:35,612  INFO ons.internal.ConnectionProviderInitiator: 188 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
11:05:35,914  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
11:05:35,920  INFO e.engine.jdbc.internal.LobCreatorBuilder:  94 - HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
11:05:36,036  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
11:05:36,040  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
Hibernate: select auto0_.ID as ID1_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_
11:05:36,815  INFO 7.demo.app.AutoManufacturerSpringDataApp:  46 - 

Start listAllAutos()
11:05:36,816  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
11:05:36,817  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 2, Model: Challenger, Year: 2017, MSRP: $26,000
11:05:36,817  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 3, Model: Charger, Year: 2018, MSRP: $27,000
11:05:36,817  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 4, Model: Fusion, Year: 2017, MSRP: $23,000
11:05:36,817  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 5, Model: Fiesta, Year: 2018, MSRP: $20,000
11:05:36,817  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 6, Model: Mustang, Year: 2018, MSRP: $25,000
11:05:36,817  INFO 7.demo.app.AutoManufacturerSpringDataApp:  50 - End listAllAutos()

Hibernate: select auto0_.ID as ID1_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_ where auto0_.MODEL=?
11:05:36,839  INFO 7.demo.app.AutoManufacturerSpringDataApp:  46 - 

Start listAllAutos()
11:05:36,839  INFO 7.demo.app.AutoManufacturerSpringDataApp:  48 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
11:05:36,839  INFO 7.demo.app.AutoManufacturerSpringDataApp:  50 - End listAllAutos()

11:05:36,839  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@2776410d: startup date [Fri Oct 20 11:05:35 EDT 2017]; root of context hierarchy
11:05:36,841  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.162 s
[INFO] Finished at: 2017-10-20T11:05:36-04:00
[INFO] Final Memory: 16M/257M
[INFO] ------------------------------------------------------------------------
```

## demo_crud App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerSpringDataApp

### To Execute
```
$ cd demo_crud
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringDataApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringDataApp"
```

### Console Output
```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building springjpa2 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ springjpa2 ---
09:56:58,167  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
09:56:58,543  INFO ctory.support.DefaultListableBeanFactory: 746 - Overriding bean definition for bean 'autoRepository': replacing [Root bean: class [org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null] with [Root bean: class [org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null]
09:56:58,549  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@6c5f7a2a: startup date [Fri Nov 03 09:56:58 EDT 2017]; root of context hierarchy
09:56:58,794  INFO a.LocalContainerEntityManagerFactoryBean: 332 - Building JPA container EntityManagerFactory for persistence unit 'default'
09:56:58,940  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
09:56:58,946  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
09:56:58,949  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
09:56:58,951  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
09:56:58,970  INFO      org.hibernate.ejb.Ejb3Configuration: 529 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
09:56:59,103  INFO ons.internal.ConnectionProviderInitiator: 188 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
09:56:59,486  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
09:56:59,495  INFO e.engine.jdbc.internal.LobCreatorBuilder:  94 - HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
09:56:59,658  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
09:56:59,663  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
09:57:00,154  INFO 7.demo.app.AutoManufacturerSpringDataApp:  33 - List all Autos BEFORE Insert...
09:57:00,434  INFO 7.demo.app.AutoManufacturerSpringDataApp:  82 - Start listAllAutosWithAndManufacturers()
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  84 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  87 - Manufacturer - Id: 1, Name: Chevrolet
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  89 - 
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  84 - Auto - Id: 2, Manufacturer: Dodge, Model: Challenger, Year: 2017, MSRP: $26,000.
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  87 - Manufacturer - Id: 2, Name: Dodge
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  89 - 
09:57:00,436  INFO 7.demo.app.AutoManufacturerSpringDataApp:  84 - Auto - Id: 3, Manufacturer: Dodge, Model: Charger, Year: 2018, MSRP: $27,000.
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  87 - Manufacturer - Id: 2, Name: Dodge
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  89 - 
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  84 - Auto - Id: 4, Manufacturer: Ford, Model: Fusion, Year: 2017, MSRP: $23,000.
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  87 - Manufacturer - Id: 3, Name: Ford
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  89 - 
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  84 - Auto - Id: 5, Manufacturer: Ford, Model: Fiesta, Year: 2018, MSRP: $20,000.
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  87 - Manufacturer - Id: 3, Name: Ford
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  89 - 
09:57:00,437  INFO 7.demo.app.AutoManufacturerSpringDataApp:  84 - Auto - Id: 6, Manufacturer: Ford, Model: Mustang, Year: 2018, MSRP: $25,000.
09:57:00,438  INFO 7.demo.app.AutoManufacturerSpringDataApp:  87 - Manufacturer - Id: 3, Name: Ford
09:57:00,438  INFO 7.demo.app.AutoManufacturerSpringDataApp:  89 - 
09:57:00,438  INFO 7.demo.app.AutoManufacturerSpringDataApp:  91 - End listAllAutosWithAndManufacturers()


09:57:00,537  INFO edu.hes.e57.demo.service.AutoServiceImpl:  54 - List all Autos AFTER Insert...
09:57:00,538  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 1, Manufacturer: Chevrolet, Model: Camaro, Year: 2018, MSRP: $25,000.
09:57:00,542  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 1, Name: Chevrolet
09:57:00,552  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,553  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 2, Manufacturer: Dodge, Model: Challenger, Year: 2017, MSRP: $26,000.
09:57:00,553  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 2, Name: Dodge
09:57:00,573  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 3, Manufacturer: Dodge, Model: Charger, Year: 2018, MSRP: $27,000.
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 2, Name: Dodge
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 4, Manufacturer: Ford, Model: Fusion, Year: 2017, MSRP: $23,000.
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 3, Name: Ford
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 5, Manufacturer: Ford, Model: Fiesta, Year: 2018, MSRP: $20,000.
09:57:00,574  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 3, Name: Ford
09:57:00,575  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,575  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 6, Manufacturer: Ford, Model: Mustang, Year: 2018, MSRP: $25,000.
09:57:00,586  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 3, Name: Ford
09:57:00,587  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,587  INFO edu.hes.e57.demo.service.AutoServiceImpl:  56 - Auto - Id: 7, Manufacturer: Chevrolet, Model: Chevelle, Year: 1970, MSRP: $15,000.
09:57:00,587  INFO edu.hes.e57.demo.service.AutoServiceImpl:  59 - Manufacturer - Id: 1, Name: Chevrolet
09:57:00,587  INFO edu.hes.e57.demo.service.AutoServiceImpl:  61 - 
09:57:00,611  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@6c5f7a2a: startup date [Fri Nov 03 09:56:58 EDT 2017]; root of context hierarchy
09:57:00,615  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.492 s
[INFO] Finished at: 2017-11-03T09:57:00-04:00
[INFO] Final Memory: 16M/252M
[INFO] ------------------------------------------------------------------------
```
