package edu.hes.e57.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Manufacturer;

@Transactional 
@Repository("autoManufacturerDao") //Declares this class as Spring bean. Used in main()
@SuppressWarnings("restriction")
public class AutoManufacturerDaoImpl implements AutoManufacturerDao {
	private static final Log LOG = LogFactory.getLog(AutoManufacturerDaoImpl.class);
	
    private SessionFactory sessionFactory;
	    
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Manufacturer> findAllManufacturers() {
		return sessionFactory.getCurrentSession().createQuery("from Manufacturer c").list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Auto> findAllAutos() {
		return sessionFactory.getCurrentSession().createQuery("from Auto a").list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Drivetrain> findAllDrivetrains() {
		return sessionFactory.getCurrentSession().createQuery("from Drivetrain d").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
