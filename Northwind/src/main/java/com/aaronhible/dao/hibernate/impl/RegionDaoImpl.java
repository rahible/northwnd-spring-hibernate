package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.RegionDao;
import com.aaronhible.model.Region;

/**
 * Home object for domain model class Region.
 * 
 * @see com.aaronhible.model.Region
 * @author Hibernate Tools
 */
public class RegionDaoImpl implements RegionDao {

	private static final Log log = LogFactory.getLog(RegionDaoImpl.class);

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
	 * @see com.aaronhible.model.RegionDao#persist(com.aaronhible.model.Region)
	 */
	@Override
	public void persist(Region transientInstance) {
		log.debug("persisting Region instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.model.RegionDao#attachDirty(com.aaronhible.model.Region)
	 */
	@Override
	public void attachDirty(Region instance) {
		log.debug("attaching dirty Region instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.model.RegionDao#attachClean(com.aaronhible.model.Region)
	 */
	@Override
	public void attachClean(Region instance) {
		log.debug("attaching clean Region instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.model.RegionDao#delete(com.aaronhible.model.Region)
	 */
	@Override
	public void delete(Region persistentInstance) {
		log.debug("deleting Region instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.model.RegionDao#merge(com.aaronhible.model.Region)
	 */
	@Override
	public Region merge(Region detachedInstance) {
		log.debug("merging Region instance");
		try {
			Region result = (Region) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.model.RegionDao#findById(int)
	 */
	@Override
	public Region findById(int id) {
		log.debug("getting Region instance with id: " + id);
		try {
			Region instance = (Region) sessionFactory.getCurrentSession().get(
					"com.aaronhible.model.Region", id);
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
	 * @see com.aaronhible.model.RegionDao#findByExample(com.aaronhible.model.Region)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Region> findByExample(Region instance) {
		log.debug("finding Region instance by example");
		try {
			List<Region> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Region")
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
