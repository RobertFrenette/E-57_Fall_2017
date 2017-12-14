package edu.hes.e57.demo.repository;

import org.springframework.data.repository.CrudRepository;

import edu.hes.e57.demo.domain.Auto;

public interface AutoRepository extends CrudRepository<Auto, Long> {
}
