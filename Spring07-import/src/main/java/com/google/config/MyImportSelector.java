package com.google.config;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.convert.Property;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyImportSelector implements ImportSelector {

	//表达式
	private String expression;

	public MyImportSelector(){
		Properties properties = null;
		try {
			properties = PropertiesLoaderUtils.loadAllProperties("MyImportSelector.properties");
			expression = properties.getProperty("com.google.config.MyImportSelector.expression");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String[] basePackers = null;
		if(importingClassMetadata.hasAnnotatedMethods(ComponentScan.class.getName())){
			Map<String, Object> annotationAttributes =
					importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
			basePackers = (String[]) annotationAttributes.get("basePacker");

		}
		Set<String> classes = new HashSet<String>();
		if (basePackers == null || basePackers.length == 0){
			String basePacker = null;
			try {
				basePacker = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			basePackers = new String[] {basePacker};

			ClassPathScanningCandidateComponentProvider classPathScanningCandidateComponentProvider =
					new ClassPathScanningCandidateComponentProvider(Boolean.FALSE);
			AspectJTypeFilter aspectJTypeFilter = new AspectJTypeFilter(expression,MyImportSelector.class.getClassLoader());
			classPathScanningCandidateComponentProvider.addIncludeFilter(aspectJTypeFilter);
			for (String packer : basePackers) {
				classPathScanningCandidateComponentProvider.findCandidateComponents(packer).forEach( beanDefinition ->
						classes.add(beanDefinition.getBeanClassName()));
			}
		}
		return classes.toArray(new String[classes.size()]);
	}
}
