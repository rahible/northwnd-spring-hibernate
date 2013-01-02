package com.aaronhible.dao.hibernate.impl;

// Generated Dec 12, 2012 8:51:31 AM by Hibernate Tools 3.2.2.GA

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import com.aaronhible.dao.CategoryDao;
import com.aaronhible.model.Category;

/**
 * Home object for domain model class Category.
 * 
 * @see com.aaronhible.model.Category
 * @author Hibernate Tools
 */
@Repository(value = "categoryDao")
public class CategoryDaoImpl extends AbstractHibernateSessionFactoryDao
		implements CategoryDao {

	private static final Log log = LogFactory.getLog(CategoryDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CategoriesDao#persist(com.aaronhible
	 * .model.Categories)
	 */
	@Override
	public void persist(Category transientInstance) {
		log.debug("persisting Category instance");
		try {
			getSessionFactory().getCurrentSession().save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CategoriesDao#attachDirty(com.aaronhible
	 * .model.Categories)
	 */
	@Override
	public void attachDirty(Category instance) {
		log.debug("attaching dirty Category instance");
		try {
			getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CategoriesDao#attachClean(com.aaronhible
	 * .model.Categories)
	 */
	@Override
	public void attachClean(Category instance) {
		log.debug("attaching clean Category instance");
		try {
			getSessionFactory().getCurrentSession().lock(instance,
					LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CategoriesDao#delete(com.aaronhible
	 * .model.Categories)
	 */
	@Override
	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CategoriesDao#merge(com.aaronhible.
	 * model.Category)
	 */
	@Override
	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = (Category) getSessionFactory()
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aaronhible.dao.hibernate.impl.CategoriesDao#findById(int)
	 */
	@Override
	public Category findById(int id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Category instance = (Category) getSessionFactory()
					.getCurrentSession().get("com.aaronhible.model.Category",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aaronhible.dao.hibernate.impl.CategoriesDao#findByExample(com.aaronhible
	 * .model.Categories)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Category> findByExample(Category instance) {
		log.debug("finding Category instance by example");
		try {
			List<Category> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Category")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Category> findAll() {
		log.debug("finding all Category");
		try {
			List<Category> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.aaronhible.model.Category").list();
			log.debug("find all successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}

	}

	public byte[] findPicture(int id) {
		Category category = this.findById(id);
		if (category == null)
			return null;
		try {
			Blob blob = category.getPicture();
			long length = blob.length();
			if (length == 0)
				return null;
			return blob.getBytes(1, (int) length);
		} catch (SQLException sql) {
			throw new RuntimeException(sql);
		}

	}
}
