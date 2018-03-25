package com.niit.amkart.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = "com.niit.amkart")


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private DataSource dataSource;
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = passwordEncoder();
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select email, password, enabled "
        		+ "from user where email=?")
        .authoritiesByUsernameQuery("select email,role "
        		+ "from user where email=?").passwordEncoder(encoder);
		//auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("bill").password(encoder.encode("abc123")).roles("USER");
		//auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("admin").password(encoder.encode("root123")).roles("ADMIN");
	}
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http.authorizeRequests()
        .antMatchers("/", "/register","/showAllProducts","/productList","/index").permitAll()
        .antMatchers("/AddEntities","/ModifySupplier","/ModifyProduct").hasAnyAuthority("ADMIN")
        .antMatchers("/showOrderDetails","/showUserDetails").hasAnyAuthority("USER","ADMIN")
        .and().formLogin().loginPage("/login")
        .usernameParameter("username").passwordParameter("password")
       // .defaultSuccessUrl("/index")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
 
	}
}