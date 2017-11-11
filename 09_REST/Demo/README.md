# Spring REST Services
This Spring REST Repo code is based on the examples provided by Vitaly in Week 9 and Pro Spring 4: com.apress.prospring4.ch12.

Note: Some functionality / implementation in these examples has been intentionally excluded, as they are part of the solution to the Term Projects.

## DB Creation
See README.md in root dir.

## REST / CRUD Mapping
### REST Verbs: GET / POST / PUT / DELETE
	Create: POST
	Read:   GET
	Update: PUT
	Delete: DELETE


## URI
	http://www.somedonain.com/restful/customer/1

	server: www.somedomain.com
	context root: restful 
	resource (Object): customer
	id: 1


## Tomcat (Mac)
	Homebrew: https://brew.sh/ 
	brew install tomcat 
	brew ls tomcat


## POM
	Package: WAR
	Build:  Tomcat plugin
	OutputDirectory: /usr/local/Cellar/tomcat/n.n.n/libexec/webapps


## Tomcat Run
	catalina run
	http://localhost:8080
	catalina stop

## Tomcat Debug
	catalina jpda run 


## demo App

### Driver Class
edu.hes.e57.demo.app.AutoSpringRESTApp


### Console Output
```
$ mvn exec:java -Dexec.mainClass="edu.hes.e57.demo.app.AutoSpringRESTApp" -Dexec.cleanupDaemonThreads=false
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building springrest 4.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.5.0:java (default-cli) @ springrest ---
10:12:23,373  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/restful-client-app-context.xml]
10:12:23,532  INFO ext.support.GenericXmlApplicationContext: 513 - Refreshing org.springframework.context.support.GenericXmlApplicationContext@159e229e: startup date [Fri Nov 10 10:12:23 EST 2017]; root of context hierarchy
10:12:23,706  WARN beans.GenericTypeAwarePropertyDescriptor: 116 - Invalid JavaBean property 'credentials' being accessed! Ambiguous write methods found next to actually used [public void edu.hes.e57.demo.provider.CustomCredentialsProvider.setCredentials(org.apache.http.auth.Credentials)]: [public void org.apache.http.impl.client.BasicCredentialsProvider.setCredentials(org.apache.http.auth.AuthScope,org.apache.http.auth.Credentials)]
10:12:24,292  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  32 - Testing retrieve all autos:
10:12:25,147  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
10:12:25,147  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 2, Model: Challenger, Year: 2017, MSRP: $26,000
10:12:25,147  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 3, Model: Charger, Year: 2018, MSRP: $27,000
10:12:25,147  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 4, Model: Fusion, Year: 2017, MSRP: $23,000
10:12:25,147  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 5, Model: Fiesta, Year: 2018, MSRP: $20,000
10:12:25,147  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 6, Model: Mustang, Year: 2018, MSRP: $25,000
10:12:25,148  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  69 - 
10:12:25,148  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  36 - Testing retrieve a auto by id :
10:12:25,182  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  38 - Auto - Id: 1, Model: Camaro, Year: 2018, MSRP: $25,000
10:12:25,182  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  39 - 
10:12:25,199  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  43 - Testing update auto by id :
10:12:25,352  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  45 - Auto updated successfully: Auto - Id: 1, Model: New Model, Year: 2018, MSRP: $25,000
10:12:25,353  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  46 - 
10:12:25,401  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  49 - Testing delete auto by id :
10:12:25,454  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 2, Model: Challenger, Year: 2017, MSRP: $26,000
10:12:25,455  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 3, Model: Charger, Year: 2018, MSRP: $27,000
10:12:25,456  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 4, Model: Fusion, Year: 2017, MSRP: $23,000
10:12:25,456  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 5, Model: Fiesta, Year: 2018, MSRP: $20,000
10:12:25,456  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  67 - Auto - Id: 6, Model: Mustang, Year: 2018, MSRP: $25,000
10:12:25,456  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  69 - 
10:12:25,456  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  53 - Testing create auto :
10:12:25,502  INFO   edu.hes.e57.demo.app.AutoSpringRESTApp:  59 - Auto created successfully: Auto - Id: null, Model: Chevelle, Year: 1970, MSRP: $15,000
10:12:25,503  INFO ext.support.GenericXmlApplicationContext: 873 - Closing org.springframework.context.support.GenericXmlApplicationContext@159e229e: startup date [Fri Nov 10 10:12:23 EST 2017]; root of context hierarchy
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.405 s
[INFO] Finished at: 2017-11-10T10:12:25-05:00
[INFO] Final Memory: 19M/170M
[INFO] ------------------------------------------------------------------------
```


## Postman Testing URIs
	URL_GET_ALL_AUTOS  = "http://localhost:8080/springrest/restful/auto/listdata";
    URL_GET_AUTO_BY_ID = "http://localhost:8080/springrest/restful/auto/{id}";
    URL_CREATE_AUTO = "http://localhost:8080/springrest/restful/auto/";
    URL_UPDATE_AUTO = "http://localhost:8080/springrest/restful/auto/{id}";
    URL_DELETE_AUTO = "http://localhost:8080/springrest/restful/auto/{id}";
