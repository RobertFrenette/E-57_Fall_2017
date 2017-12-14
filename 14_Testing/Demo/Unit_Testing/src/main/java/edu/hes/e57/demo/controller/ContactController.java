package edu.hes.e57.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hes.e57.demo.domain.Contact;
import edu.hes.e57.demo.domain.Contacts;
import edu.hes.e57.demo.service.ContactService;

@Controller
@RequestMapping(value="/contact")
public class ContactController {
    final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Contacts listData() {
    	List<Contact> contactList = contactService.findAll();
    	for (Contact contact: contactList) {
    		logger.info("Found contact: " + contact);
    	}
        return new Contacts(contactList);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Contact findContactById(@PathVariable Long id) {
    	Contact contact = contactService.findById(id);
    	logger.info("By id = " + id + " found contact: " + contact);
    	return contact;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        logger.info("Creating contact: " + contact);
        contactService.save(contact);
        logger.info("Contact created successfully with info: " + contact);
        return contact;
    }

    @RequestMapping(method=RequestMethod.PUT)
    @ResponseBody
    public Contact update(@RequestBody Contact updatedContact) {
        logger.info("Updating contact: " + updatedContact);
        contactService.save(updatedContact);
        logger.info("Contact updated successfully with info: " + updatedContact);
        return updatedContact;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        logger.info("Deleting contact with id: " + id);
        Contact contact = contactService.findById(id);
        contactService.delete(contact);
        logger.info("Contact deleted successfully");
    }
}
