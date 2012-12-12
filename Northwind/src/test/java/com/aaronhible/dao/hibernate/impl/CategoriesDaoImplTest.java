package com.aaronhible.dao.hibernate.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aaronhible.dao.CategoriesDao;
import com.aaronhible.model.Categories;
import com.aaronhible.util.AbstractContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/aaronhible/dao/applicationContext-dao.xml" })
public class CategoriesDaoImplTest extends AbstractContextConfiguration {

	@Autowired
	CategoriesDao categoriesDao;

	@Test
	@Transactional
	public void testFindById() {
		Categories cat = categoriesDao.findById(1);
		assertNotNull(cat);
	}
}
