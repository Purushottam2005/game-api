package com.firstProject.config;

import com.firstProject.model.Game;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestConfiguration extends RepositoryRestMvcConfiguration {
	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Game.class);
	}
}