package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.SummaryOfSalesByYear;
import com.aaronhible.model.views.SummaryOfSalesByYearId;

/**
 * Home object for domain model class SummaryOfSalesByYear.
 * @see com.aaronhible.model.views.SummaryOfSalesByYear
 * @author Hibernate Tools
 */
public class SummaryOfSalesByYearHome {

    private static final Log log = LogFactory.getLog(SummaryOfSalesByYearHome.class);

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
    
    public void persist(SummaryOfSalesByYear transientInstance) {
        log.debug("persisting SummaryOfSalesByYear instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(SummaryOfSalesByYear instance) {
        log.debug("attaching dirty SummaryOfSalesByYear instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SummaryOfSalesByYear instance) {
        log.debug("attaching clean SummaryOfSalesByYear instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(SummaryOfSalesByYear persistentInstance) {
        log.debug("deleting SummaryOfSalesByYear instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SummaryOfSalesByYear merge(SummaryOfSalesByYear detachedInstance) {
        log.debug("merging SummaryOfSalesByYear instance");
        try {
            SummaryOfSalesByYear result = (SummaryOfSalesByYear) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SummaryOfSalesByYear findById( com.aaronhible.model.views.SummaryOfSalesByYearId id) {
        log.debug("getting SummaryOfSalesByYear instance with id: " + id);
        try {
            SummaryOfSalesByYear instance = (SummaryOfSalesByYear) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.SummaryOfSalesByYear", id);
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
    
    public List findByExample(SummaryOfSalesByYear instance) {
        log.debug("finding SummaryOfSalesByYear instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.SummaryOfSalesByYear")
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

