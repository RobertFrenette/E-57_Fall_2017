package edu.hes.e57.demo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.AutoRepository;
 
@Service("autoService")
@Repository
@Transactional
public class AutoServiceImpl implements AutoService {
    private AutoRepository autoRepository;
    
	private static final Log LOG = LogFactory.getLog(AutoServiceImpl.class);

    @Override
    @Transactional(readOnly=true)
    public List<Auto> findAll() {
        return Lists.newArrayList(autoRepository.findAll());
    }
    
    @Override
    @Transactional(propagation = Propagation.NEVER)
    public long countAll() {
        return autoRepository.countAllAutos();
    }
    
    @Autowired
    public void setAutoRepository(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }
}
