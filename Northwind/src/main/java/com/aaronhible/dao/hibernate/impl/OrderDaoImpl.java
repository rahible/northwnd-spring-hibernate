package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.OrderDao;
import com.aaronhible.model.Order;

/**
 * Home object for domain model class Order.
 * 
 * @see com.aaronhible.model.Order
 * @author Hibernate Tools
 */
public class OrderDaoImpl extends AbstractHibernateSessionFactoryDao implements OrderDao {

	private static final Log log = LogFactory.getLog(OrderDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#persist(com.aaronhible.model.Order)
	 */
	@Override
	public void persist(Order transientInstance) {
		log.debug("persisting Order instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#attachDirty(com.aaronhible.model.Order)
	 */
	@Override
	public void attachDirty(Order instance) {
		log.debug("attaching dirty Order instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#attachClean(com.aaronhible.model.Order)
	 */
	@Override
	public void attachClean(Order instance) {
		log.debug("attaching clean Order instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#delete(com.aaronhible.model.Order)
	 */
	@Override
	public void delete(Order persistentInstance) {
		log.debug("deleting Order instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#merge(com.aaronhible.model.Order)
	 */
	@Override
	public Order merge(Order detachedInstance) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) getSessionFactory().getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#findById(int)
	 */
	@Override
	public Order findById(int id) {
		log.debug("getting Order instance with id: " + id);
		try {
			Order instance = (Order) getSessionFactory().getCurrentSession().get(
					"com.aaronhible.model.Order", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#findByExample(com.aaronhible.model.Order)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Order> findByExample(Order instance) {
		log.debug("finding Order instance by example");
		try {
			List<Order> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Order")
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
