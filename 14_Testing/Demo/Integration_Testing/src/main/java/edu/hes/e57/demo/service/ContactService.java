package edu.hes.e57.demo.service;

import java.util.List;

import edu.hes.e57.demo.domain.Contact;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact findByFirstNameAndLastName(String firstName, String lastName);
    Contact save(Contact contact);
    void delete(Contact contact);
}
