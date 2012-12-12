package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.SummaryOfSalesByQuarter;
import com.aaronhible.model.views.SummaryOfSalesByQuarterId;

/**
 * Home object for domain model class SummaryOfSalesByQuarter.
 * @see com.aaronhible.model.views.SummaryOfSalesByQuarter
 * @author Hibernate Tools
 */
public class SummaryOfSalesByQuarterHome {

    private static final Log log = LogFactory.getLog(SummaryOfSalesByQuarterHome.class);

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
    
    public void persist(SummaryOfSalesByQuarter transientInstance) {
        log.debug("persisting SummaryOfSalesByQuarter instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(SummaryOfSalesByQuarter instance) {
        log.debug("attaching dirty SummaryOfSalesByQuarter instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SummaryOfSalesByQuarter instance) {
        log.debug("attaching clean SummaryOfSalesByQuarter instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(SummaryOfSalesByQuarter persistentInstance) {
        log.debug("deleting SummaryOfSalesByQuarter instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SummaryOfSalesByQuarter merge(SummaryOfSalesByQuarter detachedInstance) {
        log.debug("merging SummaryOfSalesByQuarter instance");
        try {
            SummaryOfSalesByQuarter result = (SummaryOfSalesByQuarter) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SummaryOfSalesByQuarter findById( com.aaronhible.model.views.SummaryOfSalesByQuarterId id) {
        log.debug("getting SummaryOfSalesByQuarter instance with id: " + id);
        try {
            SummaryOfSalesByQuarter instance = (SummaryOfSalesByQuarter) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.SummaryOfSalesByQuarter", id);
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
    
    public List findByExample(SummaryOfSalesByQuarter instance) {
        log.debug("finding SummaryOfSalesByQuarter instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.SummaryOfSalesByQuarter")
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

