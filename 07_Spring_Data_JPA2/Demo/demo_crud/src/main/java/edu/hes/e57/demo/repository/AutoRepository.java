package edu.hes.e57.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hes.e57.demo.domain.Auto;

public interface AutoRepository extends JpaRepository<Auto, Long> {
    List<Auto> findAll();
    Auto saveAndFlush(Auto auto);
}
