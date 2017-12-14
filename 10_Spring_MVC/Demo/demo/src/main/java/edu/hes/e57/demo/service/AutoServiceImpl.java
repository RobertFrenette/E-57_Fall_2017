package edu.hes.e57.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.repository.AutoRepository;

@Repository
@Transactional
@Service("autoService")
public class AutoServiceImpl implements AutoService {
    private AutoRepository autoRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Auto> findAll() {
        return Lists.newArrayList(autoRepository.findAll());
    }

    @Autowired
    public void setAutoRepository(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }
}
