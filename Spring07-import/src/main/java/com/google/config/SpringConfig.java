package com.google.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.google")
@Import(MyImportSelector.class)
//org.springframework.context.annotation.ImportSelector
//org.springframework.context.annotation.ImportBeanDefinitionRegistrar
public class SpringConfig {

}
