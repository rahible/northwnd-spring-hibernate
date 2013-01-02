package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.EmployeeDao;
import com.aaronhible.model.Employee;

/**
 * Home object for domain model class Employee.
 * 
 * @see com.aaronhible.model.Employee
 * @author Hibernate Tools
 */
public class EmployeeDaoImpl extends AbstractHibernateSessionFactoryDao implements EmployeeDao {

	private static final Log log = LogFactory.getLog(EmployeeDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#persist(com.aaronhible.model.Employee)
	 */
	@Override
	public void persist(Employee transientInstance) {
		log.debug("persisting Employee instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#attachDirty(com.aaronhible.model.Employee)
	 */
	@Override
	public void attachDirty(Employee instance) {
		log.debug("attaching dirty Employee instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#attachClean(com.aaronhible.model.Employee)
	 */
	@Override
	public void attachClean(Employee instance) {
		log.debug("attaching clean Employee instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#delete(com.aaronhible.model.Employee)
	 */
	@Override
	public void delete(Employee persistentInstance) {
		log.debug("deleting Employee instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#merge(com.aaronhible.model.Employee)
	 */
	@Override
	public Employee merge(Employee detachedInstance) {
		log.debug("merging Employee instance");
		try {
			Employee result = (Employee) getSessionFactory().getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#findById(int)
	 */
	@Override
	public Employee findById(int id) {
		log.debug("getting Employee instance with id: " + id);
		try {
			Employee instance = (Employee) getSessionFactory().getCurrentSession()
					.get("com.aaronhible.model.Employee", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#findByExample(com.aaronhible.model.Employee)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Employee> findByExample(Employee instance) {
		log.debug("finding Employee instance by example");
		try {
			List<Employee> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Employee")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
