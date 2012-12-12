package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.dao.OrderDetailsDao;
import com.aaronhible.model.OrderDetails;

/**
 * Home object for domain model class OrderDetails.
 * 
 * @see com.aaronhible.model.OrderDetails
 * @author Hibernate Tools
 */
public class OrderDetailsDaoImpl implements OrderDetailsDao {

	private static final Log log = LogFactory.getLog(OrderDetailsDaoImpl.class);

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
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#persist(com.aaronhible.model.OrderDetails)
	 */
	@Override
	public void persist(OrderDetails transientInstance) {
		log.debug("persisting OrderDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#attachDirty(com.aaronhible.model.OrderDetails)
	 */
	@Override
	public void attachDirty(OrderDetails instance) {
		log.debug("attaching dirty OrderDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#attachClean(com.aaronhible.model.OrderDetails)
	 */
	@Override
	public void attachClean(OrderDetails instance) {
		log.debug("attaching clean OrderDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#delete(com.aaronhible.model.OrderDetails)
	 */
	@Override
	public void delete(OrderDetails persistentInstance) {
		log.debug("deleting OrderDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#merge(com.aaronhible.model.OrderDetails)
	 */
	@Override
	public OrderDetails merge(OrderDetails detachedInstance) {
		log.debug("merging OrderDetails instance");
		try {
			OrderDetails result = (OrderDetails) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#findById(com.aaronhible.model.OrderDetailsId)
	 */
	@Override
	public OrderDetails findById(com.aaronhible.model.OrderDetailsId id) {
		log.debug("getting OrderDetails instance with id: " + id);
		try {
			OrderDetails instance = (OrderDetails) sessionFactory
					.getCurrentSession().get(
							"com.aaronhible.model.OrderDetails", id);
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
	 * @see com.aaronhible.dao.hibernate.impl.OrderDetailsDao#findByExample(com.aaronhible.model.OrderDetails)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<OrderDetails> findByExample(OrderDetails instance) {
		log.debug("finding OrderDetails instance by example");
		try {
			List<OrderDetails> results = sessionFactory.getCurrentSession()
					.createCriteria("com.aaronhible.model.OrderDetails")
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
