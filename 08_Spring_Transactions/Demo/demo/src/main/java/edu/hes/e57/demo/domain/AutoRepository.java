package edu.hes.e57.demo.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {
	    @Query("select count(a) from Auto a")
	    Long countAllAutos();
}
