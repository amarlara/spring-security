package com.lithi.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecutiryConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource secutiryDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication().withUser(users.username("lithi").password(
		 * "lithi123").roles("EMPLOYEE"))
		 * .withUser(users.username("Mouni").password("lithi123").roles("EMPLOYEE",
		 * "MANAGER"))
		 * .withUser(users.username("Ranjith").password("lithi123").roles("EMPLOYEE",
		 * "ADMIN"));
		 */
		auth.jdbcAuthentication().dataSource(secutiryDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
		// http.authorizeRequests().antMatchers("/").anyRequest().authenticated().and().formLogin()
		// .loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser").permitAll().and().logout()
		// .permitAll();
	}

}
