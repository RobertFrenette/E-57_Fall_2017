package edu.hes.e57.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.hes.e57.demo.domain.Auto;

public interface AutoRepository extends PagingAndSortingRepository<Auto, Long> {
}
