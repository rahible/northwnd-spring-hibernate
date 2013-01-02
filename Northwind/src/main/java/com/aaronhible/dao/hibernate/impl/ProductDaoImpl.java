package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.ProductDao;
import com.aaronhible.model.Product;

/**
 * Home object for domain model class Product.
 * 
 * @see com.aaronhible.model.Product
 * @author Hibernate Tools
 */
public class ProductDaoImpl extends AbstractHibernateSessionFactoryDao implements ProductDao {

	private static final Log log = LogFactory.getLog(ProductDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#persist(com.aaronhible.model.Product)
	 */
	@Override
	public void persist(Product transientInstance) {
		log.debug("persisting Product instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#attachDirty(com.aaronhible.model.Product)
	 */
	@Override
	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#attachClean(com.aaronhible.model.Product)
	 */
	@Override
	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#delete(com.aaronhible.model.Product)
	 */
	@Override
	public void delete(Product persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#merge(com.aaronhible.model.Product)
	 */
	@Override
	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getSessionFactory().getCurrentSession()
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
	public Product findById(int id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getSessionFactory().getCurrentSession()
					.get("com.aaronhible.model.Product", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.ProductsDao#findByExample(com.aaronhible.model.Product)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Product> findByExample(Product instance) {
		log.debug("finding Product instance by example");
		try {
			List<Product> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Product")
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
