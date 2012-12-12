package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.ProductsByCategory;
import com.aaronhible.model.views.ProductsByCategoryId;

/**
 * Home object for domain model class ProductsByCategory.
 * @see com.aaronhible.model.views.ProductsByCategory
 * @author Hibernate Tools
 */
public class ProductsByCategoryHome {

    private static final Log log = LogFactory.getLog(ProductsByCategoryHome.class);

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
    
    public void persist(ProductsByCategory transientInstance) {
        log.debug("persisting ProductsByCategory instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ProductsByCategory instance) {
        log.debug("attaching dirty ProductsByCategory instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProductsByCategory instance) {
        log.debug("attaching clean ProductsByCategory instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ProductsByCategory persistentInstance) {
        log.debug("deleting ProductsByCategory instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProductsByCategory merge(ProductsByCategory detachedInstance) {
        log.debug("merging ProductsByCategory instance");
        try {
            ProductsByCategory result = (ProductsByCategory) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ProductsByCategory findById( com.aaronhible.model.views.ProductsByCategoryId id) {
        log.debug("getting ProductsByCategory instance with id: " + id);
        try {
            ProductsByCategory instance = (ProductsByCategory) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.ProductsByCategory", id);
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
    
    public List findByExample(ProductsByCategory instance) {
        log.debug("finding ProductsByCategory instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.ProductsByCategory")
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

