package edu.hes.e57.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;
import edu.hes.e57.demo.domain.Drivetrain;
import edu.hes.e57.demo.domain.Auto_;
import edu.hes.e57.demo.domain.Manufacturer_;
import edu.hes.e57.demo.domain.Drivetrain_;

@Service("jpaAutoService")
@Repository
@Transactional
public class autoManufacturerServiceImpl implements AutoManufacturerService {
	private static final Log LOG = LogFactory.getLog(autoManufacturerServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Auto> findByCriteriaQuery(String model) {
		LOG.info("Finding Auto with model: " + model);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Auto> criteriaQuery = cb.createQuery(Auto.class);

		Root<Auto> autoRoot = criteriaQuery.from(Auto.class);

		autoRoot.fetch(Auto_.manufacturer, JoinType.LEFT);
		autoRoot.fetch(Auto_.drivetrains, JoinType.LEFT);

		criteriaQuery.select(autoRoot).distinct(true);

		Predicate criteria = cb.conjunction();

		if (model != null) {
			Predicate p = cb.equal(autoRoot.get(Auto_.model), model);
			criteria = cb.and(criteria, p);
		}

		criteriaQuery.where(criteria);

		return em.createQuery(criteriaQuery).getResultList();
	}
}
