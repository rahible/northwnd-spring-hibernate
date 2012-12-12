package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.CurrentProductList;
import com.aaronhible.model.views.CurrentProductListId;

/**
 * Home object for domain model class CurrentProductList.
 * @see com.aaronhible.model.views.CurrentProductList
 * @author Hibernate Tools
 */
public class CurrentProductListHome {

    private static final Log log = LogFactory.getLog(CurrentProductListHome.class);

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
    
    public void persist(CurrentProductList transientInstance) {
        log.debug("persisting CurrentProductList instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(CurrentProductList instance) {
        log.debug("attaching dirty CurrentProductList instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CurrentProductList instance) {
        log.debug("attaching clean CurrentProductList instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(CurrentProductList persistentInstance) {
        log.debug("deleting CurrentProductList instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CurrentProductList merge(CurrentProductList detachedInstance) {
        log.debug("merging CurrentProductList instance");
        try {
            CurrentProductList result = (CurrentProductList) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public CurrentProductList findById( com.aaronhible.model.views.CurrentProductListId id) {
        log.debug("getting CurrentProductList instance with id: " + id);
        try {
            CurrentProductList instance = (CurrentProductList) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.CurrentProductList", id);
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
    
    public List findByExample(CurrentProductList instance) {
        log.debug("finding CurrentProductList instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.CurrentProductList")
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

