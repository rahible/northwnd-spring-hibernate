package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.OrdersDao;
import com.aaronhible.model.Orders;

/**
 * Home object for domain model class Orders.
 * 
 * @see com.aaronhible.model.Orders
 * @author Hibernate Tools
 */
public class OrdersDaoImpl extends AbstractHibernateSessionFactoryDao implements OrdersDao {

	private static final Log log = LogFactory.getLog(OrdersDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#persist(com.aaronhible.model.Orders)
	 */
	@Override
	public void persist(Orders transientInstance) {
		log.debug("persisting Orders instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#attachDirty(com.aaronhible.model.Orders)
	 */
	@Override
	public void attachDirty(Orders instance) {
		log.debug("attaching dirty Orders instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#attachClean(com.aaronhible.model.Orders)
	 */
	@Override
	public void attachClean(Orders instance) {
		log.debug("attaching clean Orders instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#delete(com.aaronhible.model.Orders)
	 */
	@Override
	public void delete(Orders persistentInstance) {
		log.debug("deleting Orders instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#merge(com.aaronhible.model.Orders)
	 */
	@Override
	public Orders merge(Orders detachedInstance) {
		log.debug("merging Orders instance");
		try {
			Orders result = (Orders) getSessionFactory().getCurrentSession().merge(
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
	public Orders findById(int id) {
		log.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getSessionFactory().getCurrentSession().get(
					"com.aaronhible.model.Orders", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.OrdersDao#findByExample(com.aaronhible.model.Orders)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Orders> findByExample(Orders instance) {
		log.debug("finding Orders instance by example");
		try {
			List<Orders> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Orders")
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
