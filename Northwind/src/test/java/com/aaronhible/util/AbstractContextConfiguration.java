package com.aaronhible.util;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {
		"classpath:applicationContext-database.xml",
		"classpath:applicationContext-hibernate.xml",
		"classpath:applicationContext-resources.xml",
		"classpath:applicationContext-transaction.xml" })
public abstract class AbstractContextConfiguration {

}
