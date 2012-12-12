package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.EmployeesDao;
import com.aaronhible.model.Employees;

/**
 * Home object for domain model class Employees.
 * 
 * @see com.aaronhible.model.Employees
 * @author Hibernate Tools
 */
public class EmployeesDaoImpl implements EmployeesDao {

	private static final Log log = LogFactory.getLog(EmployeesDaoImpl.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#persist(com.aaronhible.model.Employees)
	 */
	@Override
	public void persist(Employees transientInstance) {
		log.debug("persisting Employees instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#attachDirty(com.aaronhible.model.Employees)
	 */
	@Override
	public void attachDirty(Employees instance) {
		log.debug("attaching dirty Employees instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#attachClean(com.aaronhible.model.Employees)
	 */
	@Override
	public void attachClean(Employees instance) {
		log.debug("attaching clean Employees instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#delete(com.aaronhible.model.Employees)
	 */
	@Override
	public void delete(Employees persistentInstance) {
		log.debug("deleting Employees instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#merge(com.aaronhible.model.Employees)
	 */
	@Override
	public Employees merge(Employees detachedInstance) {
		log.debug("merging Employees instance");
		try {
			Employees result = (Employees) sessionFactory.getCurrentSession()
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
	public Employees findById(int id) {
		log.debug("getting Employees instance with id: " + id);
		try {
			Employees instance = (Employees) sessionFactory.getCurrentSession()
					.get("com.aaronhible.model.Employees", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.EmployeesDao#findByExample(com.aaronhible.model.Employees)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Employees> findByExample(Employees instance) {
		log.debug("finding Employees instance by example");
		try {
			List<Employees> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Employees")
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
