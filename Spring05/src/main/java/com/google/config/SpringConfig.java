package com.google.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfig {

}

