package com.niit.amkart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;
import com.niit.amkart.model.Category;

import com.niit.amkart.model.Orders;
import com.niit.amkart.model.Product;
import com.niit.amkart.model.Supplier;
import com.niit.amkart.model.User;

@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class AppContextConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/onlineshopping");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "update");
  
        return properties;
    }
	
	@Autowired
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
		sessionFactory.addAnnotatedClass(User.class);
		sessionFactory.addAnnotatedClass(Supplier.class);
		sessionFactory.addAnnotatedClass(Category.class);
		sessionFactory.addAnnotatedClass(Product.class);
		sessionFactory.addAnnotatedClass(Cart.class);
		sessionFactory.addAnnotatedClass(Orders.class);
		sessionFactory.addAnnotatedClass(CartItem.class);
		sessionFactory.addProperties(getHibernateProperties());
		return sessionFactory.buildSessionFactory();
	}
																																																																																																																																																																			
	@Autowired
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
	
	
}
