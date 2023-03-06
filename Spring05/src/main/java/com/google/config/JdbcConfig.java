package com.google.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class JdbcConfig {

	@Value("${jdbc.driver}")
	private String driver;

	@Value("${jdbc.driver}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.username}")
	private String password;

	@Bean("jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource createDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
