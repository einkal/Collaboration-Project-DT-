package com.niit.FreyaBackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.Freya.config.AppContextConfig;
import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.dao.UserDetailDAO;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.UserDetail;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppContextConfig.class)

public class UserTest 
{
	@Autowired 
	private UserDetailDAO userDetailDAO;
	@Autowired
	private UserDetail userDetail;
	@Ignore
	public void testRegisterUser()
	{
		userDetail.setUserName("Amrita");
		userDetail.setEmailId("amrita@gmail.com");
		userDetail.setAddress("Kolkata");
		userDetail.setRole("USER");
		userDetail.setMobileNo("9887456321");
		userDetail.setIsOnline("N");
		userDetail.setPassword("pass123");
		assertEquals(true,userDetailDAO.registerUser(userDetail));

	}
	@Test
	public void updateOnlineStatusTest()
	{
		userDetail=userDetailDAO.getUserDetail("Amrita");
		assertTrue("Problem in updating",userDetailDAO.updateOnlineStatus("Y",userDetail));
	}

}
