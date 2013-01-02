package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.TerritoryDao;
import com.aaronhible.model.Territory;

/**
 * Home object for domain model class Territory.
 * 
 * @see com.aaronhible.model.Territory
 * @author Hibernate Tools
 */
public class TerritoryDaoImpl extends AbstractHibernateSessionFactoryDao implements TerritoryDao {

	private static final Log log = LogFactory.getLog(TerritoryDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#persist(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void persist(Territory transientInstance) {
		log.debug("persisting Territory instance");
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#attachDirty(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void attachDirty(Territory instance) {
		log.debug("attaching dirty Territory instance");
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#attachClean(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void attachClean(Territory instance) {
		log.debug("attaching clean Territory instance");
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
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#delete(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public void delete(Territory persistentInstance) {
		log.debug("deleting Territory instance");
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
	 * @see
	 * com.aaronhible.dao.hibernate.impl.TerritoriesDao#merge(com.aaronhible
	 * .model.Territories)
	 */
	@Override
	public Territory merge(Territory detachedInstance) {
		log.debug("merging Territory instance");
		try {
			Territory result = (Territory) getSessionFactory()
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
	public Territory findById(java.lang.String id) {
		log.debug("getting Territory instance with id: " + id);
		try {
			Territory instance = (Territory) getSessionFactory()
					.getCurrentSession().get(
							"com.aaronhible.model.Territory", id);
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
	public List<Territory> findByExample(Territory instance) {
		log.debug("finding Territory instance by example");
		try {
			List<Territory> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Territory")
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
