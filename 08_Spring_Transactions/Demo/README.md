# Spring Transactions
This Spring Transaction Repo code is based on the examples provided by Vitaly in Week 8 and Pro Spring 4: com.apress.prospring4.ch9.

Note: Some functionality / implementation in these examples has been intentionally excluded, as they are part of the solution to the Term Projects.

## DB Creation
See README.md in root dir.


## demo App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerSpringTrxApp

### To Execute
```
$ cd demo
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringTrxApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringTrxApp"
```

### Console Output
```
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerSpringTrxApp" -Dexec.cleanupDaemonThreads=false
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building springtransactions 4.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ springtransactions ---
11:22:13,658  INFO eans.factory.xml.XmlBeanDefinitionReader: 317 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
11:22:14,159  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@36f7d13b: startup date [Thu Nov 02 11:22:14 EDT 2017]; root of context hierarchy
11:22:14,497  INFO a.LocalContainerEntityManagerFactoryBean: 334 - Building JPA container EntityManagerFactory for persistence unit 'default'
11:22:14,638  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.2.Final}
11:22:14,643  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.2.3.Final}
11:22:14,645  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
11:22:14,647  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
11:22:14,666  INFO      org.hibernate.ejb.Ejb3Configuration: 529 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
11:22:14,767  INFO ons.internal.ConnectionProviderInitiator: 188 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
11:22:15,151  INFO            org.hibernate.dialect.Dialect: 130 - HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
11:22:15,156  WARN          org.hibernate.dialect.H2Dialect:  78 - HHH000431: Unable to determine H2 database version, certain features may not work
11:22:15,160  INFO e.engine.jdbc.internal.LobCreatorBuilder:  94 - HHH000423: Disabling contextual LOB creation as JDBC driver reported JDBC version [3] less than 4
11:22:15,292  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
11:22:15,297  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
Hibernate: select auto0_.ID as ID1_0_, auto0_.MODEL as MODEL2_0_, auto0_.MSRP as MSRP3_0_, auto0_.VERSION as VERSION4_0_, auto0_.YEAR as YEAR5_0_ from AUTO auto0_

11:22:16,132  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  44 - Start listAllAutos()
11:22:16,133  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  46 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
11:22:16,135  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  46 - Auto - Id: 2, Model: Challenger, Year: 2017, MSRP: $26,000
11:22:16,136  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  46 - Auto - Id: 3, Model: Charger, Year: 2018, MSRP: $27,000
11:22:16,136  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  46 - Auto - Id: 4, Model: Fusion, Year: 2017, MSRP: $23,000
11:22:16,136  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  46 - Auto - Id: 5, Model: Fiesta, Year: 2018, MSRP: $20,000
11:22:16,136  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  46 - Auto - Id: 6, Model: Mustang, Year: 2018, MSRP: $25,000
11:22:16,137  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  48 - End listAllAutos()

Hibernate: select count(auto0_.ID) as col_0_0_ from AUTO auto0_
11:22:16,144  INFO 57.demo.app.AutoManufacturerSpringTrxApp:  31 - Auto count: 6

11:22:16,144  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@36f7d13b: startup date [Thu Nov 02 11:22:14 EDT 2017]; root of context hierarchy
11:22:16,146  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.589 s
[INFO] Finished at: 2017-11-02T11:22:16-04:00
[INFO] Final Memory: 16M/292M
[INFO] ------------------------------------------------------------------------
```
