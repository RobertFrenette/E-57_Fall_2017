package edu.hes.e57.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.hes.e57.demo.domain.Auto;

public interface AutoService {
    List<Auto> findAll();
    Auto findById(Long id);
    Auto save(Auto auto);
    Page<Auto> findAllByPage(Pageable pageable);
}
