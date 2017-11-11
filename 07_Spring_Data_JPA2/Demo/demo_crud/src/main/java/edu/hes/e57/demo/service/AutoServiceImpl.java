package edu.hes.e57.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.hes.e57.demo.app.AutoManufacturerSpringDataApp;
import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;
import edu.hes.e57.demo.repository.AutoRepository;
 
@Service("springDataAutoService")
@Repository
@Transactional
public class AutoServiceImpl implements AutoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoServiceImpl.class);
	
	@Autowired
	private AutoRepository autoRepository;
	
	@PersistenceContext
	private EntityManager em;
    
	private static final Log LOG = LogFactory.getLog(AutoServiceImpl.class);

	@Transactional(readOnly=true)
	public List<Auto> findAll() {
		return Lists.newArrayList(autoRepository.findAll());
	}

    @Override
	public Auto save(Auto auto) {
    	Auto savedAuto = autoRepository.saveAndFlush(auto);

   	 List<Auto> autos = this.findAll();
   	 listAllAutos(autos);
   	 
   	 return savedAuto;
	}
    
	private static void listAllAutos(List<Auto> autos) {
        LOGGER.info("List all Autos AFTER Insert...");
		for (Auto auto : autos) {
			LOGGER.info(auto.toString());

			if (auto.getManufacturer() != null) {
				LOGGER.info(auto.getManufacturer().toString());
			}
			LOGGER.info("");
		}
	}
}
