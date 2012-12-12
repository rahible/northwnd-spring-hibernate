package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.CustomersDao;
import com.aaronhible.model.Customers;

/**
 * Home object for domain model class Customers.
 * 
 * @see com.aaronhible.model.Customers
 * @author Hibernate Tools
 */
public class CustomersDaoImpl implements CustomersDao {

	private static final Log log = LogFactory.getLog(CustomersDaoImpl.class);

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
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#persist(com.aaronhible.model.Customers)
	 */
	@Override
	public void persist(Customers transientInstance) {
		log.debug("persisting Customers instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#attachDirty(com.aaronhible.model.Customers)
	 */
	@Override
	public void attachDirty(Customers instance) {
		log.debug("attaching dirty Customers instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#attachClean(com.aaronhible.model.Customers)
	 */
	@Override
	public void attachClean(Customers instance) {
		log.debug("attaching clean Customers instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#delete(com.aaronhible.model.Customers)
	 */
	@Override
	public void delete(Customers persistentInstance) {
		log.debug("deleting Customers instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#merge(com.aaronhible.model.Customers)
	 */
	@Override
	public Customers merge(Customers detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customers result = (Customers) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#findById(java.lang.String)
	 */
	@Override
	public Customers findById(java.lang.String id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customers instance = (Customers) sessionFactory.getCurrentSession()
					.get("com.aaronhible.model.Customers", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#findByExample(com.aaronhible.model.Customers)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Customers> findByExample(Customers instance) {
		log.debug("finding Customers instance by example");
		try {
			List<Customers> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Customers")
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
