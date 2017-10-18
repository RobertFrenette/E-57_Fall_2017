# Spring JDBC

These examples use Spring JDBC to perform CRUD operations on a MySQL DB containing Automboile Manufacturer Vehicles.

## DB Creation
See README.md in root dir.


## demo App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerJdbcApp

### To Execute
```
$ cd demo
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJdbcApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJdbcApp"
```

### Console Output
```
Preparing to Execute Maven in Debug Mode
Listening for transport dt_socket at address: 8000
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ demo ---
09:54:12,944  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
09:54:13,159  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/datasource-dbcp.xml]
09:54:13,336  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@358d80d1: startup date [Sat Sep 16 09:54:13 EDT 2017]; root of context hierarchy
09:54:13,411  INFO ort.PropertySourcesPlaceholderConfigurer: 172 - Loading properties file from class path resource [META-INF/config/jdbc.properties]

09:54:13,831  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  50 - Manufacturer - Id: 1, Name: Chevrolet
09:54:13,831  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  50 - Manufacturer - Id: 2, Name: Dodge
09:54:13,831  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  50 - Manufacturer - Id: 3, Name: Ford

09:54:13,833  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  62 - Auto - Id: 1, ManufacturerId: 1, Model: Camaro, Year: 2018, Msrp: $25,000
09:54:13,833  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  62 - Auto - Id: 2, ManufacturerId: 2, Model: Challenger, Year: 2017, Msrp: $26,000
09:54:13,833  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  62 - Auto - Id: 3, ManufacturerId: 2, Model: Charger, Year: 2018, Msrp: $27,000
09:54:13,833  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  62 - Auto - Id: 4, ManufacturerId: 3, Model: Fusion, Year: 2017, Msrp: $23,000
09:54:13,833  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  62 - Auto - Id: 5, ManufacturerId: 3, Model: Fiesta, Year: 2018, Msrp: $20,000
09:54:13,834  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  62 - Auto - Id: 6, ManufacturerId: 3, Model: Mustang, Year: 2018, Msrp: $25,000

09:54:13,834  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@358d80d1: startup date [Sat Sep 16 09:54:13 EDT 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.248 s
[INFO] Finished at: 2017-09-16T09:54:13-04:00
[INFO] Final Memory: 14M/167M
[INFO] ------------------------------------------------------------------------
```

## demo_crud App

### Driver Class
edu.hes.e57.demo.app.AutoManufacturerJdbcApp

### To Execute
```
$ cd demo_crud
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJdbcApp"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoManufacturerJdbcApp"
```

### Console Output
```
Preparing to Execute Maven in Debug Mode
Listening for transport dt_socket at address: 8000
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ demo ---
10:00:35,281  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
10:00:35,423  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/datasource-dbcp.xml]
10:00:35,601  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@6ed0f4c0: startup date [Sat Sep 16 10:00:35 EDT 2017]; root of context hierarchy
10:00:35,677  INFO ort.PropertySourcesPlaceholderConfigurer: 172 - Loading properties file from class path resource [META-INF/config/jdbc.properties]

10:00:36,141  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  76 - Printing All Autos for Manufacturer 'Chevrolet' BEFORE Insert:
10:00:36,146  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  54 - Auto - Id: 1, ManufacturerId: 1, Model: Camaro, Year: 2018, Msrp: $25,000
10:00:36,152  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  91 - Printing All Autos for Manufacturer 'Chevrolet' AFTER Insert:
10:00:36,154  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  54 - Auto - Id: 1, ManufacturerId: 1, Model: Camaro, Year: 2018, Msrp: $25,000

10:00:36,154  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  54 - Auto - Id: 7, ManufacturerId: 1, Model: Chevelle, Year: 1970, Msrp: $20,000
10:00:36,156  INFO hes.e57.demo.app.AutoManufacturerJdbcApp: 112 - Printing Auto Model 'Chevelle' BEFORE Update:
10:00:36,156  INFO hes.e57.demo.app.AutoManufacturerJdbcApp: 113 - Auto - Id: 7, ManufacturerId: 1, Model: Chevelle, Year: 1970, Msrp: $20,000
10:00:36,195  INFO hes.e57.demo.app.AutoManufacturerJdbcApp: 123 - Printing Auto Model 'Chevelle' AFTER Update:
10:00:36,195  INFO hes.e57.demo.app.AutoManufacturerJdbcApp: 124 - Auto - Id: 7, ManufacturerId: 1, Model: Chevelle, Year: 1970, Msrp: $30,000

10:00:36,195  INFO hes.e57.demo.app.AutoManufacturerJdbcApp: 135 - Printing All 'Chevrolet' Autos BEFORE Delete:
10:00:36,197  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  54 - Auto - Id: 1, ManufacturerId: 1, Model: Camaro, Year: 2018, Msrp: $25,000
10:00:36,197  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  54 - Auto - Id: 7, ManufacturerId: 1, Model: Chevelle, Year: 1970, Msrp: $30,000
10:00:36,202  INFO hes.e57.demo.app.AutoManufacturerJdbcApp: 148 - Printing All 'Chevrolet' Autos AFTER Delete:
10:00:36,204  INFO hes.e57.demo.app.AutoManufacturerJdbcApp:  54 - Auto - Id: 1, ManufacturerId: 1, Model: Camaro, Year: 2018, Msrp: $25,000

10:00:36,204  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@6ed0f4c0: startup date [Sat Sep 16 10:00:35 EDT 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.836 s
[INFO] Finished at: 2017-09-16T10:00:36-04:00
[INFO] Final Memory: 14M/168M
[INFO] ------------------------------------------------------------------------
```
