package edu.hes.e57.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.hes.e57.demo.domain.Contact;
import edu.hes.e57.demo.domain.ContactRepository;

/**
 * 
 * ContactService interface implementation.
 * To ease remote debugging I replaced one liner return statements with 
 * ones that show in debugger what is returned.
 *
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAll() {
    	List<Contact> list = Lists.newArrayList(contactRepository.findAll());
    	return list;
    }

    @Override
    @Transactional(readOnly=true)
    public Contact findById(Long id) {
    	Contact contact = contactRepository.findOne(id);
    	return contact;
    }

    @Override
    public Contact findByFirstNameAndLastName(String firstName, String lastName) {
    	Contact contact = contactRepository.findByFirstNameAndLastName(firstName, lastName);
    	return contact;
    }

    @Override
    public Contact save(Contact contact) {
    	Contact savedContact = contactRepository.save(contact);
    	return savedContact;
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }
}
