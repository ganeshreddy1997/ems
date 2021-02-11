package com.springBoot.ems.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfoguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/delete**").hasAnyRole("ADMIN")
		.antMatchers("/index").permitAll()
		.anyRequest().authenticated()
		.and()
//		.httpBasic()
		.formLogin()
		
//		.formLogin().loginPage("/WEB-INF/views/login.jsp").failureUrl("/login")
		
//		.formLogin().loginPage("/WEB-INF/views/loginPage.jsp").failureUrl("/doLogin")
//		.usernameParameter("t1").passwordParameter("t2")
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/denied.jsp")
		.and()
		.csrf().disable();
		
		http.sessionManagement().maximumSessions(1);
		http.logout().logoutUrl("/logoutMe").logoutSuccessUrl("/loggedOut").permitAll();
		http.requiresChannel().anyRequest().requiresSecure();
	}
	  
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		/*
		builder.inMemoryAuthentication()
		.withUser("sgk").password(encoder.encode("123456")).roles("ADMIN")
		.and()
		.withUser("sree").password(encoder.encode("123456")).roles("ADMIN")
		.and()
		.withUser("ganesh").password(encoder.encode("654321")).roles("USER")
		.and()
		.withUser("bhavya").password(encoder.encode("654321")).roles("USER");
		*/
		
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
		.passwordEncoder(encoder);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}




























