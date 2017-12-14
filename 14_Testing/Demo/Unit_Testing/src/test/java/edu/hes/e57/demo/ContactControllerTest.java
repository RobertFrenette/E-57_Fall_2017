package edu.hes.e57.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import edu.hes.e57.demo.controller.ContactController;
import edu.hes.e57.demo.domain.Contact;
import edu.hes.e57.demo.domain.Contacts;
import edu.hes.e57.demo.service.ContactService;

public class ContactControllerTest {
    private final List<Contact> contacts = new ArrayList<Contact>();
    private final long testId = 1l;
    private Contact contact;
    private Contact newContact;

	/* This method, which is applied with the @Before annotation, indicates to JUnit that the method  	 
	   should be run before running each test case. In the method, a list of contacts is initialized with 
       hard-coded information.
	*/
    @Before
    public void initContacts() {
        contact = new Contact();
        contact.setId(1l);
        contact.setVersion(1);
        contact.setFirstName("Chris");
        contact.setLastName("Schaefer");
		contact.setBirthDate(new DateTime(1987, 3, 26, 12, 0, 0, 0));
        contacts.add(contact);
    }
    
	/* This method is decorated with the @Test annotation, which indicates to JUnit that it’s a test 
       case  that JUnit should run.
	*/
    @Test
    public void testList() throws Exception {
		// the private variable contactService (of type ContactService) is mocked 
		// by using Mockito.mock() method (note the import static statement). 
        ContactService contactService = mock(ContactService.class);
		
		//The when() method is also provided by Mockito to mock the ContactService.findAll() method, 
        //which will be used by the ContactController class.
        when(contactService.findAll()).thenReturn(contacts);

		//An instance of the ContactController class is created
        ContactController contactController = new ContactController();

		/* The ContactController "contactService" variable (which will be injected by Spring in normal situations) 
		 * is set with the mocked instance by using the Spring-provided ReflectionTestUtils class’s setField() method. 
         * This method sets the contactController's field "contactService" with the mocked contactService instance.
		 */
        ReflectionTestUtils.setField(contactController, "contactService", contactService);

		// An instance of the ExtendedModelMap class (which implements the org.springframework.ui.Model 
        // interface) is constructed. This class is a Subclass of ModelMap that implements the Model interface.
        //ModelMap is an implementation of Map for use when building model data for use with UI tools. 
        ExtendedModelMap uiModel = new ExtendedModelMap();
		
		//The ContactController.listData() method is called and the return value is the value of the 
		//"contacts" key uiModel attribute.
        uiModel.addAttribute("contacts", contactController.listData());

		//uiModel "contacts" key value is returned
        Contacts modelContacts = (Contacts) uiModel.get("contacts");

		//Assert the size of contact list is 1.
        assertEquals(1, modelContacts.getContacts().size());
        //Do other assertions.
        assertEquals(Long.valueOf(1l), modelContacts.getContacts().get(0).getId());
        assertEquals(1, modelContacts.getContacts().get(0).getVersion());
        assertEquals("Chris", modelContacts.getContacts().get(0).getFirstName());
        assertEquals("Schaefer", modelContacts.getContacts().get(0).getLastName());
    }

    @Test
    public void testCreate() {    
        ContactService contactService = mock(ContactService.class);
        newContact = new Contact();
        newContact.setId(999l);
        newContact.setVersion(1);
        newContact.setFirstName("Rod");
        newContact.setLastName("Johnson");
		newContact.setBirthDate(new DateTime(1968, 11, 2, 11, 0, 0, 0));
		// The ContactService.save() method is mocked to simulate the addition of a new Contact object 
        // in the list of contacts. Note the use of the org.mockito.stubbing.Answer<T> interface, which 
        // mocks the method with the expected logic and returns a value.
        when(contactService.save(newContact)).thenAnswer(new Answer<Contact>() {
            public Contact answer(InvocationOnMock invocation) throws Throwable {
                contacts.add(newContact);
                return newContact;
            }
        });

        ContactController contactController = new ContactController();
		/* The ContactController "contactService" variable is set with the mocked instance by using the  
		Spring-provided ReflectionTestUtils class’s setField() method. */
        ReflectionTestUtils.setField(contactController, "contactService", contactService);

	    // ContactController.create() method is called, and assert operations are invoked to verify the 
        //result. Run the result again, and note the test case results.
        Contact contact = contactController.create(newContact);
        assertEquals(Long.valueOf(999l), contact.getId());
        assertEquals(1, contact.getVersion());
        assertEquals("Rod", contact.getFirstName());
        assertEquals("Johnson", contact.getLastName());

        assertEquals(2, contacts.size());
    }
    
