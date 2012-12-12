package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.ProductsDao;
import com.aaronhible.model.Products;

/**
 * Home object for domain model class Products.
 * 
 * @see com.aaronhible.model.Products
 * @author Hibernate Tools
 */
public class ProductsDaoImpl implements ProductsDao {

	private static final Log log = LogFactory.getLog(ProductsDaoImpl.class);

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
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#persist(com.aaronhible.model.Products)
	 */
	@Override
	public void persist(Products transientInstance) {
		log.debug("persisting Products instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#attachDirty(com.aaronhible.model.Products)
	 */
	@Override
	public void attachDirty(Products instance) {
		log.debug("attaching dirty Products instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#attachClean(com.aaronhible.model.Products)
	 */
	@Override
	public void attachClean(Products instance) {
		log.debug("attaching clean Products instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#delete(com.aaronhible.model.Products)
	 */
	@Override
	public void delete(Products persistentInstance) {
		log.debug("deleting Products instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#merge(com.aaronhible.model.Products)
	 */
	@Override
	public Products merge(Products detachedInstance) {
		log.debug("merging Products instance");
		try {
			Products result = (Products) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#findById(int)
	 */
	@Override
	public Products findById(int id) {
		log.debug("getting Products instance with id: " + id);
		try {
			Products instance = (Products) sessionFactory.getCurrentSession()
					.get("com.aaronhible.model.Products", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#findByExample(com.aaronhible.model.Products)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Products> findByExample(Products instance) {
		log.debug("finding Products instance by example");
		try {
			List<Products> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.Products")
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
