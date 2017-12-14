# Spring JMS 1.1
This Spring JMS Repo code is based on the examples provided by Vitaly in Week 13 and Pro Spring 4: com.apress.prospring4.ch12.

### Start ActiveMQ: (Mac)
```
cd [activemq_install_dir]/bin
./activemq console
```

### Access ActiveMQ Console: (creds: admin/admin)
```
http://localhost:8161
```

### Stop ActiveMQ:
```
cd [activemq_install_dir]/bin
./activemq stop
```

### Exec:
```
mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.JmsSample"
```

### Output:
```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building jms 4.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ jms ---
12:10:34,129  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/jms-sender-app-context.xml]
12:10:34,377  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/jms-listener-app-context.xml]
12:10:34,423  INFO ctory.support.DefaultListableBeanFactory: 746 - Overriding bean definition for bean 'connectionFactory': replacing [Generic bean: class [org.apache.activemq.pool.PooledConnectionFactory]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [META-INF/spring/jms-sender-app-context.xml]] with [Generic bean: class [org.apache.activemq.pool.PooledConnectionFactory]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [META-INF/spring/jms-listener-app-context.xml]]
12:10:34,431  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@5e5c377f: startup date [Tue Dec 05 12:10:34 EST 2017]; root of context hierarchy
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/Users/Rob/.m2/repository/org/apache/activemq/activemq-all/5.10.0/activemq-all-5.10.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/Users/Rob/.m2/repository/org/slf4j/slf4j-log4j12/1.7.6/slf4j-log4j12-1.7.6.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
12:10:34,668  INFO ontext.support.DefaultLifecycleProcessor: 341 - Starting beans in phase 2147483647
12:10:34,873  INFO emq.transport.failover.FailoverTransport:1055 - Successfully connected to tcp://localhost:61616
12:10:35,028  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 10
12:10:35,033  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 11
12:10:35,036  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 12
12:10:35,038  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 13
12:10:35,045  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 14
12:10:35,048  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 15
12:10:35,051  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 16
12:10:35,054  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 17
12:10:35,057  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 18
12:10:35,059  INFO   edu.hes.e57.demo.SimpleMessageListener:  19 - Message received: Test message: 19
```