    @Test
    public void testFindContactById() throws Exception {
		// the private variable contactService (of type ContactService) is mocked 
		// by using Mockito.mock() method (note the import static statement). 
        ContactService contactService = mock(ContactService.class);
		
		//The when() method is also provided by Mockito to mock the ContactService.findById() method, 
        //which will be used by the ContactController class.
        when(contactService.findById(testId)).thenReturn(contact);

		//An instance of the ContactController class is created
        ContactController contactController = new ContactController();

		/* The ContactController "contactService" variable (which will be injected by Spring in normal situations) 
		 * is set with the mocked instance by using the Spring-provided ReflectionTestUtils class’s setField() method. 
		 */
        ReflectionTestUtils.setField(contactController, "contactService", contactService);

		// An instance of the ExtendedModelMap class (which implements the org.springframework.ui.Model 
        // interface) is constructed.
        ExtendedModelMap uiModel = new ExtendedModelMap();
		
		//The ContactController.findContactById() method is called and the return value is the value of the 
		//"contact" key uiModel attribute.
        uiModel.addAttribute("contact", contactController.findContactById(testId));

		//uiModel "contact" key value is returned
        Contact modelContact = (Contact) uiModel.get("contact");
	    
        assertEquals(Long.valueOf(1l), modelContact.getId());
        assertEquals(1, modelContact.getVersion());
        assertEquals("Chris", modelContact.getFirstName());
        assertEquals("Schaefer", modelContact.getLastName());
    }
    
    @Test
    public void testUpdate() {
        contact.setVersion(2);
        ContactService contactService = mock(ContactService.class);

		// The ContactService.save() method is mocked to simulate the setting of an updated Contact object 
        // in the list of contacts. Note the use of the org.mockito.stubbing.Answer<T> interface, which 
        // mocks the method with the expected logic and returns a value.
        when(contactService.save(contact)).thenAnswer(new Answer<Contact>() {
            public Contact answer(InvocationOnMock invocation) throws Throwable {
                contacts.set(0, contact);
                return contact;
            }
        });

        ContactController contactController = new ContactController();
		/* The ContactController "contactService" variable is set with the mocked instance by using the  
		Spring-provided ReflectionTestUtils class’s setField() method. */
        ReflectionTestUtils.setField(contactController, "contactService",
                contactService);

	    // ContactController.update() method is called, and assert operations are invoked to verify the 
        //result. Run the result again, and note the test case results.
        Contact updatedContact = contactController.update(contact);
        assertEquals(2, updatedContact.getVersion());
    }
    
    @Test
    public void testDelete() {
        ContactService contactService = mock(ContactService.class);
        
        when(contactService.findById(1l)).thenReturn(contact);

		// The ContactService.delete() method is mocked to simulate the setting of delete Contact object 
        // in the list of contacts. Note the use of the org.mockito.stubbing.Answer<T> interface, which 
        // mocks the method with the expected logic and returns a value.
        when(contactService.delete(contact)).thenAnswer(new Answer<Contact>() {
            public Contact answer(InvocationOnMock invocation) throws Throwable {
                contacts.remove(0);
                return newContact;
            }
        });

        ContactController contactController = new ContactController();
        
		/* The ContactController "contactService" variable is set with the mocked instance by using the  
		Spring-provided ReflectionTestUtils class’s setField() method. */
        ReflectionTestUtils.setField(contactController, "contactService",
                contactService);

	    // ContactController.delete() method is called, and assert operations are invoked to verify the 
        //result.
        contactController.delete(1l);
        assertEquals(0, contacts.size());
    }
}
