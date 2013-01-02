package com.aaronhible.dao.hibernate.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aaronhible.dao.CategoryDao;
import com.aaronhible.model.Category;
import com.aaronhible.util.AbstractContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/aaronhible/dao/applicationContext-dao.xml" })
public class CategoriesDaoImplTest extends AbstractContextConfiguration {

	@Autowired
	CategoryDao categoryDao;

	@Test
	@Transactional
	public void testFindById() {
		Category cat = categoryDao.findById(1);
		assertNotNull(cat);
	}
}
