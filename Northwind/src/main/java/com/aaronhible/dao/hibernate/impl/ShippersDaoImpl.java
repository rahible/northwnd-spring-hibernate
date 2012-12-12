package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.ShippersDao;
import com.aaronhible.model.Shippers;

/**
 * Home object for domain model class Shippers.
 * 
 * @see com.aaronhible.model.Shippers
 * @author Hibernate Tools
 */
public class ShippersDaoImpl implements ShippersDao {

	private static final Log log = LogFactory.getLog(ShippersDaoImpl.class);

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
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#persist(com.aaronhible.model.Shippers)
	 */
	@Override
	public void persist(Shippers transientInstance) {
		log.debug("persisting Shippers instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#attachDirty(com.aaronhible.model.Shippers)
	 */
	@Override
	public void attachDirty(Shippers instance) {
		log.debug("attaching dirty Shippers instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#attachClean(com.aaronhible.model.Shippers)
	 */
	@Override
	public void attachClean(Shippers instance) {
		log.debug("attaching clean Shippers instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#delete(com.aaronhible.model.Shippers)
	 */
	@Override
	public void delete(Shippers persistentInstance) {
		log.debug("deleting Shippers instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#merge(com.aaronhible.model.Shippers)
	 */
	@Override
	public Shippers merge(Shippers detachedInstance) {
		log.debug("merging Shippers instance");
		try {
			Shippers result = (Shippers) sessionFactory.getCurrentSession()
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
	public Shippers findById(int id) {
		log.debug("getting Shippers instance with id: " + id);
		try {
			Shippers instance = (Shippers) sessionFactory.getCurrentSession()
					.get("com.aaronhible.model.Shippers", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.ShippersDao#findByExample(com.aaronhible.model.Shippers)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Shippers> findByExample(Shippers instance) {
		log.debug("finding Shippers instance by example");
		try {
			List<Shippers> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Shippers")
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
