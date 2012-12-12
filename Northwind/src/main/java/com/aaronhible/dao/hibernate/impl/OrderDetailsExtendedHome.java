package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.OrderDetailsExtended;
import com.aaronhible.model.views.OrderDetailsExtendedId;

/**
 * Home object for domain model class OrderDetailsExtended.
 * @see com.aaronhible.model.views.OrderDetailsExtended
 * @author Hibernate Tools
 */
public class OrderDetailsExtendedHome {

    private static final Log log = LogFactory.getLog(OrderDetailsExtendedHome.class);

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
    
    public void persist(OrderDetailsExtended transientInstance) {
        log.debug("persisting OrderDetailsExtended instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(OrderDetailsExtended instance) {
        log.debug("attaching dirty OrderDetailsExtended instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OrderDetailsExtended instance) {
        log.debug("attaching clean OrderDetailsExtended instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(OrderDetailsExtended persistentInstance) {
        log.debug("deleting OrderDetailsExtended instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OrderDetailsExtended merge(OrderDetailsExtended detachedInstance) {
        log.debug("merging OrderDetailsExtended instance");
        try {
            OrderDetailsExtended result = (OrderDetailsExtended) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public OrderDetailsExtended findById( com.aaronhible.model.views.OrderDetailsExtendedId id) {
        log.debug("getting OrderDetailsExtended instance with id: " + id);
        try {
            OrderDetailsExtended instance = (OrderDetailsExtended) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.OrderDetailsExtended", id);
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
    
    public List findByExample(OrderDetailsExtended instance) {
        log.debug("finding OrderDetailsExtended instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.OrderDetailsExtended")
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

