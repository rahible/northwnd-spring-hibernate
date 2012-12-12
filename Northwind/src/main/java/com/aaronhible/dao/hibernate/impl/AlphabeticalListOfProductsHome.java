package com.aaronhible.dao.hibernate.impl;
// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.aaronhible.model.views.AlphabeticalListOfProducts;
import com.aaronhible.model.views.AlphabeticalListOfProductsId;

/**
 * Home object for domain model class AlphabeticalListOfProducts.
 * @see com.aaronhible.model.views.AlphabeticalListOfProducts
 * @author Hibernate Tools
 */
public class AlphabeticalListOfProductsHome {

    private static final Log log = LogFactory.getLog(AlphabeticalListOfProductsHome.class);

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
    
    public void persist(AlphabeticalListOfProducts transientInstance) {
        log.debug("persisting AlphabeticalListOfProducts instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(AlphabeticalListOfProducts instance) {
        log.debug("attaching dirty AlphabeticalListOfProducts instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlphabeticalListOfProducts instance) {
        log.debug("attaching clean AlphabeticalListOfProducts instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(AlphabeticalListOfProducts persistentInstance) {
        log.debug("deleting AlphabeticalListOfProducts instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlphabeticalListOfProducts merge(AlphabeticalListOfProducts detachedInstance) {
        log.debug("merging AlphabeticalListOfProducts instance");
        try {
            AlphabeticalListOfProducts result = (AlphabeticalListOfProducts) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public AlphabeticalListOfProducts findById( com.aaronhible.model.views.AlphabeticalListOfProductsId id) {
        log.debug("getting AlphabeticalListOfProducts instance with id: " + id);
        try {
            AlphabeticalListOfProducts instance = (AlphabeticalListOfProducts) sessionFactory.getCurrentSession()
                    .get("com.aaronhible.model.AlphabeticalListOfProducts", id);
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
    
    public List findByExample(AlphabeticalListOfProducts instance) {
        log.debug("finding AlphabeticalListOfProducts instance by example");
        try {
            List results = sessionFactory.getCurrentSession()
                    .createCriteria("com.aaronhible.model.AlphabeticalListOfProducts")
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

