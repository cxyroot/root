package com.google.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class JdbcConfig {

	@Bean
	public DataSource createDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		return dataSource;
	}

}
