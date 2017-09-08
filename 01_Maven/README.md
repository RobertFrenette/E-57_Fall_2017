# Maven

Note: Demo App modified from the [Pro Spring](https://github.com/Apress/pro-spring-14) Class: com.apress.prospring4.ch2.HelloWorldSpringDI 

This example covers:
+ Creating a MVN Project in Eclipse
+ Building and Running an Application
+ Remote Debugging


### To Build

```
mvn clean install
```


### To Run

```
mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.HelloWorld"
```


### To Remote Debug
+ setup remote debugging in Eclipse

```
mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.HelloWorld"
```

+ Click Debug button in Eclipse


### Console Output

```
$ mvnDebug exec:java -Dexec.mainClass="edu.hes.e57.demo.HelloWorld"
Preparing to Execute Maven in Debug Mode
Listening for transport dt_socket at address: 8000
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ demo ---
Sep 08, 2017 5:19:32 AM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1bc1c270: startup date [Fri Sep 08 05:19:32 EDT 2017]; root of context hierarchy
Sep 08, 2017 5:19:32 AM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [META-INF/spring/app-context.xml]
Hello, World!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.311 s
[INFO] Finished at: 2017-09-08T05:19:32-04:00
[INFO] Final Memory: 11M/178M
[INFO] ------------------------------------------------------------------------
```
