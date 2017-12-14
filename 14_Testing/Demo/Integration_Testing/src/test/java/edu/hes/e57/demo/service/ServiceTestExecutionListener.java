package edu.hes.e57.demo.service;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import edu.hes.e57.demo.DataSets;

/**
    In the spring-test module, the org.springframework.test.context.TestExecutionListener interface
    defines a listener API that can intercept the events in the various phases of the test case execution
     (for example, before and after the class under test, before and after the method under test, and so on). 
     In testing the service layer, we will implement a custom listener for the newly introduced @DataSets annotation. 
     The objective is to support the population of test data with a simple annotation on the test case. 
     For example, to test the ContactService.findAll() method, we would like to have the code look like the code 
     snippet in ContactServiceImplTest.testFindAll() method.


	This is the custom test listener class. We are interested only in the 
	methods beforeTestMethod() and afterTestMethod(), in which the population 
	and cleanup of the testing data before and after the execution of each test 
	method will be performed. 
	Note that within each method, Spring will pass in an instance of the 
	TestContext class so the method can access the underlying testing 
	ApplicationContext bootstrapped by the Spring Framework.
*/
public class ServiceTestExecutionListener implements TestExecutionListener {
    private IDatabaseTester databaseTester;

    @Override
    public void afterTestClass(TestContext arg0) throws Exception {
    }

	
    //In the afterTestMethod() method, the IDatabaseTester.onTearDown() method 
	//is called to clean up the data.
    @Override
    public void afterTestMethod(TestContext arg0) throws Exception {
        if (databaseTester != null) {
            databaseTester.onTearDown();
        }
    }

    @Override
    public void beforeTestClass(TestContext arg0) throws Exception {
    }

	/*
	   The method beforeTestMethod() is of particular interest. First, it checks 
	   for the existence of the @DataSets annotation for the test method. 
	   If the annotation exists, the test data will be loaded from the specified Excel file.
	   In this case, the IDatabaseTester interface (with the implementation class 
	   org.dbunit.DataSourceDatabaseTester) is obtained from the TestContext. 
	   The IDatabaseTester interface is provided by DbUnit and supports database 
	   operations based on a given database connection or data source.
	   Second, an instance of the XlsDataFileLoader class is obtained from 
	   TestContext. The XlsDataFileLoader class is DbUnit’s support of loading 
	   data from the Excel file. It uses the Apache POI library behind the scenes 
	   for reading files in Microsoft Office format. 
	   Then, the XlsDataFileLoader.load() method is called to load the data from 
	   the file, which returns an instance of the IDataSet interface, representing 
	   the set of data loaded.
	   Finally, the IDatabaseTester.setDataSet() is called to set the testing data, 
	   and the IDatabaseTester.onSetup() method is called to trigger the population 
	   of data.
	*/
    @Override
    public void beforeTestMethod(TestContext testCtx) throws Exception {
        DataSets dataSetAnnotation = testCtx.getTestMethod().getAnnotation(DataSets.class);

        if (dataSetAnnotation == null ) {
            return;
        }

        String dataSetName = dataSetAnnotation.setUpDataSet();

        if (!dataSetName.equals("") ) {
            databaseTester = (IDatabaseTester)
                    testCtx.getApplicationContext().getBean("databaseTester");
            XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader)
                    testCtx.getApplicationContext().getBean("xlsDataFileLoader");
            IDataSet dataSet = xlsDataFileLoader.load(dataSetName);

            //Sets the test dataset to use.
            databaseTester.setDataSet(dataSet);

            //Trigger the population of data.
            databaseTester.onSetup();
        }
    }

    @Override
    public void prepareTestInstance(TestContext arg0) throws Exception {
    }
}
