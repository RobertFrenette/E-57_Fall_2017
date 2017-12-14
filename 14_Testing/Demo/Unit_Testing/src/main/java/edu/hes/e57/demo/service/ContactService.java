package edu.hes.e57.demo.service;

import java.util.List;

import edu.hes.e57.demo.domain.Contact;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    Contact delete(Contact contact);
}
