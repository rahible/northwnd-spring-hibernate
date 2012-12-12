package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.SalesTotalsByAmount;
import com.aaronhible.model.views.SalesTotalsByAmountId;

/**
 * Home object for domain model class SalesTotalsByAmount.
 * @see com.aaronhible.model.views.SalesTotalsByAmount
 * @author Hibernate Tools
 */
public class SalesTotalsByAmountHome {

    private static final Log log = LogFactory.getLog(SalesTotalsByAmountHome.class);

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
    
    public void persist(SalesTotalsByAmount transientInstance) {
        log.debug("persisting SalesTotalsByAmount instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(SalesTotalsByAmount instance) {
        log.debug("attaching dirty SalesTotalsByAmount instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SalesTotalsByAmount instance) {
        log.debug("attaching clean SalesTotalsByAmount instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(SalesTotalsByAmount persistentInstance) {
        log.debug("deleting SalesTotalsByAmount instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SalesTotalsByAmount merge(SalesTotalsByAmount detachedInstance) {
        log.debug("merging SalesTotalsByAmount instance");
        try {
            SalesTotalsByAmount result = (SalesTotalsByAmount) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SalesTotalsByAmount findById( com.aaronhible.model.views.SalesTotalsByAmountId id) {
        log.debug("getting SalesTotalsByAmount instance with id: " + id);
        try {
            SalesTotalsByAmount instance = (SalesTotalsByAmount) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.SalesTotalsByAmount", id);
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
    
    public List findByExample(SalesTotalsByAmount instance) {
        log.debug("finding SalesTotalsByAmount instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.SalesTotalsByAmount")
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

