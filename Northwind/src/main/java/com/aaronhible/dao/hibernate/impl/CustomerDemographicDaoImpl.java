package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.CustomerDemographicDao;
import com.aaronhible.model.CustomerDemographic;

/**
 * Home object for domain model class CustomerDemographic.
 * 
 * @see com.aaronhible.model.CustomerDemographic
 * @author Hibernate Tools
 */
public class CustomerDemographicDaoImpl extends AbstractHibernateSessionFactoryDao implements CustomerDemographicDao {

	private static final Log log = LogFactory
			.getLog(CustomerDemographicDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#persist(com
	 * .aaronhible.model.CustomerDemographic)
	 */
	@Override
	public void persist(CustomerDemographic transientInstance) {
		log.debug("persisting CustomerDemographic instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
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
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#attachDirty
	 * (com.aaronhible.model.CustomerDemographic)
	 */
	@Override
	public void attachDirty(CustomerDemographic instance) {
		log.debug("attaching dirty CustomerDemographic instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
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
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#attachClean
	 * (com.aaronhible.model.CustomerDemographic)
	 */
	@Override
	public void attachClean(CustomerDemographic instance) {
		log.debug("attaching clean CustomerDemographic instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
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
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#delete(com.
	 * aaronhible.model.CustomerDemographic)
	 */
	@Override
	public void delete(CustomerDemographic persistentInstance) {
		log.debug("deleting CustomerDemographic instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#merge(com.
	 * aaronhible.model.CustomerDemographic)
	 */
	@Override
	public CustomerDemographic merge(CustomerDemographic detachedInstance) {
		log.debug("merging CustomerDemographic instance");
		try {
			CustomerDemographic result = (CustomerDemographic) getSessionFactory()
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
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#findById(java
	 * .lang.String)
	 */
	@Override
	public CustomerDemographic findById(java.lang.String id) {
		log.debug("getting CustomerDemographic instance with id: " + id);
		try {
			CustomerDemographic instance = (CustomerDemographic) getSessionFactory()
					.getCurrentSession().get(
							"com.aaronhible.model.CustomerDemographic", id);
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
	 * com.aaronhible.dao.hibernate.impl.CustomerDemographicDao#findByExample
	 * (com.aaronhible.model.CustomerDemographic)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<CustomerDemographic> findByExample(
			CustomerDemographic instance) {
		log.debug("finding CustomerDemographic instance by example");
		try {
			List<CustomerDemographic> results = getSessionFactory()
					.getCurrentSession()
					.createCriteria("com.aaronhible.model.CustomerDemographic")
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
