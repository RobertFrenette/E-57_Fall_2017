# Collections

This example is modified from Vitaly's Collections presentation (from Pro Spring 4)

### Driver Class
edu.hes.e57.demo.App

### To Execute
```
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.App"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.App"
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
13:27:32,940  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/app-context-annotation.xml]
13:27:33,252  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@17d08a6a: startup date [Tue Sep 12 13:27:33 EDT 2017]; root of context hierarchy

13:27:33,391  INFO                     edu.hes.e57.demo.App:  49 - Map contents:
13:27:33,391  INFO                     edu.hes.e57.demo.App:  51 - Key: theBean - Value: edu.hes.e57.demo.CollectionManagerImpl@615721af
13:27:33,391  INFO                     edu.hes.e57.demo.App:  51 - Key: Ford - Value: Mustang
13:27:33,392  INFO                     edu.hes.e57.demo.App:  51 - Key: Dodge - Value: Charger
13:27:33,392  INFO                     edu.hes.e57.demo.App:  51 - Key: Chevrolet - Value: Camaro
13:27:33,392  INFO                     edu.hes.e57.demo.App:  53 - 

13:27:33,392  INFO                     edu.hes.e57.demo.App:  55 - Properties contents:
13:27:33,392  INFO                     edu.hes.e57.demo.App:  57 - Key: manufacturer - Value: Chevrolet
13:27:33,393  INFO                     edu.hes.e57.demo.App:  57 - Key: vehicle - Value: Camaro
13:27:33,393  INFO                     edu.hes.e57.demo.App:  59 - 

13:27:33,393  INFO                     edu.hes.e57.demo.App:  61 - Set contents:
13:27:33,393  INFO                     edu.hes.e57.demo.App:  63 - Value: Set Value 1
13:27:33,393  INFO                     edu.hes.e57.demo.App:  63 - Value: Set Value 2
13:27:33,393  INFO                     edu.hes.e57.demo.App:  63 - Value: Set Value 3
13:27:33,394  INFO                     edu.hes.e57.demo.App:  63 - Value: edu.hes.e57.demo.CollectionManagerImpl@615721af
13:27:33,394  INFO                     edu.hes.e57.demo.App:  65 - 

13:27:33,394  INFO                     edu.hes.e57.demo.App:  67 - List contents:
13:27:33,394  INFO                     edu.hes.e57.demo.App:  69 - Value: List Value 1
13:27:33,395  INFO                     edu.hes.e57.demo.App:  69 - Value: List Value 2
13:27:33,395  INFO                     edu.hes.e57.demo.App:  69 - Value: List Value 3
13:27:33,395  INFO                     edu.hes.e57.demo.App:  69 - Value: edu.hes.e57.demo.CollectionManagerImpl@615721af

13:27:33,395  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@17d08a6a: startup date [Tue Sep 12 13:27:33 EDT 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.434 s
[INFO] Finished at: 2017-09-12T13:27:33-04:00
[INFO] Final Memory: 11M/165M
[INFO] ------------------------------------------------------------------------
```
