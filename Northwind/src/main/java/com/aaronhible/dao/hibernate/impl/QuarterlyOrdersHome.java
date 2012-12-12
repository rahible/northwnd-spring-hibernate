package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.QuarterlyOrders;
import com.aaronhible.model.views.QuarterlyOrdersId;

/**
 * Home object for domain model class QuarterlyOrders.
 * @see com.aaronhible.model.views.QuarterlyOrders
 * @author Hibernate Tools
 */
public class QuarterlyOrdersHome {

    private static final Log log = LogFactory.getLog(QuarterlyOrdersHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(QuarterlyOrders transientInstance) {
        log.debug("persisting QuarterlyOrders instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(QuarterlyOrders instance) {
        log.debug("attaching dirty QuarterlyOrders instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(QuarterlyOrders instance) {
        log.debug("attaching clean QuarterlyOrders instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(QuarterlyOrders persistentInstance) {
        log.debug("deleting QuarterlyOrders instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public QuarterlyOrders merge(QuarterlyOrders detachedInstance) {
        log.debug("merging QuarterlyOrders instance");
        try {
            QuarterlyOrders result = (QuarterlyOrders) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public QuarterlyOrders findById( com.aaronhible.model.views.QuarterlyOrdersId id) {
        log.debug("getting QuarterlyOrders instance with id: " + id);
        try {
            QuarterlyOrders instance = (QuarterlyOrders) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.QuarterlyOrders", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List findByExample(QuarterlyOrders instance) {
        log.debug("finding QuarterlyOrders instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.QuarterlyOrders")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

