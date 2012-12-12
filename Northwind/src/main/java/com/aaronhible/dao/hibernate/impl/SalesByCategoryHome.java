package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.SalesByCategory;
import com.aaronhible.model.views.SalesByCategoryId;

/**
 * Home object for domain model class SalesByCategory.
 * @see com.aaronhible.model.views.SalesByCategory
 * @author Hibernate Tools
 */
public class SalesByCategoryHome {

    private static final Log log = LogFactory.getLog(SalesByCategoryHome.class);

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
    
    public void persist(SalesByCategory transientInstance) {
        log.debug("persisting SalesByCategory instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(SalesByCategory instance) {
        log.debug("attaching dirty SalesByCategory instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SalesByCategory instance) {
        log.debug("attaching clean SalesByCategory instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(SalesByCategory persistentInstance) {
        log.debug("deleting SalesByCategory instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SalesByCategory merge(SalesByCategory detachedInstance) {
        log.debug("merging SalesByCategory instance");
        try {
            SalesByCategory result = (SalesByCategory) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SalesByCategory findById( com.aaronhible.model.views.SalesByCategoryId id) {
        log.debug("getting SalesByCategory instance with id: " + id);
        try {
            SalesByCategory instance = (SalesByCategory) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.SalesByCategory", id);
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
    
    public List findByExample(SalesByCategory instance) {
        log.debug("finding SalesByCategory instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.SalesByCategory")
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

