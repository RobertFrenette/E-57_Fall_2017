# Setter Injection

This example is modified from Vitaly's Setter-Injection presentation (from Pro Spring 4)

### Driver Classes
edu.hes.e57.demo.App (uses GenericXmlApplicationContext)
edu.hes.e57.demo.App2 (uses AnnotationConfigApplicationContext)

### To Execute
```
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.App"
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.App2"
```

### To Remote Debug
```
$ mvn clean install
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.App"
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.App2"
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
11:51:41,307  INFO ation.AnnotationConfigApplicationContext: 513 - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@25fff9ad: startup date [Tue Sep 12 11:51:41 EDT 2017]; root of context hierarchy

11:51:41,502  INFO .hes.e57.demo.StandardOutMessageRenderer:  23 - messageProvider.getMessage() = Hello, Spring!

11:51:41,502  INFO ation.AnnotationConfigApplicationContext: 873 - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@25fff9ad: startup date [Tue Sep 12 11:51:41 EDT 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.227 s
[INFO] Finished at: 2017-09-12T11:51:41-04:00
[INFO] Final Memory: 13M/155M
[INFO] ------------------------------------------------------------------------
```
