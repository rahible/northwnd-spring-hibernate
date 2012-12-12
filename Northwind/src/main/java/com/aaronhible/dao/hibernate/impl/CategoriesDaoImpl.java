package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.CategoriesDao;
import com.aaronhible.model.Categories;

/**
 * Home object for domain model class Categories.
 * 
 * @see com.aaronhible.model.Categories
 * @author Hibernate Tools
 */
public class CategoriesDaoImpl implements CategoriesDao {

	private static final Log log = LogFactory.getLog(CategoriesDaoImpl.class);

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
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#persist(com.aaronhible.model.Categories)
	 */
	@Override
	public void persist(Categories transientInstance) {
		log.debug("persisting Categories instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#attachDirty(com.aaronhible.model.Categories)
	 */
	@Override
	public void attachDirty(Categories instance) {
		log.debug("attaching dirty Categories instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#attachClean(com.aaronhible.model.Categories)
	 */
	@Override
	public void attachClean(Categories instance) {
		log.debug("attaching clean Categories instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#delete(com.aaronhible.model.Categories)
	 */
	@Override
	public void delete(Categories persistentInstance) {
		log.debug("deleting Categories instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#merge(com.aaronhible.model.Categories)
	 */
	@Override
	public Categories merge(Categories detachedInstance) {
		log.debug("merging Categories instance");
		try {
			Categories result = (Categories) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#findById(int)
	 */
	@Override
	public Categories findById(int id) {
		log.debug("getting Categories instance with id: " + id);
		try {
			Categories instance = (Categories) sessionFactory
					.getCurrentSession().get("com.aaronhible.model.Categories",
							id);
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
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#findByExample(com.aaronhible.model.Categories)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Categories> findByExample(Categories instance) {
		log.debug("finding Categories instance by example");
		try {
			List<Categories> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Categories")
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