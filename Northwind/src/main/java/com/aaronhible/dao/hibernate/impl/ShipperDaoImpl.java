package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.ShipperDao;
import com.aaronhible.model.Shipper;

/**
 * Home object for domain model class Shipper.
 * 
 * @see com.aaronhible.model.Shipper
 * @author Hibernate Tools
 */
public class ShipperDaoImpl extends AbstractHibernateSessionFactoryDao implements ShipperDao {

	private static final Log log = LogFactory.getLog(ShipperDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#persist(com.aaronhible.model.Shipper)
	 */
	@Override
	public void persist(Shipper transientInstance) {
		log.debug("persisting Shipper instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#attachDirty(com.aaronhible.model.Shipper)
	 */
	@Override
	public void attachDirty(Shipper instance) {
		log.debug("attaching dirty Shipper instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#attachClean(com.aaronhible.model.Shipper)
	 */
	@Override
	public void attachClean(Shipper instance) {
		log.debug("attaching clean Shipper instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#delete(com.aaronhible.model.Shipper)
	 */
	@Override
	public void delete(Shipper persistentInstance) {
		log.debug("deleting Shipper instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#merge(com.aaronhible.model.Shipper)
	 */
	@Override
	public Shipper merge(Shipper detachedInstance) {
		log.debug("merging Shipper instance");
		try {
			Shipper result = (Shipper) getSessionFactory().getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#findById(int)
	 */
	@Override
	public Shipper findById(int id) {
		log.debug("getting Shipper instance with id: " + id);
		try {
			Shipper instance = (Shipper) getSessionFactory().getCurrentSession()
					.get("com.aaronhible.model.Shipper", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#findByExample(com.aaronhible.model.Shipper)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Shipper> findByExample(Shipper instance) {
		log.debug("finding Shipper instance by example");
		try {
			List<Shipper> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Shipper")
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
