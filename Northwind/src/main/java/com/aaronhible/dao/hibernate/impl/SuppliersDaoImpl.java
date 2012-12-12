package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.SuppliersDao;
import com.aaronhible.model.Suppliers;

/**
 * Home object for domain model class Suppliers.
 * 
 * @see com.aaronhible.model.Suppliers
 * @author Hibernate Tools
 */
public class SuppliersDaoImpl implements SuppliersDao {

	private static final Log log = LogFactory.getLog(SuppliersDaoImpl.class);

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
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#persist(com.aaronhible.model.Suppliers)
	 */
	@Override
	public void persist(Suppliers transientInstance) {
		log.debug("persisting Suppliers instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#attachDirty(com.aaronhible.model.Suppliers)
	 */
	@Override
	public void attachDirty(Suppliers instance) {
		log.debug("attaching dirty Suppliers instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#attachClean(com.aaronhible.model.Suppliers)
	 */
	@Override
	public void attachClean(Suppliers instance) {
		log.debug("attaching clean Suppliers instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#delete(com.aaronhible.model.Suppliers)
	 */
	@Override
	public void delete(Suppliers persistentInstance) {
		log.debug("deleting Suppliers instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#merge(com.aaronhible.model.Suppliers)
	 */
	@Override
	public Suppliers merge(Suppliers detachedInstance) {
		log.debug("merging Suppliers instance");
		try {
			Suppliers result = (Suppliers) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#findById(int)
	 */
	@Override
	public Suppliers findById(int id) {
		log.debug("getting Suppliers instance with id: " + id);
		try {
			Suppliers instance = (Suppliers) sessionFactory.getCurrentSession()
					.get("com.aaronhible.model.Suppliers", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#findByExample(com.aaronhible.model.Suppliers)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Suppliers> findByExample(Suppliers instance) {
		log.debug("finding Suppliers instance by example");
		try {
			List<Suppliers> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Suppliers")
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
