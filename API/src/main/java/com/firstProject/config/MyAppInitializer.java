package com.firstProject.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Author: Øyvind Bjerke
 * Date: 10/17/13
 * Time: 9:16 AM
 */

public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{
				new HiddenHttpMethodFilter(), new ShallowEtagHeaderFilter()
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{PersistenceConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{RestConfiguration.class, MVCConfig.class};
	}


}
