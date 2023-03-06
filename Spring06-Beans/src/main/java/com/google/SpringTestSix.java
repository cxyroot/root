package com.google;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringTestSix {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                =new AnnotationConfigApplicationContext("com.google.config");
        JdbcTemplate jdbcTemplate = annotationConfigApplicationContext.getBean("", JdbcTemplate.class);
    }
}
