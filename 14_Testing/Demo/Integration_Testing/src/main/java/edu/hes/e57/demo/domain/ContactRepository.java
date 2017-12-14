package edu.hes.e57.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Contact findByFirstNameAndLastName(String firstName, String lastName);
}
