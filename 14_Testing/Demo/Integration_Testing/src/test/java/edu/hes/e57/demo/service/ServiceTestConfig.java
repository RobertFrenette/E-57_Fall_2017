package edu.hes.e57.demo.service;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
This is the configuration class for the testing environment, using JavaConfig style 
configuration. 
It defines  the ApplicationContext  for service-layer testing.

*/
@Configuration
//The XML configuration file datasource-tx-jpa.xml is imported, which defines 
//the transaction and JPA configuration that is reusable for testing.
@ImportResource("classpath:META-INF/spring/datasource-tx-jpa.xml")
//The @ComponentScan annotation is applied to instruct Spring to scan 
//the service-layer beans that we want to test. 
@ComponentScan(basePackages={"edu.hes.e57.demo"})
//The @Profile annotation specifies that the beans defined in this class belong to the test profile.
@Profile("test")
public class ServiceTestConfig {

    //Another dataSource bean "ds" is declared that executes only the schema.sql 
    //script to the H2 database without any data
    @Bean
    public DataSource dataSource() {
    	DataSource ds;
    	ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
    			.addScript("classpath:META-INF/config/schema.sql").build();
    	return ds;
       // return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
       //         .addScript("classpath:META-INF/config/schema.sql").build();
    }

    //In next two methods, the custom test execution listener for loading test data 
    //from the Excel file uses the databaseTester and xlsDataFileLoader beans. 
    //Note that the dataSourceDatabaseTester bean was constructed using the dataSource "ds" 
    //bean defined for the testing environment.
    @Bean(name="databaseTester")
    public DataSourceDatabaseTester dataSourceDatabaseTester() {
        DataSourceDatabaseTester databaseTester =
                new DataSourceDatabaseTester(dataSource());
        return databaseTester;
    }

    @Bean(name="xlsDataFileLoader")
    public XlsDataFileLoader xlsDataFileLoader() {
    	XlsDataFileLoader xlsDataFileLoader = new XlsDataFileLoader();
    	return xlsDataFileLoader;
      //  return new XlsDataFileLoader();
    }
}
