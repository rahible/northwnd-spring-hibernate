package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.SysDiagramsDao;
import com.aaronhible.model.Sysdiagrams;

/**
 * Home object for domain model class Sysdiagrams.
 * 
 * @see com.aaronhible.model.Sysdiagrams
 * @author Hibernate Tools
 */
public class SysDiagramsDaoImpl extends AbstractHibernateSessionFactoryDao implements SysDiagramsDao {

	private static final Log log = LogFactory.getLog(SysDiagramsDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#persist(com.aaronhible.model.Sysdiagrams)
	 */
	@Override
	public void persist(Sysdiagrams transientInstance) {
		log.debug("persisting Sysdiagrams instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#attachDirty(com.aaronhible.model.Sysdiagrams)
	 */
	@Override
	public void attachDirty(Sysdiagrams instance) {
		log.debug("attaching dirty Sysdiagrams instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#attachClean(com.aaronhible.model.Sysdiagrams)
	 */
	@Override
	public void attachClean(Sysdiagrams instance) {
		log.debug("attaching clean Sysdiagrams instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#delete(com.aaronhible.model.Sysdiagrams)
	 */
	@Override
	public void delete(Sysdiagrams persistentInstance) {
		log.debug("deleting Sysdiagrams instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#merge(com.aaronhible.model.Sysdiagrams)
	 */
	@Override
	public Sysdiagrams merge(Sysdiagrams detachedInstance) {
		log.debug("merging Sysdiagrams instance");
		try {
			Sysdiagrams result = (Sysdiagrams) getSessionFactory()
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#findById(int)
	 */
	@Override
	public Sysdiagrams findById(int id) {
		log.debug("getting Sysdiagrams instance with id: " + id);
		try {
			Sysdiagrams instance = (Sysdiagrams) getSessionFactory()
					.getCurrentSession().get(
							"com.aaronhible.model.Sysdiagrams", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.SysDiagramsDao#findByExample(com.aaronhible.model.Sysdiagrams)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Sysdiagrams> findByExample(Sysdiagrams instance) {
		log.debug("finding Sysdiagrams instance by example");
		try {
			List<Sysdiagrams> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Sysdiagrams")
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
