package com.google;

import com.google.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class SpringTestSix {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				=new AnnotationConfigApplicationContext(SpringConfig.class);
		DataSource dataSource = annotationConfigApplicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
	}



}
