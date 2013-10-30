package com.firstProject.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Author: Øyvind Bjerke
 * Date: 10/17/13
 * Time: 9:11 AM
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.firstProject.controllers")
public class MVCConfig extends WebMvcConfigurerAdapter{
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver(){
			@Override
			public View resolveViewName(String viewName, Locale locale) throws Exception {
				this.getAttributesMap().put("viewName", viewName);
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
				return request.getRequestURI().endsWith(".inline") ? super.resolveViewName(viewName, locale) : super.resolveViewName("template", locale);
			}
		};
		internalResourceViewResolver.setCache(false);
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		DefaultMessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();
		return messageCodesResolver;    //To change body of overridden methods use File | Settings | File Templates.
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setCacheSeconds(1);
		messageSource.setBasenames("classpath:messages","classpath:ValidationMessages" );
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;

	}
}
