package com.niit.amkart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.niit.amkart.config.AppContextConfig;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppContextConfig.class)
public class UserTest {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Test
	public void testCreateUser() {
		
		user.setEmail("Morgan");
		user.setPassword("123456");
		user.setName("Morgan Morris");
		assertEquals(true, userDAO.save(user));
		
	}

}
