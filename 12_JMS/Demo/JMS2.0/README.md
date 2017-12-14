# Spring JMS 2.0
This Spring JMS Repo code is based on the examples provided by Vitaly in Week 13 and Pro Spring 4: com.apress.prospring4.ch12.

### Config HornetQ:
[hornetq_install_dir]/config/stand-alone/non-clustered/hornetq-jms.xml
```
<queue name="YOUR_ActiveMQ_QUEUE_NAME">
  <entry name="/queue/YOUR_ActiveMQ_QUEUE_NAME"/>
</queue>
```


### Start HornetQ:
```
cd [hornetq_install_dir]/bin
./run.sh
```


### Stop HornetQ:
```
cd [hornetq_install_dir]/bin
./stop.sh
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
10:45:39,302  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/jms-sender-app-context.xml]
10:45:39,608  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/jms-listener-app-context.xml]
10:45:39,648  INFO ctory.support.DefaultListableBeanFactory: 746 - Overriding bean definition for bean 'connectionFactory': replacing [Generic bean: class [org.hornetq.jms.client.HornetQJMSConnectionFactory]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [META-INF/spring/jms-sender-app-context.xml]] with [Generic bean: class [org.hornetq.jms.client.HornetQJMSConnectionFactory]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [META-INF/spring/jms-listener-app-context.xml]]
10:45:39,659  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@5498910f: startup date [Tue Dec 05 10:45:39 EST 2017]; root of context hierarchy
10:45:39,727  INFO ion.AutowiredAnnotationBeanPostProcessor: 141 - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
10:45:39,916  INFO ontext.support.DefaultLifecycleProcessor: 341 - Starting beans in phase 2147483647
10:45:45,331  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 0
10:45:45,386  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 1
10:45:45,403  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 2
10:45:45,429  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 3
10:45:45,444  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 4
10:45:45,459  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 5
10:45:45,479  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 6
10:45:45,496  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 7
10:45:45,510  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 8
10:45:45,532  INFO ss.prospring4.ch12.SimpleMessageListener:  19 - Message received: Test message: 9
```
