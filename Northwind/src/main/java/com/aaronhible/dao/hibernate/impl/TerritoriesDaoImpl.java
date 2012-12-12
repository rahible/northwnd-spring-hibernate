package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.TerritoriesDao;
import com.aaronhible.model.Territories;

/**
 * Home object for domain model class Territories.
 * 
 * @see com.aaronhible.model.Territories
 * @author Hibernate Tools
 */
public class TerritoriesDaoImpl implements TerritoriesDao {

	private static final Log log = LogFactory.getLog(TerritoriesDaoImpl.class);

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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#persist(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void persist(Territories transientInstance) {
		log.debug("persisting Territories instance");
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#attachDirty(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void attachDirty(Territories instance) {
		log.debug("attaching dirty Territories instance");
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#attachClean(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void attachClean(Territories instance) {
		log.debug("attaching clean Territories instance");
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#delete(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void delete(Territories persistentInstance) {
		log.debug("deleting Territories instance");
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
	 * @see
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#merge(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public Territories merge(Territories detachedInstance) {
		log.debug("merging Territories instance");
		try {
			Territories result = (Territories) sessionFactory
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#findById(java.lang.String
	 * )
	 */
	@Override
	public Territories findById(java.lang.String id) {
		log.debug("getting Territories instance with id: " + id);
		try {
			Territories instance = (Territories) sessionFactory
					.getCurrentSession().get(
							"com.aaronhible.model.Territories", id);
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#findByExample(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Territories> findByExample(Territories instance) {
		log.debug("finding Territories instance by example");
		try {
			List<Territories> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Territories")
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
