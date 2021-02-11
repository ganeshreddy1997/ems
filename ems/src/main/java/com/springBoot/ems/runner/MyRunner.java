package com.springBoot.ems.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void run(String... args) throws Exception {
		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		jdbcTemplate.update("INSERT INTO USERS VALUES(?,?,?)", "GANESHS",encoder.encode("123456"), 1);
//		jdbcTemplate.update("INSERT INTO USERS VALUES(?,?,?)", "SGKS", encoder.encode("123456"), 1);
//		jdbcTemplate.update("INSERT INTO USERS VALUES(?,?,?)", "SREES", encoder.encode("123456"), 1);

	}

}
