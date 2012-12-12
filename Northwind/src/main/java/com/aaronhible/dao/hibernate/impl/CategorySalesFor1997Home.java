package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.CategorySalesFor1997;

/**
 * Home object for domain model class CategorySalesFor1997.
 * @see com.aaronhible.model.views.CategorySalesFor1997
 * @author Hibernate Tools
 */
public class CategorySalesFor1997Home {

    private static final Log log = LogFactory.getLog(CategorySalesFor1997Home.class);

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
    
    public void persist(CategorySalesFor1997 transientInstance) {
        log.debug("persisting CategorySalesFor1997 instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(CategorySalesFor1997 instance) {
        log.debug("attaching dirty CategorySalesFor1997 instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CategorySalesFor1997 instance) {
        log.debug("attaching clean CategorySalesFor1997 instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(CategorySalesFor1997 persistentInstance) {
        log.debug("deleting CategorySalesFor1997 instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CategorySalesFor1997 merge(CategorySalesFor1997 detachedInstance) {
        log.debug("merging CategorySalesFor1997 instance");
        try {
            CategorySalesFor1997 result = (CategorySalesFor1997) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public CategorySalesFor1997 findById( com.aaronhible.model.views.CategorySalesFor1997Id id) {
        log.debug("getting CategorySalesFor1997 instance with id: " + id);
        try {
            CategorySalesFor1997 instance = (CategorySalesFor1997) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.CategorySalesFor1997", id);
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
    
    public List findByExample(CategorySalesFor1997 instance) {
        log.debug("finding CategorySalesFor1997 instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.CategorySalesFor1997")
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

