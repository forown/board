package com.freehoon.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/dataSource-context.xml"})
public class MybatisConnectionTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisConnectionTest.class);
	
	
	@Inject
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void mybaitsConnectionTest() {
		try(SqlSession session = sessionFactory.openSession()){
			logger.info("" + session);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
