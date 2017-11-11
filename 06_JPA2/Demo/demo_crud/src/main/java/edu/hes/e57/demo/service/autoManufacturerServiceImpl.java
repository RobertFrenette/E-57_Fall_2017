package edu.hes.e57.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;
 
@Service("jpaAutoService")
@Repository
@Transactional
public class autoManufacturerServiceImpl implements AutoManufacturerService {
	private static final Log LOG = LogFactory.getLog(autoManufacturerServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	 
	@Transactional(readOnly=true)
	public List<Auto> findAllAutos() {
		List<Auto> autos = em.createNamedQuery("Auto.findAllAutos", Auto.class).getResultList();
		return autos;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Auto findAutoWithDrivetrainsAndManufacturerByAutoId(Long id) {
		TypedQuery<Auto> query = em.createNamedQuery("Auto.findAutoWithDrivetrainsAndManufacturerByAutoId", Auto.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	@Override
	public Auto save(Auto auto) {
        if (auto.getId() == null) {
            em.persist(auto);
        } else {
        	 	em.merge(auto);
        }
        return auto;
	}
	
	@Override
	public void delete(Auto auto) {
        Auto mergedAuto = em.merge(auto);
        em.remove(mergedAuto);
	}
}
