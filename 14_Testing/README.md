# Testing
This Testing Repo code is based on the examples provided by Vitaly in Week 14 and Pro Spring 4: com.apress.prospring4.ch13.

## Unit_Testing
```
mvn clean install
...
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running edu.hes.e57.demo.ContactControllerTest
06:32:25,822  INFO es.e57.demo.controller.ContactController:  32 - Found contact: Contact - Id: 1, Version: 1, First name: Chris, Last name: Schaefer, Birthday: 1987-03-26T12:00:00.000-05:00
06:32:25,828  INFO es.e57.demo.controller.ContactController:  41 - By id = 1 found contact: Contact - Id: 1, Version: 1, First name: Chris, Last name: Schaefer, Birthday: 1987-03-26T12:00:00.000-05:00
06:32:25,830  INFO es.e57.demo.controller.ContactController:  48 - Creating contact: Contact - Id: 999, Version: 1, First name: Rod, Last name: Johnson, Birthday: 1968-11-02T11:00:00.000-05:00
06:32:25,830  INFO es.e57.demo.controller.ContactController:  50 - Contact created successfully with info: Contact - Id: 999, Version: 1, First name: Rod, Last name: Johnson, Birthday: 1968-11-02T11:00:00.000-05:00
06:32:25,832  INFO es.e57.demo.controller.ContactController:  66 - Deleting contact with id: 1
06:32:25,833  INFO es.e57.demo.controller.ContactController:  69 - Contact deleted successfully
06:32:25,835  INFO es.e57.demo.controller.ContactController:  57 - Updating contact: Contact - Id: 1, Version: 2, First name: Chris, Last name: Schaefer, Birthday: 1987-03-26T12:00:00.000-05:00
06:32:25,835  INFO es.e57.demo.controller.ContactController:  59 - Contact updated successfully with info: Contact - Id: 1, Version: 2, First name: Chris, Last name: Schaefer, Birthday: 1987-03-26T12:00:00.000-05:00
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.356 sec

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
...
```


