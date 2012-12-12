package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.CustomerDemographicsDao;
import com.aaronhible.model.CustomerDemographics;

/**
 * Home object for domain model class CustomerDemographics.
 * 
 * @see com.aaronhible.model.CustomerDemographics
 * @author Hibernate Tools
 */
public class CustomerDemographicsDaoImpl implements CustomerDemographicsDao {

	private static final Log log = LogFactory
			.getLog(CustomerDemographicsDaoImpl.class);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#persist(com
	 * .aaronhible.model.CustomerDemographics)
	 */
	@Override
	public void persist(CustomerDemographics transientInstance) {
		log.debug("persisting CustomerDemographics instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#attachDirty
	 * (com.aaronhible.model.CustomerDemographics)
	 */
	@Override
	public void attachDirty(CustomerDemographics instance) {
		log.debug("attaching dirty CustomerDemographics instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#attachClean
	 * (com.aaronhible.model.CustomerDemographics)
	 */
	@Override
	public void attachClean(CustomerDemographics instance) {
		log.debug("attaching clean CustomerDemographics instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#delete(com.
	 * aaronhible.model.CustomerDemographics)
	 */
	@Override
	public void delete(CustomerDemographics persistentInstance) {
		log.debug("deleting CustomerDemographics instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#merge(com.
	 * aaronhible.model.CustomerDemographics)
	 */
	@Override
	public CustomerDemographics merge(CustomerDemographics detachedInstance) {
		log.debug("merging CustomerDemographics instance");
		try {
			CustomerDemographics result = (CustomerDemographics) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#findById(java
	 * .lang.String)
	 */
	@Override
	public CustomerDemographics findById(java.lang.String id) {
		log.debug("getting CustomerDemographics instance with id: " + id);
		try {
			CustomerDemographics instance = (CustomerDemographics) sessionFactory
					.getCurrentSession().get(
							"com.aaronhible.model.CustomerDemographics", id);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicsDao#findByExample
	 * (com.aaronhible.model.CustomerDemographics)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<CustomerDemographics> findByExample(
			CustomerDemographics instance) {
		log.debug("finding CustomerDemographics instance by example");
		try {
			List<CustomerDemographics> results = sessionFactory
					.getCurrentSession()
					.createCriteria("com.aaronhible.model.CustomerDemographics")
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
