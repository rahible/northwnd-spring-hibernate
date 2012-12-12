package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.ProductsAboveAveragePrice;
import com.aaronhible.model.views.ProductsAboveAveragePriceId;

/**
 * Home object for domain model class ProductsAboveAveragePrice.
 * @see com.aaronhible.model.views.ProductsAboveAveragePrice
 * @author Hibernate Tools
 */
public class ProductsAboveAveragePriceHome {

    private static final Log log = LogFactory.getLog(ProductsAboveAveragePriceHome.class);

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
    
    public void persist(ProductsAboveAveragePrice transientInstance) {
        log.debug("persisting ProductsAboveAveragePrice instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ProductsAboveAveragePrice instance) {
        log.debug("attaching dirty ProductsAboveAveragePrice instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProductsAboveAveragePrice instance) {
        log.debug("attaching clean ProductsAboveAveragePrice instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ProductsAboveAveragePrice persistentInstance) {
        log.debug("deleting ProductsAboveAveragePrice instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProductsAboveAveragePrice merge(ProductsAboveAveragePrice detachedInstance) {
        log.debug("merging ProductsAboveAveragePrice instance");
        try {
            ProductsAboveAveragePrice result = (ProductsAboveAveragePrice) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ProductsAboveAveragePrice findById( com.aaronhible.model.views.ProductsAboveAveragePriceId id) {
        log.debug("getting ProductsAboveAveragePrice instance with id: " + id);
        try {
            ProductsAboveAveragePrice instance = (ProductsAboveAveragePrice) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.ProductsAboveAveragePrice", id);
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
    
    public List findByExample(ProductsAboveAveragePrice instance) {
        log.debug("finding ProductsAboveAveragePrice instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.ProductsAboveAveragePrice")
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

