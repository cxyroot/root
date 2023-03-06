package com.google;

import com.google.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestEight {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				=new AnnotationConfigApplicationContext(SpringConfig.class);

		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.err.println(beanDefinitionName);
		}
	}
}
