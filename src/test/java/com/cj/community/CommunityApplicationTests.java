package com.cj.community;

import com.cj.community.CommunityApplication;
import com.cj.community.dao.AlphaDao;
import com.cj.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
		 alphaDao=applicationContext.getBean("AlphaHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());
	}
	@Test
	public void testManagementBean(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}
	@Test
	public void  TestBeanConfig(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Autowired
	@Qualifier("AlphaHibernate")
	private  AlphaDao alphaDao;
	@Autowired
	private  AlphaService alphaService;
	@Test
	public void TestDi(){
		System.out.println(simpleDateFormat);
		System.out.println(alphaDao);
		System.out.println(alphaService);
	}
}
