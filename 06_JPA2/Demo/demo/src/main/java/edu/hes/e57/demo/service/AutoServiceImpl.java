package edu.hes.e57.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;
 
@Service("jpaAutoService")
@Repository
@Transactional
public class AutoServiceImpl implements AutoService {
	final static String ALL_DRIVETRAIN_NATIVE_QUERY = "select ID, TRANSMISSION, ENGINE_DISPLACEMENT from DRIVETRAIN";
	final static String ALL_AUTO_NATIVE_QUERY = "select ID, MANUFACTURER_ID, MODEL, YEAR, MSRP, VERSION from AUTO";
	
	private static final Log LOG = LogFactory.getLog(AutoServiceImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	    
	@Transactional(readOnly = true)
	@Override
	public List<Manufacturer> findAllManufacturers() {
		List<Manufacturer> manufacturers = em.createNamedQuery("Manufacturer.findAllManufacturers", Manufacturer.class).getResultList();
		return manufacturers;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Drivetrain> findAllDrivetrainsByNativeSimpleQuery() {
		return em.createNativeQuery(ALL_DRIVETRAIN_NATIVE_QUERY, Drivetrain.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Auto> findAllAutosByNativeResultSetMapping() {
		return em.createNativeQuery(ALL_AUTO_NATIVE_QUERY, "autoResult").getResultList();
	}
}
