package edu.hes.e57.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.hes.e57.demo.DataSets;
import edu.hes.e57.demo.domain.Contact;
import edu.hes.e57.demo.service.ContactService;
import edu.hes.e57.demo.service.ServiceTestConfig;
import edu.hes.e57.demo.service.ServiceTestExecutionListener;
/**
This is the test class with test cases for the two finder methods.
When a class is annotated with @RunWith JUnit will invoke the class it references to run 
the tests in that class instead of the runner built into JUnit. 
The @ContextConfiguration specifies that the ApplicationContext configuration should be 
loaded from the ServiceTestConfig class.
The @TestExecutionListeners annotation indicates that the ServiceTestExecutionListener class 
should be used for intercepting the test case execution life cycle. 
The @ActiveProfiles annotation specifies the profile to use. So, in this case, the dataSource 
bean defined in the ServiceTestConfig class will be loaded, instead of the one defined in the 
datasource-tx-jpa.xml file, since it belongs to the dev profile.
In addition, the class extends Spring’s AbstractTransactionalJUnit4SpringContextTests class, which is Spring’s support for JUnit, 
with Spring’s DI and transaction management mechanism in place. Note that in Spring’s testing environment, Spring will roll back 
the transaction upon execution of each test method so that all database update operations will be rolled back. To control the rollback
 behavior, you can use the @Rollback annotation at the method level.
There is one test case for the findAll() method and two test cases for the testFindByFirstNameAndLastName() method 
(one retrieves a result and one doesn’t). All the finder methods are applied with the @DataSets annotation with 
the contact test data file in Excel.
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class}) 
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class ContactServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	//the ContactService is autowired into the test case from ApplicationContext
    @Autowired
    ContactService contactService;

    @PersistenceContext
    private EntityManager em;

	//@DataSets annotation indicates that before running the test, testing data needs to be 
    //loaded into the database from the specified Excel file
    @DataSets(setUpDataSet= "/edu/hes/e57/demo/ContactServiceImplTest.xls")
    @Test
    public void testFindAll() throws Exception {
        List<Contact> result = contactService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
    }
    
    //This method asserts that the Contact exist.
    @DataSets(setUpDataSet="/edu/hes/e57/demo/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_1() throws Exception {
        Contact result = contactService.findByFirstNameAndLastName("Chris", "Schaefer");
        assertNotNull(result);
    }

    ////This method asserts that the Contact does not exist.
    @DataSets(setUpDataSet="/edu/hes/e57/demo/ContactServiceImplTest.xls")
    @Test
    public void testFindByFirstNameAndLastName_2() throws Exception {
        Contact result = contactService.findByFirstNameAndLastName("Peter", "Chan");
        assertNull(result);
    }
 
    /* This is a normal scenario tests. To ensure that no data exists in the CONTACT table, 
	  we call the convenient method deleteFromTables() provided by the 
	  AbstractTransactionalJUnit4SpringContextTests class to clean up the table.
	  Note that after calling the save operation, we need to explicitly call the EntityManager.flush() 
	  method to force Hibernate to flush the persistence context to the database so that the findAll() 
	  method can retrieve the information from the database correctly.
	*/
    @Test
    public void testAddContact() throws Exception {
        deleteFromTables("CONTACT");

        Contact contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");

        contactService.save(contact);
        em.flush();

        List<Contact> contacts = contactService.findAll();
        assertEquals(1, contacts.size());
    }
    
	/*
	    Here we test the save operation of a contact with a validation error. Note that in the 
		@Test annotation, an expected attribute is passed, which specifies that this test case 
		is expected to throw an exception with the specified type, which in this case is 
		the ConstraintViolationException class.
	*/
    @Test(expected=ConstraintViolationException.class)
    public void testAddContactWithJSR349Error() throws Exception {
        deleteFromTables("CONTACT");

        Contact contact = new Contact();

        contactService.save(contact);
        em.flush();

        List<Contact> contacts = contactService.findAll();
        assertEquals(0, contacts.size());
    }
}