## Integration_Testing
```
mvn clean install
...
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running edu.hes.e57.demo.controller.ContactControllerTest
06:54:32,069  INFO es.e57.demo.controller.ContactController:  32 - Found contact: Contact - Id: 1, First name: Chris, Last name: Schaefer, Birthday: null
06:54:32,082  INFO es.e57.demo.controller.ContactController:  48 - Creating contact: Contact - Id: 999, First name: Rod, Last name: Johnson, Birthday: null
06:54:32,085  INFO es.e57.demo.controller.ContactController:  50 - Contact created successfully with info: Contact - Id: 999, First name: Rod, Last name: Johnson, Birthday: null
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.289 sec
Running edu.hes.e57.demo.controller.ContactServiceImplTest
06:54:32,148  INFO ramework.test.context.TestContextManager: 234 - Could not instantiate TestExecutionListener class [org.springframework.test.context.web.ServletTestExecutionListener]. Specify custom listener classes or make the default listener classes (and their dependencies) available.
06:54:32,286  INFO ontext.support.GenericApplicationContext: 513 - Refreshing org.springframework.context.support.GenericApplicationContext@7f416310: startup date [Thu Dec 14 06:54:32 EST 2017]; root of context hierarchy
06:54:32,405  INFO eans.factory.xml.XmlBeanDefinitionReader: 316 - Loading XML bean definitions from class path resource [META-INF/spring/datasource-tx-jpa.xml]
06:54:32,596  INFO ctory.support.DefaultListableBeanFactory: 746 - Overriding bean definition for bean 'contactRepository': replacing [Root bean: class [org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null] with [Root bean: class [org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null]
06:54:32,787  INFO asource.embedded.EmbeddedDatabaseFactory: 130 - Creating embedded database 'testdb'
06:54:32,923  INFO atasource.init.ResourceDatabasePopulator: 162 - Executing SQL script from class path resource [META-INF/config/schema.sql]
06:54:32,935  INFO atasource.init.ResourceDatabasePopulator: 217 - Done executing SQL script from class path resource [META-INF/config/schema.sql] in 12 ms.
06:54:32,981  INFO a.LocalContainerEntityManagerFactoryBean: 332 - Building JPA container EntityManagerFactory for persistence unit 'default'
06:54:33,077  INFO org.hibernate.annotations.common.Version:  37 - HCANN000001: Hibernate Commons Annotations {4.0.1.Final}
06:54:33,082  INFO                    org.hibernate.Version:  41 - HHH000412: Hibernate Core {4.0.1.Final}
06:54:33,083  INFO            org.hibernate.cfg.Environment: 239 - HHH000206: hibernate.properties not found
06:54:33,085  INFO            org.hibernate.cfg.Environment: 342 - HHH000021: Bytecode provider name : javassist
06:54:33,099  INFO      org.hibernate.ejb.Ejb3Configuration: 526 - HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
06:54:33,368  INFO ons.internal.ConnectionProviderInitiator: 186 - HHH000130: Instantiating explicit connection provider: org.hibernate.ejb.connection.InjectedDataSourceConnectionProvider
06:54:33,402  INFO            org.hibernate.dialect.Dialect: 121 - HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
06:54:33,431  INFO ion.internal.TransactionFactoryInitiator:  73 - HHH000268: Transaction strategy: org.hibernate.engine.transaction.internal.jdbc.JdbcTransactionFactory
06:54:33,435  INFO l.internal.ast.ASTQueryTranslatorFactory:  48 - HHH000397: Using ASTQueryTranslatorFactory
06:54:33,489  INFO ibernate.validator.internal.util.Version:  27 - HV000001: Hibernate Validator 5.1.0.Final
06:54:34,140  WARN ingframework.aop.framework.CglibAopProxy: 263 - Unable to proxy method [public final void org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests.setApplicationContext(org.springframework.context.ApplicationContext)] because it is final: All calls to this method via a proxy will be routed directly to the proxy.
06:54:34,174  INFO ction.TransactionalTestExecutionListener: 276 - Began transaction (1) for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@c6634d, testMethod = testAddContactWithJSR349Error@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]; transaction manager [org.springframework.orm.jpa.JpaTransactionManager@73ad7e90]; rollback [true]
Hibernate: DELETE FROM CONTACT
06:54:34,216  INFO .springframework.test.jdbc.JdbcTestUtils:  99 - Deleted 0 rows from table CONTACT
06:54:34,347  INFO ction.TransactionalTestExecutionListener: 298 - Rolled back transaction after test execution for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@c6634d, testMethod = testAddContactWithJSR349Error@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]
06:54:34,352  INFO ction.TransactionalTestExecutionListener: 276 - Began transaction (2) for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@243f003c, testMethod = testFindByFirstNameAndLastName_1@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]; transaction manager [org.springframework.orm.jpa.JpaTransactionManager@73ad7e90]; rollback [true]
06:54:34,626  WARN org.dbunit.dataset.AbstractTableMetaData: 166 - Potential problem found: The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' might cause problems with the current database 'H2' (e.g. some datatypes may not be supported properly). In rare cases you might see this message because the list of supported database products is incomplete (list=[derby]). If so please request a java-class update via the forums.If you are using your own IDataTypeFactory extending DefaultDataTypeFactory, ensure that you override getValidDbProducts() to specify the supported database products.
Hibernate: select contact0_.ID as ID0_, contact0_.BIRTH_DATE as BIRTH2_0_, contact0_.FIRST_NAME as FIRST3_0_, contact0_.LAST_NAME as LAST4_0_ from contact contact0_ where contact0_.FIRST_NAME=? and contact0_.LAST_NAME=? limit ?
06:54:34,849  INFO ction.TransactionalTestExecutionListener: 298 - Rolled back transaction after test execution for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@243f003c, testMethod = testFindByFirstNameAndLastName_1@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]
06:54:34,856  INFO ction.TransactionalTestExecutionListener: 276 - Began transaction (3) for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@7f353d99, testMethod = testFindByFirstNameAndLastName_2@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]; transaction manager [org.springframework.orm.jpa.JpaTransactionManager@73ad7e90]; rollback [true]
06:54:34,877  WARN org.dbunit.dataset.AbstractTableMetaData: 166 - Potential problem found: The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' might cause problems with the current database 'H2' (e.g. some datatypes may not be supported properly). In rare cases you might see this message because the list of supported database products is incomplete (list=[derby]). If so please request a java-class update via the forums.If you are using your own IDataTypeFactory extending DefaultDataTypeFactory, ensure that you override getValidDbProducts() to specify the supported database products.
Hibernate: select contact0_.ID as ID0_, contact0_.BIRTH_DATE as BIRTH2_0_, contact0_.FIRST_NAME as FIRST3_0_, contact0_.LAST_NAME as LAST4_0_ from contact contact0_ where contact0_.FIRST_NAME=? and contact0_.LAST_NAME=? limit ?
06:54:34,896  INFO ction.TransactionalTestExecutionListener: 298 - Rolled back transaction after test execution for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@7f353d99, testMethod = testFindByFirstNameAndLastName_2@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]
06:54:34,903  INFO ction.TransactionalTestExecutionListener: 276 - Began transaction (4) for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@4fc3c165, testMethod = testFindAll@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]; transaction manager [org.springframework.orm.jpa.JpaTransactionManager@73ad7e90]; rollback [true]
06:54:34,930  WARN org.dbunit.dataset.AbstractTableMetaData: 166 - Potential problem found: The configured data type factory 'class org.dbunit.dataset.datatype.DefaultDataTypeFactory' might cause problems with the current database 'H2' (e.g. some datatypes may not be supported properly). In rare cases you might see this message because the list of supported database products is incomplete (list=[derby]). If so please request a java-class update via the forums.If you are using your own IDataTypeFactory extending DefaultDataTypeFactory, ensure that you override getValidDbProducts() to specify the supported database products.
Hibernate: select contact0_.ID as ID0_, contact0_.BIRTH_DATE as BIRTH2_0_, contact0_.FIRST_NAME as FIRST3_0_, contact0_.LAST_NAME as LAST4_0_ from contact contact0_
06:54:34,978  INFO ction.TransactionalTestExecutionListener: 298 - Rolled back transaction after test execution for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@4fc3c165, testMethod = testFindAll@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]
06:54:34,981  INFO ction.TransactionalTestExecutionListener: 276 - Began transaction (5) for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@4c6007fb, testMethod = testAddContact@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]; transaction manager [org.springframework.orm.jpa.JpaTransactionManager@73ad7e90]; rollback [true]
Hibernate: DELETE FROM CONTACT
06:54:34,986  INFO .springframework.test.jdbc.JdbcTestUtils:  99 - Deleted 1 rows from table CONTACT
Hibernate: insert into contact (ID, BIRTH_DATE, FIRST_NAME, LAST_NAME) values (null, ?, ?, ?)
Hibernate: select contact0_.ID as ID0_, contact0_.BIRTH_DATE as BIRTH2_0_, contact0_.FIRST_NAME as FIRST3_0_, contact0_.LAST_NAME as LAST4_0_ from contact contact0_
06:54:35,005  INFO ction.TransactionalTestExecutionListener: 298 - Rolled back transaction after test execution for test context [DefaultTestContext@3701e6e4 testClass = ContactServiceImplTest, testInstance = edu.hes.e57.demo.controller.ContactServiceImplTest@4c6007fb, testMethod = testAddContact@ContactServiceImplTest, testException = [null], mergedContextConfiguration = [MergedContextConfiguration@65f58c6e testClass = ContactServiceImplTest, locations = '{}', classes = '{class edu.hes.e57.demo.service.ServiceTestConfig}', contextInitializerClasses = '[]', activeProfiles = '{test}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.901 sec
06:54:35,029  INFO ontext.support.GenericApplicationContext: 873 - Closing org.springframework.context.support.GenericApplicationContext@7f416310: startup date [Thu Dec 14 06:54:32 EST 2017]; root of context hierarchy
06:54:35,032  INFO a.LocalContainerEntityManagerFactoryBean: 462 - Closing JPA EntityManagerFactory for persistence unit 'default'

Results :

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

...
```
