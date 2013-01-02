package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.SupplierDao;
import com.aaronhible.model.Supplier;

/**
 * Home object for domain model class Supplier.
 * 
 * @see com.aaronhible.model.Supplier
 * @author Hibernate Tools
 */
public class SupplierDaoImpl extends AbstractHibernateSessionFactoryDao implements SupplierDao {

	private static final Log log = LogFactory.getLog(SupplierDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#persist(com.aaronhible.model.Supplier)
	 */
	@Override
	public void persist(Supplier transientInstance) {
		log.debug("persisting Supplier instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#attachDirty(com.aaronhible.model.Supplier)
	 */
	@Override
	public void attachDirty(Supplier instance) {
		log.debug("attaching dirty Supplier instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#attachClean(com.aaronhible.model.Supplier)
	 */
	@Override
	public void attachClean(Supplier instance) {
		log.debug("attaching clean Supplier instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#delete(com.aaronhible.model.Supplier)
	 */
	@Override
	public void delete(Supplier persistentInstance) {
		log.debug("deleting Supplier instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#merge(com.aaronhible.model.Supplier)
	 */
	@Override
	public Supplier merge(Supplier detachedInstance) {
		log.debug("merging Supplier instance");
		try {
			Supplier result = (Supplier) getSessionFactory().getCurrentSession()
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
	public Supplier findById(int id) {
		log.debug("getting Supplier instance with id: " + id);
		try {
			Supplier instance = (Supplier) getSessionFactory().getCurrentSession()
					.get("com.aaronhible.model.Supplier", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.SuppliersDao#findByExample(com.aaronhible.model.Supplier)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Supplier> findByExample(Supplier instance) {
		log.debug("finding Supplier instance by example");
		try {
			List<Supplier> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Supplier")
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
