package edu.hes.e57.demo.service;

import java.util.List;
import com.google.common.collect.Lists;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.AutoRepository;
 
@Service("springDataAutoService")
@Repository
@Transactional
public class AutoServiceImpl implements AutoService {
    @Autowired
    private AutoRepository autoRepository;
    
	private static final Log LOG = LogFactory.getLog(AutoServiceImpl.class);

    @Transactional(readOnly=true)
    public List<Auto> findAll() {
        return Lists.newArrayList(autoRepository.findAll());
    }

    @Transactional(readOnly=true)
    public List<Auto> findByModel(String model) {
        return autoRepository.findByModel(model);
    }
}
