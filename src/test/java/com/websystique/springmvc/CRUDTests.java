package com.websystique.springmvc;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.configuration.AppConfig;
import com.websystique.springmvc.configuration.AppInitializer;
import com.websystique.springmvc.configuration.HibernateConfiguration;
import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, AppInitializer.class,
		HibernateConfiguration.class })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class CRUDTests extends Assert {
	private final User userEx = new User();

	@Autowired
	private UserDao userDao;

	@Before
	public void userSetup() {
		userEx.setUserId(11);
		userEx.setName("bunny");
		userEx.setUsername("bunny");
		userEx.setPassword("bunny");
		userEx.setEmail("bunny@mail.com");
		userEx.setCreatedAt(new LocalDate(2015, 10, 15));
		userEx.setAdmin("bunny");
		userEx.setAvatar("");
	}

	@Test
	public void testFindById() {
		User user = userDao.findById(11);
		assertEquals(userEx, user);
		return;
	}

	@Test
	public void testFindUserByUsername() {
		User user = userDao.findUserByUsername("bunny");
		assertEquals(userEx, user);
		return;
	}

	@Test
	public void testFindAllUsers() {
		int totalNumber = userDao.findAllUsers().size();
		assertEquals(17, totalNumber);
		return;
	}
	
	@Test
	public void testDeleteUserByUsername(){
		User user = userDao.findUserByUsername("Post");
		if(user!=null){
			userDao.deleteUserByUsername("Post");
			user = userDao.findUserByUsername("Post");
			assertNull("Object should not exist", user);
		}
		
		
	}

}
