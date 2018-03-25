package com.niit.FreyaBackend;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.niit.Freya.config.AppContextConfig;
import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.model.Blog;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppContextConfig.class)

public class BlogTest {
	@Autowired 
	private BlogDAO blogDAO;
	@Autowired
	private Blog blog;
	@Test
	public void testAddBlog()
	{
		blog.setBlogName("Hibernate");
		blog.setBlogContent("Hibernate concept");
		blog.setUserName("Amrita");
		blog.setStatus("A");
		blog.setLikes(0);
		blog.setCreateDate(new java.util.Date());
		assertEquals(true,blogDAO.add(blog));
		
	}
	@Test
	public void TestListBlog()
	{
		List<Blog> listBlogs=blogDAO.list("Amrita");
		assertTrue("Problem in Listing Blogs",listBlogs.size()>0);
		for(Blog blog:listBlogs)
		{
			System.out.println(blog.getBlogID()+"::");
			System.out.println(blog.getBlogName()+"::");
			System.out.println(blog.getStatus()+"::");
			System.out.println(blog.getLikes()+"::");
		}
	}
}
