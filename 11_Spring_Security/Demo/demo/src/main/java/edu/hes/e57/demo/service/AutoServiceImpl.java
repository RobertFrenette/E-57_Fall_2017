package edu.hes.e57.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    @Transactional(readOnly=true)
    public Auto findById(Long id) {
        return autoRepository.findOne(id);
    }

    @Override
    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    @Autowired
    public void setAutoRepository(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Page<Auto> findAllByPage(Pageable pageable) {
        return autoRepository.findAll(pageable);
    }
}
