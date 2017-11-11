package edu.hes.e57.demo.service;

import java.util.List;

import edu.hes.e57.demo.domain.Auto;

public interface AutoService {
    List<Auto> findAll();
    List<Auto> findByModel(String name);
}