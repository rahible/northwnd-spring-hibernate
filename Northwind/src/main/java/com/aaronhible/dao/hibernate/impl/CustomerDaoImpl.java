package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.CustomerDao;
import com.aaronhible.model.Customer;

/**
 * Home object for domain model class Customer.
 * 
 * @see com.aaronhible.model.Customer
 * @author Hibernate Tools
 */
public class CustomerDaoImpl extends AbstractHibernateSessionFactoryDao implements CustomerDao {

	private static final Log log = LogFactory.getLog(CustomerDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#persist(com.aaronhible.model.Customer)
	 */
	@Override
	public void persist(Customer transientInstance) {
		log.debug("persisting Customer instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#attachDirty(com.aaronhible.model.Customer)
	 */
	@Override
	public void attachDirty(Customer instance) {
		log.debug("attaching dirty Customer instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#attachClean(com.aaronhible.model.Customer)
	 */
	@Override
	public void attachClean(Customer instance) {
		log.debug("attaching clean Customer instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#delete(com.aaronhible.model.Customer)
	 */
	@Override
	public void delete(Customer persistentInstance) {
		log.debug("deleting Customer instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#merge(com.aaronhible.model.Customer)
	 */
	@Override
	public Customer merge(Customer detachedInstance) {
		log.debug("merging Customer instance");
		try {
			Customer result = (Customer) getSessionFactory().getCurrentSession()
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
	public Customer findById(java.lang.String id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) getSessionFactory().getCurrentSession()
					.get("com.aaronhible.model.Customer", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.CustomersDao#findByExample(com.aaronhible.model.Customer)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Customer> findByExample(Customer instance) {
		log.debug("finding Customer instance by example");
		try {
			List<Customer> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Customer")
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
